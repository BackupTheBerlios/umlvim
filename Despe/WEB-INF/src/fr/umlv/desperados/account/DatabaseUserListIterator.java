//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserListIterator.java

package fr.umlv.desperados.account;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.umlv.desperados.database.DatabaseAbstractListIterator;

/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseUserList.
 */
final class DatabaseUserListIterator extends DatabaseAbstractListIterator {

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing a User list.
	 * @roseuid 3FE2F884035B
	 */
	DatabaseUserListIterator(ResultSet rs) {
		super(rs);
	}

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing a User list.
	 * @roseuid 3FE2F884035B
	 */
	DatabaseUserListIterator(ResultSet rs, int index) {
		super(rs, index);
	}

	/**
	 * @return java.lang.Object
	 * @roseuid 3FF869B8012C
	 */
	public Object next() {
		index++;
		return rowToUser();
	}

	/**
	 * @return java.lang.Object
	 * @roseuid 3FF869B80140
	 */
	public Object previous() {
		index--;
		return rowToUser();
	}

	private User rowToUser() {
		int current = -1;
		User user = null;
		synchronized (rs) {
			try {
				current = rs.getRow();
				rs.absolute(index);
				user = new User(rs.getString("LOGIN_COM"));
				user.setName(rs.getString("NOM_COM"));
				user.setFirstname(rs.getString("PRENOM_COM"));
				user.setAdmin(rs.getBoolean("EST_ADM_COM"));
				user.setPassword(rs.getString("PASS_COM"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(current != -1) {
						rs.absolute(current);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return user;
	}
}