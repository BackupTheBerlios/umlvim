//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\student\\DatabaseStudentManager.java

package fr.umlv.desperados.student;

import java.util.List;

import fr.umlv.desperados.database.DatabaseRequestor;
import fr.umlv.desperados.util.Cache;

/**
 * Provides an implementation of the StudentManager interface, using an relational 
 * database.
 * It contains a cache system, which prevents to instanciate Student several times.
 * A unique instance of this manager is created ("singleton" design pattern) for a 
 * given DatabaseRequestor.
 */
public class DatabaseStudentManager implements StudentManager 
{
   
   /**
    * The unique instance of the DatabaseUserManager.
    */
   private static DatabaseStudentManager theInstance = null;
   
   /**
    * The DatabaseRequestor of this manager.
    */
   private DatabaseRequestor requestor;
   
   /**
    * The Cache of this manager.
    */
   private Cache cache;
   
   /**
    * Private default constructor.
    * 
    * @param requestor the DatabaseRequestor of this manager.
    * @roseuid 3FE3136B035E
    */
   private DatabaseStudentManager(DatabaseRequestor requestor) 
   {
    
   }
   
   /**
    * Instance getter.
    * 
    * @param requestor the DatabaseRequestor for this manager.
    * @return the unique instance of DatabaseStudentManager.
    * @roseuid 3FF851EE0284
    */
   public DatabaseStudentManager getInstance(DatabaseRequestor requestor) 
   {if (theInstance == null)
	theInstance = new DatabaseStudentManager(requestor);
return theInstance;    
   }
   
   /**
    * @param student
    * @throws fr.umlv.desperados.student.StudentAlreadyExistsException
    * @roseuid 3FF869BD015C
    */
   public void addStudent(Student student) throws StudentAlreadyExistsException 
   {
    
   }
   
   /**
    * @param name
    * @param firstname
    * @param birthday
    * @return java.lang.String
    * @roseuid 3FF869BD0170
    */
   public String existStudent(String name, String firstname, java.util.Date birthday) 
   {
    return null;
   }
   
   /**
    * @param studentId
    * @return fr.umlv.desperados.student.Student
    * @roseuid 3FF869BD01AC
    */
   public Student getStudent(int studentId) 
   {
    return null;
   }
   
   /**
    * @param student
    * @throws fr.umlv.desperados.student.StudentNotFoundException
    * @roseuid 3FF869BD01CA
    */
   public void modifyStudent(Student student) throws StudentNotFoundException 
   {
    
   }
   
   /**
    * @param studentId
    * @return fr.umlv.desperados.student.Student
    * @throws fr.umlv.desperados.student.StudentNotFoundException
    * @roseuid 3FF869BD01F2
    */
   public Student removeStudent(String studentId) throws StudentNotFoundException 
   {
    return null;
   }
   
   /**
    * @param INE
    * @param name
    * @param firstname
    * @param diplomaId
    * @return java.util.List
    * @roseuid 3FF869BD0210
    */
   public List searchStudent(String INE, String name, String firstname, int diplomaId) 
   {
    return null;
   }
   
   /**
    * Sets the size of the cache of this manager.
    * 
    * @param size the new size of the cache.
    * @roseuid 3FF9BE4C01C4
    */
   public void setCacheSize(int size) 
   {
    
   }
}
/**
 * 
 *  
 * DatabaseStudentManager.addStudent(Student){
 *     
 *    }
 *  
 *  
 * DatabaseStudentManager.existStudent(String,String,java.util.Date){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentManager.getStudent(int){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentManager.searchStudent(String,String,String,int){
 *     return null;
 *    }
 *  
 *  
 * DatabaseStudentManager.modifyStudent(Student){
 *     
 *    }
 *  
 *  
 * DatabaseStudentManager.removeStudent(String){
 *     return null;
 *    }
 *  
 *  
 */
