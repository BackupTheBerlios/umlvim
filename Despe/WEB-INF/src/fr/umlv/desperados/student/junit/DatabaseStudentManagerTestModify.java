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
import fr.umlv.desperados.student.StudentBirthdayException;
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

	public void testModifyStudent() throws SQLException {
		Connection cCon = null;
		try {
						// db requestor init
						Driver dDriverOracle =
							(java.sql.Driver) Class
								.forName("oracle.jdbc.driver.OracleDriver")
								.newInstance();
						DriverManager.registerDriver(dDriverOracle);
						cCon =
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
		student.setName("dupont2");
		student.setBirthday(java.sql.Date.valueOf("1981-02-11" ));
		student.setFirstname1("jeannot");
		student.setIne("11137");
		student.setWasToUmlvLastYear(true);
		student.setPatronymicName("gégé");
		student.setFirstname2("truc");
		student.setTownOfBirth("tours");
		student.setSex("m");
		student.setFirstInsSupEduc("1ermachin");
		student.setFirstInsFrenchUniv("chUniv");
		student.setEstaFirstInsFrenchUniv("sFchUniv");
		student.setFirstInsEstablishment("stablish");
		student.setBacYear("1902");
		student.setEstablishmentBacObtaining("acObtaining");
		student.setForeignCityBac("ForeiBac");
		student.setHaveFixAddFr(true);
		student.setNumFixAdd("numFixAdd");
		student.setStreetFixAdd("streetFixAdd");
		student.setBuildingFixAdd("builingFixAdd");
		student.setForeignCityFixAdd("foityFixAdd");
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
		student.setInternaExchOriEstab("intetab");
		student.setInternaExchRecEstab("intab");
		student.setLastAttendedEstab("lastAttab");
		student.setLastAttendedEstabYear("lbYear");
		student.setPrecedentYearEstab("pretab");
		student.setOtherInsEstab("otstab");
		student.setPrincCycleInsNum(1);
		student.setComplCycleInsNum(2);
		student.setPrincDiplInsNum(3);
		student.setComplDipInsNum(4);
		student.setPrincInsYearNum(5);
		student.setCompInsYearNum(6);
		student.setStockBrokerNum(27);
		student.setSocialSecurityNum("som");
		student.setFatherName("fatherNa");
		student.setFatherFirstName("fathe");
		student.setMotherPatronymicName("hcName");
		student.setMotherName("mote");
		student.setInsuranceCivilLiability(true);
		student.setAppointmentDate(java.sql.Date.valueOf("1981-02-11" ));
		student.setWorkedShareId(1);
		student.setFinancialAssistanceId("1");
		student.setSocialEconomicCategoryId(-1);
		student.setMLVDiplomaId(-1);
		student.setBaccalaureatId("vide");
		student.setLodgingTypeId(-1);
		student.setInscriptionModeId(-1);
		student.setInscriptionTypeId(-1);
		student.setCenterPaymentId(-1);
		student.setInternationalExchangeTypeId(-1);
		student.setMutualInsuranceCompanyId(1);
		student.setSocialSecurityId(-1);
		student.setPaymentModeId(-1);
		student.setPurseId(-1);
		student.setLastDiplomaTypeId("0");
		student.setBacMentionId(-1);
		student.setBaccalaureatEstablishmentTypeId(-1);
		student.setLastEstabTypeId(-1);
		student.setMilitarySituationId(-1);
		student.setFixeAddFrenchCityId(-1);
		student.setTmpAdressFrenchCityId(-1);
		student.setFrenchBirthplaceId(-1);
		student.setFrenchBacCityId(-1);
		student.setFirstInsFrUnivDepId(-1);
		student.setLastAttendedEstabPlaceId(-1);
		student.setPrecYearEstabPlaceId(-1);
		student.setOtherEstabInsPlaceId(-1);
		student.setBacObtainingCountryId(-1);
		student.setNationalityId(-1);
		student.setIntExchPlaceId(-1);
		student.setForeignBirthplaceId(-1);
		student.setFixeAddCountryId(-1);
		student.setTmpAddCountryId(-1);
		student.setPrecYearSitTypeId("0");
		student.setFamSituation(-1);
		student.setMotifProlSocSec("motifPrc");
		student.setNoSocSecStu(true);
		student.setOtherEtabIns(-1);
		student.setHeadFamJob(-1);
		student.setMLVDiplomaComplId(-1);
					
		try {
			try {
				databaseStudentManager.modifyStudent(student);
			} catch (StudentBirthdayException e4) {
				// TODO Bloc catch auto-généré
				e4.printStackTrace();
			}
		} catch (StudentNotFoundException e3) {
			e3.printStackTrace();
		}
	cCon.close();
			}

		
	}


