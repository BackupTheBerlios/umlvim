//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\User.java

package fr.umlv.desperados.account;

/**
 * Object that defines a user of the application (i.e. members of the secretariat 
 * and administrators)
 */
public class User {

	/**
	 * The statut of the User : <code>true</code> if the User is admin, 
	 * <code>false</code> otherwise.
	 */
	private boolean admin = false;

	/**
	 * The e-mail address of the User.
	 */
	private String email = null;

	/**
	 * The firstname of the User.
	 */
	private String firstname = null;

	/**
	 * The login of the User ; must be unique (it's the primary key in the database).
	 */
	private String login = null;

	/**
	 * The name of the User.
	 */
	private String name = null;

	/**
	 * The password of the User, in plain text.
	 */
	private String password = null;

	/**
	 * Constructor.
	 * 
	 * @param login the login of the User to create.
	 * @roseuid 3FC3BF8C03D5
	 */
	public User(String login) {
		this.login = login;
	}

	/**
	 * Returns the name of the User.
	 * 
	 * @return the name of the User.
	 * @roseuid 3FE1706C0078
	 */
	public boolean getAdmin() {
		return admin;
	}

	/**
	 * Returns the e-mail address of the User.
	 * 
	 * @return the e-mail address of the User.
	 * @roseuid 3FE17053023E
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Returns the firstname of the User.
	 * 
	 * @return the firstname of the User.
	 * @roseuid 3FE1705D008A
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Returns the login of the User.
	 * 
	 * @return the login of the User.
	 * @roseuid 3FE17078024C
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Access method for the name property.
	 * 
	 * @return   the current value of the name property
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the password of the User, in plain text.
	 * 
	 * @return the password of the User.
	 * @roseuid 3FE55BE0025C
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the statut of the User.
	 * 
	 * @param isAdmin whether the User is admin or not.
	 * @roseuid 3FE170A1033B
	 */
	public void setAdmin(boolean isAdmin) {
		admin = isAdmin;
	}

	/**
	 * Sets the e-mail address of the User.
	 * 
	 * @param email the new e-mail address of the User.
	 * @roseuid 3FE170870059
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the firstname of the User.
	 * 
	 * @param firstname the new firstname of the User.
	 * @roseuid 3FE1708F0213
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Sets the value of the login property.
	 * 
	 * @param login the new value of the login property
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Sets the value of the name property.
	 * 
	 * @param name the new value of the name property
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the password of the User.
	 * 
	 * @param password the new password of the User.
	 * @roseuid 3FE55BEB012B
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
