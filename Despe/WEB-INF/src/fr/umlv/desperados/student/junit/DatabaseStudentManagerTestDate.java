/*
 * Créé le 22 janv. 2004
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

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.struts.database.StrutsDatabaseRequestor;
import fr.umlv.desperados.student.DatabaseStudentManager;
import fr.umlv.desperados.student.Student;
import junit.framework.TestCase;

/**
 * @author gdupont
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class DatabaseStudentManagerTestDate extends TestCase {

	private DatabaseRequestor requestor;
	private Student student=null;
	private static DatabaseStudentManager databaseStudentManager=null;
	public static StrutsDatabaseRequestor strutsDatabaseRequestor;
	ResultSet result = null;

	/**
	 * Constructor for DatabaseStudentManagerTestDate.
	 * @param arg0
	 */
	public DatabaseStudentManagerTestDate(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDateControl() throws SQLException {
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
	//java.util.Date truc=databaseStudentManager.dateControl(java.sql.Date.valueOf("9999-12-12" ));
	//String machin="t";
	cCon.close();
	}
}
