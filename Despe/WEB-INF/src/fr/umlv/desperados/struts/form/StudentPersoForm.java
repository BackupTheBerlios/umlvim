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
	private String addressTemp;
	private String addressFixe;
	private String zip;
	private String zipTemp;
	private String city;
	private String cityTemp;
	private String country;
	private String countryTemp;
	private String phone;
	private String phoneTemp;
	private String lodgingType;
	private String famSituation;
	private String handicap;
	private String militarySituation;
	private String workedShare;
	private String emlpoyed;
	private String workNature;
	private String headFamilyProfession;

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
		if((addressTemp == null) || (addressTemp.equals(""))) {
			errors.add("addressTemp", new ActionError("error.required"));
		}
		if((addressFixe == null) || (addressFixe.equals(""))) {
			errors.add("addressFixe", new ActionError("error.required"));
		}
		if((zip == null) || (zip.equals(""))) {
			errors.add("zip", new ActionError("error.required"));
		}
		if((zipTemp == null) || (zipTemp.equals(""))) {
			errors.add("zipTemp", new ActionError("error.required"));
		}
		if((city == null) || (city.equals(""))) {
			errors.add("city", new ActionError("error.required"));
		}
		if((cityTemp == null) || (cityTemp.equals(""))) {
			errors.add("cityTemp", new ActionError("error.required"));
		}
		if((country == null) || (country.equals(""))) {
			errors.add("country", new ActionError("error.required"));
		}
		if((countryTemp == null) || (countryTemp.equals(""))) {
			errors.add("countryTemp", new ActionError("error.required"));
		}
		if((phone == null) || (phone.equals(""))) {
			errors.add("phone", new ActionError("error.required"));
		}
		if((phoneTemp == null) || (phoneTemp.equals(""))) {
			errors.add("phoneTemp", new ActionError("error.required"));
		}
		if((lodgingType == null) || (lodgingType.equals(""))) {
			errors.add("lodgingType", new ActionError("error.required"));
		}
		if((famSituation == null) || (famSituation.equals(""))) {
			errors.add("lodgingType", new ActionError("error.required"));
		}
		if((handicap == null) || (handicap.equals(""))) {
			errors.add("handicap", new ActionError("error.required"));
		}
		if((militarySituation == null) || (militarySituation.equals(""))) {
			errors.add("militarySituation", new ActionError("error.required"));
		}
		if((workedShare == null) || (workedShare.equals(""))) {
			errors.add("workedShare", new ActionError("error.required"));
		}
		if((emlpoyed == null) || (emlpoyed.equals(""))) {
			errors.add("emlpoyed", new ActionError("error.required"));
		}
		if((workNature == null) || (workNature.equals(""))) {
			errors.add("workNature", new ActionError("error.required"));
		}
		if((headFamilyProfession == null) || (headFamilyProfession.equals(""))) {
			errors.add("headFamilyProfession", new ActionError("error.required"));
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
		city="";
		cityTemp="";
		country="";
		countryTemp="";
		phone="";
		phoneTemp="";
		famSituation="";
		handicap="";
		militarySituation="";
		workedShare="";
		emlpoyed="";
		workNature="";
		headFamilyProfession="";
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

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param string
	 */
	public void setCity(String string) {
		city = string;
	}

	/**
	 * @param string
	 */
	public void setCountry(String string) {
		country = string;
	}

	/**
	 * @param string
	 */
	public void setZip(String string) {
		zip = string;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param string
	 */
	public void setPhone(String string) {
		phone = string;
	}

	/**
	 * @return
	 */
	public String getLodgingType() {
		return lodgingType;
	}

	/**
	 * @param string
	 */
	public void setLodgingType(String string) {
		lodgingType = string;
	}

	/**
	 * @return
	 */
	public String getAddressFixe() {
		return addressFixe;
	}

	/**
	 * @return
	 */
	public String getAddressTemp() {
		return addressTemp;
	}

	/**
	 * @param string
	 */
	public void setAddressFixe(String string) {
		addressFixe = string;
	}

	/**
	 * @param string
	 */
	public void setAddressTemp(String string) {
		addressTemp = string;
	}

	/**
	 * @return
	 */
	public String getCityTemp() {
		return cityTemp;
	}

	/**
	 * @return
	 */
	public String getCountryTemp() {
		return countryTemp;
	}

	/**
	 * @return
	 */
	public String getPhoneTemp() {
		return phoneTemp;
	}

	/**
	 * @return
	 */
	public String getZipTemp() {
		return zipTemp;
	}

	/**
	 * @param string
	 */
	public void setCityTemp(String string) {
		cityTemp = string;
	}

	/**
	 * @param string
	 */
	public void setCountryTemp(String string) {
		countryTemp = string;
	}

	/**
	 * @param string
	 */
	public void setPhoneTemp(String string) {
		phoneTemp = string;
	}

	/**
	 * @param string
	 */
	public void setZipTemp(String string) {
		zipTemp = string;
	}

	/**
	 * @return
	 */
	public String getFamSituation() {
		return famSituation;
	}

	/**
	 * @param string
	 */
	public void setFamSituation(String string) {
		famSituation = string;
	}

	/**
	 * @return
	 */
	public String getHandicap() {
		return handicap;
	}

	/**
	 * @param string
	 */
	public void setHandicap(String string) {
		handicap = string;
	}

	/**
	 * @return
	 */
	public String getMilitarySituation() {
		return militarySituation;
	}

	/**
	 * @param string
	 */
	public void setMilitarySituation(String string) {
		militarySituation = string;
	}

	/**
	 * @return
	 */
	public String getWorkedShare() {
		return workedShare;
	}

	/**
	 * @param string
	 */
	public void setWorkedShare(String string) {
		workedShare = string;
	}

	/**
	 * @return
	 */
	public String getEmlpoyed() {
		return emlpoyed;
	}

	/**
	 * @return
	 */
	public String getWorkNature() {
		return workNature;
	}

	/**
	 * @param string
	 */
	public void setEmlpoyed(String string) {
		emlpoyed = string;
	}

	/**
	 * @param string
	 */
	public void setWorkNature(String string) {
		workNature = string;
	}

	/**
	 * @return
	 */
	public String getHeadFamilyProfession() {
		return headFamilyProfession;
	}

	/**
	 * @param string
	 */
	public void setHeadFamilyProfession(String string) {
		headFamilyProfession = string;
	}

}