//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\student\\Student.java

package fr.umlv.desperados.student;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import fr.umlv.desperados.util.XMLable;

/**
 * Object that defines a student in the application.
 */
public class Student implements XMLable {

	/**
	 * primary key in the Student database
	 */
	private int studentId;

	/**
	 * @see Current name
	 */
	private String name;
	private java.sql.Date birthday;
	private String ine;
	private boolean wasToUmlvLastYear;
	private String patronymicName;
	private String firstname1;
	private String firstname2;
	private String townOfBirth;
	private String sex;
	private String firstInsSupEduc;

	/**
	 * @see first inscription french university
	 */
	private String firstInsFrenchUniv;

	/**
	 * @see establishment first inscription french university
	 */
	private String estaFirstInsFrenchUniv;

	/**
	 * @see first inscription establishment
	 */
	private String firstInsEstablishment;

	/**
	 * @see year bac obtaining
	 */
	private String bacYear;
	private String establishmentBacObtaining;

	/**
	 * @see foreign city bac
	 */
	private String foreignCityBac;

	/**
	 * @see have a fixed address in France
	 */
	private boolean haveFixAddFr;

	/**
	 * @see number fixe address
	 */
	private String numFixAdd;

	/**
	 * @see street fixe address
	 */
	private String streetFixAdd;

	/**
	 * @see building fixed address
	 */
	private String buildingFixAdd;

	/**
	 * @see foreign city fixed address
	 */
	private String foreignCityFixAdd;

	/**
	 * @see phone fixe address
	 */
	private String phoneFixAdd;

	/**
	 * @see have a temporary address in France
	 */
	private boolean haveTmpAddFr;

	/**
	 * @see number temporary address
	 */
	private String numTmpAdd;

	/**
	 * @see street temporary address
	 */
	private String streetTmpAdd;

	/**
	 * @see building temporary address
	 */
	private String buildingTmpAdd;

	/**
	 * @see city temporary address
	 */
	private String cityTmpAdd;

	/**
	 * @see phone temporary address
	 */
	private String phoneTmpAdd;

	/**
	 * @see is employed
	 */
	private boolean isEmployed;

	/**
	 * @see student employment type
	 */
	private String studEmplType;

	/**
	 * @see head of family profession
	 */
	private String headFamProf;

	/**
	 * @see is national sportsman
	 */
	private boolean isNatSport;
	private boolean isRegSport;

	/**
	 * @see practised sport
	 */
	private String practisedSport;

	/**
	 * @see have a financial assistance
	 */
	private boolean haveFinancialAss;

	/**
	 * @see international exchange original astablishment
	 */
	private String internaExchOriEstab;

	/**
	 * @see international exchange reception establishment
	 */
	private String internaExchRecEstab;

	/**
	 * @see last attended establishment
	 */
	private String lastAttendedEstab;

	/**
	 * @see last attended establishment year
	 */
	private String lastAttendedEstabYear;

	/**
	 * @see precedent year establishment
	 */
	private String precedentYearEstab;

	/**
	 * @see other inscription establishment
	 */
	private String otherInsEstab;

	/**
	 * @see principal cycle inscriptions number
	 */
	private int princCycleInsNum;

	/**
	 * @see complementary cycle inscriptions number
	 */
	private int complCycleInsNum;

	/**
	 * @see principal diploma inscription number
	 */
	private int princDiplInsNum;

	/**
	 * @see complementary diploma inscription number
	 */
	private int complDipInsNum;

	/**
	 * @see principal inscriptions year number
	 */
	private int princInsYearNum;

	/**
	 * @see complementary inscriptions year number
	 */
	private int compInsYearNum;

	/**
	 * @see stock broker number
	 */
	private int stockBrokerNum;

	/**
	 * @see social security number
	 */
	private String socialSecurityNum;

	/**
	 * @see father name
	 */
	private String fatherName;

	/**
	 * @see father first name
	 */
	private String fatherFirstName;

	/**
	 * @see mother patronymic name
	 */
	private String motherPatronymicName;

	/**
	 * @see mother name
	 */
	private String motherName;

	/**
	 * @see insurance civil liability
	 */
	private boolean insuranceCivilLiability;

