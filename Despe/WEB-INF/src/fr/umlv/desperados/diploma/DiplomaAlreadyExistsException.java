//Source file: C:\\Documents and Settings\\Arnaud FRICOTTEAU\\Mes documents\\fr\\umlv\\desperados\\diploma\\DiplomaAlreadyExistsException.java

package fr.umlv.desperados.diploma;


/**
 * Happens when a we add a Diploma that already exists in the permanent storage.
 */
public final class DiplomaAlreadyExistsException extends Exception 
{
   
   /**
	* Constructs a new DiplomaAlreadyExistsException with the specified detail 
	* message.
	* 
	* @param message
	* @roseuid 400C27550177
	*/
   public DiplomaAlreadyExistsException(String message) 
   {
	super(message);
   }
}
