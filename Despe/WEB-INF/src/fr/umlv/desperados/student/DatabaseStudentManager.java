//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\student\\DatabaseStudentManager.java

package fr.umlv.desperados.student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;
import java.util.Properties;
import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.util.Cache;

/**
 * Provides an implementation of the StudentManager interface, using an relational 
 * database.
 * It contains a cache system, which prevents to instanciate Student several times.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseStudentManager implements StudentManager {

	/**
	 * The unique instance of the DatabaseUserManager.
	 */
	private static DatabaseStudentManager theInstance = null;

	/**
	 * The DatabaseRequestor of this manager.
	 */
	private DatabaseRequestor requestor;

	/**
	 * The Cache of this manager.
	 */
	private Cache cache;

	private Properties prop;

	/**
	 * Private default constructor.
	 * 
	 * @param requestor the DatabaseRequestor of this manager.
	 * @roseuid 3FE3136B035E
	 */
	DatabaseStudentManager(
		DatabaseRequestor requestor,
		String propertiesPath) {
		this.requestor = requestor;
		prop = new Properties();
		try {
			prop.load(new FileInputStream(propertiesPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Instance getter.
	 * 
	 * @param requestor the DatabaseRequestor for this manager.
	 * @return the unique instance of DatabaseStudentManager.
	 * @roseuid 3FF851EE0284
	 */
	public static synchronized DatabaseStudentManager getInstance(
		DatabaseRequestor requestor,
		String propertiesPath) {
		if (theInstance == null)
			theInstance = new DatabaseStudentManager(requestor, propertiesPath);
		return theInstance;
	}

	/**
	 * @param student
	 * @throws fr.umlv.desperados.student.StudentAlreadyExistsException
	 * @roseuid 3FF869BD015C
	 */
	
	public void addStudent(Student student)
		throws StudentAlreadyExistsException {
			
		if(existStudent(student.getPatronymicName() ,student.getFirstname1() ,student.getBirthday())!=0)
			throw new StudentAlreadyExistsException("impossible to add student : Student already exist in Database");
		
		StringBuffer insert =
			new StringBuffer("insert into " + prop.get("tableName") + " (");
		StringBuffer values = new StringBuffer(" values (");
		
		if (!(student.getPatronymicName().equals(null))) {
			insert.append(prop.get("patronymicName") + ",");
			values.append("'"+student.getPatronymicName() + "',");
		}

		if (!student.getBirthday().equals(null)) {
			insert.append(prop.get("birthday") + ",");
			values.append("TO_DATE('"
					+ DateFormat.getDateInstance(DateFormat.LONG ).format(
						student.getBirthday())
					+ "','DD/MM/YYYY'),");
		}

		if (!student.getFirstname1().equals(null)) {
			insert.append(prop.get("firstname1") + ",");
			values.append("'"+student.getFirstname1() + "',");
		}

		insert.replace(insert.length() - 1, insert.length(), ")");
		values.replace(values.length() - 1, values.length(), ")");

		try {
			String stringTemp=insert.append(values).toString();
			requestor.doQuery(stringTemp);
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 * @param firstname
	 * @param birthday
	 * @return java.lang.String return
	 * @roseuid 3FF869BD0170
	 */
	public int existStudent(
		String patronymiqueName,
		String firstName,
		java.util.Date birthday) {
		ResultSet result = null;
		String query =
			"SELECT "+ prop.get("studentId")
			 +" FROM  "+ prop.get("tableName") +"  WHERE "
			+prop.get("patronymicName")+"='"
				+ patronymiqueName
				+ "' and "
			+prop.get("firstname1")+"='"
				+ firstName
				+ "' and "
				+" TO_CHAR("+prop.getProperty("birthday")+",'dd/mm/yyyy')="
				+ "TO_DATE('"+DateFormat.getDateInstance(DateFormat.LONG).format(birthday)+"','dd/mm/yyyy')";
			try {	
			result = requestor.doQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (result.first())
				return result.getInt("id_etu");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param studentId
	 * @return fr.umlv.desperados.student.Student
	 * @roseuid 3FF869BD01AC
	 */
	public Student getStudent(int studentId) throws StudentNotFoundException {
			ResultSet result = null;
		Student student = null;
		String query =
			"SELECT * FROM "+prop.get("tableName")+" Where "+prop.get("studentId")+"=" + studentId;
		try {
			result = requestor.doQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (!result.first()) {
				throw new StudentNotFoundException("impossible to get Student : Student not found in Database");
			}

				student = new Student(studentId);
				student.setName(result.getString(prop.get("name").toString()));
				student.setBirthday(
					result.getDate(prop.get("birthday").toString()));
				student.setFirstname1(
					result.getString(prop.get("firstname1").toString()));
				student.setIne(result.getString(prop.get("ine").toString()));
				student.setWasToUmlvLastYear(
					result.getBoolean(
						(prop.get("wasToUmlvLastYear").toString())));
				student.setPatronymicName(
					result.getString(prop.get("patronymicName").toString()));
				student.setFirstname2(
					result.getString(prop.get("firstname2").toString()));
				student.setTownOfBirth(
					result.getString(prop.get("townOfBirth").toString()));
				student.setSex(result.getString(prop.get("sex").toString()));
				student.setFirstInsSupEduc(
					result.getString(prop.get("firstInsSupEduc").toString()));
				student.setFirstInsFrenchUniv(
					result.getString(
						prop.get("firstInsFrenchUniv").toString()));
				student.setEstaFirstInsFrenchUniv(
					result.getString(
						prop.get("estaFirstInsFrenchUniv").toString()));
				student.setFirstInsEstablishment(
					result.getString(
						prop.get("firstInsEstablishment").toString()));
				student.setBacYear(
					result.getString(prop.get("bacYear").toString()));
				student.setEstablishmentBacObtaining(
					result.getString(
						prop.get("establishmentBacObtaining").toString()));
				student.setForeignCityBac(
					result.getString(prop.get("foreignCityBac").toString()));
				student.setHaveFixAddFr(
					result.getBoolean(prop.get("haveFixAddFr").toString()));
				student.setNumFixAdd(
					result.getString(prop.get("numFixAdd").toString()));
				student.setStreetFixAdd(
					result.getString(prop.get("streetFixAdd").toString()));
				student.setBuildingFixAdd(
					result.getString(prop.get("buildingFixAdd").toString()));
				student.setForeignCityFixAdd(
					result.getString(prop.get("foreignCityFixAdd").toString()));
				student.setPhoneFixAdd(
					result.getString(prop.get("phoneFixAdd").toString()));
				student.setHaveTmpAddFr(
					result.getBoolean(
						prop.getProperty("haveTmpAddFr").toString()));
				student.setNumTmpAdd(
					result.getString(prop.get("numTmpAdd").toString()));
				student.setStreetTmpAdd(
					result.getString(prop.get("streetTmpAdd").toString()));
				student.setBuildingTmpAdd(
					result.getString(prop.get("buildingTmpAdd").toString()));
				student.setCityTmpAdd(
					result.getString(prop.get("cityTmpAdd").toString()));
				student.setPhoneTmpAdd(
					result.getString(prop.get("phoneTmpAdd").toString()));
				student.setEmployed(
					result.getBoolean(prop.get("isEmployed").toString()));
				student.setStudEmplType(
					result.getString(prop.get("studEmplType").toString()));
				student.setHeadFamProf(
					result.getString(prop.get("headFamProf").toString()));
				student.setNatSport(
					result.getBoolean(prop.get("isNatSport").toString()));
				student.setRegSport(
					result.getBoolean(prop.get("isRegSport").toString()));
				student.setPractisedSport(
					result.getString(prop.get("practisedSport").toString()));
				student.setHaveFinancialAss(
					result.getBoolean(prop.get("haveFinancialAss").toString()));
				student.setInternaExchOriEstab(
					result.getString(
						prop.get("internaExchOriEstab").toString()));
				student.setInternaExchRecEstab(
					result.getString(
						prop.get("internaExchRecEstab").toString()));
				student.setLastAttendedEstab(
					result.getString(prop.get("lastAttendedEstab").toString()));
				student.setLastAttendedEstabYear(
					result.getString(
						prop.get("lastAttendedEstabYear").toString()));
				student.setPrecedentYearEstab(
					result.getString(
						prop.get("precedentYearEstab").toString()));
				student.setOtherInsEstab(
					result.getString(prop.get("otherInsEstab").toString()));
				student.setPrincCycleInsNum(
					result.getInt(prop.get("princCycleInsNum").toString()));
				student.setComplCycleInsNum(
					result.getInt(prop.get("complCycleInsNum").toString()));
				student.setPrincDiplInsNum(
					result.getInt(prop.get("princDiplInsNum").toString()));
				student.setComplDipInsNum(
					result.getInt(prop.get("complDipInsNum").toString()));
				student.setPrincInsYearNum(
					result.getInt(prop.get("princInsYearNum").toString()));
				student.setCompInsYearNum(
					result.getInt(prop.get("compInsYearNum").toString()));
				student.setStockBrokerNum(
					result.getInt(prop.get("stockBrokerNum").toString()));
				student.setSocialSecurityNum(
					result.getString(prop.get("socialSecurityNum").toString()));
				student.setFatherName(
					result.getString(prop.get("fatherName").toString()));
				student.setFatherFirstName(
					result.getString(prop.get("fatherFirstName").toString()));
				student.setMotherPatronymicName(
					result.getString(
						prop.get("motherPatronymicName").toString()));
				student.setMotherName(
					result.getString(prop.get("motherName").toString()));
				student.setInsuranceCivilLiability(
					result.getBoolean(
						prop
							.getProperty("insuranceCivilLiability")
							.toString()));
				student.setAppointmentDate(
					result.getDate(
						prop.get("appointmentDate").toString()));
				student.setWorkedShareId(
					result.getInt(prop.get("workedShareId").toString()));
				student.setFinancialAssistanceId(
					result.getString(
						prop.get("financialAssistanceId").toString()));
				student.setSocialEconomicCategoryId(
					result.getInt(
						prop.get("socialEconomicCategoryId").toString()));
				student.setMLVDiplomaId(
					result.getInt(prop.get("MLVDiplomaId").toString()));
				student.setBaccalaureatId(
					result.getString(prop.get("baccalaureatId").toString()));
				student.setLodgingTypeId(
					result.getInt(prop.get("lodgingTypeId").toString()));
				student.setInscriptionModeId(
					result.getInt(prop.get("inscriptionModeId").toString()));
				student.setInscriptionTypeId(
					result.getInt(prop.get("inscriptionTypeId").toString()));
				student.setCenterPaymentId(
					result.getInt(prop.get("centerPaymentId").toString()));
				student.setInternationalExchangeTypeId(
					result.getInt(
						prop
							.getProperty("internationalExchangeTypeId")
							.toString()));
				student.setMutualInsuranceCompanyId(
					result.getInt(
						prop.get("mutualInsuranceCompanyId").toString()));
				student.setSocialSecurityId(
					result.getInt(prop.get("socialSecurityId").toString()));
				student.setPaymentModeId(
					result.getInt(prop.get("paymentModeId").toString()));
				student.setPurseId(
					result.getInt(prop.get("purseId").toString()));
				student.setLastDiplomaTypeId(
					result.getString(prop.get("lastDiplomaTypeId").toString()));
				student.setBacMentionId(
					result.getInt(prop.get("bacMentionId").toString()));
				student.setBaccalaureatEstablishmentTypeId(
					result.getInt(
						prop
							.get("baccalaureatEstablishmentTypeId")
							.toString()));
				student.setLastEstabTypeId(
					result.getInt(
						prop.getProperty("lastEstabTypeId").toString()));
				student.setMilitarySituationId(
					result.getInt(prop.get("militarySituationId").toString()));
				student.setFixeAddFrenchCityId(
					result.getInt(prop.get("fixeAddFrenchCityId").toString()));
				student.setTmpAdressFrenchCityId(
					result.getInt(
						prop.get("tmpAdressFrenchCityId").toString()));
				student.setFrenchBirthplaceId(
					result.getInt(prop.get("frenchBirthplaceId").toString()));
				student.setFrenchBacCityId(
					result.getInt(prop.get("frenchBacCityId").toString()));
				student.setFirstInsFrUnivDepId(
					result.getInt(prop.get("firstInsFrUnivDepId").toString()));
				student.setLastAttendedEstabPlaceId(
					result.getInt(
						prop.get("lastAttendedEstabPlaceId").toString()));
				student.setPrecYearEstabPlaceId(
					result.getInt(prop.get("precYearEstabPlaceId").toString()));
				student.setOtherEstabInsPlaceId(
					result.getInt(prop.get("otherEstabInsPlaceId").toString()));
				student.setBacObtainingCountryId(
					result.getInt(
						prop.get("bacObtainingCountryId").toString()));
				student.setNationalityId(
					result.getInt(prop.get("nationalityId").toString()));
				student.setIntExchPlaceId(
					result.getInt(prop.get("intExchPlaceId").toString()));
				student.setForeignBirthplaceId(
					result.getInt(prop.get("foreignBirthplaceId").toString()));
				student.setFixeAddCountryId(
					result.getInt(prop.get("fixeAddCountryId").toString()));
				student.setTmpAddCountryId(
					result.getInt(prop.get("tmpAddCountryId").toString()));
				student.setPrecYearSitTypeId(
					result.getString(prop.get("precYearSitTypeId").toString()));
				student.setFamSituation(
					result.getInt(prop.get("famSituation").toString()));
				student.setMotifProlSocSec(
					result.getString(prop.get("motifProlSocSec").toString()));
				student.setNoSocSecStu(
					result.getBoolean(
						prop.getProperty("noSocSecStu").toString()));
				student.setOtherEtabIns(
					result.getInt(prop.get("otherEtabIns").toString()));
				student.setHeadFamJob(
					result.getInt(prop.get("headFamJob").toString()));
				student.setMLVDiplomaComplId(
					result.getInt(prop.get("MLVDiplomaComplId").toString()));
				//student.setHandicapList((ArrayList)(result.getArray ( prop.get("handicapList").toString()).getArray()));
				//TODO a vérifier si ça fonctionne vraiment bien faire handicap 
			
			
			
			} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return student;
	}

	/**
	 * @param student
	 * @throws fr.umlv.desperados.student.StudentNotFoundException
	 * @roseuid 3FF869BD01CA
	 */
	public void modifyStudent(Student student)
		throws StudentNotFoundException {
		ResultSet result = null;
		String query =
			"SELECT * FROM "+prop.get("tableName")+" WHERE "+prop.get("studentId")+" = "
				+ student.getId();
				
			try {
			result = requestor.doQuery(query);
			if (!result.first()) {
				throw new StudentNotFoundException("Impossible modify student : Student not found in Database");
			}
				result.updateString(
					prop.get("name").toString(),
					student.getName());
				result.updateDate(
					prop.get("birthday").toString(),
					(java.sql.Date)student.getBirthday());
				result.updateString(
					prop.get("firstname1").toString(),
					student.getFirstname1());
				result.updateString(
					prop.get("ine").toString(),
					student.getIne());
				result.updateBoolean(
					prop.get("wasToUmlvLastYear").toString(),
					student.isWasToUmlvLastYear());
				result.updateString(
					prop.get("patronymicName").toString(),
					student.getPatronymicName());
				result.updateString(
					prop.get("firstname2").toString(),
					student.getFirstname2());
				result.updateString(
					prop.get("townOfBirth").toString(),
					student.getTownOfBirth());
				result.updateString(
					prop.get("sex").toString(),
					student.getSex());
				result.updateString(
					prop.get("firstInsSupEduc").toString(),
					student.getFirstInsSupEduc());
				result.updateString(
					prop.get("firstInsFrenchUniv").toString(),
					student.getFirstInsFrenchUniv());
				result.updateString(
					prop.get("estaFirstInsFrenchUniv").toString(),
					student.getEstaFirstInsFrenchUniv());
				result.updateString(
					prop.get("firstInsEstablishment").toString(),
					student.getFirstInsEstablishment());
				result.updateString(
					prop.get("bacYear").toString(),
					student.getBacYear());
				result.updateString(
					prop.get("establishmentBacObtaining").toString(),
					student.getEstablishmentBacObtaining());
				result.updateString(
					prop.get("foreignCityBac").toString(),
					student.getForeignCityBac());
				result.updateBoolean(
					prop.get("haveFixeAddFr").toString(),
					student.isHaveFixAddFr());
				result.updateString(
					prop.get("numFixAdd").toString(),
					student.getNumFixAdd());
				result.updateString(
					prop.get("streetFixAdd").toString(),
					student.getStreetFixAdd());
				result.updateString(
					prop.get("buildingFixAdd").toString(),
					student.getBuildingFixAdd());
				result.updateString(
					prop.get("foreignCityFixAdd").toString(),
					student.getForeignCityFixAdd());
				result.updateString(
					prop.get("phoneFixAdd").toString(),
					student.getPhoneFixAdd());
				result.updateBoolean(
					prop.getProperty("haveTmpAddFr").toString(),
					student.isHaveTmpAddFr());
				result.updateString(
					prop.get("numTmpAdd").toString(),
					student.getNumTmpAdd());
				result.updateString(
					prop.get("streetTmpAdd").toString(),
					student.getStreetTmpAdd());
				result.updateString(
					prop.get("buildingTmpAdd").toString(),
					student.getBuildingTmpAdd());
				result.updateString(
					prop.get("cityTmpAdd").toString(),
					student.getCityTmpAdd());
				result.updateString(
					prop.get("phoneTmpAdd").toString(),
					student.getPhoneTmpAdd());
				result.updateBoolean(
					prop.get("isEmployed").toString(),
					student.isEmployed());
				result.updateString(
					prop.get("studEmplType").toString(),
					student.getStudEmplType());
				result.updateString(
					prop.get("headFamProf").toString(),
					student.getHeadFamProf());
				result.updateBoolean(
					prop.get("isNatSport").toString(),
					student.isNatSport());
				result.updateBoolean(
					prop.get("isRegSport").toString(),
					student.isRegSport());
				result.updateString(
					prop.get("practisedSport").toString(),
					student.getPractisedSport());
				result.updateBoolean(
					prop.get("haveFinancialAss").toString(),
					student.isHaveFinancialAss());
				result.updateString(
					prop.get("internaExchOriEstab").toString(),
					student.getInternaExchOriEstab());
				result.updateString(
					prop.get("internaExchRecEstab").toString(),
					student.getInternaExchRecEstab());
				result.updateString(
					prop.get("lastAttendedEstab").toString(),
					student.getLastAttendedEstab());
				result.updateString(
					prop.get("lastAttendedEstabYear").toString(),
					student.getLastAttendedEstabYear());
				result.updateString(
					prop.get("precedentYearEstab").toString(),
					student.getPrecedentYearEstab());
				result.updateString(
					prop.get("otherInsEstab").toString(),
					student.getOtherInsEstab());
				result.updateInt(
					prop.get("princCycleInsNum").toString(),
					student.getPrincCycleInsNum());
				result.updateInt(
					prop.get("complCycleInsNum").toString(),
					student.getComplCycleInsNum());
				result.updateInt(
					prop.get("princDiplInsNum").toString(),
					student.getPrincDiplInsNum());
				result.updateInt(
					prop.get("complDipInsNum").toString(),
					student.getComplDipInsNum());
				result.updateInt(
					prop.get("princInsYearNum").toString(),
					student.getPrincInsYearNum());
				result.updateInt(
					prop.get("compInsYearNum").toString(),
					student.getCompInsYearNum());
				result.updateInt(
					prop.get("stockBrokerNum").toString(),
					student.getStockBrokerNum());
				result.updateString(
					prop.get("socialSecurityNum").toString(),
					student.getSocialSecurityNum());
				result.updateString(
					prop.get("fatherName").toString(),
					student.getFatherName());
				result.updateString(
					prop.get("fatherFirstName").toString(),
					student.getFatherFirstName());
				result.updateString(
					prop.get("motherPatronymicName").toString(),
					student.getMotherPatronymicName());
				result.updateString(
					prop.get("motherName").toString(),
					student.getMotherName());
				result.updateBoolean(
					prop.getProperty("insuranceCivilLiability").toString(),
					student.isInsuranceCivilLiability());
				result.updateDate(
					prop.get("appointmentDate").toString(),
					(java.sql.Date)student.getAppointmentDate());
				result.updateInt(
					prop.get("workedShareId").toString(),
					student.getWorkedShareId());
				result.updateString(
					prop.get("financialAssistanceId").toString(),
					student.getFinancialAssistanceId());
				result.updateInt(
					prop.get("socialEconomicCategoryId").toString(),
					student.getSocialEconomicCategoryId());
				result.updateInt(
					prop.get("MLVDiplomaId").toString(),
					student.getMLVDiplomaId());
				result.updateString(
					prop.get("baccalaureatId").toString(),
					student.getBaccalaureatId());
				result.updateInt(
					prop.get("lodgingTypeId").toString(),
					student.getLodgingTypeId());
				result.updateInt(
					prop.get("inscriptionModeId").toString(),
					student.getInscriptionModeId());
				result.updateInt(
					prop.get("inscriptionTypeId").toString(),
					student.getInscriptionTypeId());
				result.updateInt(
					prop.get("centerPaymentId").toString(),
					student.getCenterPaymentId());
				result.updateInt(
					prop.getProperty("internationalExchangeTypeId").toString(),
					student.getInternationalExchangeTypeId());
				result.updateInt(
					prop.get("mutualInsuranceCompanyId").toString(),
					student.getMutualInsuranceCompanyId());
				result.updateInt(
					prop.get("socialSecurityId").toString(),
					student.getSocialSecurityId());
				result.updateInt(
					prop.get("paymentModeId").toString(),
					student.getPaymentModeId());
				result.updateInt(
					prop.get("purseId").toString(),
					student.getPurseId());
				result.updateString(
					prop.get("lastDiplomaTypeId").toString(),
					student.getLastDiplomaTypeId());
				result.updateInt(
					prop.get("bacMentionId").toString(),
					student.getBacMentionId());
				result.updateInt(
					prop.get("baccalaureatEstablishmentTypeId").toString(),
					student.getBaccalaureatEstablishmentTypeId());
				result.updateInt(
					prop.getProperty("lastEstabTypeId").toString(),
					student.getLastEstabTypeId());
				result.updateInt(
					prop.get("militarySituationId").toString(),
					student.getMilitarySituationId());
				result.updateInt(
					prop.get("fixeAddFrenchCityId").toString(),
					student.getFixeAddFrenchCityId());
				result.updateInt(
					prop.get("tmpAdressFrenchCityId").toString(),
					student.getTmpAdressFrenchCityId());
				result.updateInt(
					prop.get("frenchBirthplaceId").toString(),
					student.getFrenchBirthplaceId());
				result.updateInt(
					prop.get("frenchBacCityId").toString(),
					student.getFrenchBacCityId());
				result.updateInt(
					prop.get("firstInsFrUnivDepId").toString(),
					student.getFirstInsFrUnivDepId());
				result.updateInt(
					prop.get("lastAttendedEstabPlaceId").toString(),
					student.getLastAttendedEstabPlaceId());
				result.updateInt(
					prop.get("precYearEstabPlaceId").toString(),
					student.getPrecYearEstabPlaceId());
				result.updateInt(
					prop.get("otherEstabInsPlaceId").toString(),
					student.getOtherEstabInsPlaceId());
				result.updateInt(
					prop.get("bacObtainingCountryId").toString(),
					student.getBacObtainingCountryId());
				result.updateInt(
					prop.get("nationalityId").toString(),
					student.getNationalityId());
				result.updateInt(
					prop.get("intExchPlaceId").toString(),
					student.getIntExchPlaceId());
				result.updateInt(
					prop.get("foreignBirthplaceId").toString(),
					student.getForeignBirthplaceId());
				result.updateInt(
					prop.get("fixeAddCountryId").toString(),
					student.getFixeAddCountryId());
				result.updateInt(
					prop.get("tmpAddCountryId").toString(),
					student.getTmpAddCountryId());
				result.updateString(
					prop.get("precYearSitTypeId").toString(),
					student.getPrecYearSitTypeId());
				result.updateInt(
					prop.get("famSituation").toString(),
					student.getFamSituation());
				result.updateString(
					prop.get("motifProlSocSec").toString(),
					student.getMotifProlSocSec());
				result.updateBoolean(
					prop.getProperty("noSocSecStu").toString(),
					student.isNoSocSecStu());
				result.updateInt(
					prop.get("otherEtabIns").toString(),
					student.getOtherEtabIns());
				result.updateInt(
					prop.get("headFamJob").toString(),
					student.getHeadFamJob());
				result.updateInt(
					prop.get("MLVDiplomaComplId").toString(),
					student.getMLVDiplomaComplId());
				//result.updateArray(prop.get("handicapList").toString(),Array(student.getHandicapList().getClass()  ));
//TODO handicap à faire
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param studentId
	 * @return fr.umlv.desperados.student.Student
	 * @throws fr.umlv.desperados.student.StudentNotFoundException
	 * @roseuid 3FF869BD01F2
	 */

	public Student removeStudent(int studentId)
		throws StudentNotFoundException {
		ResultSet result = null;
		Student newStudent=null;
		try{
		newStudent = getStudent((new Integer(studentId)).intValue());
		}
		catch(StudentNotFoundException e){
			throw new StudentNotFoundException("Impossible to remove student : Student not found in Database");
		}
			String query="DELETE FROM ETUDIANT WHERE "+prop.get("studentId")+"="+studentId;
		try {
			result = requestor.doQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newStudent;
	}

	/**
	 * @param INE
	 * @param name
	 * @param firstname
	 * @param diplomaId
	 * @return java.util.List
	 * @roseuid 3FF869BD0210
	 */
	public List searchStudent(
		String INE,
		String patronymiqueName,
		String firstname,
		int diplomaId) {
		StringBuffer query =
			new StringBuffer("SELECT "+prop.get("studentId")+" FROM "+prop.get("tableName")+" where ");
		if (!(INE.equals(null))) {
			query.append(prop.get("ine")+"='" + INE + "' and ");
		}
		if (!(patronymiqueName.equals(null))) {
			query.append(prop.get("patronymicName")+"='" + patronymiqueName + "' and ");
		}
		if (!(firstname.equals(null))) {
			query.append(prop.get("firstName1")+"='" + firstname + "' and ");
		}
		if (!(diplomaId == 0)) {
			query.append(prop.get("MLVdiplomaId")+"='" + diplomaId + "' and ");
		}

		query.replace(query.length() - 4, query.length(), " ;");

		try {
			requestor.doQuery(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Sets the size of the cache of this manager.
	 * 
	 * @param size the new size of the cache.
	 * @roseuid 3FF9BE4C01C4
	 */
	public void setCacheSize(int size) {
//		cache.setCapacity(size);
	}
}