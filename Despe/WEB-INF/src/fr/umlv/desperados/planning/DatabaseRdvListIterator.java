//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\DatabaseRdvListIterator.java

package fr.umlv.desperados.planning;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import fr.umlv.desperados.database.DatabaseAbstractListIterator;

/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseRdvList.
 */
final class DatabaseRdvListIterator extends DatabaseAbstractListIterator {

	/**
	 * @param rs
	 * @param index
	 */
	public DatabaseRdvListIterator(ResultSet rs, int index) {

		super(rs, index);
	}

	/**
	 * The ResultSet containing the Rdv list.
	 */
	private ResultSet rs;

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing a Rdv list.
	 * @roseuid 3FE5EA7D026D
	 */
	DatabaseRdvListIterator(ResultSet rs) {
		super(rs);
	}

	/**
	 * @return java.lang.Object
	 * @roseuid 3FF869CC030C
	 */
	public Object next() {
		index++;
		return rowToRdv();
	}

	/**
	 * @return java.lang.Object
	 * @roseuid 3FF869CC0320
	 */
	public Object previous() {
		index--;
		return rowToRdv();
	}

	/**
	 * transforme the current rs row in a Rdv
	 * @return a Rdv
	 */
	private Object rowToRdv() {
		int current = -1;
		Rdv rdv = null;

		synchronized (rs) {
			try {
				current = rs.getRow();
				rs.absolute(index);

				String id = String.valueOf(rs.getString("ID_ETU"));
				String name = rs.getString("NOM_PATRONYMIQUE");
				String firstName = rs.getString("PRENOM1");

				// TODO deprecated, a changer en utilisant calendar
				boolean isRavel =
					(rs.getDate("ANNEE_BAC").getYear()
						== new Date(System.currentTimeMillis()).getYear());
				Date dateRdv = rs.getDate("DATE_DE_RDV");

				rdv = new Rdv(dateRdv, id, name, firstName, isRavel);

			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				try {
					if (current != -1)
						rs.absolute(current);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}

		}

		return rdv;
	}

}
