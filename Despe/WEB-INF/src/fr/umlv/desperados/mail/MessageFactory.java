//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\mail\\MessageFactory.java

package fr.umlv.desperados.mail;

import java.util.prefs.Preferences;

import fr.umlv.desperados.account.User;

/**
 * A factory class for Message objects.
 * The models of message are read from a XML stream, which has the following form :
 * <pre>
 * <?xml version="1.0" encoding="UTF-8"?>
 * <!DOCTYPE preferences SYSTEM 'http://java.sun.com/dtd/preferences.dtd'>
 * 
 * <preferences EXTERNAL_XML_VERSION="1.0">
 *   <root type="user">
 *     <map />
 *     <node name="accountCreatedMail">
 *       <map>
 *         <entry key="object" value="Creation de votre compte pour l'outil 
 * d'inscription des etudiants" />
 *         <entry key="body" value="Bonjour #FIRSTNAME# #NAME#. \nVotre compte 
 * #ADMIN#, pour acceder a l'application, a ete cree avec les parametres suivants 
 * : \n login : #LOGIN# \n mot de passe : #PASSWORD#" />
 *       </map>
 *     </node>
 *     <node name="accountModifiedMail">
 *       <map>
 *         <entry key="object" value="Modification de votre compte pour l'outil 
 * d'inscription des etudiants" />
 *         <entry key="body" value="Bonjour #FIRSTNAME# #NAME#. \nVotre compte 
 * #ADMIN#, pour acceder a l'application, a ete modifie avec les parametres 
 * suivants : \n login : #LOGIN# \n mot de passe : #PASSWORD#" />
 *       </map>
 *     </node>
 *     <node name="accountRemovedMail">
 *       <map>
 *         <entry key="object" value="Suppression de votre compte pour l'outil 
 * d'inscription des etudiants" />
 *         <entry key="body" value="Bonjour #FIRSTNAME# #NAME#. \nVotre compte 
 * #ADMIN#, pour acceder a l'application, a ete supprime." />
 *       </map>
 *     </node>
 *   </root>
 * </preferences>
 * </pre>
 * 
 * When a message is create (method <code>createMessage(int, User)</code>, the 
 * string above are used (according to the type of message), and tags are replaced 
 * in the following way :
 * <pre>
 * #FIRSTNAME#  -->  user.getFirstname()
 * #NAME#  -->  user.getname()
 * #ADMIN#  -->  user.getAdmin() ? "administrateur"
 * #PASSWORD#  -->  user.getPassword()
 * #LOGIN#  -->  user.getLogin()
 * </pre>
 */
public class MessageFactory {
	public static final String CREATION_MESSAGE = "accountCreatedMail";
	public static final String MODIFICATION_MESSAGE = "accountModifiedMail";
	public static final String SUPPRESSION_MESSAGE = "accountRemovedMail";

	private String creationMessageObject;
	private String creationMessageBody;
	private String modificationMessageObject;
	private String modificationMessageBody;
	private String suppressionMessageObject;
	private String suppressionMessageBody;

	/**
	 * The Preferences containing mail configuration (i.e. the smtp server address and 
	 * the sender mail address).
	 */
	private Preferences prefs;

	/**
	 * Constructor.
	 * 
	 * @param confPath the path of the file containing the configuration of the Mailer.
	 * @roseuid 3FE566F401C4
	 */
	public MessageFactory() {

		// Getting the user root node
		Preferences uroot = Preferences.userRoot();

		// Getting the creation node ...
		Preferences child = uroot.node(CREATION_MESSAGE);
		// ... and read the object and the body of the creation mail
		creationMessageObject = child.get("object", "");
		creationMessageBody = child.get("body", "");

		// Getting the creation node
		child = uroot.node(MODIFICATION_MESSAGE);
		// ... and read the object and the body of the modification mail
		modificationMessageObject = child.get("object", "");
		modificationMessageBody = child.get("body", "");

		// Getting the creation node
		child = uroot.node(SUPPRESSION_MESSAGE);
		// ... and read the object and the body of the suppression mail
		suppressionMessageObject = child.get("object", "");
		suppressionMessageBody = child.get("body", "");
	}

	/**
	 * @param body the body to update
	 * @param user the user the mail is to be sent to
	 * @return the updated body
	 */
	private String updateBodyMail(String body, User user) {
		body = body.replaceAll("#firstname", user.getFirstname());
		body = body.replaceAll("#name", user.getName());
		if (user.getAdmin())
			body = body.replaceAll("#admin", "administrateur");
		else
			body = body.replaceAll("#admin", "utilisateur");
		body = body.replaceAll("#login", user.getLogin());
		body = body.replaceAll("#password", user.getPassword());

		return body;
	}

	/**
	 * Constructs a new instance of Message, containing a user specific message, and 
	 * according to the given type.
	 * 
	 * @param type the type of message to send.
	 * It must be one of MessageFactory.CREATION_MESSAGE, 
	 * MessageFactory.MODIFICATION_MESSAGE and MessageFactory.SUPPRESSION_MESSAGE.
	 * @param user the User the message contains (used to fill the blanks in the mail 
	 * model).
	 * 
	 * @return fr.umlv.desperados.mail.Message
	 * @roseuid 3FC8B53A0320
	 */
	public Message createMessage(String type, User user) {

		// Select the message according to the type
		String object = "";
		String body = "";
		if(CREATION_MESSAGE.equals(type)) {
			object = creationMessageObject;
			body = creationMessageBody;
		}
		else if(MODIFICATION_MESSAGE.equals(type)) {
			object = modificationMessageObject;
			body = modificationMessageBody;
		}
		else if(SUPPRESSION_MESSAGE.equals(type)) {
			object = suppressionMessageObject;
			body = suppressionMessageBody;
		}

		// Update the message body with user infos
		body = updateBodyMail(body, user);

		// Creat the message
		Message m = new Message(object, body);

		return m;
	}
}
