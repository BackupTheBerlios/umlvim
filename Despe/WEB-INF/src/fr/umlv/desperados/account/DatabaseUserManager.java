//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserManager.java

package fr.umlv.desperados.account;

import java.util.List;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.util.Cache;

/**
 * Provides an implementation of the UserManager interface, using an relational 
 * database.
 * It contains a cache system, which prevents to instanciate User several times.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseUserManager implements UserManager 
{
   
   /**
    * The unique instance of the DatabaseUserManager.
    */
   private static DatabaseUserManager theInstance = null;
   
   /**
    * The DatabaseRequestor of this manager.
    */
   private DatabaseRequestor requestor;
   
   /**
    * The Cache of this manager.
    */
   private Cache cache;
   
   /**
    * Private constructor.
    * 
    * @param requestor the DatabaseRequestor of this manager.
    * @roseuid 3FE3139602DD
    */
   private DatabaseUserManager(DatabaseRequestor requestor) 
   {
    
   }
   
   /**
    * Instance getter.
    * 
    * @param requestor the DatabaseRequestor for this manager.
    * @return the unique instance of DatabaseUserManager.
    * @roseuid 3FC8B67D027A
    */
   public static synchronized DatabaseUserManager getInstance(DatabaseRequestor requestor) 
   {
    return null;
   }
   
   /**
    * @param user
    * @throws fr.umlv.desperados.account.UserAlreadyExistsException
    * @roseuid 3FF869B902D2
    */
   public void addUser(User user) throws UserAlreadyExistsException 
   {
    
   }
   
   /**
    * @param login
    * @return boolean
    * @roseuid 3FF869B902F0
    */
   public boolean existUser(String login) 
   {
    return true;
   }
   
   /**
    * @param login
    * @return fr.umlv.desperados.account.User
    * @roseuid 3FF869B9030F
    */
   public User getUser(String login) 
   {
    return null;
   }
   
   /**
    * @param user
    * @throws fr.umlv.desperados.account.UserNotFoundException
    * @roseuid 3FF869B90323
    */
   public void modifyUser(User user) throws UserNotFoundException 
   {
    
   }
   
   /**
    * @param login
    * @return fr.umlv.desperados.account.User
    * @throws fr.umlv.desperados.account.UserNotFoundException
    * @roseuid 3FF869B90341
    */
   public User removeUser(String login) throws UserNotFoundException 
   {
    return null;
   }
   
   /**
    * @param login
    * @param name
    * @return java.util.List
    * @roseuid 3FF869B90369
    */
   public List searchUser(String login, String name) 
   {
    return null;
   }
   
   /**
    * Sets the size of the cache of this manager.
    * 
    * @param size the new size of the cache.
    * @roseuid 3FF9BC6C0105
    */
   public void setCacheSize(int size) 
   {
    
   }
}
/**
 * 
 * 
 *  
 * DatabaseUserManager.getUser(String){
 *     return null;
 *    }
 *  
 *  
 * DatabaseUserManager.modifyUser(User){
 *     
 *    }
 *  
 *  
 * DatabaseUserManager.removeUser(String){
 *     return null;
 *    }
 *  
 *  
 * DatabaseUserManager.existUser(String){
 *     return true;
 *    }
 *  
 *  
 * DatabaseUserManager.addUser(User){
 *     
 *    }
 *  
 *  
 * DatabaseUserManager.searchUser(String,String){
 *     return null;
 *    }
 *  
 *  
 *  
 */
