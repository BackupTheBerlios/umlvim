//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\dummy\\XMLUserManager.java

package fr.umlv.desperados.dummy;

import java.util.List;

import fr.umlv.desperados.account.UserManager;
import fr.umlv.desperados.account.User;
import fr.umlv.desperados.account.UserAlreadyExistsException;
import fr.umlv.desperados.account.UserNotFoundException;

/**
 * Class providing an implementation of the UserManager interface, using an XML 
 * file.
 */
public class XMLUserManager implements UserManager 
{
   
   /**
    * the unique instance of the XMLUserManager
    */
   private static XMLUserManager theInstance;
   
   /**
    * private default constructor
    * 
    * @param databasePath the path of the XML database
    * @roseuid 3FE2D4F3005F
    */
   private XMLUserManager(String databasePath) 
   {
    
   }
   
   /**
    * load the user database
    * @roseuid 3FE2E5AC0296
    */
   public void load() 
   {
    
   }
   
   /**
    * make the user database persistent
    * @roseuid 3FE2E56B0102
    */
   public void save() 
   {
    
   }
   
   /**
    * instance getter
    * 
    * @param databasePath the path of the XML database
    * @return the unique instance of SQLUserManager
    * @roseuid 3FF3025002FF
    */
   public static synchronized XMLUserManager getInstance(String databasePath) 
   {if (theInstance == null)
	theInstance = new XMLUserManager(databasePath);
return theInstance;    
   }
   
   /**
    * @param user
    * @throws fr.umlv.desperados.account.UserAlreadyExistsException
    * @roseuid 3FF869C80374
    */
   public void addUser(User user) throws UserAlreadyExistsException 
   {
    
   }
   
   /**
    * @param login
    * @return boolean
    * @roseuid 3FF869C8037F
    */
   public boolean existUser(String login) 
   {
    return true;
   }
   
   /**
    * @param login
    * @return fr.umlv.desperados.account.User
    * @roseuid 3FF869C80388
    */
   public User getUser(String login) 
   {
    return null;
   }
   
   /**
    * @param user
    * @throws fr.umlv.desperados.account.UserNotFoundException
    * @roseuid 3FF869C8038A
    */
   public void modifyUser(User user) throws UserNotFoundException 
   {
    
   }
   
   /**
    * @param login
    * @return fr.umlv.desperados.account.User
    * @throws fr.umlv.desperados.account.UserNotFoundException
    * @roseuid 3FF869C80393
    */
   public User removeUser(String login) throws UserNotFoundException 
   {
    return null;
   }
   
   /**
    * @param login
    * @param name
    * @return java.util.List
    * @roseuid 3FF869C8039C
    */
   public List searchUser(String login, String name) 
   {
    return null;
   }
}
