//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\diploma\\DatabaseDiplomaList.java

package fr.umlv.desperados.diploma;

import java.sql.ResultSet;
import java.util.AbstractList;


/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of Diploma.
 */
class DatabaseDiplomaList extends AbstractList 
{
   
   /**
    * The ResultSet containing the Diploma list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing the Diploma list.
    * @roseuid 3FE5CF43012B
    */
   DatabaseDiplomaList(ResultSet rs) 
   {
    
   }
   
   /**
    * @param i
    * @return java.lang.Object
    * @roseuid 3FF869CF02AC
    */
   public Object get(int i) 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869CF02C0
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
 * DatabaseDiplomaList.get(int){
 *     return null;
 *    }
 *  
 *  
 * DatabaseDiplomaList.size(){
 *     return 0;
 *    }
 *  
 *  
 *  
 */
