//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\UserManager.java

package fr.umlv.desperados.account;

import java.sql.SQLException;
import java.util.List;


/**
 * Class responsible of adding, removing, modifying, listing and getting User 
 * in/from a permanent storage.
 */
public interface UserManager 
{
   
   /**
    * Adds a User in the permanent storage.
    * 
    * @param user the User to add.
    * @throws fr.umlv.desperados.account.UserAlreadyExistsException if the User 
    * already exists in the permanent storage.
    * @roseuid 3FC46F9F007D
    */
   public void addUser(User user) throws UserAlreadyExistsException;
   
   /**
    * Checks if a User exists in the permanent storage.
    * 
    * @param login the login of the User to check.
    * @return <code>true</code> if the User exist in the permanent storage, 
    * <code>false</code> otherwise.
    * @roseuid 3FC369F202AF
    */
   public boolean existUser(String login);
   
   /**
    * Gets a User from the permanent storage.
    * 
    * @param login the login of the User to get.
    * @return the User to get.
    * @roseuid 3FC8C1B3021D
    */
   public User getUser(String login)  throws UserNotFoundException;
   
   /**
    * Modifies a User in the permanent storage.
    * 
    * @param user the User to modify.
    * @throws fr.umlv.desperados.account.UserNotFoundException if the User does not 
    * exist in the permanent storage.
    * @roseuid 3FC46EFE01B5
    */
   public void modifyUser(User user) throws UserNotFoundException;
   
   /**
    * Removes a User from the permanent storage.
    * 
    * @param login the login of the user to remove.
    * @return the removed user.
    * @throws fr.umlv.desperados.account.UserNotFoundException if the User does not 
    * exist in the permanent storage.
    * @roseuid 3FC46FC1000F
    */
   public User removeUser(String login) throws UserNotFoundException;
   
   /**
    * Searches a User in the permanent storage.
    * 
    * @param login the login of the User to search.
    * @param name the name of the User to search.
    * @return a <code>List</code> containing all the User found in the permanent 
    * storage.
    * @roseuid 3FBF5C2702AE
    */
   public List searchUser(String login, String name) throws SQLException;
}
