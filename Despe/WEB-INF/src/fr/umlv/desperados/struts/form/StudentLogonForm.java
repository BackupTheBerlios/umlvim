// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.util.Constants;

/** 
 * UserLogonForm.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:form name="StudentLogonForm"
 */
public class StudentLogonForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables

	/** name property */
	private String name;

	/** firstname property */
	private String firstname;

	/** birthday property */
	private String birthday;

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
		if((name == null) || (name.equals(""))) {
			errors.add("name", new ActionError("error.required"));
		}
		if((firstname == null) || (firstname).equals("")) {
			errors.add("firstname", new ActionError("error.required"));
		}
		if((birthday == null) || (birthday).equals("")) {
			errors.add("birthday", new ActionError("error.required"));
		} else if (!birthday.matches(Constants.DATE_FORMAT)) {
			errors.add("birthday", new ActionError("error.date.matches",
															Constants.DATE_FORMAT.replaceAll("\\d", "X")));
		}
		return errors;
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		name = "";
		firstname = "";
		birthday = "";
	}

	/** 
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/** 
	 * Set the name.
	 * @param name The name to set
	 */
	public void setPassword(String name) {
		this.name = name;
	}

	/** 
	 * Returns the firstname.
	 * @return String
	 */
	public String getFirstname() {
		return firstname;
	}

	/** 
	 * Set the login.
	 * @param login The login to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/** 
	 * Returns the birthday.
	 * @return String
	 */
	public String getBirthday() {
		return birthday;
	}

	/** 
	 * Set the birthday.
	 * @param birthday The birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
