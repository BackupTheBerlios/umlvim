//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\DatabaseRdvList.java

package fr.umlv.desperados.planning;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;

import fr.umlv.desperados.database.DatabaseAbstractList;

/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of Rdv.
 */
final class DatabaseRdvList extends DatabaseAbstractList {

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
		super(rs);
	}

	/**
	 * @param i
	 * @return java.lang.Object
	 * @roseuid 3FF869CC017B
	 */
	public Object get(int i) {
		Rdv rdv = null;
		synchronized (rs) {
			try {
				rs.absolute(i);

				String id = String.valueOf(rs.getString("ID_ETU"));
				String name = rs.getString("NOM_PATRONYMIQUE");
				String firstName = rs.getString("PRENOM1");

				java.util.Date dateBac = rs.getDate("ANNEE_BAC");
				Calendar calBac = new GregorianCalendar();
				calBac.setTime(dateBac);

				java.util.Date dateRdv = rs.getDate("DATE_DE_RDV");
				Calendar calRdv = new GregorianCalendar();
				calRdv.setTime(dateRdv);

				boolean isRavel = (calBac.get(Calendar.YEAR) == calRdv.get(Calendar.YEAR));

				rdv = new Rdv(dateRdv, id, name, firstName, isRavel);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rdv;
	}

	/**
	 * @return int
	 * @roseuid 3FF869CC018F
	 */
	/* (non-Javadoc)
	* @see fr.umlv.desperados.database.DatabaseAbstractList#iterator()
	*/
	public Iterator iterator() {
		return new DatabaseRdvListIterator(rs);
	}

	public ListIterator listIterator(int index) {
		return new DatabaseRdvListIterator(rs, index);
	}
}
/**
 * 
 * 
 *  
 * DatabaseRdvList.size(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseRdvList.get(int){
 *     return null;
 *    }
 *  
 *  
 *  
 */
