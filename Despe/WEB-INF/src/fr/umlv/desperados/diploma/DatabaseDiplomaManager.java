//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\diploma\\DatabaseDiplomaManager.java

package fr.umlv.desperados.diploma;

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
    
   }
   
   /**
    * Instance getter.
    * 
    * @param requestor the DatabaseRequestor for this manager.
    * @return the unique instance of DatabaseDiplomaManager.
    * @roseuid 3FD742300119
    */
   public synchronized DatabaseDiplomaManager getInstance(DatabaseRequestor requestor) 
   {
    return null;
   }
   
   /**
    * @return java.util.List
    * @roseuid 3FF869CF00DF
    */
   public List listDiploma() 
   {
    return null;
   }
   
   /**
    * @param diplomaId
    * @return java.lang.String
    * @roseuid 3FF869CF00E9
    */
   public String getDiploma(String diplomaId) 
   {
    return null;
   }
   
   /**
    * @param diploma
    * @roseuid 3FF869CF00FD
    */
   public void addDiploma(String diploma) 
   {
    
   }
   
   /**
    * @param diplomaId
    * @roseuid 3FF869CF011B
    */
   public void removeDiploma(String diplomaId) 
   {
    
   }
}
/**
 * 
 * 
 *  
 * DatabaseDiplomaManager.addDiploma(String){
 *     
 *    }
 *  
 *  
 * DatabaseDiplomaManager.removeDiploma(String){
 *     
 *    }
 *  
 *  
 * DatabaseDiplomaManager.getDiploma(String){
 *     return null;
 *    }
 *  
 *  
 * DatabaseDiplomaManager.listDiploma(){
 *     return null;
 *    }
 *  
 *  
 *  
 */
