/*
 * Créé le 3 févr. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.umlv.desperados.struts.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.student.DatabaseInformationListManager;
import fr.umlv.desperados.util.Constants;

/**
 * @author gdupont
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class EditStudentFileAction extends StudentAction {
	
	public ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new  ActionErrors();

		// Load student
		HttpSession session = request.getSession();

		DatabaseInformationListManager manager =
			(DatabaseInformationListManager) servlet.getServletContext().getAttribute(
				Constants.INFORMATION_DATABASE_KEY);
		if (manager == null) {
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.missing"));
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		String page = request.getParameter("page");
		if(page == null) {
			//TODO mettre 1 au lieu de 3
			page = "1";
		} 
		if ("1".equals(page)) {
		}
		if ("3".equals(page)) {
			Set list=manager.list(DatabaseInformationListManager .SOCIAL_SECURITY_AFF);
			request.setAttribute( "socialSecurityAffList",list);
		}

		System.out.println("*****\nEditStudentAction: forwarding to "+page+"\n*****");
		return (mapping.findForward(page));
	}
}