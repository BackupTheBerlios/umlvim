// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * UserLogonForm.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:form name="userLogonForm"
 */
public class UserLogonForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables

	/** password property */
	private String password;

	/** login property */
	private String login;

	// --------------------------------------------------------- Methods

	/** 
	 * Method validate
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 * @return ActionErrors
	 */
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if((login == null) || (login.equals(""))) {
			errors.add("login", new ActionError("error.required"));
		}
		if((password == null) || (password).equals("")) {
			errors.add("password", new ActionError("error.required"));
		}
		return errors;
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		password = "";
		login = "";

	}

	/** 
	 * Returns the password.
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/** 
	 * Set the password.
	 * @param password The password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** 
	 * Returns the login.
	 * @return String
	 */
	public String getLogin() {
		return login;
	}

	/** 
	 * Set the login.
	 * @param login The login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
}