//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\student\\DatabaseStudentList.java

package fr.umlv.desperados.student;

import java.sql.ResultSet;
import java.util.AbstractList;


/**
 * Provides a concrete implementation of java.util.List interface that contains a 
 * list of Student.
 */
class DatabaseStudentList extends AbstractList 
{
   
   /**
    * The ResultSet containing the Student list.
    */
   private ResultSet rs;
   
   /**
    * Constructor.
    * 
    * @param rs the ResultSet containing a Student list.
    * @roseuid 3FE186B80276
    */
   DatabaseStudentList(ResultSet rs) 
   {
    
   }
   
   /**
    * @param i
    * @return java.lang.Object
    * @roseuid 3FF869BC00B0
    */
   public Object get(int i) 
   {
    return null;
   }
   
   /**
    * @return int
    * @roseuid 3FF869BC00C4
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
 * DatabaseStudentList.size(){
 *     return 0;
 *    }
 *  
 *  
 * DatabaseStudentList.get(int){
 *     return null;
 *    }
 *  
 *  
 *  
 */
