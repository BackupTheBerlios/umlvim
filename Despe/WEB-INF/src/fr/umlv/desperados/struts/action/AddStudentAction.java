// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Aucun fichier ou répertoire de ce type))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.struts.form.AddStudentForm;
import fr.umlv.desperados.student.DatabaseStudentManager;
import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.student.StudentAlreadyExistsException;
import fr.umlv.desperados.student.StudentBirthdayException;
import fr.umlv.desperados.util.Constants;

/** 
 * AddStudentAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-29-2004
 * 
 * XDoclet definition:
 * @struts:action
 */
public class AddStudentAction extends Action {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	
	private Log log =
			LogFactory.getLog("fr.umlv.desperados.struts");
			
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		 {
			
			String target="success";
			ActionErrors errors = form.validate(mapping, request);
			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				return (mapping.findForward("addstudent"));
			}

			
			AddStudentForm addStudentForm = (AddStudentForm) form;
			
			String patronymicName = addStudentForm.getPatronymicName();
			String firstname1= addStudentForm.getFirstname1();
			String birthday = addStudentForm.getBirthday();


			ServletContext context = servlet.getServletContext();
			
			DatabaseStudentManager databaseStudentManager =
				(DatabaseStudentManager) context.getAttribute(
					Constants.STUDENT_DATABASE_KEY);
			
			if (databaseStudentManager == null) {
						errors.add("database",
						   new ActionError("error.database.missing"));
						log.warn("AddStudentAction: Database is missing");
					}
			
		

			DateFormat dateFormat =
			DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);

			Date dateBirthday = null;
			try {
				dateBirthday = dateFormat.parse(birthday);
	
					
			Student student =new Student();
			student.setPatronymicName(patronymicName);
			student.setFirstname1(firstname1);
			student.setBirthday(dateBirthday);
			
	
		
				databaseStudentManager.addStudent(student);
				
				} catch (StudentBirthdayException e2) {
				errors.add(ActionErrors.GLOBAL_ERROR,
											   new ActionError("error.student.badBirthday"));
			
			} catch (StudentAlreadyExistsException e1) {
				errors.add(ActionErrors.GLOBAL_ERROR,
				   new ActionError("error.student.alreadyexist"));
		
			 } catch (ParseException e) {
				 target="error";
				 e.printStackTrace();
			 }
			 
			if (!errors.isEmpty()) {
						saveErrors(request, errors);
						return (mapping.findForward("error"));
					}

	
			return mapping.findForward(target);
	}

}
