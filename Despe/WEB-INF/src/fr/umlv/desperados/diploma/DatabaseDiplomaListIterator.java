//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\diploma\\DatabaseDiplomaListIterator.java

package fr.umlv.desperados.diploma;

import java.sql.ResultSet;
import java.util.ListIterator;


/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseDiplomaList.
 */
final class DatabaseDiplomaListIterator implements ListIterator 
{
   
   /**
    * The ResultSet containing the Diploma list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing the Diploma list.
    * @roseuid 3FE5CFBE0091
    */
   DatabaseDiplomaListIterator(ResultSet rs) 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869D00195
    */
   public void add(Object obj) 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869D001A9
    */
   public boolean hasNext() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869D001B3
    */
   public boolean hasPrevious() 
   {
    return true;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869D001B4
    */
   public Object next() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869D001BD
    */
   public int nextIndex() 
   {
    return 0;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869D001C7
    */
   public Object previous() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869D001DB
    */
   public int previousIndex() 
   {
    return 0;
   }
   
   /**
    * @roseuid 3FF869D001E5
    */
   public void remove() 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869D001EF
    */
   public void set(Object obj) 
   {
    
   }
}
/**
 * 
 * 
 *  
 * DatabaseDiplomaListIterator.nextIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseDiplomaListIterator.hasNext(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseDiplomaListIterator.remove(){
 *     
 *    }
 *  
 *  
 * DatabaseDiplomaListIterator.previousIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseDiplomaListIterator.add(Object){
 *     
 *    }
 *  
 *  
 * DatabaseDiplomaListIterator.hasPrevious(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseDiplomaListIterator.set(Object){
 *     
 *    }
 *  
 *  
 * DatabaseDiplomaListIterator.previous(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseDiplomaListIterator.next(){
 *     return null;
 *    }
 *  
 *  
 *  
 */
