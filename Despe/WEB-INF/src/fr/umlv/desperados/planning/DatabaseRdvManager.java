//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\DatabaseRdvManager.java

package fr.umlv.desperados.planning;

import java.util.Date;
import java.util.List;

import fr.umlv.desperados.database.DatabaseRequestor;

/**
 * Provides an implementation of the RdvManager interface, using an relational 
 * database.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseRdvManager implements RdvManager 
{
   
   /**
    * The unique instance of DatabaseRdvManager.
    */
   private static DatabaseRdvManager theInstance = null;
   
   /**
    * The DatabaseRequestor of this manager.
    */
   private DatabaseRequestor requestor;
   
   /**
    * Private default constructor.
    * 
    * @param requestor the DatabaseRequestor for this manager.
    * @roseuid 3FE5EB7D0081
    */
   private DatabaseRdvManager(DatabaseRequestor requestor) 
   {
    
   }
   
   /**
    * Instance getter.
    * 
    * @param requestor the DatabaseRequestor for this manager.
    * @return the unique instance of DatabaseRdvManager.
    * @roseuid 3FF302030359
    */
   public DatabaseRdvManager getInstance(DatabaseRequestor requestor) 
   {
    return null;
   }
   
   /**
    * @param rdv
    * @roseuid 3FF869CD00E6
    */
   public void addRdv(Rdv rdv) 
   {
    
   }
   
   /**
    * @param ravel
    * @return java.util.Date[]
    * @roseuid 3FF869CD00FB
    */
   public Date[] getFreeDays(boolean ravel) 
   {
    return null;
   }
   
   /**
    * @param day
    * @param ravel
    * @return java.util.Date[]
    * @roseuid 3FF869CD0119
    */
   public Date[] getFreeHours(java.util.Date day, boolean ravel) 
   {
    return null;
   }
   
   /**
    * @param studentId
    * @return fr.umlv.desperados.planning.Rdv
    * @roseuid 3FF869CD0141
    */
   public Rdv getRdv(int studentId) 
   {
    return null;
   }
   
   /**
    * @param date
    * @param ravel
    * @return boolean
    * @roseuid 3FF869CD015F
    */
   public boolean isDateFree(java.util.Date date, boolean ravel) 
   {
    return true;
   }
   
   /**
    * @param day
    * @return java.util.List
    * @roseuid 3FF869CD0191
    */
   public List listRdv(java.util.Date day) 
   {
    return null;
   }
   
   /**
    * @param rdv
    * @roseuid 3FF869CD01AF
    */
   public void removeRdv(Rdv rdv) 
   {
    
   }
}
/**
 * 
 * 
 *  
 * DatabaseRdvManager.addRdv(Rdv){
 *     
 *    }
 *  
 *  
 * DatabaseRdvManager.removeRdv(Rdv){
 *     
 *    }
 *  
 *  
 * DatabaseRdvManager.getRdv(int){
 *     return null;
 *    }
 *  
 *  
 * DatabaseRdvManager.listRdv(java.util.Date){
 *     return null;
 *    }
 *  
 *  
 * DatabaseRdvManager.isDateFree(java.util.Date,boolean){
 *     return true;
 *    }
 *  
 *  
 * DatabaseRdvManager.getFreeHours(java.util.Date,boolean){
 *     return null;
 *    }
 *  
 *  
 * DatabaseRdvManager.getFreeDays(boolean){
 *     return null;
 *    }
 *  
 *  
 *  
 */
