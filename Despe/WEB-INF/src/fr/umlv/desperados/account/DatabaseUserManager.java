//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserManager.java

package fr.umlv.desperados.account;

import java.util.List;
import java.sql.*;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.util.Cache;

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
	public void addUser(User user)
		throws UserAlreadyExistsException, SQLException {

		ResultSet rs = selectQuery(user.getLogin());
		if (rs.first()) {
			throw new UserAlreadyExistsException("User exists in the database");
		} else {
			rs.moveToInsertRow();
			rs.updateString("LOGIN_COM", user.getLogin());
			rs.updateString("NOM_COM", user.getName());
			rs.updateString("PRENOM_COM", user.getFirstname());
			rs.updateString("MAIL_COM", user.getEmail());
			rs.updateBoolean("EST_ADM_COM", user.getAdmin());
			rs.updateString("PASS_COM", user.getPassword());
		}
	}

	/**
	 * @param login
	 * @return boolean
	 * @roseuid 3FF869B902F0
	 */
	public boolean existUser(String login) throws SQLException {
		ResultSet rs = null;
		rs =
			requestor.getQueryResult(
				"SELECT NOM_COM FROM Compte WHERE LOGIN_COM like '"
					+ login
					+ "'");

		if (rs.next())
			return true;

		else
			return false;
	}

	/**
	 * @param login
	 * @return fr.umlv.desperados.account.User
	 * @roseuid 3FF869B9030F
	 */
	public User getUser(String login)
		throws UserNotFoundException, SQLException {

		User user = null;
		ResultSet rs = null;
		rs =
			requestor.getQueryResult(
				"SELECT * FROM Compte WHERE LOGIN_COM like '" + login + "'");

		if (!rs.first()) {
			throw new UserNotFoundException("User doesn't exist in the database");
		}

		user = new User(rs.getString("LOGIN_COM"));
		user.setName(rs.getString("NOM_COM"));
		user.setFirstname(rs.getString("PRENOM_COM"));
		user.setEmail(rs.getString("MAIL_COM"));
		user.setAdmin(rs.getBoolean("EST_ADM_COM"));
		user.setPassword(rs.getString("PASS_COM"));

		rs.close();
		return user;
	}

	/**
	 * @param user
	 * @throws fr.umlv.desperados.account.UserNotFoundException
	 * @roseuid 3FF869B90323
	 */
	public void modifyUser(User user)
		throws UserNotFoundException, SQLException {
		requestor.executeQuery(
			"UPDATE TABLE Compte SET LOGIN_COM='"
				+ user.getLogin()
				+ "',NOM_COM='"
				+ user.getName()
				+ "',PRENOM_COM='"
				+ user.getFirstname()
				+ "',EST_ADM_COM="
				+ user.getAdmin()
				+ ",PASS_COM='"
				+ user.getPassword()
				+ "'");
	}

	/**
	 * @param login
	 * @return fr.umlv.desperados.account.User
	 * @throws fr.umlv.desperados.account.UserNotFoundException
	 * @roseuid 3FF869B90341
	 */
	public User removeUser(String login)
		throws UserNotFoundException, SQLException {
		User user;
		if (existUser(login))
			throw new UserNotFoundException("User doesn't exist in the database");

		user = getUser(login);

		ResultSet rs = null;
		rs =
			requestor.getQueryResult(
				"SELECT * FROM Compte WHERE LOGIN_COM like '" + login + "'");
		if (rs.first()) {
			rs.deleteRow();
			rs.updateString("NOM_COM", user.getEmail());
			rs.updateRow();
		}
		return user;
	}

	/**
	 * @param login
	 * @param name
	 * @return java.util.List
	 * @roseuid 3FF869B90369
	 */
	public List searchUser(String login, String name) throws SQLException {
		ResultSet rs = null;
		DatabaseUserList userList = null;
		StringBuffer search = new StringBuffer("SELECT * FROM Compte WHERE");
		if (login != null) {
			search.append(" LOGIN_COM like '" + login + "%' ");
			if (name != null)
				search.append("OR NOM_COM like '" + name + "%' ");
		} else
			search.append("NOM_COM like '" + name + "%' ");

		rs =
			requestor.getQueryResult(
				"SELECT * FROM Compte WHERE LOGIN_COM like '"
					+ login
					+ "%' OR NOM_COM like '"
					+ name
					+ "%'");

		userList = new DatabaseUserList(rs);
		return (List) userList;
	}

	/**
	 * Sets the size of the cache of this manager.
	 * 
	 * @param size the new size of the cache.
	 * @roseuid 3FF9BC6C0105
	 */
	public void setCacheSize(int size) {
		//cache.setCapacity(10);
	}

	private ResultSet selectQuery(String login) {
		ResultSet rs = null;
		try {
			rs =
				requestor.doQuery(
					"SELECT * FROM Compte WHERE LOGIN_COM = '" + login + "'");
		} catch (SQLException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
		return rs;
	}
}