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
import java.util.List;
import java.util.Map;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.struts.database.StrutsDatabaseRequestor;
import fr.umlv.desperados.stylesheet.DatabaseStyleSheetManager;
import fr.umlv.desperados.stylesheet.ExistStylesheetException;
import fr.umlv.desperados.stylesheet.StyleSheet;
import fr.umlv.desperados.stylesheet.UsedStylesheetException;

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

	public void testAddStyleSheet() throws ExistStylesheetException, SQLException {
		StyleSheet ss = new StyleSheet("feuille_test.xsl","test");
		dssm.addStyleSheet(ss);
		System.out.println("ss = "+ss.getFilename());
		ResultSet rs = requestor.doQuery("select * from FEUILLE_DE_STYLE where NOM_FIC_FEU = '" + ss.getFilename()+"'");
		assertTrue(rs.first());
		assertTrue(rs.getString("NOM_FIC_FEU").equals("feuille_test.xsl"));
	}
	
	public void testRemoveStyleSheet() {
		try {
			dssm.removeStyleSheet("feuille_test.xsl","/stylesheet/");
		} catch (UsedStylesheetException e) {
			e.printStackTrace();
		}
		try {
			ResultSet rs = requestor.doQuery("select * from FEUILLE_DE_STYLE where NOM_FIC_FEU='feuille_test.xsl'");
			assertTrue(!rs.first());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void testSetStyleSheet() throws ExistStylesheetException, SQLException {
		StyleSheet ss = new StyleSheet("feuille_test.xsl","test");
		dssm.addStyleSheet(ss);
		dssm.setStyleSheet(ss.getFilename(),DatabaseStyleSheetManager.CONFIRMATION_DOCUMENT);
		ResultSet rs = requestor.doQuery("select  FEUILLE_STYLE_DOC from DOCUMENT where ID_DOC="+DatabaseStyleSheetManager.CONFIRMATION_DOCUMENT);
		assertTrue(rs.first());
		assertTrue(rs.getString("FEUILLE_STYLE_DOC").equals("feuille_test.xsl"));
	}
	
	public void testListStyleSheet() {
		List l = dssm.listStyleSheet();
		System.out.println(l.size());
		assertTrue(l.size() > 0);
	}
	
	public void testGetStyleSheet() {
		StyleSheet ss = dssm.getStyleSheet(DatabaseStyleSheetManager.CONFIRMATION_DOCUMENT);
		assertTrue(ss.getFilename().equals("feuille_test.xsl"));
		assertTrue(ss.getName().equals("test"));
	}
	
	public void testListDocType() throws UsedStylesheetException {
		Map map = dssm.listDocType();
		assertTrue(!map.isEmpty());
		assertTrue(map.containsValue("inscription"));
		assertTrue(map.containsValue("confirmation"));
		dssm.setStyleSheet("confirmation.sxw", DatabaseStyleSheetManager.CONFIRMATION_DOCUMENT);
		dssm.removeStyleSheet("feuille_test.xsl","/stylesheet");
	}
}
