//Source file: C:\\Documents and Settings\\Arnaud FRICOTTEAU\\Mes documents\\fr\\umlv\\desperados\\diploma\\DatabaseDiplomaManager.java

package fr.umlv.desperados.diploma;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.umlv.desperados.database.DatabaseRequestor;

/**
 * Provides an implementation of the DiplomaManager interface, using an relational 
 * database.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseDiplomaManager implements DiplomaManager 
{
   
   /**
	* The DatabaseRequestor of this manager.
	*/
   private DatabaseRequestor requestor;
   
   /**
	* The unique instance of DatabaseDiplomaManager.
	*/
   private static DatabaseDiplomaManager theInstance = null;
   
   /**
	* Private default constructor.
	* 
	* @param requestor the DatabaseRequestor for this manager.
	* @roseuid 3FE5DD56006D
	*/
   private DatabaseDiplomaManager(DatabaseRequestor requestor) 
   {
	this.requestor = requestor;
   }
   
   /**
	* Instance getter.
	* 
	* @param requestor the DatabaseRequestor for this manager.
	* @return the unique instance of DatabaseDiplomaManager.
	* @roseuid 3FD742300119
	*/
   public static DatabaseDiplomaManager getInstance(DatabaseRequestor requestor) 
   {
	if(theInstance==null)
		theInstance = new DatabaseDiplomaManager(requestor);
	return theInstance;
   }
   
   /**
	* @return java.util.List
	* @roseuid 3FF869CF00DF
	*/
   public List listDiploma() 
   {
	List laListe = null;
	try {
		ResultSet rs = requestor.doQuery("SELECT * FROM DIPLOME_MLV");
		laListe = new DatabaseDiplomaList(rs);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return laListe;
   }
   
   /**
	* @param diplomaId
	* @return java.lang.String
	* @roseuid 3FF869CF00E9
	*/
   public Diploma getDiploma(String diplomaId) 
   {
	Diploma diploma = null;
	try {
		ResultSet rs = requestor.doQuery("SELECT * FROM DIPLOME_MLV WHERE ID_DIP_MLV="+diplomaId);
		if(rs.first()) {
			diploma = new Diploma(rs.getString("LIB_DIP_MLV"), rs.getString("ID_CYC"));
			diploma.setId(diplomaId);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return diploma;
   }
   
   /**
	* @param diploma
	* @throws fr.umlv.desperados.diploma.DiplomaAlreadyExistsException
	* @roseuid 3FF869CF00FD
	*/
   public void addDiploma(Diploma diploma) throws DiplomaAlreadyExistsException 
   {
	ResultSet rs = null;
   	
	String reqInsertDip = "INSERT INTO DIPLOME_MLV (ID_CYC, LIB_DIP_MLV) VALUES ("
		+diploma.getCycle()
		+", '"
		+diploma.getName()
		+"')";
    
	String reqSelectId = "SELECT * FROM DIPLOME_MLV WHERE (ID_CYC = "
		+diploma.getCycle()
		+" AND LIB_DIP_MLV = '"
		+diploma.getName()
		+"') order by ID_DIP_MLV";
    
	try {
		synchronized(requestor) {
			requestor.doQuery(reqInsertDip);
			
			// When a diploma is insert, the database attribute an unique id
			// by incrementation of the max
			rs = requestor.doQuery(reqSelectId);
		}
		rs.last();
		String idMax = rs.getString("ID_DIP_MLV"); 

		diploma.setId(idMax);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   /**
	* @param diplomaId
	* @roseuid 3FF869CF011B
	*/
   public void removeDiploma(String diplomaId) 
   {
	String reqDeleteDip = "DELETE FROM DIPLOME_MLV WHERE ID_DIP_MLV = " + diplomaId;
		
	try {
		requestor.doQuery(reqDeleteDip);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}
