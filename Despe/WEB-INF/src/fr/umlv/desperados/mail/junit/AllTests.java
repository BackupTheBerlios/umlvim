/*
 * Cr�� le 21 janv. 2004
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package fr.umlv.desperados.mail.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author africott
 *
 * Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
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
