//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\database\\StrutsDatabaseRequestor.java

package fr.umlv.desperados.struts.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import fr.umlv.desperados.database.DatabaseRequestor;

public class StrutsDatabaseRequestor implements DatabaseRequestor {

	/**
	 * the source of the database.
	 */
	DataSource source;

	/**
	 * Constructor.
	 * 
	 * @param source the source of the database.
	 * @roseuid 3FE18C33015B
	 */
	public StrutsDatabaseRequestor(DataSource source) {
		this.source = source;
	}

	/**
	 * @param query
	 * @return java.sql.ResultSet
	 * @roseuid 3FF2CD41015A
	 */
	public ResultSet doQuery(String query) throws SQLException {
		ResultSet rs = null;
		Connection conn = source.getConnection();
		conn.createStatement();
		return rs;
	}
}
