/*
 * Cr�� le 21 janv. 2004
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
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
 * Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
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
		
		//strutsDatabaseRequestor.closeConnection();
	}
	
	/*public void testAddDiploma() {
		String diplomaId;
		Diploma diploma = new Diploma("DEA informatique", "3");
		
		try {
			ddm.addDiploma(diploma);
		} catch (DiplomaAlreadyExistsException e) {
			// TODO Bloc catch auto-g�n�r�
			e.printStackTrace();
			assertTrue(false);
		}
		diplomaId = diploma.getId();
		assertTrue(! (diplomaId.equals("0")));
	}*/
	
	public void testGetDiploma() {
		Diploma diploma = ddm.getDiploma("-1");
		assertTrue(diploma.getName().equals("default"));
	}
	
	public void testListDiploma() {
		Diploma diploma = null;
		boolean diplomaFinded = false;
		Iterator iterator;
		
		List list = ddm.listDiploma();
		
		iterator = list.iterator();
		int i = 0;
		 while(iterator.hasNext()) {
		 	i++;
		 	diploma = (Diploma)iterator.next();
		 	String str = diploma.getName();
		 	if( (diploma.getName().equals("DEA informatique")) && (diploma.getCycle().equals("3")) )
				diplomaFinded = true;
		 }
		assertTrue(diplomaFinded);
	}
	
	public void testAddThenRemoveDiploma() {
		String diplomaId;
		Diploma diploma = new Diploma("DEA informatique", "3");
		
		 try {
			ddm.addDiploma(diploma);
		 } catch (DiplomaAlreadyExistsException e) {
			// TODO Bloc catch auto-g�n�r�
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
