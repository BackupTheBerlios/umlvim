/*
 * Created on 2 janv. 2004
 *
 */
package fr.umlv.desperados.mail.junit;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

import fr.umlv.desperados.account.User;
import fr.umlv.desperados.mail.Message;
import fr.umlv.desperados.mail.MessageFactory;

/**
 * @author Arnaud FRICOTTEAU
 *
 */
public class MessageFactoryTest extends TestCase {

	private MessageFactory messageFactory = null;

	/**
	 * Constructor for MailClassTest.
	 * @param arg0
	 */
	public MessageFactoryTest(String arg0) {
		super(arg0);
	}

	public static void main(String[] args) {
		junit.swingui.TestRunner.run(MessageFactoryTest.class);
	}

	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
		// System.err.println(System.getProperty("user.dir"));
		String confPath = "WEB-INF/mail-conf.xml";
		
		InputStream is = null;
		try {
			is = new FileInputStream(confPath);
		} catch (FileNotFoundException e) {
			System.out.println(
				"Cannot found or open the file : " + confPath);
		}

		//	Import preference data
		try {
			Preferences.importPreferences(is);
		} catch (InvalidPreferencesFormatException e) {
			System.err.println(
				"InvalidPreferencesFormatException in PlugIn PrefsPlugin : " + e);
		} catch (IOException e) {
			System.err.println(
				"IOException in PlugIn PrefsPlugin : " + e);
		}
		
		messageFactory = new MessageFactory();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		messageFactory = null;
	}
	
	public void testCreateMessage() {
		final String object = "Creation de votre compte pour l'outil d'inscription des etudiants";
		final String body = "Bonjour Arnaud FRICOTTEAU. \nVotre compte administrateur, pour acceder a l'application, a ete cree avec les parametres suivants : \n login : africott \n mot de passe : 123";
		
		Message message = null;
		User user = new User("africott");
		user.setAdmin(true);
		user.setEmail("africott@etudiant.univ-mlv.fr");
		user.setFirstname("Arnaud");
		user.setName("FRICOTTEAU");
		user.setPassword("123");
		
		message = messageFactory.createMessage(Message.CREATION_MESSAGE, user);
		
		/*if((message.getObject()).equals(object))
			System.out.println("Génération de l'objet du message de création : OK");
		else System.out.println("Génération de l'objet du message de création : Erreur");
				
		if((message.getBody()).equals(body))
			System.out.println("Génération du corps du message de création : OK");
		else System.out.println("Génération du corps du message de création : Erreur");*/
		
		assertTrue((message.getObject()).equals(object));
		assertTrue((message.getBody()).equals(body));
	}
	
	public void testModifyMessage() {
		final String object = "Modification de votre compte pour l'outil d'inscription des etudiants";
		final String body = "Bonjour Arnaud FRICOTTEAU. \nVotre compte administrateur, pour acceder a l'application, a ete modifie avec les parametres suivants : \n login : africott \n mot de passe : 123";		
		Message message = null;
		User user = new User("africott");
		user.setAdmin(true);
		user.setEmail("africott@etudiant.univ-mlv.fr");
		user.setFirstname("Arnaud");
		user.setName("FRICOTTEAU");
		user.setPassword("123");
		
		message = messageFactory.createMessage(Message.MODIFICATION_MESSAGE, user);
		
		assertTrue((message.getObject()).equals(object));
		assertTrue((message.getBody()).equals(body));
	}
		
	public void testRemoveMessage() {
		final String object = "Suppression de votre compte pour l'outil d'inscription des etudiants";
		final String body = "Bonjour Arnaud FRICOTTEAU. \nVotre compte administrateur, pour acceder a l'application, a ete supprime.";
		
		Message message = null;
		User user = new User("africott");
		user.setAdmin(true);
		user.setEmail("africott@etudiant.univ-mlv.fr");
		user.setFirstname("Arnaud");
		user.setName("FRICOTTEAU");
		user.setPassword("123");
		
		message = messageFactory.createMessage(Message.SUPPRESSION_MESSAGE, user);
		
		assertTrue((message.getObject()).equals(object));
		assertTrue((message.getBody()).equals(body));
	}

}