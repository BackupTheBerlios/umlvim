//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserListIterator.java

package fr.umlv.desperados.account;

import java.sql.ResultSet;
import java.util.ListIterator;


/**
 * Provides a implementation of java.util.ListIterator interface to iterate the 
 * elements contained by a DatabaseUserList.
 */
final class DatabaseUserListIterator implements ListIterator 
{
   
   /**
    * The ResultSet containing the User list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing a User list.
    * @roseuid 3FE2F884035B
    */
   DatabaseUserListIterator(ResultSet rs) 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869B80104
    */
   public void add(Object obj) 
   {
    
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869B80118
    */
   public boolean hasNext() 
   {
    return true;
   }
   
   /**
    * @return boolean
    * @roseuid 3FF869B80122
    */
   public boolean hasPrevious() 
   {
    return true;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869B8012C
    */
   public Object next() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869B80136
    */
   public int nextIndex() 
   {
    return 0;
   }
   
   /**
    * @return java.lang.Object
    * @roseuid 3FF869B80140
    */
   public Object previous() 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869B8014A
    */
   public int previousIndex() 
   {
    return 0;
   }
   
   /**
    * @roseuid 3FF869B80154
    */
   public void remove() 
   {
    
   }
   
   /**
    * @param obj
    * @roseuid 3FF869B8015E
    */
   public void set(Object obj) 
   {
    
   }
}
/**
 * 
 * 
 *  
 * DatabaseUserListIterator.next(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseUserListIterator.add(Object){
 *     
 *    }
 *  
 *  
 * DatabaseUserListIterator.set(Object){
 *     
 *    }
 *  
 *  
 * DatabaseUserListIterator.remove(){
 *     
 *    }
 *  
 *  
 * DatabaseUserListIterator.previous(){
 *     return null;
 *    }
 *  
 *  
 * DatabaseUserListIterator.nextIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseUserListIterator.hasPrevious(){
 *     return true;
 *    }
 *  
 *  
 * DatabaseUserListIterator.previousIndex(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseUserListIterator.hasNext(){
 *     return true;
 *    }
 *  
 *  
 *  
 */
