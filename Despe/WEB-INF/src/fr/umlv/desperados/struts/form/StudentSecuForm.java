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
	private String nonAffiliation;
	private String centerPayment;
	private String mutualInsuranceCompany;

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
		if((nonAffiliation == null) || (nonAffiliation.equals(""))) {
				errors.add("nonAffiliation", new ActionError("error.required"));
			}
		if((centerPayment == null) || (centerPayment.equals(""))) {
				errors.add("centerPayment", new ActionError("error.required"));
			}
		if((mutualInsuranceCompany == null) || (mutualInsuranceCompany.equals(""))) {
				errors.add("mutualInsuranceCompany", new ActionError("error.required"));
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
		nonAffiliation="";
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
	
	
	
	/**
	 * @return
	 */
	public String getNonAffiliation() {
		return nonAffiliation;
	}

	/**
	 * @param string
	 */
	public void setNonAffiliation(String string) {
		nonAffiliation = string;
	}
	
	
	/**
	 * @return
	 */
	public String getCenterPayment() {
		return centerPayment;
	}

	/**
	 * @param string
	 */
	public void setCenterPayment(String string) {
		centerPayment = string;
	}
	
	/**
		 * @return
		 */
		public String getMutualInsuranceCompany() {
			return mutualInsuranceCompany;
		}

		/**
		 * @param string
		 */
		public void setMutualInsuranceCompany(String string) {
			mutualInsuranceCompany = string;
		}
}