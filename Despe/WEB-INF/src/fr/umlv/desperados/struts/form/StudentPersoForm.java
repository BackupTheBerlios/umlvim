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
public class StudentPersoForm extends ActionForm {
	
	// --------------------------------------------------------- Instance Variables

	private String patronymicName;
	private String name;
	private String firstname1;
	private String firstname2;
	private String ine;
	private String birthday;
	private String birthplace;
	private String birthdep;
	private String sex;
	private String nationality;

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

		if((birthday == null) || (birthday.equals(""))) {
			errors.add("birthday", new ActionError("error.required"));
		}
		if((birthplace == null) || (birthplace.equals(""))) {
			errors.add("birthplace", new ActionError("error.required"));
		}
		if((birthdep == null) || (birthdep.equals(""))) {
			errors.add("birthdep", new ActionError("error.required"));
		}
		if((firstname1 == null) || (firstname1.equals(""))) {
			errors.add("firstname1", new ActionError("error.required"));
		}
		if((firstname2 == null) || (firstname2.equals(""))) {
			errors.add("firstname2", new ActionError("error.required"));
		}
		if((ine == null) || (ine.equals(""))) {
			errors.add("ine", new ActionError("error.required"));
		}
		if((name == null) || (name.equals(""))) {
			errors.add("name", new ActionError("error.required"));
		}
		if((nationality == null) || (nationality.equals(""))) {
			errors.add("nationality", new ActionError("error.required"));
		}
		if((patronymicName == null) || (patronymicName.equals(""))) {
			errors.add("patronymicName", new ActionError("error.required"));
		}
		if((sex == null) || (sex.equals(""))) {
			errors.add("sex", new ActionError("error.required"));
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
		name = "";
		firstname1 = "";
		firstname2 = "";
		ine = "";
		birthday = "";
		birthplace = "";
		birthdep = "";
		sex = "";
		nationality = "";
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
	public String getBirthdep() {
		return birthdep;
	}

	/**
	 * @return
	 */
	public String getBirthplace() {
		return birthplace;
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
	public String getFirstname2() {
		return firstname2;
	}

	/**
	 * @return
	 */
	public String getIne() {
		return ine;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * @return
	 */
	public String getPatronymicName() {
		return patronymicName;
	}

	/**
	 * @return
	 */
	public String getSex() {
		return sex;
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
	public void setBirthdep(String string) {
		birthdep = string;
	}

	/**
	 * @param string
	 */
	public void setBirthplace(String string) {
		birthplace = string;
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
	public void setFirstname2(String string) {
		firstname2 = string;
	}

	/**
	 * @param string
	 */
	public void setIne(String string) {
		ine = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	/**
	 * @param string
	 */
	public void setNationality(String string) {
		nationality = string;
	}

	/**
	 * @param string
	 */
	public void setPatronymicName(String string) {
		patronymicName = string;
	}

	/**
	 * @param string
	 */
	public void setSex(String string) {
		sex = string;
	}

}