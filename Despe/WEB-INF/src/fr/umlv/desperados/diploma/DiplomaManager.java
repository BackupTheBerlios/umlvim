//Source file: C:\\Documents and Settings\\Arnaud FRICOTTEAU\\Mes documents\\fr\\umlv\\desperados\\diploma\\DiplomaManager.java

package fr.umlv.desperados.diploma;

import java.util.List;


/**
 * Class responsible of adding, removing, listing and getting Diploma in/from a 
 * permanent storage.
 */
public interface DiplomaManager 
{
   
   /**
	* Lists all the Diploma in the permanent storage.
	* 
	* @return a <code>List</code> containing all the User found in the permanent 
	* storage.
	* @roseuid 3FD59622030D
	*/
   public List listDiploma();
   
   /**
	* Gets a Diploma from the permanent storage.
	* 
	* @param diplomaId the identifiant of the Diploma to get.
	* @return the Diploma to get.
	* @roseuid 3FD5965E03C8
	*/
   public Diploma getDiploma(String diplomaId);
   
   /**
	* Adds a Diploma to the permanent storage.
	* 
	* @param diploma the diploma to add (id will be automatically generated).
	* 
	* @throws fr.umlv.desperados.diploma.DiplomaAlreadyExistsException
	* @roseuid 3FD59677005D
	*/
   public void addDiploma(Diploma diploma) throws DiplomaAlreadyExistsException;
   
   /**
	* Removes a Diploma from the permanent storage.
	* 
	* @param diplomaId the identifiant of the diploma to remove.
	* @roseuid 3FD5969201B5
	*/
   public void removeDiploma(String diplomaId);
}
