/*
 * Cr�� le 21 janv. 2004
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
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
import fr.umlv.desperados.student.StudentBirthdayException;
import junit.framework.TestCase;

/**
 * @author gdupont
 *
 * Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
public class DatabaseStudentManagerTestExist extends TestCase {

	private DatabaseRequestor requestor;
	private Student student=null;
	private static DatabaseStudentManager databaseStudentManager=null;
	public static StrutsDatabaseRequestor strutsDatabaseRequestor;
	ResultSet result = null;

	/**
	 * Constructor for DatabaseStudentManagerTest1.
	 * @param arg0
	 */
	public DatabaseStudentManagerTestExist(String arg0) {
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

	public void testExistStudent() throws SQLException {
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
			try {
				assertFalse(databaseStudentManager.existStudent("g�g�","jeannot",java.sql.Date.valueOf("1981-02-11" ))==0);
			} catch (StudentBirthdayException e3) {
				// TODO Bloc catch auto-g�n�r�
				e3.printStackTrace();
			}
			cCon.close();
		}

	}


