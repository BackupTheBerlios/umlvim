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
	private String patronymicName;

	/** firstname property */
	private String firstname1;

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
		if((patronymicName == null) || (patronymicName.equals(""))) {
			errors.add("patronymicName", new ActionError("error.required"));
		}
		if((firstname1 == null) || (firstname1).equals("")) {
			errors.add("firstname1", new ActionError("error.required"));
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
		patronymicName = "";
		firstname1 = "";
		birthday = "";
	}

	/** 
	 * Returns the name.
	 * @return String
	 */
	public String getPatronymicName() {
		return patronymicName;
	}

	/** 
	 * Set the name.
	 * @param name The name to set
	 */
	public void setPatronymicName(String name) {
		this.patronymicName = name;
	}

	/**
	 * Returns the firstname.
	 * @return String
	 */
	public String getFirstname1() {
		return firstname1;
	}

	/** 
	 * Set the login.
	 * @param login The login to set
	 */
	public void setFirstname1(String firstname) {
		this.firstname1 = firstname;
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
