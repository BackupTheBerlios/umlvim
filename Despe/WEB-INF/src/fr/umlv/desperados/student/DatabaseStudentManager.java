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
	
	public void addStudent(Student student) throws StudentAlreadyExistsException, StudentBirthdayException {
			
		if(existStudent(student.getPatronymicName() ,student.getFirstname1() ,student.getBirthday())!=0)
			throw new StudentAlreadyExistsException("impossible to add student : Student already exist in Database");
			
		if(dateControl(student.getBirthday()))
			throw new StudentBirthdayException("Date of birthday is impossible");
		
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
			requestor.executeQuery(stringTemp);
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
		java.util.Date birthday) throws StudentBirthdayException {
			
			if(dateControl(birthday))
					throw new StudentBirthdayException("Date of birthday is impossible");
		
			
			//TODO gerer les erreurs de date (genre 77/88/9999)
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
	public Student getStudent(int studentId) throws StudentNotFoundException{
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
		throws StudentNotFoundException,StudentBirthdayException {
/*		ResultSet result = null;
		String query =
			"SELECT * FROM "+prop.get("tableName")+" WHERE "+prop.get("studentId")+" = "
				+ student.getId();
				
			try {
			result = requestor.doQuery(query);
			if (!result.first()) {
				throw new StudentNotFoundException("Impossible modify student : Student not found in Database");
			}
			} catch (SQLException e) {
					e.printStackTrace();
				}*/
			
				if(dateControl(student.getBirthday()))
						throw new StudentBirthdayException("Date of birthday is impossible");
			
			String query="UPDATE "+prop.get("tableName")+" SET "+
			prop.get("name")+"='"+student.getName()+"',"+
			prop.get("birthday")+"=TO_DATE('"+DateFormat.getDateInstance(DateFormat.LONG).format(student.getBirthday())+ "','DD/MM/YYYY'),"+
			prop.get("firstname1")+"='"+student.getFirstname1()+"',"+
			prop.get("ine")+"='"+student.getIne()+"',"+
			prop.get("wasToUmlvLastYear")+"="+ (student.isWasToUmlvLastYear()?1:0)+","+
			prop.get("patronymicName")+"='"+student.getPatronymicName()+"',"+
			prop.get("firstname2")+"='"+student.getFirstname2()+"',"+
			prop.get("townOfBirth")+"='"+student.getTownOfBirth()+"',"+
			prop.get("sex")+"='"+student.getSex()+"',"+
			prop.get("firstInsSupEduc")+"='"+student.getFirstInsSupEduc()+"',"+
			prop.get("firstInsFrenchUniv")+"='"+student.getFirstInsFrenchUniv()+"',"+
			prop.get("estaFirstInsFrenchUniv")+"='"+student.getEstaFirstInsFrenchUniv()+"',"+
			prop.get("firstInsEstablishment")+"='"+student.getFirstInsEstablishment()+"',"+
			prop.get("bacYear")+"="+student.getBacYear()+","+
			prop.get("establishmentBacObtaining")+"='"+student.getEstablishmentBacObtaining()+"',"+
			prop.get("foreignCityBac")+"='"+student.getForeignCityBac()+"',"+
			prop.get("haveFixAddFr")+"="+(student.isHaveFixAddFr()?1:0)+","+
			prop.get("numFixAdd")+"='"+student.getNumFixAdd()+"',"+
			prop.get("streetFixAdd")+"='"+student.getStreetFixAdd()+"',"+
			prop.get("buildingFixAdd")+"='"+student.getBuildingFixAdd()+"',"+
			prop.get("foreignCityFixAdd")+"='"+student.getForeignCityFixAdd()+"',"+
			prop.get("phoneFixAdd")+"='"+student.getPhoneFixAdd()+"',"+
			prop.getProperty("haveTmpAddFr")+"="+(student.isHaveTmpAddFr()?1:0)+","+
			prop.get("numTmpAdd")+"='"+student.getNumTmpAdd()+"',"+
			prop.get("streetTmpAdd")+"='"+student.getStreetTmpAdd()+"',"+
			prop.get("buildingTmpAdd")+"='"+student.getBuildingTmpAdd()+"',"+
			prop.get("cityTmpAdd")+"='"+student.getCityTmpAdd()+"',"+
			prop.get("phoneTmpAdd")+"='"+student.getPhoneTmpAdd()+"',"+
			prop.get("isEmployed")+"="+(student.isEmployed()?1:0)+","+
			prop.get("studEmplType")+"='"+student.getStudEmplType()+"',"+
			prop.get("headFamProf")+"='"+student.getHeadFamProf()+"',"+
			prop.get("isNatSport")+"="+(student.isNatSport()?1:0)+","+
			prop.get("isRegSport")+"="+(student.isRegSport()?1:0)+","+
			prop.get("practisedSport")+"='"+student.getPractisedSport()+"',"+
			prop.get("haveFinancialAss")+"="+(student.isHaveFinancialAss()?1:0)+","+
			prop.get("internaExchOriEstab")+"='"+student.getInternaExchOriEstab()+"',"+
			prop.get("internaExchRecEstab")+"='"+student.getInternaExchRecEstab()+"',"+
			prop.get("lastAttendedEstab")+"='"+student.getLastAttendedEstab()+"',"+
			prop.get("lastAttendedEstabYear")+"='"+student.getLastAttendedEstabYear()+"',"+
			prop.get("precedentYearEstab")+"='"+student.getPrecedentYearEstab()+"',"+
			prop.get("otherInsEstab")+"='"+student.getOtherInsEstab()+"',"+
			prop.get("princCycleInsNum")+"="+student.getPrincCycleInsNum()+","+
			prop.get("complCycleInsNum")+"="+student.getComplCycleInsNum()+","+
			prop.get("princDiplInsNum")+"="+student.getPrincDiplInsNum()+","+
			prop.get("complDipInsNum")+"="+student.getComplDipInsNum()+","+
			prop.get("princInsYearNum")+"="+student.getPrincInsYearNum()+","+
			prop.get("compInsYearNum")+"="+student.getCompInsYearNum()+","+
			prop.get("stockBrokerNum")+"="+student.getStockBrokerNum()+","+
			prop.get("socialSecurityNum")+"='"+student.getSocialSecurityNum()+"',"+
			prop.get("fatherName")+"='"+student.getFatherName()+"',"+
			prop.get("fatherFirstName")+"='"+student.getFatherFirstName()+"',"+
			prop.get("motherPatronymicName")+"='"+student.getMotherPatronymicName()+"',"+
			prop.get("motherName")+"='"+student.getMotherName()+"',"+
			prop.getProperty("insuranceCivilLiability")+"="+(student.isInsuranceCivilLiability()?1:0)+","+
			prop.get("appointmentDate")+"=TO_DATE('"+DateFormat.getDateInstance(DateFormat.LONG).format(student.getAppointmentDate())+ "','DD/MM/YYYY'),"+
			prop.get("workedShareId")+"="+student.getWorkedShareId()+","+
			prop.get("financialAssistanceId")+"='"+student.getFinancialAssistanceId()+"',"+
			prop.get("socialEconomicCategoryId")+"="+student.getSocialEconomicCategoryId()+","+
			prop.get("MLVDiplomaId")+"="+student.getMLVDiplomaId()+","+
			prop.get("baccalaureatId")+"='"+student.getBaccalaureatId()+"',"+
			prop.get("lodgingTypeId")+"="+student.getLodgingTypeId()+","+
			prop.get("inscriptionModeId")+"="+student.getInscriptionModeId()+","+
			prop.get("inscriptionTypeId")+"="+student.getInscriptionTypeId()+","+
			prop.get("centerPaymentId")+"="+student.getCenterPaymentId()+","+
			prop.getProperty("internationalExchangeTypeId")+"="+student.getInternationalExchangeTypeId()+","+
			prop.get("mutualInsuranceCompanyId")+"="+student.getMutualInsuranceCompanyId()+","+
			prop.get("socialSecurityId")+"="+student.getSocialSecurityId()+","+
			prop.get("paymentModeId")+"="+student.getPaymentModeId()+","+
			prop.get("purseId")+"="+student.getPurseId()+","+
			prop.get("lastDiplomaTypeId")+"='"+student.getLastDiplomaTypeId()+"',"+
			prop.get("bacMentionId")+"="+student.getBacMentionId()+","+
			prop.get("baccalaureatEstablishmentTypeId")+"="+student.getBaccalaureatEstablishmentTypeId()+","+
			prop.getProperty("lastEstabTypeId")+"="+student.getLastEstabTypeId()+","+
			prop.get("militarySituationId")+"="+student.getMilitarySituationId()+","+
			prop.get("fixeAddFrenchCityId")+"="+student.getFixeAddFrenchCityId()+","+
			prop.get("tmpAdressFrenchCityId")+"="+student.getTmpAdressFrenchCityId()+","+
			prop.get("frenchBirthplaceId")+"="+student.getFrenchBirthplaceId()+","+
			prop.get("frenchBacCityId")+"="+student.getFrenchBacCityId()+","+
			prop.get("firstInsFrUnivDepId")+"="+student.getFirstInsFrUnivDepId()+","+
			prop.get("lastAttendedEstabPlaceId")+"="+student.getLastAttendedEstabPlaceId()+","+
			prop.get("precYearEstabPlaceId")+"="+student.getPrecYearEstabPlaceId()+","+
			prop.get("otherEstabInsPlaceId")+"="+student.getOtherEstabInsPlaceId()+","+
			prop.get("bacObtainingCountryId")+"="+student.getBacObtainingCountryId()+","+
			prop.get("nationalityId")+"="+student.getNationalityId()+","+
			prop.get("intExchPlaceId")+"="+student.getIntExchPlaceId()+","+
			prop.get("foreignBirthplaceId")+"="+student.getForeignBirthplaceId()+","+
			prop.get("fixeAddCountryId")+"="+student.getFixeAddCountryId()+","+
			prop.get("tmpAddCountryId")+"="+student.getTmpAddCountryId()+","+
			prop.get("precYearSitTypeId")+"='"+student.getPrecYearSitTypeId()+"',"+
			prop.get("famSituation")+"="+student.getFamSituation()+","+
			prop.get("motifProlSocSec")+"='"+student.getMotifProlSocSec()+"',"+
			prop.getProperty("noSocSecStu")+"="+(student.isNoSocSecStu()?1:0)+","+
 			prop.get("otherEtabIns")+"="+student.getOtherEtabIns()+","+
			prop.get("headFamJob")+"="+student.getHeadFamJob()+","+
			prop.get("MLVDiplomaComplId")+"="+student.getMLVDiplomaComplId()
			+" WHERE "+prop.get("studentId")+" = "+ student.getId();
				//result.updateArray(prop.get("handicapList").toString(),Array(student.getHandicapList().getClass()  ));
//TODO handicap à faire
			
  			try {
			  int nbRows = requestor.executeQuery(query);
				if (nbRows==0) {
				  throw new StudentNotFoundException("Impossible modify student : Student not found in Database");
			  }
			
			
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
			System.out.println("liste "+INE+","+patronymiqueName+","+firstname+","+diplomaId);
		StringBuffer query =
			new StringBuffer("SELECT * FROM "+prop.get("tableName")+" where ");
		if (!(INE.equals(""))) {
			query.append(prop.get("ine")+"='" + INE + "' and ");
		}
		if (!(patronymiqueName.equals(""))) {
			query.append(prop.get("patronymicName")+" like '" + patronymiqueName + "%' and ");
		}
		if (!(firstname.equals(""))) {
			query.append(prop.get("firstName1")+" like " + firstname + "%' and ");
		}
		if (diplomaId != 0) {
			query.append(prop.get("MLViplomaId")+"='" + diplomaId + "' and ");
		}

		query.replace(query.length() - 4, query.length(), "");
		
		System.out.println("quey : "+query);

		ResultSet rs = null;
		try {
			rs=requestor.doQuery(query.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		try {
			if((rs != null) && (rs.first())) {
		//		System.out.println("liste"+new DatabaseStudentList(rs,"/home/dslg00/npetitde/genieLog/jakarta-tomcat-4.1.29/webapps/despe/WEB-INF/src/fr/umlv/desperados/struts/studentDatabase.properties"));
				return (List)(new DatabaseStudentList(rs,"/home/dslg00/npetitde/genieLog/jakarta-tomcat-4.1.29/webapps/despe/WEB-INF/src/fr/umlv/desperados/struts/studentDatabase.properties"));
			}
		} catch (SQLException e1) {
			// TODO Bloc catch auto-généré
			e1.printStackTrace();
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
	
	private boolean dateControl(java.util.Date date){
		if(date.getTime()>System.currentTimeMillis())
		return true;
		return false;
	}
}