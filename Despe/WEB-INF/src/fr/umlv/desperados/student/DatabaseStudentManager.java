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
	private DatabaseStudentManager(
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
		StringBuffer insert =
			new StringBuffer("INSERT INTO" + prop.get("tableName") + " (");
		StringBuffer values = new StringBuffer(" VALUES (");
		if (!(student.getName().equals(null))) {
			insert.append(prop.get("name") + ",");
			values.append(student.getName() + ",");
		}

		if (!student.getBirthday().equals(null)) {
			insert.append(prop.get("birthday") + ",");
			values.append(
				"TO_DATE("
					+ DateFormat.getDateInstance(DateFormat.SHORT).format(
						student.getBirthday())
					+ ",'DD/MM/YY'),");
		}

		if (!student.getFirstname1().equals(null)) {
			insert.append(prop.get("firstname1") + ",");
			values.append(student.getFirstname1() + ",");
		}

		insert.replace(insert.length() - 1, insert.length(), ")");
		values.replace(values.length() - 1, values.length(), ");");

		try {
			requestor.doQuery(insert.append(values).toString());
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
	public String existStudent(
		String name,
		String firstName,
		java.util.Date birthday) {
		ResultSet result = null;
		String query =
			"SELECT id_etud FROM Etudiant WHERE nom_usage=\""
				+ name
				+ "\"prenom1=\""
				+ firstName
				+ "\"date_naiss=\""
				+ birthday
				+ "\";";
		try {
			result = requestor.doQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (result.next())
				return Integer.toString(result.getInt("id_etud"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	/**
	 * @param studentId
	 * @return fr.umlv.desperados.student.Student
	 * @roseuid 3FF869BD01AC
	 */
	public Student getStudent(int studentId) {
		ResultSet result = null;
		Student student = null;
		String query =
			"SELECT * FROM Etudiant Where id_etu=\"" + studentId + "\";";
		try {
			result = requestor.doQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (result.next()) {

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
						prop.get("EstablishmentBacObtaining").toString()));
				student.setForeignCityBac(
					result.getString(prop.get("ForeignCityBac").toString()));
				student.setHaveFixAddFr(
					result.getBoolean(prop.get("haveFixeAddFr").toString()));
				student.setNumFixAdd(
					result.getString(prop.get("numFixAdd").toString()));
				student.setStreetFixAdd(
					result.getString(prop.get("streetFixAdd").toString()));
				student.setBuildingFixAdd(
					result.getString(prop.get("builingFixAdd").toString()));
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
					result.getTimestamp(
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

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		query = "SELECT * FROM A_UN_HANDICAP Where id_etu='" + studentId + "';";
		try {
			result = requestor.doQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (result.next()) {
				student.setHandic(result.getString("ID_HAN"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
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
			"SELECT * FROM Etudiant WHERE id_etu = '"
				+ student.getStudentId()
				+ "';";
		try {
			result = requestor.doQuery(query);
			if (result.next()) {
				result.updateString(
					prop.get("name").toString(),
					student.getName());
				result.updateDate(
					prop.get("birthday").toString(),
					new java.sql.Date(student.getBirthday().getTime()));
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
					prop.get("EstablishmentBacObtaining").toString(),
					student.getEstablishmentBacObtaining());
				result.updateString(
					prop.get("ForeignCityBac").toString(),
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
					prop.get("builingFixAdd").toString(),
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
				result.updateTimestamp(
					prop.get("appointmentDate").toString(),
					student.getAppointmentDate());
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

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		query =
			"SELECT * FROM A_UN_HANDICAP WHERE id_etu = '"
				+ student.getStudentId()
				+ "';";

		try {
			result = requestor.doQuery(query);

			if (result.next()) {
				result.updateString("id_han", student.getHandic());
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

	/**
	 * @param studentId
	 * @return fr.umlv.desperados.student.Student
	 * @throws fr.umlv.desperados.student.StudentNotFoundException
	 * @roseuid 3FF869BD01F2
	 */

	public Student removeStudent(String studentId)
		throws StudentNotFoundException {
		ResultSet result = null;
		Student newStudent = getStudent((new Integer(studentId)).intValue());

		String query =
			"SELECT * FROM Etudiant WHERE id_etud='" + studentId + "'";
		try {
			result = requestor.doQuery(query);
			if (result.next()) {
				result.deleteRow();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		query = "SELECT * FROM A_UN_HANDICAP WHERE id_etud='" + studentId + "'";
		try {
			result = requestor.doQuery(query);
			if (result.next()) {
				result.deleteRow();
			}
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
		String name,
		String firstname,
		int diplomaId) {
		StringBuffer query =
			new StringBuffer("SELECT id_etud FROM Etudiant where ");
		if (!(INE.equals(null))) {
			query.append("ine='" + INE + "' and ");
		}
		if (!(name.equals(null))) {
			query.append("nom_usage='" + name + "' and ");
		}
		if (!(firstname.equals(null))) {
			query.append("prenom1='" + firstname + "' and ");
		}
		if (!(diplomaId == 0)) {
			query.append("diplomaId='" + diplomaId + "' and ");
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
		//cache.setCapacity(size); 
	}
}
/**
 * 
 *  
 * DatabaseStudentManager.addStudent(Student){
 *     
 *    }
 *  
 *  
 * DatabaseStudentManager.existStudent(String,String,java.util.Date){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentManager.getStudent(int){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentManager.searchStudent(String,String,String,int){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentManager.modifyStudent(Student){
 *     
 *    }
 *  
 *  
 * DatabaseStudentManager.removeStudent(String){
 *     return null;
 *    }
 *  
 *  
 */

/*
if(!student.getIne().equals(null))
{
	query.append(prop.get("ine")+",");
	values.append(student.getIne()+",");
}
   	
	query.append(prop.get("wasToUmlvLastYear")+",");
	values.append(student.isWasToUmlvLastYear()+","); 
   	
if(!student.getPatronymicName() .equals(null))
	{
		query.append(prop.get("patronymicName")+",");
		values.append(student.getPatronymicName() +",");
	}
   		
if(!student.getFirstname1().equals(null))
	{
		query.append(prop.get("firstname1")+",");
		values.append(student.getFirstname1() +",");
	}
	   
   if(!student.getFirstname2() .equals(null))
   {
	query.append(prop.get("firstname2")+",");
	values.append(student.getFirstname2()+",");
   }
	   
if(!student.getTownOfBirth() .equals(null))
	   {
		query.append(prop.get("townOfBirth")+",");
		values.append(student.getTownOfBirth()+",");
	   }
	   
if(!(student.getSex ().equals(null)))
	   {
		query.append(prop.get("sex")+",");
		values.append(student.getSex()+",");
	   }
	   
if(!(student.getFirstInsSupEduc() .equals(null)))
		   {
			query.append(prop.get("firstInsSupEduc")+",");
			values.append(student.getFirstInsSupEduc()+",");
		   }

if(!(student.getFirstInsFrenchUniv () .equals(null)))
		   {
			query.append(prop.get("firstInsFrenchUniv")+",");
			values.append(student.getFirstInsFrenchUniv ()+",");
		   }	   
	   
if(!(student.getEstaFirstInsFrenchUniv() .equals(null)))
		   {
			query.append(prop.get("estaFirstInsFrenchUniv")+",");
			values.append(student.getEstaFirstInsFrenchUniv()+",");
		   }
	
if(!(student.getFirstInsEstablishment() .equals(null)))
		   {
			query.append(prop.get("firstInsEstablishment")+",");
			values.append(student.getFirstInsEstablishment()+",");
		   }		   
   	  
if(!(student.getBacYear() .equals(null)))
		   {
			query.append(prop.get("bacYear")+",");
			values.append(student.getBacYear ()+",");
		   }
	
if(!(student.getEstablishmentBacObtaining () .equals(null)))
		   {
			query.append(prop.get("EstablishmentBacObtaining")+",");
			values.append(student.getEstablishmentBacObtaining()+",");
		   }		   
	
if(!(student.getForeignCityBac () .equals(null)))
		   {
			query.append(prop.get("ForeignCityBac")+",");
			values.append(student.getForeignCityBac ()+",");
		   }		   
      
query.append(prop.get("haveFixeAddFr")+",");
values.append(student.isHaveFixAddFr ()+",");
		
if(!(student.getNumFixAdd() .equals(null)))
		   {
			query.append(prop.get("numFixAdd")+",");
			values.append(student.getNumFixAdd()+",");
		   }
      
if(!(student.getStreetFixAdd () .equals(null)))
		   {
			query.append(prop.get("streetFixAdd")+",");
			values.append(student.getStreetFixAdd ()+",");
		   }
      
if(!(student.getBuildingFixAdd() .equals(null)))
		   {
			query.append(prop.get("builingFixAdd")+",");
			values.append(student.getBuildingFixAdd ()+",");
		   }
      
if(!(student.getForeignCityFixAdd () .equals(null)))
		   {
			query.append(prop.get("foreignCityFixAdd")+",");
			values.append(student.getForeignCityFixAdd ()+",");
		   }
      
if(!(student.getPhoneFixAdd ()==null))
		   {
			query.append(prop.get("phoneFixAdd")+",");
			values.append(student.getPhoneFixAdd()+",");
		   }
      
  query.append( "haveTmpAddFr"+",");
  values.append(student.isHaveTmpAddFr()+",");
      
if(!(student.getNumTmpAdd() .equals(null)))
		   {
			query.append(prop.get("numTmpAdd")+",");
			values.append(student.getNumTmpAdd()+",");
		   }
			   
if(!(student.getStreetTmpAdd() .equals(null)))
		   {
			query.append(prop.get("streetTmpAdd")+",");
			values.append(student.getStreetTmpAdd()+",");
		   }
      
if(!(student.getBuildingTmpAdd () .equals(null)))
		   {
			query.append(prop.get("buildingTmpAdd")+",");
			values.append(student.getBuildingTmpAdd ()+",");
		   }
      
if(!(student.getCityTmpAdd() .equals(null)))
		   {
			query.append(prop.get("cityTmpAdd")+",");
			values.append(student.getCityTmpAdd()+",");
		   }
      
if(!(student.getPhoneTmpAdd()==null))
		   {
			query.append(prop.get("phoneTmpAdd")+",");
			values.append(student.getPhoneTmpAdd()+",");
		   }
      
  query.append( prop.get("isEmployed")+",");
  values.append(student.isEmployed() +",");
      
if(!(student.getStudEmplType() .equals(null)))
		   {
			query.append(prop.get("studEmplType")+",");
			values.append(student.getStudEmplType()+",");
		   }
      
if(!(student.getHeadFamProf() .equals(null)))
		   {
			query.append(prop.get("headFamProf")+",");
			values.append(student.getHeadFamProf()+",");
		   }
      
query.append(prop.get("isNatSport")+",");
values.append(student.isNatSport ()+",");
				
query.append(prop.get("isRegSport")+",");
values.append(student.isRegSport()+",");
      
if(!(student.getPractisedSport() .equals(null)))
			   {
				query.append(prop.get("practisedSport")+",");
				values.append(student.getPractisedSport()+",");
			   }
      
	query.append(prop.get("haveFinancialAss")+",");
	values.append(student.isHaveFinancialAss ()+",");
		
if(!(student.getInternaExchOriEstab () .equals(null)))
				   {
					query.append(prop.get("internaExchOriEstab")+",");
					values.append(student.getInternaExchOriEstab ()+",");
				   }
		
if(!(student.getInternaExchRecEstab() .equals(null)))
				   {
					query.append(prop.get("internaExchRecEstab")+",");
					values.append(student.getInternaExchRecEstab ()+",");
				   }
					   
if(!(student.getLastAttendedEstab () .equals(null)))
				   {
					query.append(prop.get("lastAttendedEstab")+",");
					values.append(student.getLastAttendedEstab ()+",");
				   }
           
if(!(student.getLastAttendedEstabYear() .equals(null)))
				   {
					query.append(prop.get("lastAttendedEstabYear")+",");
					values.append(student.getLastAttendedEstabYear()+",");
				   }
					   
if(!(student.getPrecedentYearEstab() .equals(null)))
				   {
					query.append(prop.get("precedentYearEstab")+",");
					values.append(student.getPrecedentYearEstab()+",");
				   }
      
if(!(student.getOtherInsEstab() .equals(null)))
				   {
					query.append(prop.get("otherInsEstab")+",");
					values.append(student.getOtherInsEstab()+",");
				   }
      
if(!(student.getPrincCycleInsNum() ==null))
				   {
					query.append(prop.get("princCycleInsNum")+",");
					values.append(student.getPrincCycleInsNum()+",");
				   }
      
  private int complCycleInsNum;
  private int princDiplInsNum;
  private int complDipInsNum;
  private int princInsYearNum;
  private int compInsYearNum;
  private int stockBrokerNum;
  private String socialSecurityNum;
  private String fatherName;
  private String fatherFirstName;
  private String motherPatronymicName;
  private String motherName;
  private boolean insuranceCivilLiability;
  private Timestamp appointmentDate;
   private int workedShareId;
   private char financialAssistanceId;
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
   private char lastDiplomaTypeId;
   private int bacMentionId;
   private int baccalaureatEstablishmentTypeId;
   private int lastEstabTypeId;
   private int militarySituationId;
   private int fixeAddFrenchCityId;
   private int tmpAdressFrenchCityId;
   private int frenchBirthplaceId;
   private int frenchBacCityId;
  private int firstInsFrUnivDepId;
  private int lastAttendedEstabPlaceId;
  private int precYearEstabPlaceId;
  private int otherEstabInsPlaceId;
   private int bacObtainingCountryId;
   private int nationalityId;
  private int intExchPlaceId;
   private int foreignBirthplaceId;
  private int fixeAddCountryId;
  private int tmpAddCountryId;
  private char precYearSitTypeId;
   private int famSituation;
   private String motifProlSocSec;
   private boolean noSocSecStu;
   private int otherEtabIns;
   private int headFamJob;
   private int MLVDiplomaComplId;
*/
