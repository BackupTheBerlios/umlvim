//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\student\\StudentManager.java

package fr.umlv.desperados.student;

import java.util.List;

/**
 * Class responsible of adding, removing, modifying, listing and getting Student 
 * in/from a permanent storage.
 */
public interface StudentManager {

	/**
	 * Adds a Student in the permanent storage.
	 * 
	 * @param student the Student to add.
	 * @throws fr.umlv.desperados.student.StudentAlreadyExistsException if the user 
	 * already exists in the permanent storage.
	 * @roseuid 3FBF5F9A02AE
	 */
	public void addStudent(Student student)
		throws StudentAlreadyExistsException,StudentBirthdayException;

	/**
	 * Checks if a Student exists in the permanent storage.
	 * 
	 * @param name the name of the Student to check.
	 * @param firstname the firstname of the Student to check.
	 * @param birthday the birthday of the Student to check.
	 * @return <code>null</code> if the Student does not exist in the permanent 
	 * storage, the Student id otherwise.
	 * @roseuid 3FC3693303B9
	 */
	public int existStudent(
		String name,
		String firstname,
		java.util.Date birthday)  throws StudentBirthdayException;

	/**
	 * Gets a Student from the permanent storage.
	 * 
	 * @param studentId the identifiant of the Student in the permanent storage.
	 * @return the user found, or <code>null</code> if the user is not found in the 
	 * permanent storage.
	 * @roseuid 3FBF5EA000BA
	 */
	public Student getStudent(int studentId) throws StudentNotFoundException;

	/**
	 * Modifies a Student in the permanent storage.
	 * 
	 * @param student the User to modify.
	 * @throws fr.umlv.desperados.student.StudentNotFoundException if the user does 
	 * not exists in the permanent storage.
	 * @roseuid 3FBF5E1B0389
	 */
	public void modifyStudent(Student student) throws StudentNotFoundException,StudentBirthdayException;

	/**
	 * Removes a Student from the permanent storage.
	 * 
	 * @param studentId the identifiant of the Student to remove from the permanent 
	 * storage.
	 * @return fr.umlv.desperados.student.Student
	 * @throws fr.umlv.desperados.student.StudentNotFoundException if the user does 
	 * not exists in the permanent storage.
	 * @roseuid 3FBF60780389
	 */
	public Student removeStudent(int studentId)
		throws StudentNotFoundException;

	/**
	 * Searches a Student in the permanent storage, according to 4 criteria : the 
	 * student's INE, his name, his firstname and/or the diploma he is registered in.
	 * 
	 * @param INE the INE of the User to search.
	 * @param name the name of the User to search.
	 * @param firstname the firstname of the User to search.
	 * @param diplomaId the diploma id of the User to search.
	 * @return a List containing the User found. If no student is found, an empty list 
	 * is returned.
	 * @roseuid 3FBF5D4F01F3
	 */
	public List searchStudent(
		String INE,
		String name,
		String firstname,
		int diplomaId);
}
