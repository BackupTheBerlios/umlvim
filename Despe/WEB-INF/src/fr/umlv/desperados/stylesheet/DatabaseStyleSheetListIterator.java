//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\stylesheet\\DatabaseStyleSheetListIterator.java

package fr.umlv.desperados.stylesheet;

import java.sql.ResultSet;
import java.util.ListIterator;


/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseStyleSheetList.
 */
final class DatabaseStyleSheetListIterator implements ListIterator 
{
   
   /**
    * The ResultSet containing the StyleSheet list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing the StyleSheet list.
    * @roseuid 3FE73B85027E
    */
   DatabaseStyleSheetListIterator(ResultSet rs) 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869D201D4
    */
   public void add(Object obj) 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869D201E8
    */
   public boolean hasNext() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869D201F2
    */
   public boolean hasPrevious() 
   {
    return true;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869D201FC
    */
   public Object next() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869D20206
    */
   public int nextIndex() 
   {
    return 0;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869D20210
    */
   public Object previous() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869D2021A
    */
   public int previousIndex() 
   {
    return 0;
   }
   
   /**
    * @roseuid 3FF869D20224
    */
   public void remove() 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869D2022E
    */
   public void set(Object obj) 
   {
    
   }
}
/**
 * 
 * 
 *  
 * DatabaseStyleSheetListIterator.hasNext(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseStyleSheetListIterator.next(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStyleSheetListIterator.add(Object){
 *     
 *    }
 *  
 *  
 * DatabaseStyleSheetListIterator.previous(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStyleSheetListIterator.set(Object){
 *     
 *    }
 *  
 *  
 * DatabaseStyleSheetListIterator.remove(){
 *     
 *    }
 *  
 *  
 * DatabaseStyleSheetListIterator.nextIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseStyleSheetListIterator.hasPrevious(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseStyleSheetListIterator.previousIndex(){
 *     return 0;
 *    }
 *  
 *  
 *  
 */