	/**
	 * @see appointment date
	 */
	private Timestamp appointmentDate;
	private int workedShareId;
	private String financialAssistanceId;
	private int socialEconomicCategoryId;
	private int MLVDiplomaId;
	private String baccalaureatId;
	private int lodgingTypeId;
	private int inscriptionModeId;
	private int inscriptionTypeId;
	private int centerPaymentId;
	private int internationalExchangeTypeId;
	private int mutualInsuranceCompanyId;
	private int socialSecurityId;
	private int paymentModeId;
	private int purseId;
	private String lastDiplomaTypeId;
	private int bacMentionId;
	private int baccalaureatEstablishmentTypeId;
	private int lastEstabTypeId;
	private int militarySituationId;
	private int fixeAddFrenchCityId;
	private int tmpAdressFrenchCityId;
	private int frenchBirthplaceId;
	private int frenchBacCityId;

	/**
	 * @see first inscription in french university department identify
	 */
	private int firstInsFrUnivDepId;

	/**
	 * @see last attended establishment place identify
	 */
	private int lastAttendedEstabPlaceId;

	/**
	 * @see precedent year establishment place identify
	 */
	private int precYearEstabPlaceId;

	/**
	 * @see other establishment inscription place idetify
	 */
	private int otherEstabInsPlaceId;
	private int bacObtainingCountryId;
	private int nationalityId;
	private ArrayList handicapList;

	/**
	 * @see international exchange place identify
	 */
	private int intExchPlaceId;
	private int foreignBirthplaceId;

	/**
	 * @see fixed address country identify
	 */
	private int fixeAddCountryId;

	/**
	 * @see temporary address country identify
	 */
	private int tmpAddCountryId;

	/**
	 * @see precedent year situation type identify
	 */
	private String precYearSitTypeId;
	private int famSituation;
	private String motifProlSocSec;
	private boolean noSocSecStu;
	private int otherEtabIns;
	private int headFamJob;
	private int MLVDiplomaComplId;

	/**
	 * @param studentId
	 * @roseuid 3FCA089F033C
	 */
	public Student(int studentId) {
		this.studentId = studentId;
//		DateFormat.getDateInstance(DateFormat.SHORT).format(birthday);
	}

	/**
		* @param studentId
		* @roseuid 3FCA089F033C
		*/
	public Student() {
//		DateFormat.getDateInstance(DateFormat.SHORT).format(birthday);
	}

	/**
	 * @param name
	 * @roseuid 3FCB614B000D
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param birthday
	 * @roseuid 3FCB618101F5
	 */
	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @param ine
	 * @roseuid 3FD7AD2603D8
	 */
	public void setIne(String ine) {
		this.ine = ine;
	}

	/**
	 * @return int
	 * @roseuid 3FD7AD550148
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @return java.lang.String
	 * @roseuid 3FD7AD74003E
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return java.util.Date
	 * @roseuid 3FD7AD9000BB
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @return java.lang.String
	 * @roseuid 3FD7ADA80399
	 */
	public String getIne() {
		return ine;
	}

	/**
	 * @return java.lang.String
	 * @roseuid 3FF869BB00F5
	 */
	public String toXML() {
		return null;
	}
	/**
	 * @return
	 */
	public Timestamp getAppointmentDate() {
		return appointmentDate;
	}

	/**
	 * @return
	 */
	public int getBaccalaureatEstablishmentTypeId() {
		return baccalaureatEstablishmentTypeId;
	}

	/**
	 * @return
	 */
	public String getBaccalaureatId() {
		return baccalaureatId;
	}

	/**
	 * @return
	 */
	public int getBacMentionId() {
		return bacMentionId;
	}

	/**
	 * @return
	 */
	public int getBacObtainingCountryId() {
		return bacObtainingCountryId;
	}

	/**
	 * @return
	 */
	public String getBacYear() {
		return bacYear;
	}

	/**
	 * @return
	 */
	public String getBuildingFixAdd() {
		return buildingFixAdd;
	}

	/**
	 * @return
	 */
	public String getBuildingTmpAdd() {
		return buildingTmpAdd;
	}

	/**
	 * @return
	 */
	public int getCenterPaymentId() {
		return centerPaymentId;
	}

