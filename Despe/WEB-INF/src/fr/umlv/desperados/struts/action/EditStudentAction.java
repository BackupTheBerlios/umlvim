/*
 * Cr�� le 3 f�vr. 2004
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package fr.umlv.desperados.struts.action;

import java.text.DateFormat;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.struts.form.StudentForm;
import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.student.StudentManager;
import fr.umlv.desperados.util.Constants;

/**
 * @author gdupont
 *
 * Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
public class EditStudentAction extends UserAction {
	
	public ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new  ActionErrors();
		HttpSession session = request.getSession();

		 StudentForm studentForm = (StudentForm)form;
		 if(studentForm == null) {
				studentForm = new StudentForm();
		 }

		if ("request".equals(mapping.getScope()))
			request.setAttribute(mapping.getAttribute(), studentForm);
		else
			session.setAttribute(mapping.getAttribute(), studentForm);
	
		String action = request.getParameter("action");

		if(action.equals("delete")) {
			StudentManager manager = (StudentManager) servlet.getServletContext()
									.getAttribute(Constants.STUDENT_DATABASE_KEY);
			if(manager == null) {
				errors.add("database",
					new ActionError("error.database.missing"));
			} else {
				Student student = manager.getStudent(Integer.parseInt(studentForm.getId()));
				request.setAttribute("name", student.getPatronymicName());
				request.setAttribute("firstname", student.getFirstname1());

				DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
				String birthday = df.format(student.getBirthday());
				request.setAttribute("birthday",birthday);
			}
		}
		studentForm.setAction(action);
		return (mapping.findForward("success"));
	}
}