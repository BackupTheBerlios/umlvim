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
public class DatabaseStudentManagerTestget extends TestCase {

	private DatabaseRequestor requestor;
	private Student student = null;
	private static DatabaseStudentManager databaseStudentManager = null;
	public static StrutsDatabaseRequestor strutsDatabaseRequestor;
	ResultSet result = null;
	private Properties prop;

	/**
	 * Constructor for DatabaseStudentManagerTest3.
	 * @param arg0
	 */
	public DatabaseStudentManagerTestget(String arg0) {
		super(arg0);
		student = new Student();
	}

	public static void main(String[] args) {
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		student = null;
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetStudent() throws SQLException {
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
			databaseStudentManager =
				DatabaseStudentManager.getInstance(
					strutsDatabaseRequestor,
					"/home/dslg00/gdupont/genielog/despe/WEB-INF/src/fr/umlv/desperados/struts/studentDatabase.properties");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		try {
			student = databaseStudentManager.getStudent(38);
		} catch (StudentNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		assertTrue(student.getId() == 38);
		cCon.close();
	}

}
