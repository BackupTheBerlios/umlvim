//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\mail\\MailNotSentException.java

package fr.umlv.desperados.mail;

/**
 * Happens when an error occured while sending the mail.
 */
public class MailNotSentException extends Exception {

	/**
	 * Constructs a new MailNotSentException with the specified detail message.
	 * 
	 * @param message the detail message.
	 * @roseuid 3FE99EBC007B
	 */
	public MailNotSentException(String message) {
		super(message);
	}

	/**
		* @roseuid 3FE99EAC0046
		*/
	public MailNotSentException() {
		super();
	}
}
