//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserManager.java

package fr.umlv.desperados.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.util.Cache;
import fr.umlv.desperados.util.ManagerException;

/**
 * Provides an implementation of the UserManager interface, using an relational 
 * database.
 * It contains a cache system, which prevents to instanciate User several times.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseUserManager implements UserManager {

	/**
	 * The unique instance of the DatabaseUserManager.
	 */
	private static DatabaseUserManager theInstance = null;

	/**
	 * The DatabaseRequestor of this manager.
	 */
	private DatabaseRequestor requestor;

	/**
	 * The Cache of this manager.
	 */
	private Cache cache;

	/**
	 * Private constructor.
	 * 
	 * @param requestor the DatabaseRequestor of this manager.
	 * @roseuid 3FE3139602DD
	 */
	private DatabaseUserManager(DatabaseRequestor requestor) {
		this.requestor = requestor;
		cache = new Cache(16);
	}

	/**
	 * Instance getter.
	 * 
	 * @param requestor the DatabaseRequestor for this manager.
	 * @return the unique instance of DatabaseUserManager.
	 * @roseuid 3FC8B67D027A
	 */
	public static synchronized DatabaseUserManager getInstance(DatabaseRequestor requestor) {
		if (theInstance == null)
			theInstance = new DatabaseUserManager(requestor);
		return theInstance;
	}

	/**
	 * @param user
	 * @throws fr.umlv.desperados.account.UserAlreadyExistsException
	 * @roseuid 3FF869B902D2
	 */
	public void addUser(User user) throws UserAlreadyExistsException, ManagerException {

		ResultSet rs = null;
		try {
			rs = doSelectQueryLogin(user.getLogin());
			if (rs.first()) {
				throw new UserAlreadyExistsException("User exists in the database");
			} else {
				rs.moveToInsertRow();
				updateRow(rs, user);
				rs.insertRow();
			}
		} catch (SQLException e) {
			throw new ManagerException("Unable to query the database");
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		cache.put(user.getLogin(), user);
	}

	/**
	 * @param login
	 * @return boolean
	 * @roseuid 3FF869B902F0
	 */
	public boolean existUser(String login) throws ManagerException {

		ResultSet rs = null;
		try {
			rs = doSelectQueryLogin(login);
			return rs.first();
		} catch (SQLException e) {
			throw new ManagerException("Unable to query the database");
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @param login
	 * @return fr.umlv.desperados.account.User
	 * @roseuid 3FF869B9030F
	 */
	public User getUser(String login) throws UserNotFoundException, ManagerException {
		
		User user = (User)cache.get(login);
		if(user != null) {
			return user;
		}

		ResultSet rs = null;
		try {
			rs = doSelectQueryLogin(login);
			if (!rs.first()) {
				throw new UserNotFoundException("User doesn't exist in the database");
			}
			user = resultSetToUser(rs);
		} catch (SQLException e) {
			throw new ManagerException("Unable to query the database");
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		cache.put(user.getLogin(), user);
		return user;
	}

	/**
	 * @param user
	 * @throws fr.umlv.desperados.account.UserNotFoundException
	 * @roseuid 3FF869B90323
	 */
	public void modifyUser(User user) throws UserNotFoundException, ManagerException {
		ResultSet rs = null;
		try {
			rs = doSelectQueryLogin(user.getLogin());
			if (!rs.first()) {
				throw new UserNotFoundException("User not found in the database");
			} else {
				updateRow(rs, user);
			}
		} catch (SQLException e) {
			throw new ManagerException("Unable to query the database");
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		User userInCache =(User)cache.get(user.getLogin());
		if(userInCache != null) {
			userInCache.setAdmin(user.getAdmin());
			userInCache.setEmail(user.getEmail());
			userInCache.setFirstname(user.getFirstname());
			userInCache.setName(user.getName());
			userInCache.setPassword(user.getPassword());
		}
	}

	/**
	 * @param login
	 * @return fr.umlv.desperados.account.User
	 * @throws fr.umlv.desperados.account.UserNotFoundException
	 * @roseuid 3FF869B90341
	 */
	public User removeUser(String login) throws UserNotFoundException, ManagerException {
		User user = (User)cache.remove(login);
		ResultSet rs = null;
		try {
			rs = doSelectQueryLogin(login);
			if (!rs.first()) {
				throw new UserNotFoundException("User doesn't exist in the database");
			}
			if(user == null) {
				// getting the deleted User to return him
				user = resultSetToUser(rs);
			}
			rs.deleteRow();
		} catch (SQLException e) {
			throw new ManagerException("Unable to query the database");
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * @param login
	 * @param name
	 * @return java.util.List
	 * @roseuid 3FF869B90369
	 */
	public List searchUser(String login, String name) throws ManagerException {
		ResultSet rs = null;
		if (login != null) {
			if("".equals(login)) {
				login = "%";
			} else {
				login = login.replace('*', '%').replace('?', '_');
			}
		}
		if (name != null) {
			if("".equals(name)) {
				name="%";
			} else {
				name = name.replace('*', '%').replace('?', '_');
			}
		}
		StringBuffer cond = new StringBuffer();
		cond.append(" LOGIN_COM like '" + login + "'");
		cond.append(" AND NOM_COM like '" + name + "'");

		try {
			rs = doSelectQuery(cond.toString());
			if ((rs != null) && (rs.first())) {
				return (List) (new DatabaseUserList(rs));
			}
		} catch (SQLException e) {
			throw new ManagerException("Unable to query the database");
		}
		return null;
	}

	/**
	 * Sets the size of the cache of this manager.
	 * 
	 * @param size the new size of the cache.
	 * @roseuid 3FF9BC6C0105
	 */
	public void setCacheSize(int size) {
		cache.setCapacity(size);
	}

	private ResultSet doSelectQueryLogin(String login) throws SQLException {
		return doSelectQuery("LOGIN_COM = '"+login+"'");
	}

	private ResultSet doSelectQuery(String condition) throws SQLException {
		// CAUTION: order in SELECT is important : it is used in the updateRow and resultSetToUser methods
		// 1: LOGIN_COM		2: NOM_COM				3: PRENOM_COM
		// 4: MAIL_COM			5: EST_ADM_COM		6: PASS_COM
		return requestor.doQuery(
			"SELECT LOGIN_COM, NOM_COM, PRENOM_COM, MAIL_COM, EST_ADM_COM, PASS_COM" +
			" FROM Compte WHERE " + condition);
	}

	private void updateRow(ResultSet rs, User user) throws SQLException {
		rs.updateString(1, user.getLogin());
		rs.updateString(2, user.getName());
		rs.updateString(3, user.getFirstname());
		rs.updateString(4, user.getEmail());
		rs.updateBoolean(5, user.getAdmin());
		rs.updateString(6, user.getPassword());
	}

	private User resultSetToUser(ResultSet rs) throws SQLException {
		User user = new User(rs.getString(1));
		user.setName(rs.getString(2));
		user.setFirstname(rs.getString(3));
		user.setEmail(rs.getString(4));
		user.setAdmin(rs.getBoolean(5));
		user.setPassword(rs.getString(6));
		return user;
	}
}