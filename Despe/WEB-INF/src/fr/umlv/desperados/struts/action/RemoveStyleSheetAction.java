/*
 * Créé le 16 janv. 2004
 *
 */
package fr.umlv.desperados.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.struts.form.SetStyleSheetForm;
import fr.umlv.desperados.stylesheet.StyleSheetManager;
import fr.umlv.desperados.util.Constants;

/**
 * @author ndedanil
 *
 */
public class RemoveStyleSheetAction extends AdminAction {

	public ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		SetStyleSheetForm styleSheetForm = (SetStyleSheetForm) form;
		ActionErrors errors = form.validate(mapping, request);

		StyleSheetManager manager =
			(StyleSheetManager) servlet.getServletContext().getAttribute(
				Constants.STYLESHEET_DATABASE_KEY);

		if (manager == null) {
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.missing"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("failure"));
		}

		String styleSheetId = styleSheetForm.getStyleSheetId();
		int docTypeId = styleSheetForm.getDocTypeId();

		manager.removeStyleSheet(styleSheetId);

		// Forward control to the specified success URI
		return (mapping.findForward("success"));
	}
}
