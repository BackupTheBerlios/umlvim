//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserList.java

package fr.umlv.desperados.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ListIterator;

import fr.umlv.desperados.database.DatabaseAbstractList;

/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of User.
 */
final class DatabaseUserList extends DatabaseAbstractList {

	/**
	 * Constructor.
	 * 
	 * @param rs the ResultSet containing a User list.
	 * @roseuid 3FE5CEFC0223
	 */
	DatabaseUserList(ResultSet rs) {
		super(rs);
	}

	/**
	 * @param i
	 * @return java.lang.Object
	 * @roseuid 3FF869BA0143
	 */
	public Object get(int i) {
		User user = null;
		try {
			rs.absolute(i);
		} catch (SQLException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
		try {
			user = new User(rs.getString("LOGIN_COM"));
			user.setName(rs.getString("NOM_COM"));
			user.setFirstname(rs.getString("PRENOM_COM"));
			user.setAdmin(rs.getBoolean("EST_ADM_COM"));
			user.setPassword(rs.getString("PASS_COM"));
		} catch (SQLException e1) {
			// TODO Bloc catch auto-généré
			e1.printStackTrace();
		}
		return user;
	}

	/* (non-Javadoc)
	 * @see fr.umlv.desperados.database.DatabaseAbstractList#iterator()
	 */
	public Iterator iterator() {
		return new DatabaseUserListIterator(rs);
	}

	/* (non-Javadoc)
	 * @see fr.umlv.desperados.database.DatabaseAbstractList#listIterator(int)
	 */
	public ListIterator listIterator(int index) {
		DatabaseUserListIterator it = new DatabaseUserListIterator(rs, index);
		return it;
	}
}