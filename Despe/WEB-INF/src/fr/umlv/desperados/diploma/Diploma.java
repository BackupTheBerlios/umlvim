//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\diploma\\Diploma.java

package fr.umlv.desperados.diploma;


/**
 * Represents a diploma in the application.
 */
public class Diploma 
{
   
   /**
	* The identifiant of the Diploma (primary key in the permanent storage).
	*/
   private String id;
   
   /**
	* The name of the Diploma.
	*/
   private String name;
   
   /**
	* The cycle of the Diploma.
	*/
   private String cycle;
   
   /**
	* Constructor.
	* 
	* @param name the name of the Diploma.
	* @param cycle the cycle of the Diploma.
	* @roseuid 3FE5C8720121
	*/
   public Diploma(String name, String cycle) 
   {
   	id = "0"; // set by the database
	this.name = name;
	this.cycle = cycle;
   }
   
   /**
	* Returns the identifiant of the Diploma.
	* 
	* @return the id of the Diploma.
	* @roseuid 3FE5C85201DA
	*/
   public String getId() 
   {
	return id;
   }
   
   /**
	* Returns the name of the Diploma.
	* 
	* @return the name of the Diploma.
	* @roseuid 3FE5C85C0007
	*/
   public String getName() 
   {
	return name;
   }
   
   /**
	* Returns the cycle of the Diploma.
	* 
	* @return int
	* @roseuid 400958D8007D
	*/
   public String getCycle() 
	{
	 return cycle;
	}
   
   /**
	* Sets the id of the Diploma.
	* 
	* @param id the identifiant of the Diploma.
	* @roseuid 3FF6F5130395
	*/
   void setId(String id) 
   {
	this.id = id;
   }
}