	/**
	 * @return
	 */
	public String getCityTmpAdd() {
		return cityTmpAdd;
	}

	/**
	 * @return
	 */
	public int getCompInsYearNum() {
		return compInsYearNum;
	}

	/**
	 * @return
	 */
	public int getComplCycleInsNum() {
		return complCycleInsNum;
	}

	/**
	 * @return
	 */
	public int getComplDipInsNum() {
		return complDipInsNum;
	}

	/**
	 * @return
	 */
	public String getEstablishmentBacObtaining() {
		return establishmentBacObtaining;
	}

	/**
	 * @return
	 */
	public String getEstaFirstInsFrenchUniv() {
		return estaFirstInsFrenchUniv;
	}

	/**
	 * @return
	 */
	public int getFamSituation() {
		return famSituation;
	}

	/**
	 * @return
	 */
	public String getFatherFirstName() {
		return fatherFirstName;
	}

	/**
	 * @return
	 */
	public String getFatherName() {
		return fatherName;
	}

	/**
	 * @return
	 */
	public String getFinancialAssistanceId() {
		return financialAssistanceId;
	}

	/**
	 * @return
	 */
	public String getFirstInsEstablishment() {
		return firstInsEstablishment;
	}

	/**
	 * @return
	 */
	public String getFirstInsFrenchUniv() {
		return firstInsFrenchUniv;
	}

	/**
	 * @return
	 */
	public int getFirstInsFrUnivDepId() {
		return firstInsFrUnivDepId;
	}

	/**
	 * @return
	 */
	public String getFirstInsSupEduc() {
		return firstInsSupEduc;
	}

	/**
	 * @return
	 */
	public int getFixeAddCountryId() {
		return fixeAddCountryId;
	}

	/**
	 * @return
	 */
	public int getFixeAddFrenchCityId() {
		return fixeAddFrenchCityId;
	}

	/**
	 * @return
	 */
	public int getForeignBirthplaceId() {
		return foreignBirthplaceId;
	}

	/**
	 * @return
	 */
	public String getForeignCityBac() {
		return foreignCityBac;
	}

	/**
	 * @return
	 */
	public String getForeignCityFixAdd() {
		return foreignCityFixAdd;
	}

	/**
	 * @return
	 */
	public int getFrenchBacCityId() {
		return frenchBacCityId;
	}

	/**
	 * @return
	 */
	public int getFrenchBirthplaceId() {
		return frenchBirthplaceId;
	}

	/**
	 * @return
	 */
	public boolean isHaveFinancialAss() {
		return haveFinancialAss;
	}

	/**
	 * @return
	 */
	public boolean isHaveFixAddFr() {
		return haveFixAddFr;
	}

	/**
	 * @return
	 */
	public boolean isHaveTmpAddFr() {
		return haveTmpAddFr;
	}

	/**
	 * @return
	 */
	public String getHeadFamProf() {
		return headFamProf;
	}

	/**
	 * @return
	 */
	public int getInscriptionModeId() {
		return inscriptionModeId;
	}

	/**
	 * @return
	 */
	public int getInscriptionTypeId() {
		return inscriptionTypeId;
	}

	/**
	 * @return
	 */
	public boolean isInsuranceCivilLiability() {
		return insuranceCivilLiability;
	}

	/**
	 * @return
	 */
	public String getInternaExchOriEstab() {
		return internaExchOriEstab;
	}

	/**
	 * @return
	 */
	public String getInternaExchRecEstab() {
		return internaExchRecEstab;
	}

	/**
	 * @return
	 */
	public int getInternationalExchangeTypeId() {
		return internationalExchangeTypeId;
	}

	/**
	 * @return
	 */
	public int getIntExchPlaceId() {
		return intExchPlaceId;
	}

	/**
	 * @return
	 */
	public boolean isEmployed() {
		return isEmployed;
	}

	/**
	 * @return
	 */
	public boolean isNatSport() {
		return isNatSport;
	}

	/**
	 * @return
	 */
	public boolean isRegSport() {
		return isRegSport;
	}

	/**
	 * @return
	 */
	public String getLastAttendedEstab() {
		return lastAttendedEstab;
	}

	/**
	 * @return
	 */
	public int getLastAttendedEstabPlaceId() {
		return lastAttendedEstabPlaceId;
	}

