//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\stylesheet\\DatabaseStyleSheetList.java

package fr.umlv.desperados.stylesheet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ListIterator;

import fr.umlv.desperados.database.DatabaseAbstractList;

/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of StyleSheet.
 */
final class DatabaseStyleSheetList extends DatabaseAbstractList {

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing the StyleSheet list.
	 * @roseuid 3FE73B460088
	 */
	DatabaseStyleSheetList(ResultSet rs) {
		super(rs);
	}

	/**
	 * @param i
	 * @return java.lang.Object
	 * @roseuid 3FF869D2006C
	 */
	public Object get(int i) {
		StyleSheet ss = null;
		try {
			if (rs.absolute(i))
				ss =
					new StyleSheet(
						rs.getString("NOM_FIC_FEU"),
						rs.getString("NOM_FIC"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ss;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	public Iterator iterator() {
		Iterator it = new DatabaseStyleSheetListIterator(rs);
		return it;
	}

	/* (non-Javadoc)
	 * @see java.util.List#listIterator()
	 */
	public ListIterator listIterator(int index) {
		ListIterator lit = new DatabaseStyleSheetListIterator(rs, index);
		return lit;
	}

}
