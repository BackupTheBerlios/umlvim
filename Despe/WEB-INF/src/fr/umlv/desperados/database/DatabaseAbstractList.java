//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserList.java

package fr.umlv.desperados.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of User.
 */
public abstract class DatabaseAbstractList extends AbstractList {

	/**
	 * The ResultSet containing the underlying Object list.
	 */
	protected ResultSet rs;

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing the underlying Object list.
	 * @roseuid 3FE5CEFC0223
	 */
	public DatabaseAbstractList(ResultSet rs) {
		this.rs = rs;
	}

	/**
	 * @param i
	 * @return java.lang.Object
	 * @roseuid 3FF869BA0143
	 */
	public abstract Object get(int i);

	/**
	 * @return int
	 * @roseuid 3FF869BA0157
	 */
	public int size() {
		int size = 0;
		synchronized(rs) {
			try {
				int current = rs.getRow();
				rs.last();
				size = rs.getRow();
				rs.absolute(current);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return size;
	}

	/* (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	public abstract Iterator iterator();

	/* (non-Javadoc)
	 * @see java.util.List#listIterator(int)
	 */
	public abstract ListIterator listIterator(int arg0);

}