//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\mail\\Mailer.java

package fr.umlv.desperados.mail;

import java.util.Properties;
import java.util.prefs.Preferences;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class is responsible of sending mail.
 * The configuration of the mailer is read from a XML stream, which has the 
 * following form :
 * <pre>
 * <?xml version="1.0" encoding="UTF-8"?>
 * <!DOCTYPE preferences SYSTEM 'http://java.sun.com/dtd/preferences.dtd'>
 * 
 * <preferences EXTERNAL_XML_VERSION="1.0">
 *   <root type="user">
 *     <map />
 *     <node name="systemInfos">
 *       <map>
 *         <entry key="universiteName" value="Universite de Marne-La-Vallee" />
 *         <entry key="mailAddress" value="africott@etudiant.univ-mlv.fr" />
 *         <entry key="smtpServer" value="etudiant.univ-mlv.fr" />
 *       </map>
 *   </root>
 * </preferences>
 * </pre>
 */
public class Mailer {

	/**
	 * The mail of the sender (it will be used to fill the <i>from</i> attribute of 
	 * the mail).
	 */
	private String mailFrom;

	/**
	 * The smtp server address.
	 */
	private String smtpServer;

	/**
	 * The Preferences containing mail configuration (i.e. the smtp server address and the sender mail address).
	 */
	private Preferences prefs;

	/**
	 * Constructor.
	 * 
	 * @param conf the stream containing the configuration of the Mailer.
	 * @roseuid 3FE194B901E4
	 */
	public Mailer() {
		// Search the preferences system infos
		Preferences uroot = Preferences.userRoot();
		Preferences child = uroot.node("systemInfos");

		// Read system configuration in system preferences file
		mailFrom = child.get("mailAddress", "");
		smtpServer = child.get("smtpServer", "");

		//System.out.println("mailAddress = " + mailAddress);
		//System.out.println("smtpServer = " + smtpServer);
	}

	/**
	 * Sends the given message to the specified e-mail address.
	 * 
	 * @param email the e-mail address of the recipient.
	 * @param msg the message to send.
	 * @throws fr.umlv.desperados.mail.MailNotSentException if an errors occured while 
	 * sending message.
	 * @roseuid 3FBCFF3F002D
	 */
	public void sendMail(String email, fr.umlv.desperados.mail.Message msg)
		throws MailNotSentException {

		//	Creat properties and open a session with SMTP host
		Properties props = new Properties();
		props.put("mail.smtp.host", smtpServer);
		Session session = Session.getDefaultInstance(props, null);

		try {
			// Creat message
			Message message = new MimeMessage(session);

			// Set the shipper
			message.setFrom(new InternetAddress(mailFrom));

			// Set the recipient
			InternetAddress[] address = { new InternetAddress(email) };
			message.setRecipients(Message.RecipientType.TO, address);

			// Set the subject
			message.setSubject(msg.getObject());

			// Set the message
			message.setContent(msg.getBody(), "text/plain");

			// Envoi du message
			Transport.send(message);

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
