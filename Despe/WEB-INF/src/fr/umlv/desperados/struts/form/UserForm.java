//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\form\\UserForm.java

package fr.umlv.desperados.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * UserForm.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:form name="userForm"
 */
public class UserForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables

	/** login property */
	private String login;

	/** name property */
	private String name;

	/** firstname property */
	private String firstname;

	/** admin property */
	private boolean admin;

	/** email property */
	private String email;

	/** generatePassword property */
	private boolean generatePassword;

	/** action property */
	private String action;

	// --------------------------------------------------------- Methods

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping arg0, HttpServletRequest arg1) {

		action = "create";
		login = null;
		name = null;
		firstname = null;
		email = null;
		admin = false;
		generatePassword = false;
	}

	/** 
	 * Method validate
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {

		ActionErrors errors = new ActionErrors();
		if(name == null || name.equals("")) {
			errors.add("name",
						new ActionError("error.required"));
		}
		if(firstname == null || firstname.equals("")) {
			errors.add("firstname",
						new ActionError("error.required"));
		}
		if(email == null || email.equals("")) {
			errors.add("email",
						new ActionError("error.required"));
		}
		return errors;
	}

	/** 
	 * Returns the action.
	 * @return String
	 */
	public String getAction() {
		return action;
	}

	/** 
	 * Returns the admin.
	 * @return boolean
	 */
	public boolean getAdmin() {
		return admin;
	}

	/** 
	 * Returns the email.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/** 
	 * Returns the firstname.
	 * @return String
	 */
	public String getFirstname() {
		return firstname;
	}

	/** 
	 * Returns the login.
	 * @return String
	 */
	public String getLogin() {
		return login;
	}

	/** 
	 * Returns the generatePassword.
	 * @return boolean
	 */
	public boolean getGeneratePassword() {
		return generatePassword;
	}

	/** 
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/** 
	 * Set the action.
	 * @param action The action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/** 
	 * Set the admin.
	 * @param admin The admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/** 
	 * Set the email.
	 * @param email The email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 
	 * Set the firstname.
	 * @param firstname The firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/** 
	 * Set the login.
	 * @param login The login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/** 
	 * Set the generatePassword.
	 * @param generatePassword The generatePassword to set
	 */
	public void setGeneratePassword(boolean generatePassword) {
		this.generatePassword = generatePassword;
	}

	/** 
	 * Set the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
