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
	// TODO faire le système de cache 

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

		//		TODO à décommenter quand les ResulSet seront updatable (autant dire quand les poules auront des dents)
		//		try {
		//		ResultSet rs = null;
		//			rs = doSelectQuery(user.getLogin());
		//			if (rs.first()) {
		//				throw new UserAlreadyExistsException("User exists in the database");
		//			} else {
		//				rs.moveToInsertRow();
		//				updateRow(rs, user);
		//			}
		//		} catch (SQLException e) {
		//			throw new ManagerException("Unable to query the database");
		//		} finally {
		//			try {
		//				rs.close();
		//			} catch (SQLException e1) {
		//				// TODO Auto-generated catch block
		//				e1.printStackTrace();
		//			}
		//		}

		if(existUser(user.getLogin())) {
			throw new UserAlreadyExistsException("User '"+user.getLogin()+
																					"' already exists in the database");
		}
		try {
			String query = "INSERT INTO Compte "
					+ "(LOGIN_COM, NOM_COM,PRENOM_COM,MAIL_COM,EST_ADM_COM,PASS_COM)"
					+ " VALUES('" + user.getLogin() + "','"
					+ user.getName() + "','" + user.getFirstname() + "','"
					+ user.getEmail() + "'," + (user.getAdmin() ? 1 : 0) + ",'"
					+ user.getPassword() + "')";
			if (requestor.executeQuery(query) == 0)
				throw new ManagerException(
					"Impossible to create student '" + user.getLogin() + "'");
		} catch (SQLException e) {
			throw new ManagerException("Unable to query the database");
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
			rs = doSelectQuery(login);
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
			rs = doSelectQuery(login);
			if (!rs.first()) {
				throw new UserNotFoundException("User doesn't exist in the database");
			}
			user = new User(rs.getString("LOGIN_COM"));
			user.setName(rs.getString("NOM_COM"));
			user.setFirstname(rs.getString("PRENOM_COM"));
			user.setEmail(rs.getString("MAIL_COM"));
			user.setAdmin(rs.getBoolean("EST_ADM_COM"));
			user.setPassword(rs.getString("PASS_COM"));
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
			rs = doSelectQuery(user.getLogin());
			if (!rs.first()) {
				throw new UserNotFoundException("User not found in the database");
			} else {
				//				TODO à décommenter quand les ResulSet seront updatable (autant dire quand les poules auront des dents)
				//				updateRow(rs, user);
				String query =
					"UPDATE Compte SET "
						+ "NOM_COM='"
						+ user.getName()
						+ "'"
						+ ", PRENOM_COM='"
						+ user.getFirstname()
						+ "'"
						+ ", MAIL_COM='"
						+ user.getEmail()
						+ "'"
						+ ", EST_ADM_COM='"
						+ (user.getAdmin() ? 1 : 0)
						+ "'"
						+ ", PASS_COM='"
						+ user.getPassword()
						+ "'"
						+ " WHERE LOGIN_COM='"
						+ user.getLogin()
						+ "'";
				System.out.println(query);
				if (requestor.executeQuery(query) == 0)
					throw new ManagerException(
						"Impossible to modify student '"
							+ user.getLogin()
							+ "'");
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
			rs = doSelectQuery(login);
			if (!rs.first()) {
				throw new UserNotFoundException("User doesn't exist in the database");
			}
			if(user == null) {
				user = new User(rs.getString("LOGIN_COM"));
				user.setName(rs.getString("NOM_COM"));
				user.setFirstname(rs.getString("PRENOM_COM"));
				user.setEmail(rs.getString("MAIL_COM"));
				user.setAdmin(rs.getBoolean("EST_ADM_COM"));
				user.setPassword(rs.getString("PASS_COM"));
			}
			//			TODO à décommenter quand les ResulSet seront updatable (autant dire quand les poules auront des dents)
			//			rs.deleteRow();
			String query =
				"DELETE FROM Compte" + " WHERE LOGIN_COM='" + login + "'";
			if (requestor.executeQuery(query) == 0)
				throw new ManagerException(
					"Impossible to remove student '" + login + "'");
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
		StringBuffer query = new StringBuffer("SELECT * FROM Compte WHERE");
		query.append(" LOGIN_COM like '" + login + "'");
		query.append(" AND NOM_COM like '" + name + "'");

		try {
			rs = requestor.doQuery(query.toString());
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

	private ResultSet doSelectQuery(String login) throws SQLException {
		return requestor.doQuery(
			"SELECT * FROM Compte WHERE LOGIN_COM = '" + login + "'");
	}

	private void updateRow(ResultSet rs, User user) throws SQLException {
		rs.updateString("LOGIN_COM", user.getLogin());
		rs.updateString("NOM_COM", user.getName());
		rs.updateString("PRENOM_COM", user.getFirstname());
		rs.updateString("MAIL_COM", user.getEmail());
		rs.updateBoolean("EST_ADM_COM", user.getAdmin());
		rs.updateString("PASS_COM", user.getPassword());
	}
}