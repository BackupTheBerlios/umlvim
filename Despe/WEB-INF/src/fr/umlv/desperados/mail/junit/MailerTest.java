/*
 * Created on 2 janv. 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package fr.umlv.desperados.mail.junit;

import junit.framework.TestCase;

import java.io.*;
import java.util.prefs.*;

import fr.umlv.desperados.account.User;
import fr.umlv.desperados.mail.MailNotSentException;
import fr.umlv.desperados.mail.Mailer;
import fr.umlv.desperados.mail.Message;
import fr.umlv.desperados.mail.MessageFactory;


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
		String confPath = "WEB-INF/mail-conf.xml";
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
		Message message = null;
		MessageFactory messageFactory = new MessageFactory();
		
		User user = new User("africott");
		user.setAdmin(true);
		user.setEmail("africott@etudiant.univ-mlv.fr");
		user.setFirstname("Arnaud");
		user.setName("FRICOTTEAU");
		user.setPassword("123");
		
		message = messageFactory.createMessage(Message.CREATION_MESSAGE, user);
		
		try {
			mailer.sendMail("africott@etudiant.univ-mlv.fr", message);
		} catch (MailNotSentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		} 
				
		assertTrue(true);
	}	

}
