//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserListIterator.java

package fr.umlv.desperados.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ListIterator;

/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseUserList.
 */
public abstract class DatabaseAbstractListIterator implements ListIterator {

	/**
	 * The ResultSet containing the User list.
	 */
	protected ResultSet rs;

	protected int index;
	protected int size;
	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing a User list.
	 * @roseuid 3FE2F884035B
	 */
	protected DatabaseAbstractListIterator(ResultSet rs) {
		this(rs, 0);
	}
	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing a User list.
	 * @roseuid 3FE2F884035B
	 */
	protected DatabaseAbstractListIterator(ResultSet rs, int beginIndex) {
		this.rs = rs;
		index = beginIndex;
		synchronized(rs) {
			try {
				int current = rs.getRow();
				rs.last();
				size = rs.getRow();
				rs.absolute(current);
			} catch (SQLException e) {
				// TODO Bloc catch auto-généré
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param obj
	 * @roseuid 3FF869B80104
	 */
	public void add(Object o) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("list is read-only");
	}

	/**
	 * @return boolean
	 * @roseuid 3FF869B80118
	 */
	public boolean hasNext() {
		return (index < size);
	}

	/**
	 * @return boolean
	 * @roseuid 3FF869B80122
	 */
	public boolean hasPrevious() {
		return (index > 0);
	}

	/**
	 * @return int
	 * @roseuid 3FF869B80136
	 */
	public int nextIndex() {
		return index+1;
	}

	/**
	 * @return int
	 * @roseuid 3FF869B8014A
	 */
	public int previousIndex() {
		return index-1;
	}

	/**
	 * @roseuid 3FF869B80154
	 */
	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("list is read-only");
	}

	/**
	 * @param obj
	 * @roseuid 3FF869B8015E
	 */
	public void set(Object obj) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("list is read-only");
	}
}