	/**
	 * @return
	 */
	public String getLastAttendedEstabYear() {
		return lastAttendedEstabYear;
	}

	/**
	 * @return
	 */
	public String getLastDiplomaTypeId() {
		return lastDiplomaTypeId;
	}

	/**
	 * @return
	 */
	public int getLastEstabTypeId() {
		return lastEstabTypeId;
	}

	/**
	 * @return
	 */
	public int getLodgingTypeId() {
		return lodgingTypeId;
	}

	/**
	 * @return
	 */
	public int getMilitarySituationId() {
		return militarySituationId;
	}

	/**
	 * @return
	 */
	public int getMLVDiplomaId() {
		return MLVDiplomaId;
	}

	/**
	 * @return
	 */
	public String getMotherName() {
		return motherName;
	}

	/**
	 * @return
	 */
	public String getMotherPatronymicName() {
		return motherPatronymicName;
	}

	/**
	 * @return
	 */
	public String getMotifProlSocSec() {
		return motifProlSocSec;
	}

	/**
	 * @return
	 */
	public int getMutualInsuranceCompanyId() {
		return mutualInsuranceCompanyId;
	}

	/**
	 * @return
	 */
	public int getNationalityId() {
		return nationalityId;
	}

	/**
	 * @return
	 */
	public boolean isNoSocSecStu() {
		return noSocSecStu;
	}

	/**
	 * @return
	 */
	public String getNumFixAdd() {
		return numFixAdd;
	}

	/**
	 * @return
	 */
	public String getNumTmpAdd() {
		return numTmpAdd;
	}

	/**
	 * @return
	 */
	public int getOtherEstabInsPlaceId() {
		return otherEstabInsPlaceId;
	}

	/**
	 * @return
	 */
	public int getOtherEtabIns() {
		return otherEtabIns;
	}

