//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserListIterator.java

package fr.umlv.desperados.account;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.umlv.desperados.database.DatabaseListIterator;

/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseUserList.
 */
final class DatabaseUserListIterator extends DatabaseListIterator {

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
	 * @return java.lang.Object
	 * @roseuid 3FF869B8012C
	 */
	public Object next() {
		int current;
		User user = null;
		try {
			synchronized (rs) {
				current = rs.getRow();
				rs.absolute(index);
				index++;
				user = new User(rs.getString("LOGIN_COM"));
				user.setName(rs.getString("NOM_COM"));
				user.setFirstname(rs.getString("PRENOM_COM"));
				user.setAdmin(rs.getBoolean("EST_ADM_COM"));
				user.setPassword(rs.getString("PASS_COM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.absolute(current);
		}

		return user;

	}

	/**
	 * @return java.lang.Object
	 * @roseuid 3FF869B80140
	 */
	public Object previous() {
		User user = null;
		try {
			rs.previous();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			user = new User(rs.getString("LOGIN_COM"));
			user.setName(rs.getString("NOM_COM"));
			user.setFirstname(rs.getString("PRENOM_COM"));
			user.setAdmin(rs.getBoolean("EST_ADM_COM"));
			user.setPassword(rs.getString("PASS_COM"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return null;
	}
}