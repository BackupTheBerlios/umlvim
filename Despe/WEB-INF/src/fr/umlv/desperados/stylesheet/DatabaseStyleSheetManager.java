//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\stylesheet\\DatabaseStyleSheetManager.java

package fr.umlv.desperados.stylesheet;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.stylesheet.UsedStylesheetException;

/**
 * Provides an implementation of the StyleSheetManager interface, using an 
 * relational database.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseStyleSheetManager implements StyleSheetManager {

	/**
	 * The DatabaseRequestor of this manager.
	 */
	private DatabaseRequestor requestor;

	/**
	 * The unique instance of DatabaseStyleSheetManager.
	 */
	private static DatabaseStyleSheetManager theInstance = null;

	/**
	 * Private default constructor.
	 * 
	 * @param requestor the DatabaseRequestor of this manager.
	 * @roseuid 3FD7420D01D4
	 */
	private DatabaseStyleSheetManager(DatabaseRequestor requestor) {
		this.requestor = requestor;
	}

	/**
	 * Instance getter.
	 * 
	 * @param requestor the DatabaseRequestor for this manager.
	 * @return the unique instance of StyleSheetManager.
	 * @roseuid 3FF85111002D
	 */
	public static DatabaseStyleSheetManager getInstance(DatabaseRequestor requestor) {
			if (theInstance == null)
				theInstance = new DatabaseStyleSheetManager(requestor);
		return theInstance;
	}

	/**
	 * @param styleSheet
	 * @roseuid 3FF869D00380
	 */
	public void addStyleSheet(StyleSheet styleSheet) {
		try {
			requestor.doQuery(
				"INSERT INTO FEUILLE_DE_STYLE (NOM_FIC_FEU, NOM_FEU) VALUES ('"
					+ styleSheet.getFilename()
					+ "','"
					+ styleSheet.getName()
					+"')");
		} catch (SQLException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
	}

	/**
	 * @param styleSheetId
	 * @roseuid 3FF869D00394
	 */
	public void removeStyleSheet(String styleSheetId, String path) throws UsedStylesheetException {
		try {
			ResultSet rs = requestor.doQuery("select * from DOCUMENT where FEUILLE_STYLE_DOC='"+styleSheetId+"'");
			if(!rs.first()) {
				requestor.doQuery(
					"DELETE FROM FEUILLE_DE_STYLE WHERE NOM_FIC_FEU='" + styleSheetId+"'");
				File f = new File(path+styleSheetId);
				f.delete();
			}
			else throw new UsedStylesheetException("La feuille de style que vous voulez supprimer est actuellement utilisée.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param StyleSheetId
	 * @param docTypeId
	 * @roseuid 3FF869D003A8
	 */
	public void setStyleSheet(String StyleSheetId, int docTypeId) {
		try {
			requestor.doQuery(
				"UPDATE DOCUMENT SET  FEUILLE_STYLE_DOC='"
					+ StyleSheetId
					+ "' WHERE ID_DOC='"
					+ docTypeId+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return java.util.List
	 * @roseuid 3FF869D003D0
	 */
	public List listStyleSheet() {
		List l = null;
		try {
			ResultSet rs = requestor.doQuery("SELECT * FROM FEUILLE_DE_STYLE");
			l = new DatabaseStyleSheetList(rs);
		} catch (SQLException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
		return l;
	}

	/**
	 * @param DocType
	 * @return fr.umlv.desperados.stylesheet.StyleSheet
	 * @roseuid 3FF869D003DA
	 */
	public StyleSheet getStyleSheet(int docType) {
		StyleSheet ss = null;
		try {
			ResultSet rs =
				requestor.doQuery(
					"SELECT FEUILLE_STYLE_DOC FROM DOCUMENT WHERE ID_DOC="
						+ docType);
			String fileName = null;
			if(rs.first()) {
				fileName = rs.getString("FEUILLE_STYLE_DOC");
			}
			rs =
				requestor.doQuery(
					"SELECT * FROM FEUILLE_DE_STYLE WHERE NOM_FIC_FEU = '" + fileName+"'");
			if(rs.first())
				ss = new StyleSheet(rs.getString("NOM_FIC_FEU"), rs.getString("NOM_FEU"));
		} catch (SQLException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
		return ss;
	}

	public Map listDocType() {
		Map map = new HashMap();
		try {
			ResultSet rs = requestor.doQuery("SELECT ID_DOC, LIB_DOC FROM DOCUMENT");
			while(rs.next()) {
				map.put(rs.getString("ID_DOC"), rs.getString("LIB_DOC"));
			}
		} catch (SQLException e) {
			// TODO Bloc catch auto-généré
			e.printStackTrace();
		}
		return map;
	}
}