	/**
	 * @return
	 */
	public String getOtherInsEstab() {
		return otherInsEstab;
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
	public int getPaymentModeId() {
		return paymentModeId;
	}

	/**
	 * @return
	 */
	public String getPhoneFixAdd() {
		return phoneFixAdd;
	}

	/**
	 * @return
	 */
	public String getPhoneTmpAdd() {
		return phoneTmpAdd;
	}

	/**
	 * @return
	 */
	public String getPractisedSport() {
		return practisedSport;
	}

	/**
	 * @return
	 */
	public String getPrecedentYearEstab() {
		return precedentYearEstab;
	}

	/**
	 * @return
	 */
	public int getPrecYearEstabPlaceId() {
		return precYearEstabPlaceId;
	}

	/**
	 * @return
	 */
	public int getPrincCycleInsNum() {
		return princCycleInsNum;
	}

	/**
	 * @return
	 */
	public int getPrincDiplInsNum() {
		return princDiplInsNum;
	}

	/**
	 * @return
	 */
	public int getPrincInsYearNum() {
		return princInsYearNum;
	}

	/**
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @return
	 */
	public int getSocialEconomicCategoryId() {
		return socialEconomicCategoryId;
	}

	/**
	 * @return
	 */
	public int getSocialSecurityId() {
		return socialSecurityId;
	}

	/**
	 * @return
	 */
	public String getSocialSecurityNum() {
		return socialSecurityNum;
	}

	/**
	 * @return
	 */
	public int getStockBrokerNum() {
		return stockBrokerNum;
	}

	/**
	 * @return
	 */
	public String getStreetFixAdd() {
		return streetFixAdd;
	}

	/**
	 * @return
	 */
	public String getStreetTmpAdd() {
		return streetTmpAdd;
	}

	/**
	 * @return
	 */
	public String getStudEmplType() {
		return studEmplType;
	}

	/**
	 * @return
	 */
	public int getTmpAddCountryId() {
		return tmpAddCountryId;
	}

	/**
	 * @return
	 */
	public int getTmpAdressFrenchCityId() {
		return tmpAdressFrenchCityId;
	}

	/**
	 * @return
	 */
	public String getTownOfBirth() {
		return townOfBirth;
	}

	/**
	 * @return
	 */
	public boolean isWasToUmlvLastYear() {
		return wasToUmlvLastYear;
	}

	/**
	 * @return
	 */
	public int getWorkedShareId() {
		return workedShareId;
	}

	/**
	 * @param timestamp
	 */
	public void setAppointmentDate(Timestamp timestamp) {
		appointmentDate = timestamp;
	}

	/**
	 * @param i
	 */
	public void setBaccalaureatEstablishmentTypeId(int i) {
		baccalaureatEstablishmentTypeId = i;
	}

	/**
	 * @param string
	 */
	public void setBaccalaureatId(String string) {
		baccalaureatId = string;
	}

	/**
	 * @param i
	 */
	public void setBacMentionId(int i) {
		bacMentionId = i;
	}

	/**
	 * @param i
	 */
	public void setBacObtainingCountryId(int i) {
		bacObtainingCountryId = i;
	}

	/**
	 * @param string
	 */
	public void setBacYear(String string) {
		bacYear = string;
	}

	/**
	 * @param string
	 */
	public void setBuildingFixAdd(String string) {
		buildingFixAdd = string;
	}

	/**
	 * @param string
	 */
	public void setBuildingTmpAdd(String string) {
		buildingTmpAdd = string;
	}

	/**
	 * @param i
	 */
	public void setCenterPaymentId(int i) {
		centerPaymentId = i;
	}

	/**
	 * @param string
	 */
	public void setCityTmpAdd(String string) {
		cityTmpAdd = string;
	}

	/**
	 * @param i
	 */
	public void setCompInsYearNum(int i) {
		compInsYearNum = i;
	}

	/**
	 * @param i
	 */
	public void setComplCycleInsNum(int i) {
		complCycleInsNum = i;
	}

	/**
	 * @param i
	 */
	public void setComplDipInsNum(int i) {
		complDipInsNum = i;
	}

	/**
	 * @param string
	 */
	public void setEstablishmentBacObtaining(String string) {
		establishmentBacObtaining = string;
	}

	/**
	 * @param string
	 */
	public void setEstaFirstInsFrenchUniv(String string) {
		estaFirstInsFrenchUniv = string;
	}

	/**
	 * @param i
	 */
	public void setFamSituation(int i) {
		famSituation = i;
	}

	/**
	 * @param string
	 */
	public void setFatherFirstName(String string) {
		fatherFirstName = string;
	}

	/**
	 * @param string
	 */
	public void setFatherName(String string) {
		fatherName = string;
	}

	/**
	 * @param c
	 */
	public void setFinancialAssistanceId(String c) {
		financialAssistanceId = c;
	}

	/**
	 * @param string
	 */
	public void setFirstInsEstablishment(String string) {
		firstInsEstablishment = string;
	}

	/**
	 * @param string
	 */
	public void setFirstInsFrenchUniv(String string) {
		firstInsFrenchUniv = string;
	}

	/**
	 * @param i
	 */
	public void setFirstInsFrUnivDepId(int i) {
		firstInsFrUnivDepId = i;
	}

	/**
	 * @param string
	 */
	public void setFirstInsSupEduc(String string) {
		firstInsSupEduc = string;
	}

	/**
	 * @param i
	 */
	public void setFixeAddCountryId(int i) {
		fixeAddCountryId = i;
	}

	/**
	 * @param i
	 */
	public void setFixeAddFrenchCityId(int i) {
		fixeAddFrenchCityId = i;
	}

	/**
	 * @param i
	 */
	public void setForeignBirthplaceId(int i) {
		foreignBirthplaceId = i;
	}

	/**
	 * @param string
	 */
	public void setForeignCityBac(String string) {
		foreignCityBac = string;
	}

	/**
	 * @param string
	 */
	public void setForeignCityFixAdd(String string) {
		foreignCityFixAdd = string;
	}

	/**
	 * @param i
	 */
	public void setFrenchBacCityId(int i) {
		frenchBacCityId = i;
	}

	/**
	 * @param i
	 */
	public void setFrenchBirthplaceId(int i) {
		frenchBirthplaceId = i;
	}

	/**
	 * @param b
	 */
	public void setHaveFinancialAss(boolean b) {
		haveFinancialAss = b;
	}

	/**
	 * @param b
	 */
	public void setHaveFixAddFr(boolean b) {
		haveFixAddFr = b;
	}

	/**
	 * @param b
	 */
	public void setHaveTmpAddFr(boolean b) {
		haveTmpAddFr = b;
	}

	/**
	 * @param string
	 */
	public void setHeadFamProf(String string) {
		headFamProf = string;
	}

	/**
	 * @param i
	 */
	public void setInscriptionModeId(int i) {
		inscriptionModeId = i;
	}

	/**
	 * @param i
	 */
	public void setInscriptionTypeId(int i) {
		inscriptionTypeId = i;
	}

	/**
	 * @param b
	 */
	public void setInsuranceCivilLiability(boolean b) {
		insuranceCivilLiability = b;
	}

	/**
	 * @param string
	 */
	public void setInternaExchOriEstab(String string) {
		internaExchOriEstab = string;
	}

	/**
	 * @param string
	 */
	public void setInternaExchRecEstab(String string) {
		internaExchRecEstab = string;
	}

	/**
	 * @param i
	 */
	public void setInternationalExchangeTypeId(int i) {
		internationalExchangeTypeId = i;
	}

	/**
	 * @param i
	 */
	public void setIntExchPlaceId(int i) {
		intExchPlaceId = i;
	}

	/**
	 * @param b
	 */
	public void setEmployed(boolean b) {
		isEmployed = b;
	}

	/**
	 * @param b
	 */
	public void setNatSport(boolean b) {
		isNatSport = b;
	}

	/**
	 * @param b
	 */
	public void setRegSport(boolean b) {
		isRegSport = b;
	}

	/**
	 * @param string
	 */
	public void setLastAttendedEstab(String string) {
		lastAttendedEstab = string;
	}

	/**
	 * @param i
	 */
	public void setLastAttendedEstabPlaceId(int i) {
		lastAttendedEstabPlaceId = i;
	}

	/**
	 * @param string
	 */
	public void setLastAttendedEstabYear(String string) {
		lastAttendedEstabYear = string;
	}

	/**
	 * @param c
	 */
	public void setLastDiplomaTypeId(String c) {
		lastDiplomaTypeId = c;
	}

	/**
	 * @param i
	 */
	public void setLastEstabTypeId(int i) {
		lastEstabTypeId = i;
	}

	/**
	 * @param i
	 */
	public void setLodgingTypeId(int i) {
		lodgingTypeId = i;
	}

	/**
	 * @param i
	 */
	public void setMilitarySituationId(int i) {
		militarySituationId = i;
	}

	/**
	 * @param i
	 */
	public void setMLVDiplomaId(int i) {
		MLVDiplomaId = i;
	}

	/**
	 * @param string
	 */
	public void setMotherName(String string) {
		motherName = string;
	}

	/**
	 * @param string
	 */
	public void setMotherPatronymicName(String string) {
		motherPatronymicName = string;
	}

	/**
	 * @param string
	 */
	public void setMotifProlSocSec(String string) {
		motifProlSocSec = string;
	}

	/**
	 * @param i
	 */
	public void setMutualInsuranceCompanyId(int i) {
		mutualInsuranceCompanyId = i;
	}

	/**
	 * @param i
	 */
	public void setNationalityId(int i) {
		nationalityId = i;
	}

	/**
	 * @param b
	 */
	public void setNoSocSecStu(boolean b) {
		noSocSecStu = b;
	}

	/**
	 * @param string
	 */
	public void setNumFixAdd(String string) {
		numFixAdd = string;
	}

	/**
	 * @param string
	 */
	public void setNumTmpAdd(String string) {
		numTmpAdd = string;
	}

	/**
	 * @param i
	 */
	public void setOtherEstabInsPlaceId(int i) {
		otherEstabInsPlaceId = i;
	}

	/**
	 * @param i
	 */
	public void setOtherEtabIns(int i) {
		otherEtabIns = i;
	}

	/**
	 * @param string
	 */
	public void setOtherInsEstab(String string) {
		otherInsEstab = string;
	}

	/**
	 * @param string
	 */
	public void setPatronymicName(String string) {
		patronymicName = string;
	}

	/**
	 * @param i
	 */
	public void setPaymentModeId(int i) {
		paymentModeId = i;
	}

	/**
	 * @param i
	 */
	public void setPhoneFixAdd(String i) {
		phoneFixAdd = i;
	}

	/**
	 * @param i
	 */
	public void setPhoneTmpAdd(String i) {
		phoneTmpAdd = i;
	}

	/**
	 * @param string
	 */
	public void setPractisedSport(String string) {
		practisedSport = string;
	}

	/**
	 * @param string
	 */
	public void setPrecedentYearEstab(String string) {
		precedentYearEstab = string;
	}

	/**
	 * @param i
	 */
	public void setPrecYearEstabPlaceId(int i) {
		precYearEstabPlaceId = i;
	}

	/**
	 * @param i
	 */
	public void setPrincCycleInsNum(int i) {
		princCycleInsNum = i;
	}

	/**
	 * @param i
	 */
	public void setPrincDiplInsNum(int i) {
		princDiplInsNum = i;
	}

	/**
	 * @param i
	 */
	public void setPrincInsYearNum(int i) {
		princInsYearNum = i;
	}

	/**
	 * @param c
	 */
	public void setSex(String c) {
		sex = c;
	}

	/**
	 * @param i
	 */
	public void setSocialEconomicCategoryId(int i) {
		socialEconomicCategoryId = i;
	}

	/**
	 * @param i
	 */
	public void setSocialSecurityId(int i) {
		socialSecurityId = i;
	}

	/**
	 * @param string
	 */
	public void setSocialSecurityNum(String string) {
		socialSecurityNum = string;
	}

	/**
	 * @param i
	 */
	public void setStockBrokerNum(int i) {
		stockBrokerNum = i;
	}

	/**
	 * @param string
	 */
	public void setStreetFixAdd(String string) {
		streetFixAdd = string;
	}

	/**
	 * @param string
	 */
	public void setStreetTmpAdd(String string) {
		streetTmpAdd = string;
	}

	/**
	 * @param string
	 */
	public void setStudEmplType(String string) {
		studEmplType = string;
	}

	/**
	 * @param i
	 */
	public void setTmpAddCountryId(int i) {
		tmpAddCountryId = i;
	}

	/**
	 * @param i
	 */
	public void setTmpAdressFrenchCityId(int i) {
		tmpAdressFrenchCityId = i;
	}

	/**
	 * @param string
	 */
	public void setTownOfBirth(String string) {
		townOfBirth = string;
	}

	/**
	 * @param b
	 */
	public void setWasToUmlvLastYear(boolean b) {
		wasToUmlvLastYear = b;
	}

	/**
	 * @param i
	 */
	public void setWorkedShareId(int i) {
		workedShareId = i;
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
	 * @return
	 */
	public int getHeadFamJob() {
		return headFamJob;
	}

	/**
	 * @return
	 */
	public int getMLVDiplomaComplId() {
		return MLVDiplomaComplId;
	}

	/**
	 * @return
	 */
	public int getPurseId() {
		return purseId;
	}

	/**
	 * @param i
	 */
	public void setHeadFamJob(int i) {
		headFamJob = i;
	}

	/**
	 * @param i
	 */
	public void setMLVDiplomaComplId(int i) {
		MLVDiplomaComplId = i;
	}

	/**
	 * @param c
	 */
	public void setPrecYearSitTypeId(String c) {
		precYearSitTypeId = c;
	}

	/**
	 * @param i
	 */
	public void setPurseId(int i) {
		purseId = i;
	}

	/**
	 * @return
	 */
	public ArrayList getHandicapList() {
		return handicapList;
	}

	/**
	 * @param string
	 */
	public void addHandicapList(String string) {
		handicapList.add(string);
	}

	/**
		 * @param string
		 */
		public void clearHandicapList() {
			handicapList.clear() ;
		}
	
	

	/**
	 * @return
	 */
	public String getPrecYearSitTypeId() {
		return precYearSitTypeId;
	}

	/**
	 * @param list
	 */
	public void setHandicapList(ArrayList list) {
		handicapList = list;
	}

	/**
	 * @param array
	 */
	public int sizeHandicapList() {
	return handicapList.size(); 
		
	}

}
/**
 * 
 * 
 *  
 * Student.toXML(){
 *     return null;
 *    }
 *  
 *  
 *  
 */
