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
public class StudentStudiesForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
	private String wasMLVLastYear;
	private String yearsSup;
	private String yearsFreUniv;
	private String establishment;
	private String frenchDep;
	private String yearsEstab;
	private String baccalaureat;
	private String bacMention;
	private String bacPre95;
	private String yearsBac;
	private String baccalaureatEstablishmentType;
	private String frenchCity;
	private String frenchDepBac;


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

		if((wasMLVLastYear == null) || (wasMLVLastYear.equals(""))) {
			errors.add("wasMLVLastYear", new ActionError("error.required"));
		}
		if((yearsSup == null) || (yearsSup.equals(""))) {
			errors.add("YearsSup", new ActionError("error.required"));
		}
		if((yearsFreUniv == null) || (yearsFreUniv.equals(""))) {
			errors.add("YearsFreUniv", new ActionError("error.required"));
		}
		if((establishment == null) || (establishment.equals(""))) {
			errors.add("establishment", new ActionError("error.required"));
		}
		if((frenchDep == null) || (frenchDep.equals(""))) {
			errors.add("frenchDep", new ActionError("error.required"));
		}
		if((yearsEstab == null) || (yearsEstab.equals(""))) {
			errors.add("yearsEstab", new ActionError("error.required"));
		}
		if((baccalaureat == null) || (baccalaureat.equals(""))) {
			errors.add("baccalaureat", new ActionError("error.required"));
		}
		if((bacMention == null) || (bacMention.equals(""))) {
			errors.add("bacMention", new ActionError("error.required"));
		}
		if((bacPre95 == null) || (bacPre95.equals(""))) {
			errors.add("bacPre95", new ActionError("error.required"));
		}
		if((yearsBac == null) || (yearsBac.equals(""))) {
			errors.add("yearsBac", new ActionError("error.required"));
		}
		if((baccalaureatEstablishmentType == null) || (baccalaureatEstablishmentType.equals(""))) {
			errors.add("baccalaureatEstablishmentType", new ActionError("error.required"));
		}
		if((frenchCity == null) || (frenchCity.equals(""))) {
			errors.add("frenchCity", new ActionError("error.required"));
		}
		if((frenchDepBac == null) || (frenchDepBac.equals(""))) {
			errors.add("frenchDepBac", new ActionError("error.required"));
		}
		
		return errors;
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		wasMLVLastYear="";
		yearsSup="";
		yearsFreUniv="";
		establishment="";
		frenchDep="";
		yearsEstab="";
		baccalaureat="";
		bacMention="";
		bacPre95="";
		yearsBac="";
		baccalaureatEstablishmentType="";
		frenchCity="";
		frenchDepBac="";
	}



	/**
	 * @return
	 */
	public String getWasMLVLastYear() {
		return wasMLVLastYear;
	}

	/**
	 * @param string
	 */
	public void setWasMLVLastYear(String string) {
		wasMLVLastYear = string;
	}

	/**
	 * @return
	 */
	public String getEstablishment() {
		return establishment;
	}


	/**
	 * @return
	 */
	public String getYearsSup() {
		return yearsSup;
	}

	/**
	 * @param string
	 */
	public void setEstablishment(String string) {
		establishment = string;
	}


	/**
	 * @param string
	 */
	public void setYearsSup(String string) {
		yearsSup = string;
	}

	/**
	 * @return
	 */
	public String getYearsFreUniv() {
		return yearsFreUniv;
	}

	/**
	 * @param string
	 */
	public void setYearsFreUniv(String string) {
		yearsFreUniv = string;
	}

	/**
	 * @return
	 */
	public String getFrenchDep() {
		return frenchDep;
	}

	/**
	 * @param string
	 */
	public void setFrenchDep(String string) {
		frenchDep = string;
	}

	/**
	 * @return
	 */
	public String getYearsEstab() {
		return yearsEstab;
	}

	/**
	 * @param string
	 */
	public void setYearsEstab(String string) {
		yearsEstab = string;
	}

	/**
	 * @return
	 */
	public String getBaccalaureat() {
		return baccalaureat;
	}

	/**
	 * @param string
	 */
	public void setBaccalaureat(String string) {
		baccalaureat = string;
	}

	/**
	 * @return
	 */
	public String getBacMention() {
		return bacMention;
	}

	/**
	 * @param string
	 */
	public void setBacMention(String string) {
		bacMention = string;
	}

	/**
	 * @return
	 */
	public String getBacPre95() {
		return bacPre95;
	}

	/**
	 * @param string
	 */
	public void setBacPre95(String string) {
		bacPre95 = string;
	}

	/**
	 * @return
	 */
	public String getYearsBac() {
		return yearsBac;
	}

	/**
	 * @param string
	 */
	public void setYearsBac(String string) {
		yearsBac = string;
	}

	/**
	 * @return
	 */
	public String getBaccalaureatEstablishmentType() {
		return baccalaureatEstablishmentType;
	}

	/**
	 * @param string
	 */
	public void setBaccalaureatEstablishmentType(String string) {
		baccalaureatEstablishmentType = string;
	}


	/**
	 * @return
	 */
	public String getFrenchCity() {
		return frenchCity;
	}

	/**
	 * @param string
	 */
	public void setFrenchCity(String string) {
		frenchCity = string;
	}

	/**
	 * @return
	 */
	public String getFrenchDepBac() {
		return frenchDepBac;
	}

	/**
	 * @param string
	 */
	public void setFrenchDepBac(String string) {
		frenchDepBac = string;
	}

}