package fr.umlv.desperados.struts.action;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.struts.form.StudentForm;
import fr.umlv.desperados.student.DatabaseStudentManager;
import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.student.StudentAlreadyExistsException;
import fr.umlv.desperados.student.StudentBirthdayException;
import fr.umlv.desperados.util.Constants;

/**
 * @author npetitde

 */
public class SaveStudentAction extends UserAction {

	/** 
	 * Method execute
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		ServletContext context = servlet.getServletContext();

		DatabaseStudentManager databaseStudentManager =
			(DatabaseStudentManager) context.getAttribute(
				Constants.STUDENT_DATABASE_KEY);

		if (databaseStudentManager == null) {
			errors.add("database", new ActionError("error.database.missing"));
			//				log.warn("FormStudentAction: Database is missing");
		}
		StudentForm studentForm = (StudentForm) form;
		String action = studentForm.getAction();

		if ("create".equals(action)) {
			String patronymicName = studentForm.getPatronymicName();
			String firstname1 = studentForm.getFirstname1();
			String birthday = studentForm.getBirthday();
			DateFormat dateFormat =
				DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);

			Date dateBirthday = null;
			try {
				dateBirthday = dateFormat.parse(birthday);

				Student student = new Student();
				student.setPatronymicName(patronymicName);
				student.setFirstname1(firstname1);
				student.setBirthday(dateBirthday);

				studentForm.setAction(action);
				databaseStudentManager.addStudent(student);

			} catch (StudentBirthdayException e2) {
				errors.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("error.student.badBirthday"));

			} catch (StudentAlreadyExistsException e1) {
				errors.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("error.student.alreadyexist"));

			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if ("delete".equals(action)) {
			databaseStudentManager.removeStudent(Integer.parseInt(studentForm.getId()));
		}
			return (mapping.findForward("success"));
		}

	}
