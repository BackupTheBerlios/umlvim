/*
 * Créé le 20 janv. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.umlv.desperados.stylesheet.junit;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.struts.database.StrutsDatabaseRequestor;
import fr.umlv.desperados.stylesheet.DatabaseStyleSheetManager;
import fr.umlv.desperados.stylesheet.ExistStylesheetException;
import fr.umlv.desperados.stylesheet.StyleSheet;

import junit.framework.TestCase;

/**
 * @author ndedanil
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class DatabaseStyleSheetManagerTest extends TestCase {
	private DatabaseStyleSheetManager dssm = null;
	private StrutsDatabaseRequestor requestor;
	/**
	 * Constructor for DatabaseStyleSheetManagerTest.
	 * @param arg0
	 */
	public DatabaseStyleSheetManagerTest(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(DatabaseStyleSheetManagerTest.class);
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
		requestor = new StrutsDatabaseRequestor(cCon); 
		dssm = DatabaseStyleSheetManager.getInstance((DatabaseRequestor)requestor);
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		dssm = null;
	}

	public void testAddStyleSheet() {
		StyleSheet ss = new StyleSheet("dossier5.xsl","theDossierFile5");
		// dssm.addStyleSheet(ss);
		try {
			ResultSet rs = requestor.doQuery("select * from FEUILLE_DE_STYLE where NOM_FEU = 'theDossierFile5'");
			assertTrue(rs.getString("NOM_FIC_FEU").equals("dossier5.xsl"));
		} catch (SQLException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
	}
	
	public void testRemoveStyleSheet() {
		//dssm.removeStyleSheet();
	}
}
