//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\stylesheet\\DatabaseStyleSheetList.java

package fr.umlv.desperados.stylesheet;

import java.sql.ResultSet;
import java.util.AbstractList;


/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of StyleSheet.
 */
final class DatabaseStyleSheetList extends AbstractList 
{
   
   /**
    * The ResultSet containing the StyleSheet list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing the StyleSheet list.
    * @roseuid 3FE73B460088
    */
   DatabaseStyleSheetList(ResultSet rs) 
   {
    
   }
   
   /**
    * @param i
    * @return java.lang.Object
    * @roseuid 3FF869D2006C
    */
   public Object get(int i) 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869D20080
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
 * DatabaseStyleSheetList.size(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseStyleSheetList.get(int){
 *     return null;
 *    }
 *  
 *  
 *  
 */
