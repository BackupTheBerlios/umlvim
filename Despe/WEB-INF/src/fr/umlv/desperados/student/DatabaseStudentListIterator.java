//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\student\\DatabaseStudentListIterator.java

package fr.umlv.desperados.student;

import java.sql.ResultSet;
import java.util.ListIterator;


/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseStudentList.
 */
class DatabaseStudentListIterator implements ListIterator 
{
   
   /**
    * The ResultSet containing the Student list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing a Student list.
    * @roseuid 3FE188330307
    */
   DatabaseStudentListIterator(ResultSet rs) 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869BC020E
    */
   public void add(Object obj) 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869BC0223
    */
   public boolean hasNext() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869BC022D
    */
   public boolean hasPrevious() 
   {
    return true;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869BC0237
    */
   public Object next() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869BC0241
    */
   public int nextIndex() 
   {
    return 0;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869BC024B
    */
   public Object previous() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869BC0255
    */
   public int previousIndex() 
   {
    return 0;
   }
   
   /**
    * @roseuid 3FF869BC025F
    */
   public void remove() 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869BC0269
    */
   public void set(Object obj) 
   {
    
   }
}
/**
 * 
 * 
 *  
 * DatabaseStudentListIterator.next(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.set(Object){
 *     
 *    }
 *  
 *  
 * DatabaseStudentListIterator.hasNext(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.nextIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.previousIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.hasPrevious(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.previous(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentListIterator.remove(){
 *     
 *    }
 *  
 *  
 * DatabaseStudentListIterator.add(Object){
 *     
 *    }
 *  
 *  
 *  
 */
