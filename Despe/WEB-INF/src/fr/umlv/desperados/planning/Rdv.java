//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\Rdv.java

package fr.umlv.desperados.planning;

import java.util.Date;

import fr.umlv.desperados.util.XMLable;

/**
 * Represents a rendez-vous in the application.
 */
public class Rdv implements XMLable {

	/**
	* The date and hour of the Rdv.
	*/
	private Date date;
	
	private String studentId;
	
	private String name;
	
	private String firstname;
	
	private boolean ravel;
	
	


	/**
		   * @param studentInfo
		   */
	public Rdv(Date dateRdv) {

		date = dateRdv;
	}

	/**
	 * Constructor.
	 * 
	 * @param date the date and hour of the Rdv.
	 * @param studentId the id of the Student who has the Rdv.
	 * @param name the name of the Student who has the Rdv.
	 * @param firstname the firstname of the Student who has the Rdv.
	 * @param ravel the statut of the Student who has the Rdv
	 * @roseuid 3FD5A04C01D4
	 */
	public Rdv(java.util.Date date, String studentId, String name, String firstname, boolean ravel) {
	this.date=date;
	this.studentId=studentId;
	this.name=name;
	this.firstname=firstname;
	this.ravel=ravel;
	}

	/**
	 * Returns the day and hour of the Rdv, in the form of Date.
	 * 
	 * @return the date and hour of the Rdv.
	 * @roseuid 3FE31BFF0093
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Returns the firstname of the Student who has the Rdv.
	 * 
	 * @return the firstname of the Student who has the Rdv.
	 * @roseuid 3FE31C1100FD
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Returns the name of the Student who has the Rdv.
	 * 
	 * @return the name of the Student who has the Rdv.
	 * @roseuid 3FE31C1C0199
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the statut of the Student who has the Rdv.
	 * 
	 * @return <code>true</code> if the Student who has the Rdv is RAVEL, 
	 * <code>false</code> otherwise.
	 * @roseuid 3FE5FCAB0139
	 */
	public boolean getRavel() {
		return ravel;
	}

	/**
	 * Returns the id of the Student who has the Rdv.
	 * 
	 * @return the id of the Student who has the Rdv.
	 * @roseuid 3FE31C28015A
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @return java.lang.String
	 * @roseuid 3FF869CB027E
	 */
	public String toXML() {
		return null;
	}
}
