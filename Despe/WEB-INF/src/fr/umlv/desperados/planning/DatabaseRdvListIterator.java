//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\planning\\DatabaseRdvListIterator.java

package fr.umlv.desperados.planning;

import java.sql.ResultSet;
import java.util.ListIterator;


/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseRdvList.
 */
final class DatabaseRdvListIterator implements ListIterator 
{
   
   /**
    * The ResultSet containing the Rdv list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing a Rdv list.
    * @roseuid 3FE5EA7D026D
    */
   DatabaseRdvListIterator(ResultSet rs) 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869CC02EE
    */
   public void add(Object obj) 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869CC0302
    */
   public boolean hasNext() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869CC0303
    */
   public boolean hasPrevious() 
   {
    return true;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869CC030C
    */
   public Object next() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869CC0316
    */
   public int nextIndex() 
   {
    return 0;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869CC0320
    */
   public Object previous() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869CC032A
    */
   public int previousIndex() 
   {
    return 0;
   }
   
   /**
    * @roseuid 3FF869CC0334
    */
   public void remove() 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869CC033E
    */
   public void set(Object obj) 
   {
    
   }
}
/**
 * 
 * 
 *  
 * DatabaseRdvListIterator.next(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseRdvListIterator.add(Object){
 *     
 *    }
 *  
 *  
 * DatabaseRdvListIterator.hasPrevious(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseRdvListIterator.set(Object){
 *     
 *    }
 *  
 *  
 * DatabaseRdvListIterator.remove(){
 *     
 *    }
 *  
 *  
 * DatabaseRdvListIterator.previousIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseRdvListIterator.nextIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseRdvListIterator.hasNext(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseRdvListIterator.previous(){
 *     return null;
 *    }
 *  
 *  
 *  
 */
