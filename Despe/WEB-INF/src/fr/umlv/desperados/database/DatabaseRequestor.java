//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\database\\DatabaseRequestor.java

package fr.umlv.desperados.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class provides manager classes a way to request the database.
 */
public interface DatabaseRequestor {

	/**
	 * @param query the query to send to the database
	 * @return the result of the query
	 * @roseuid 3FE0AE3500F0
	 */
	public ResultSet doQuery(String query) throws SQLException;
	public int executeQuery(String query) throws SQLException;
	public void closeConnection();
}
