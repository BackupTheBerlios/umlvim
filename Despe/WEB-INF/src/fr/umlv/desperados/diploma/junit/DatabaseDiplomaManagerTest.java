/*
 * Créé le 21 janv. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.umlv.desperados.diploma.junit;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.diploma.DatabaseDiplomaManager;
import fr.umlv.desperados.diploma.Diploma;
import fr.umlv.desperados.diploma.DiplomaAlreadyExistsException;
import fr.umlv.desperados.struts.database.StrutsDatabaseRequestor;

import junit.framework.TestCase;

/**
 * @author africott
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class DatabaseDiplomaManagerTest extends TestCase {

	private StrutsDatabaseRequestor strutsDatabaseRequestor;
	private DatabaseDiplomaManager ddm;
	
	/**
	 * Constructor for DatabaseDiplomaManagerTest.
	 * @param arg0
	 */
	public DatabaseDiplomaManagerTest(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(DatabaseDiplomaManagerTest.class);
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
		
		ddm = DatabaseDiplomaManager.getInstance((DatabaseRequestor)strutsDatabaseRequestor);
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetDiploma() {
		Diploma diploma = ddm.getDiploma("-1");
		assertTrue(diploma.getName().equals("default"));
	}
	
	public void testListDiploma() {
		Diploma diploma = null;
		boolean diplomaFinded = false;
		boolean diplomaNotFinded = true;
		Iterator iterator;
		
		List list = ddm.listDiploma();
		
		iterator = list.iterator();
		 while(iterator.hasNext()) {
		 	diploma = (Diploma)iterator.next();
		 	if( (diploma.getName().equals("default")) && (diploma.getCycle().equals("-1")) )
				diplomaFinded = true;
			if( (diploma.getName().equals("N'existe pas")) && (diploma.getCycle().equals("-100")) )
				diplomaNotFinded = false;
		 }
		assertTrue(diplomaFinded);
		assertTrue(diplomaNotFinded);
	}
	
	public void testAddThenRemoveDiploma() {
		String diplomaId;
		Diploma diploma = null;
		 
		diploma = new Diploma("DEA informatique", "3");
		
		 try {
			ddm.addDiploma(diploma);
		 } catch (DiplomaAlreadyExistsException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		 }
		 
		assertTrue(diploma != null);
		 diplomaId = diploma.getId();
				
		 ddm.removeDiploma(diplomaId);
		 
		 diploma = null;
		 diploma = ddm.getDiploma(diplomaId);
		 assertTrue(diploma == null);
		}		

}