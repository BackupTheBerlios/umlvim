//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\DatabaseRdvList.java

package fr.umlv.desperados.planning;

import java.sql.ResultSet;
import java.util.AbstractList;

/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of Rdv.
 */
final class DatabaseRdvList extends AbstractList {

	/**
	 * The ResultSet containing the Rdv list.
	 */
	private ResultSet rs;

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing a Rdv list.
	 * @roseuid 3FE5EA5B0156
	 */
	DatabaseRdvList(ResultSet rs) {		
		this.rs = rs;
	}

	/**
	 * gat a row result at the index i
	 * @param i
	 * @return java.lang.Object
	 * @roseuid 3FF869CC017B
	 */
	public Object get(int i) {
		return null;
	}

	/**
	 * @return int
	 * @roseuid 3FF869CC018F
	 */
	public int size() {
		return 0;
	}
}
