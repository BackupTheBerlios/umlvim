//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\UserAlreadyExistsException.java

package fr.umlv.desperados.account;


/**
 * Happens when a we add a User that already exists in the permanent storage.
 */
public class UserException extends Exception 
{
   
   /**
    * Constructs a new UserAlreadyExistsException with the specified detail message.
    * 
    * @param message the detail message.
    * @roseuid 3FEEF3F90173
    */
   public UserException(String message) 
   {
    super(message);
   }
}
