/*
 * Created on 2 janv. 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package fr.umlv.desperados.mail;

import junit.framework.TestCase;

import java.io.*;
import java.util.prefs.*;

/**
 * @author Arnaud FRICOTTEAU
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MailerTest extends TestCase {

	private Mailer mailer = null;

	/**
	 * Constructor for MailerTest.
	 * @param arg0
	 */
	public MailerTest(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(MailerTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		String confPath = "C:/fileConf/fileConf.xml";
		//	Create an input stream on a file
		InputStream is = null;
		try {
			is = new BufferedInputStream(new FileInputStream(confPath));
		} catch (FileNotFoundException e) {
			System.err.println ("Cannot found or open the file : " + confPath);
		}

		//	Import preference data
		try {
			Preferences.importPreferences(is);
		} catch (InvalidPreferencesFormatException e) {
			System.err.println ("InvalidPreferencesFormatException in constructor of MessageFactory : " + e);
		} catch (IOException e) {
			System.err.println ("IOException in constructor of MessageFactory : " + e);
		}
	
		mailer = new Mailer();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		mailer = null;
	}

	public void testCreateMessage() {
		String object = "Message de test";
		String body = "Test reussi !";
		Message message = new Message(object, body);
		
		try {
			assertTrue(mailer.sendMail("africott@etudiant.univ-mlv.fr", message));
		} catch (MailNotSentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
