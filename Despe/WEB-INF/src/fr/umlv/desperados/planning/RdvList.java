//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\RdvList.java

package fr.umlv.desperados.planning;

import java.util.HashMap;
import java.util.List;

import fr.umlv.desperados.util.XMLable;

/**
 * Wrapper for a list of lists of Rdv, that provides a XML transformation of the 
 * list.
 * "list of lists of Rdv" seems that this class maps a list of Rdv by a Date.
 * The typical use is the following : severals Rdv are taken in a day, and the 
 * RdvList 
 * object contains several day.
 * This implementation is usefull for separate the Rdv of each day while 
 * displaying or printing.
 */
public class RdvList implements XMLable 
{
   
   /**
    * The container mapping each list of Rdv by a day.
    */
   private HashMap map;
   
   /**
    * Constructor.
    * @roseuid 3FF2804C02A6
    */
   public RdvList() 
   {
    
   }
   
   /**
    * Adds a Rdv list corresponding to the given day.
    * 
    * @param day the day the list of Rdv corrsponds to.
    * @param list the list of Rdv to add.
    * @roseuid 3FF280DB02F2
    */
   public void addRdvList(java.util.Date day, List list) 
   {
    
   }
   
   /**
    * @return java.lang.String
    * @roseuid 3FF869CE0214
    */
   public String toXML() 
   {
    return null;
   }
}
