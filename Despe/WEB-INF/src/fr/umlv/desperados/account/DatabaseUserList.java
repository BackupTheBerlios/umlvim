//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\account\\DatabaseUserList.java

package fr.umlv.desperados.account;

import java.sql.ResultSet;
import java.util.AbstractList;


/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of User.
 */
final class DatabaseUserList extends AbstractList 
{
   
   /**
    * The ResultSet containing the User list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing a User list.
    * @roseuid 3FE5CEFC0223
    */
   DatabaseUserList(ResultSet rs) 
   {
    
   }
   
   /**
    * @param i
    * @return java.lang.Object
    * @roseuid 3FF869BA0143
    */
   public Object get(int i) 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869BA0157
    */
   public int size() 
   {
    return 0;
   }
}
/**
 * 
 * 
 *  
 * DatabaseUserList.get(int){
 *     return null;
 *    }
 *  
 *  
 * DatabaseUserList.size(){
 *     return 0;
 *    }
 *  
 *  
 *  
 */
