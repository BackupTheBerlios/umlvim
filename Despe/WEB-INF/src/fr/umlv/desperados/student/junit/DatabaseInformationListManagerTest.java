/*
 * Créé le 7 févr. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.umlv.desperados.student.junit;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import fr.umlv.desperados.struts.database.StrutsDatabaseRequestor;
import fr.umlv.desperados.student.DatabaseInformationListManager;

import junit.framework.TestCase;

/**
 * @author ncuvelie
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class DatabaseInformationListManagerTest extends TestCase {

	StrutsDatabaseRequestor strutsDatabaseRequestor;
	DatabaseInformationListManager manager;

	/**
	 * Constructor for DatabaseInformationListManagerTest.
	 * @param arg0
	 */
	public DatabaseInformationListManagerTest(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(DatabaseInformationListManagerTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
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
				manager =DatabaseInformationListManager.getInstance(strutsDatabaseRequestor,
						"/home/dslg00/ncuvelie/workspace/despe/WEB-INF/src/fr/umlv/desperados/struts/Database.properties");
				} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) { 
				e1.printStackTrace();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testList() {
		Set set = manager.list(DatabaseInformationListManager.LAST_ESTAB_TYPE);
		for(Iterator it = set.iterator() ; it.hasNext() ; ) {
			Map.Entry entry =(Map.Entry)it.next();
			System.out.println(entry.getKey()+" = "+entry.getValue());
		}
	}
}