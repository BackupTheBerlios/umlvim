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
public class StudentFinancialForm extends ActionForm {
	
	// --------------------------------------------------------- Instance Variables

	private String financialAssistance;
	private String purse;

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

		if((financialAssistance == null) || (financialAssistance.equals(""))) {
			errors.add("financialAssistance", new ActionError("error.required"));
		}
		if((purse == null) || (purse.equals(""))) {
				errors.add("purse", new ActionError("error.required"));
			}
		return errors;
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		purse="";
		financialAssistance="";
	}

	/**
	 * @return
	 */
	public String GetFinancialAssistance() {
		return financialAssistance;
	}

	/**
	 * @param string
	 */
	public void setFinancialAssistance(String string) {
		financialAssistance = string;
	}
	
	
	
	/**
	 * @return
	 */
	public String getPurse() {
		return purse;
	}

	/**
	 * @param string
	 */
	public void setPurse(String string) {
		purse = string;
	}
}