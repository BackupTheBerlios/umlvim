//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\student\\StudentAlreadyExistsException.java

package fr.umlv.desperados.student;


/**
 * Happens when a we add a Student that already exists in the permanent storage.
 */
public class StudentAlreadyExistsException extends Exception 
{
   
   /**
    * Constructs a new StudentAlreadyExistsException with the specified detail 
    * message.
    * 
    * @param message the detail message.
    * @roseuid 3FE18F3D0222
    */
   public StudentAlreadyExistsException(String message) 
   {
    super(message);
   }
}
