//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\mail\\Message.java

package fr.umlv.desperados.mail;

/**
 * Represents a message that can be sent <i>via</i>  the Mailer class.
 */
public class Message {

	public static final String CREATION_MESSAGE = "accountCreatedMail";
	public static final String MODIFICATION_MESSAGE = "accountModifiedMail";
	public static final String SUPPRESSION_MESSAGE = "accountRemovedMail";

	/**
	 * The object of the Message.
	 */
	private String object;

	/**
	 * The body of the Message.
	 */
	private String body;

	/**
	 * Constructor.
	 * 
	 * @param object the object of the Message.
	 * @param body the body of the Message.
	 * @roseuid 3FE56AF7036F
	 */
	Message(String object, String body) {
		this.object = object;
		this.body = body;
	}

	/**
	 * Returns the object of the Message.
	 * 
	 * @return the object of the Message.
	 * @roseuid 3FC3B5890126
	 */
	public String getObject() {
		return object;
	}

	/**
	 * Returns the body of the Message.
	 * 
	 * @return the body of the Message.
	 * @roseuid 3FC3B59B00FA
	 */
	public String getBody() {
		return body;
	}
}
