/*
 * Créé le 3 févr. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
package fr.umlv.desperados.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.diploma.DiplomaManager;
import fr.umlv.desperados.util.Constants;

/**
 * @author npetitde
 *
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
 */
public class SearchStudentDiplomaAction extends AdminAction {
	
	public ActionForward doExecute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {
				
	DiplomaManager manager =
		(DiplomaManager) servlet.getServletContext().getAttribute(
			Constants.DIPLOMA_DATABASE_KEY);

ActionErrors errors = new ActionErrors();
	if (manager == null) {
		errors.add(
			ActionErrors.GLOBAL_ERROR,
			new ActionError("error.database.missing"));
		saveErrors(request, errors);
		return (mapping.findForward("error"));
	}

	List diplomaList = manager.listDiploma();
	request.setAttribute("diplomaList", diplomaList);
	
	return (mapping.findForward("success"));
			
			}
			
			
}
