package fr.umlv.desperados.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

/** 
 * AddStudentForm.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-29-2004
 * 
 * XDoclet definition:
 * @struts:form name="StudentForm"
 */
public class StudentForm extends ActionForm {
	
	private String id;
	private String patronymicName;
	private String firstname1;
	private String birthday;
	private String action;

	// --------------------------------------------------------- Instance Variables

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
		MessageResources resources = servlet.getInternal();

		if((patronymicName == null) || (patronymicName.equals(""))) {
			errors.add("patronymicName", new ActionError("error.required"));
		}
		if((firstname1 == null) || (firstname1).equals("")) {
			errors.add("firstname1", new ActionError("error.required"));
		}
		if((birthday == null) || (birthday).equals("")) {
			errors.add("birthday", new ActionError("error.required"));
		} else {
			String formatRegexp = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
			if (!birthday.matches(formatRegexp)) {
				errors.add("birthday", new ActionError("error.date.format",
																	"jj/mm/aaaa"));
			}
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
		action="create";
	}




	/**
	 * @return
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @return
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @return
	 */
	public String getFirstname1() {
		return firstname1;
	}

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getPatronymicName() {
		return patronymicName;
	}

	/**
	 * @param string
	 */
	public void setAction(String string) {
		action = string;
	}

	/**
	 * @param string
	 */
	public void setBirthday(String string) {
		birthday = string;
	}

	/**
	 * @param string
	 */
	public void setFirstname1(String string) {
		firstname1 = string;
	}

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setPatronymicName(String string) {
		patronymicName = string;
	}

}
