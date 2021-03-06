//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\G�NIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\database\\StrutsDatabaseRequestor.java

package fr.umlv.desperados.struts.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import fr.umlv.desperados.database.DatabaseRequestor;

public class StrutsDatabaseRequestor implements DatabaseRequestor {

	/**
	 * the source of the database.
	 */
	DataSource source;
	Connection conn;
	/**
	 * Constructor.
	 * 
	 * @param source the source of the database.
	 * @roseuid 3FE18C33015B
	 */
	public StrutsDatabaseRequestor(Connection conn) {
		this.conn = conn;
	}

	/**
	 * @param query
	 * @return java.sql.ResultSet
	 * @roseuid 3FF2CD41015A
	 */
	public ResultSet doQuery(String query) throws SQLException {
		Statement sStat=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
																				ResultSet.CONCUR_UPDATABLE);
		// ResultSet.CLOSE_CURSORS_AT_COMMIT pour utiliser les select for update
							
		ResultSet myResultSet = null;
		
		System.out.println("StrutsDatabaseRequestor.doQuery() : query="+query);
		myResultSet = sStat.executeQuery(query);
		if(myResultSet.getConcurrency() == ResultSet.CONCUR_READ_ONLY) {
			System.out.println("StrutsDatabaseRequestor: ATTENTION: ResultSet non updatable");
		}
		if(myResultSet.getType() == ResultSet.TYPE_FORWARD_ONLY) {
			System.out.println("StrutsDatabaseRequestor: ATTENTION: ResultSet de type FORWARD_ONLY");
		}
		if(myResultSet.getType() == ResultSet.TYPE_SCROLL_SENSITIVE) {
			System.out.println("StrutsDatabaseRequestor: ATTENTION: ResultSet de type SCROLL_SENSITIVE");
		}
		return myResultSet;
	}


	public int executeQuery(String modificationQuery) throws SQLException{
		Statement sStat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		sStat=conn.createStatement();
		return(sStat.executeUpdate(modificationQuery));
	}


	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("StrutsDatabaseRequestor.closeConnection(): " +				"Erreur � la fermeture de la connection");
		}
	}
}
