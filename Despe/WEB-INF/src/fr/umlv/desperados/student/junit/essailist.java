/*
 * Cr�� le 2 f�vr. 2004
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
import junit.framework.TestCase;


/**
 * @author gdupont
 *
 * Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
public class essailist extends TestCase {

	private DatabaseRequestor requestor;
	private Student student = null;
	private static DatabaseStudentManager databaseStudentManager = null;
	public static StrutsDatabaseRequestor strutsDatabaseRequestor;
	ResultSet result = null;

	/**
	 * Constructor for essailist.
	 * @param arg0
	 */
	public essailist(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		
		Connection cCon = null;
				// db requestor init
					Driver dDriverOracle = null;
					try {
						dDriverOracle =
							(java.sql.Driver) Class
								.forName("oracle.jdbc.driver.OracleDriver")
								.newInstance();
					} catch (InstantiationException e) {
						
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						
						e.printStackTrace();
					}
					try {
						DriverManager.registerDriver(dDriverOracle);
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					try {
						cCon =
							(Connection) DriverManager.getConnection(
								"jdbc:oracle:thin:@hibiscus:1521:test",
								"desperados",
								"totofaitduvelo");
					} catch (SQLException e2) {
						
						e2.printStackTrace();
					}
					strutsDatabaseRequestor = new StrutsDatabaseRequestor(cCon);

					// managers init
					databaseStudentManager =
						DatabaseStudentManager.getInstance(
							strutsDatabaseRequestor,
							"/home/dslg00/gdupont/genielog/despe/WEB-INF/src/fr/umlv/desperados/struts/studentDatabase.properties");

	
						
					try {
						cCon.close() ;
					} catch (SQLException e3) {
						
						e3.printStackTrace();
					}
	}

}
