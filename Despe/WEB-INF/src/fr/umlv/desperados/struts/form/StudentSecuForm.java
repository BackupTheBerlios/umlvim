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
public class StudentSecuForm extends ActionForm {
	
	// --------------------------------------------------------- Instance Variables

	private String affiliation;

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

		if((affiliation == null) || (affiliation.equals(""))) {
			errors.add("affiliation", new ActionError("error.required"));
		}
		return errors;
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		affiliation="";
	}

	/**
	 * @return
	 */
	public String getAffiliation() {
		return affiliation;
	}

	/**
	 * @param string
	 */
	public void setAffiliation(String string) {
		affiliation = string;
	}
}