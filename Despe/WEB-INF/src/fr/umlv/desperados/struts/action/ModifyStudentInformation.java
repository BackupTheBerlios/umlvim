/*
 * Créé le 3 févr. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.umlv.desperados.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.student.StudentManager;
import fr.umlv.desperados.util.Constants;

/**
 * @author gdupont
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class ModifyStudentInformation extends Action {
	
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new  ActionErrors();
		String requete;
		Student student;
		StudentManager manager =
			(StudentManager) servlet.getServletContext().getAttribute(
				Constants.STUDENT_DATABASE_KEY);

		if (manager == null) {
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.missing"));
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		// Load student
		HttpSession session = request.getSession();
		student=(Student) session.getAttribute(Constants.STUDENT_KEY);

//TODO faire les requetes


//		List diplomaList = manager.listDiploma();
//		request.setAttribute("diplomaList", diplomaList);

//		List daysList = new ArrayList();
//		for(int i =1; i<=31; i++)
//			daysList.add((new Integer(i)).toString());
//		request.setAttribute("daysList", daysList);
		
//		List monthsList = new ArrayList();
//		for(int i =1; i<=12; i++)
//			monthsList.add((new Integer(i)).toString());
//		request.setAttribute("monthsList", monthsList);

		// Forward control to the specified success URI
		return (mapping.findForward("success"));
	}

}
