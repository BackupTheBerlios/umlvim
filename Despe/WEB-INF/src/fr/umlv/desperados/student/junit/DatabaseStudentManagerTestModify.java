/*
 * Créé le 21 janv. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.umlv.desperados.student.junit;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.struts.database.StrutsDatabaseRequestor;
import fr.umlv.desperados.student.DatabaseStudentManager;
import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.student.StudentNotFoundException;

import junit.framework.TestCase;

/**
 * @author gdupont
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class DatabaseStudentManagerTestModify extends TestCase {


	private DatabaseRequestor requestor;
	private Student student=null;
	private static DatabaseStudentManager databaseStudentManager=null;
	public static StrutsDatabaseRequestor strutsDatabaseRequestor;
	ResultSet result = null;
	private Properties prop;

	/**
	 * Constructor for DatabaseStudentManagerTest2.
	 * @param arg0
	 */
	public DatabaseStudentManagerTestModify(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		student=new Student();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		student=null;
	}

	public void testModifyStudent() {

		try {
						// db requestor init
						Driver dDriverOracle =
							(java.sql.Driver) Class
								.forName("oracle.jdbc.driver.OracleDriver")
								.newInstance();
						DriverManager.registerDriver(dDriverOracle);
						Connection cCon =
							DriverManager.getConnection(
								"jdbc:oracle:thin:@hibiscus:1521:test",
								"desperados",
								"totofaitduvelo");
						strutsDatabaseRequestor = new StrutsDatabaseRequestor(cCon);

						// managers init
						databaseStudentManager =DatabaseStudentManager.getInstance(strutsDatabaseRequestor,"/home/dslg00/gdupont/genielog/despe/WEB-INF/src/fr/umlv/desperados/struts/studentDatabase.properties");
						} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (InstantiationException e1) {
						e1.printStackTrace();
					} catch (IllegalAccessException e1) { 
						e1.printStackTrace();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
		student.setId(38);
		student.setName("dupont");
		student.setBirthday(java.sql.Date.valueOf("1981-02-11" ));
		student.setFirstname1("gabriel");
		student.setIne("11137");
		student.setWasToUmlvLastYear(true);
		student.setPatronymicName("millet");
		student.setFirstname2("truc");
		student.setTownOfBirth("tours");
		student.setSex("m");
		student.setFirstInsSupEduc("1ermachin");
		student.setFirstInsFrenchUniv("firstInsFrenchUniv");
		student.setEstaFirstInsFrenchUniv("estaFirstInsFrenchUniv");
		student.setFirstInsEstablishment("firstInsEstablishment");
		student.setBacYear("bacYear");
		student.setEstablishmentBacObtaining("EstablishmentBacObtaining");
		student.setForeignCityBac("ForeignCityBac");
		student.setHaveFixAddFr(true);
		student.setNumFixAdd("numFixAdd");
		student.setStreetFixAdd("streetFixAdd");
		student.setBuildingFixAdd("builingFixAdd");
		student.setForeignCityFixAdd("foreignCityFixAdd");
		student.setPhoneFixAdd("phoneFixAdd");
		student.setHaveTmpAddFr(true);
		student.setNumTmpAdd("numTmpAdd");
		student.setStreetTmpAdd("streetTmpAdd");
		student.setBuildingTmpAdd("buildingTmpAdd");
		student.setCityTmpAdd("cityTmpAdd");
		student.setPhoneTmpAdd("phoneTmpAdd");
		student.setEmployed(true);
		student.setStudEmplType("studEmplType");
		student.setHeadFamProf("headFamProf");
		student.setNatSport(true);
		student.setRegSport(true);
		student.setPractisedSport("practisedSport");
		student.setHaveFinancialAss(true);
		student.setInternaExchOriEstab("internaExchOriEstab");
		student.setInternaExchRecEstab("internaExchRecEstab");
		student.setLastAttendedEstab("lastAttendedEstab");
		student.setLastAttendedEstabYear("lastAttendedEstabYear");
		student.setPrecedentYearEstab("precedentYearEstab");
		student.setOtherInsEstab("otherInsEstab");
		student.setPrincCycleInsNum(21);
		student.setComplCycleInsNum(22);
		student.setPrincDiplInsNum(23);
		student.setComplDipInsNum(24);
		student.setPrincInsYearNum(25);
		student.setCompInsYearNum(26);
		student.setStockBrokerNum(27);
		student.setSocialSecurityNum("socialSecurityNum");
		student.setFatherName("fatherName");
		student.setFatherFirstName("fatherFirstName");
		student.setMotherPatronymicName("herPatronymicName");
		student.setMotherName("motherName");
		student.setInsuranceCivilLiability(true);
		student.setAppointmentDate(java.sql.Date.valueOf("1981-02-11" ));
		student.setWorkedShareId(28);
		student.setFinancialAssistanceId("financialAssistanceId");
		student.setSocialEconomicCategoryId(29);
		student.setMLVDiplomaId(30);
		student.setBaccalaureatId("baccalaureatId");
		student.setLodgingTypeId(31);
		student.setInscriptionModeId(32);
		student.setInscriptionTypeId(33);
		student.setCenterPaymentId(34);
		student.setInternationalExchangeTypeId(35);
		student.setMutualInsuranceCompanyId(36);
		student.setSocialSecurityId(36);
		student.setPaymentModeId(37);
		student.setPurseId(38);
		student.setLastDiplomaTypeId("lastDiplomaTypeId");
		student.setBacMentionId(39);
		student.setBaccalaureatEstablishmentTypeId(40);
		student.setLastEstabTypeId(41);
		student.setMilitarySituationId(42);
		student.setFixeAddFrenchCityId(43);
		student.setTmpAdressFrenchCityId(44);
		student.setFrenchBirthplaceId(45);
		student.setFrenchBacCityId(46);
		student.setFirstInsFrUnivDepId(47);
		student.setLastAttendedEstabPlaceId(48);
		student.setPrecYearEstabPlaceId(49);
		student.setOtherEstabInsPlaceId(50);
		student.setBacObtainingCountryId(51);
		student.setNationalityId(52);
		student.setIntExchPlaceId(53);
		student.setForeignBirthplaceId(54);
		student.setFixeAddCountryId(55);
		student.setTmpAddCountryId(56);
		student.setPrecYearSitTypeId("precYearSitTypeId");
		student.setFamSituation(57);
		student.setMotifProlSocSec("motifProlSocSec");
		student.setNoSocSecStu(true);
		student.setOtherEtabIns(58);
		student.setHeadFamJob(59);
		student.setMLVDiplomaComplId(60);
					
		try {
			databaseStudentManager.modifyStudent(student);
		} catch (StudentNotFoundException e3) {
			e3.printStackTrace();
		}
			}

		
	}


