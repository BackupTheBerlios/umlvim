//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\RdvList.java

package fr.umlv.desperados.planning;

import java.util.List;

import fr.umlv.desperados.util.XMLable;

/**
 * Wrapper for a list of lists of Rdv, that provides a XML transformation of the 
 * list.
 * "list of lists of Rdv" seems that this class maps a list of Rdv by a Date.
 * The typical use is the following : severals Rdv are taken in a day, and the 
 * RdvList 
 * object contains several day.
 * This implementation is usefull for separate the Rdv of each day while 
 * displaying or printing.
 */
public class RdvList implements XMLable {

	/**
	 * The container mapping each list of Rdv by a day.
	 */
	private DatabaseRdvList list;

	/**
	 * Constructor.
	 * @roseuid 3FF2804C02A6
	 */
	public RdvList(List list) throws IllegalArgumentException {
		try {
			this.list = (DatabaseRdvList) list;
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("The list is not a list of rendez-vous");
		}
	}

	/**
	 * @return java.lang.String
	 * @roseuid 3FF869CE0214
	 */
	public String toXML() {
		return list.toXML();
	}
}