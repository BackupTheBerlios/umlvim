/*
 * Créé le 16 janv. 2004
 *
 */
package fr.umlv.desperados.struts.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.stylesheet.StyleSheetManager;
import fr.umlv.desperados.util.Constants;

/**
 * @author ndedanil
 *
 */
public class ListStyleSheetAction extends AdminAction {

	public ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new  ActionErrors();

		StyleSheetManager manager =
			(StyleSheetManager) servlet.getServletContext().getAttribute(
				Constants.STYLESHEET_DATABASE_KEY);

		if (manager == null) {
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.missing"));
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		List styleSheetList = manager.listStyleSheet();
		request.setAttribute("styleSheetList", styleSheetList);

		Map docMap = manager.listDocType();
		request.setAttribute("docMap", docMap);

		// Forward control to the specified success URI
		return (mapping.findForward("success"));
	}
}