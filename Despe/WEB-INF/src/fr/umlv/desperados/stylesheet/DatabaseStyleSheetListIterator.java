//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\stylesheet\\DatabaseStyleSheetListIterator.java

package fr.umlv.desperados.stylesheet;

import java.sql.ResultSet;
import java.sql.SQLException;
import fr.umlv.desperados.database.DatabaseAbstractListIterator;

/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseStyleSheetList.
 */
final class DatabaseStyleSheetListIterator extends DatabaseAbstractListIterator {

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing the StyleSheet list.
	 * @roseuid 3FE73B85027E
	 */
	DatabaseStyleSheetListIterator(ResultSet rs) {
		super(rs);
	}

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing the StyleSheet list.
	 * @roseuid 3FE73B85027E
	 */
	DatabaseStyleSheetListIterator(ResultSet rs, int index) {
		super(rs, index);
	}

	/**
	 * @return java.lang.Object
	 * @roseuid 3FF869D201FC
	 */
	public Object next() {
		int current = 0;
		StyleSheet ss = null;
		try {
			synchronized (rs) {
				current = rs.getRow();
				index++;
				rs.absolute(index);
				ss = new StyleSheet(rs.getString("NOM_FIC"),
													rs.getString("NOM"));
			}
		} catch (SQLException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} finally {
			try {
				rs.absolute(current);
			} catch (SQLException e1) {
				// TODO Bloc catch auto-généré
				e1.printStackTrace();
			}
		}
		return ss;
	}

	/**
	 * @return java.lang.Object
	 * @roseuid 3FF869D20210
	 */
	public Object previous() {
		int current = 0;
		StyleSheet ss = null;
		try {
			synchronized (rs) {
				current = rs.getRow();
				index--;
				rs.absolute(index);
				ss = new StyleSheet(rs.getString("NOM_FIC"),
													rs.getString("NOM"));
			}
		} catch (SQLException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		} finally {
			try {
				rs.absolute(current);
			} catch (SQLException e1) {
				// TODO Bloc catch auto-généré
				e1.printStackTrace();
			}
		}
		return ss;
	}
}
