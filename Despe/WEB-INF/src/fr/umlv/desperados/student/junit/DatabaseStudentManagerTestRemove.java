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
import fr.umlv.desperados.student.StudentNotFoundException;
import junit.framework.TestCase;

/**
 * @author gdupont
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class DatabaseStudentManagerTestRemove extends TestCase {

	private DatabaseRequestor requestor;
	private Student student=null;
	private static DatabaseStudentManager databaseStudentManager=null;
	public static StrutsDatabaseRequestor strutsDatabaseRequestor;
	ResultSet result = null;

	/**
	 * Constructor for DatabaseStudentManagerTestRemove.
	 * @param arg0
	 */
	public DatabaseStudentManagerTestRemove(String arg0) {
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

	public void testRemoveStudent() throws SQLException {
		// db requestor init
		Connection cCon;
					Driver dDriverOracle = null;
					try {
						dDriverOracle =
							(java.sql.Driver) Class
								.forName("oracle.jdbc.driver.OracleDriver")
								.newInstance();
					} catch (InstantiationException e) {
						// TODO Bloc catch auto-généré
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Bloc catch auto-généré
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Bloc catch auto-généré
						e.printStackTrace();
					}
					try {
						DriverManager.registerDriver(dDriverOracle);
					} catch (SQLException e1) {
						// TODO Bloc catch auto-généré
						e1.printStackTrace();
					}
					cCon = null;
					try {
						cCon =
							DriverManager.getConnection(
								"jdbc:oracle:thin:@hibiscus:1521:test",
								"desperados",
								"totofaitduvelo");
					} catch (SQLException e2) {
						// TODO Bloc catch auto-généré
						e2.printStackTrace();
					}
					strutsDatabaseRequestor = new StrutsDatabaseRequestor(cCon);

					// managers init
					databaseStudentManager =DatabaseStudentManager.getInstance(strutsDatabaseRequestor,"/home/dslg00/gdupont/genielog/despe/WEB-INF/src/fr/umlv/desperados/struts/studentDatabase.properties");

	try {
		databaseStudentManager.removeStudent(39);
	} catch (StudentNotFoundException e3) {
		// TODO Bloc catch auto-généré
		e3.printStackTrace();
	}
	cCon.close();
				
	}

}
