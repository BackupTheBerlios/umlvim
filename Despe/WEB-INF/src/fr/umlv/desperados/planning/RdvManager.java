//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\RdvManager.java

package fr.umlv.desperados.planning;

import java.util.Date;
import java.util.List;


/**
 * Class responsible of adding, removing, listing and getting Rdv in/from a 
 * permanent storage.
 */
public interface RdvManager 
{
   
	/**
		* Used to configure a rdv period
		* 
		* @param rdv the Rdv to add.
		* @roseuid 3FBF56BA004D
		*/
	   public void confRdv(java.util.Date date,int nbRavMax,int nbEtuMax);
   
   /**
    * Adds a Rdv in the permanent storage.
    * 
    * @param rdv the Rdv to add.
    * @roseuid 3FBF56BA004D
    */
   public void addRdv(Rdv rdv);
   
   /**
    * Gets the days when Rdv can still be reserved (a day which is not full).
    * 
    * @param ravel whether the Student is a Ravel or not (<code>true</code> if 
    * searching a free day for Ravel Student, <code>false</code> otherwise).
    * @return the <code>List</code> of Date which are free.
    * @roseuid 3FBF57650241
    */
   public Date[] getFreeDays(boolean ravel);
   
   /**
    * Gets the hours when Rdv can still be reserved in the specified day.
    * 
    * @param ravel whether the Student is a Ravel or not (<code>true</code> if 
    * searching a free hours for Ravel Student, <code>false</code> otherwise).
    * @param day
    * @return the <code>List</code> of hours which are free (in the form of Date).
    * @roseuid 3FBF57A90241
    */
   public Date[] getFreeHours(java.util.Date day, boolean ravel);
   
   /**
    * Gets the Rdv of the given Student.
    * 
    * @param studentId the identifiant of the Student we want the Rdv.
    * @return the Rdv of the specified Student.
    * @roseuid 3FBF57EB0147
    */
   public Rdv getRdv(int studentId);
   
   /**
    * Checks if the given Date (day and hours) is free for a Rdv.
    * 
    * @param date the Date to checks.
    * @param ravel whether the Student is Ravel or not. (<code>true</code> if 
    * checking a date for Ravel Student, <code>false</code> otherwise).
    * @return <code>true</code> if the date is free, <code>false</code> otherwise.
    * @roseuid 3FBF56B702FD
    */
   public boolean isDateFree(java.util.Date date, boolean ravel);
   
   /**
    * Gets the list of Rdv for the given day.
    * 
    * @param day the day we want the Rdv list.
    * @return the List of Rdv for <code>day</code>.
    * @roseuid 3FD4A289009C
    */
   public List listRdv(java.util.Date day);
   
   /**
    * Removes the given Rdv from the planning.
    * 
    * @param rdv the Rdv to remove.
    * @roseuid 3FBF58180251
    */
   public void removeRdv(Rdv rdv);
}
