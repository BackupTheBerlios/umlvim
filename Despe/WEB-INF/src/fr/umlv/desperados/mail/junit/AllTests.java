/*
 * Créé le 21 janv. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.umlv.desperados.mail.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author africott
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite =
			new TestSuite("Test for fr.umlv.desperados.mail.junit");
		//$JUnit-BEGIN$
		suite.addTest(new TestSuite(MessageFactoryTest.class));
		suite.addTest(new TestSuite(MailerTest.class));
		//$JUnit-END$
		return suite;
	}
}
