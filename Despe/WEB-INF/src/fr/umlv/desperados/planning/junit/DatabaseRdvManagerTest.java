/*
 * Créé le 26 janv. 2004
 *
 */
package fr.umlv.desperados.planning.junit;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Calendar;
import java.util.GregorianCalendar;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.planning.DatabaseRdvManager;
import fr.umlv.desperados.struts.database.StrutsDatabaseRequestor;

import junit.framework.TestCase;

/**
 * @author africott
 *
 */
public class DatabaseRdvManagerTest extends TestCase {

	private StrutsDatabaseRequestor strutsDatabaseRequestor;
	private DatabaseRdvManager drm;
	
	/**
	 * Constructor for DatabaseDiplomaManagerTest.
	 * @param arg0
	 */
	public DatabaseRdvManagerTest(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(DatabaseRdvManagerTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		//	db requestor init
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
		
		drm = DatabaseRdvManager.getInstance((DatabaseRequestor)strutsDatabaseRequestor);
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetDiploma() {
			String numberOfRdV = "";
			
			String dateStart = "18/01";
			String dateEnd = "19/01";
			
			Calendar calendar = new GregorianCalendar();
			int year = calendar.get(Calendar.YEAR);
			dateStart = dateStart + "/" + year;
			dateEnd = dateEnd + "/" + year;
			
			numberOfRdV = drm.giveRdVNumber(dateStart, dateEnd,"-1");
			assertTrue(numberOfRdV.equals("1"));
			
			dateEnd = "18/01";
			
			numberOfRdV = drm.giveRdVNumber(dateStart,dateEnd, "");
			assertTrue(numberOfRdV.equals("0"));
		}

}
