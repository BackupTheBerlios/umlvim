/*
 * Créé le 23 janv. 2004
 *
 */
package fr.umlv.desperados.struts.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.diploma.DiplomaManager;
import fr.umlv.desperados.util.Constants;

/**
 * @author africott
 *
 */
public class ListDiplomaAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new  ActionErrors();

		DiplomaManager manager =
			(DiplomaManager) servlet.getServletContext().getAttribute(
				Constants.DIPLOMA_DATABASE_KEY);

		if (manager == null) {
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.missing"));
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		List diplomaList = manager.listDiploma();
		request.setAttribute("diplomaList", diplomaList);

		List daysList = new ArrayList();
		for(int i =1; i<=31; i++)
			daysList.add((new Integer(i)).toString());
		request.setAttribute("daysList", daysList);
		
		List monthsList = new ArrayList();
		for(int i =1; i<=12; i++)
			monthsList.add((new Integer(i)).toString());
		request.setAttribute("monthsList", monthsList);

		// Forward control to the specified success URI
		return (mapping.findForward("success"));
	}
}