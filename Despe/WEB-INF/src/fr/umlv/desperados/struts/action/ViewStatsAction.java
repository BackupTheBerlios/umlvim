/*
 * Created on 24 janv. 2004
 *
 */
package fr.umlv.desperados.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
// import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.planning.RdvManager;
import fr.umlv.desperados.struts.form.StatsForm;
import fr.umlv.desperados.util.Constants;

/**
 * @author Arnaud FRICOTTEAU
 *
 */
public class ViewStatsAction extends Action {
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
			throws Exception {

			StatsForm statsForm = (StatsForm) form;
			ActionErrors errors = form.validate(mapping, request);

			RdvManager manager =
				(RdvManager) servlet.getServletContext().getAttribute(
					Constants.RDV_DATABASE_KEY);

			if (manager == null) {
				errors.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("error.database.missing"));
			}

			if (!errors.isEmpty()) {
				saveErrors(request, errors);
				return (mapping.findForward("failure"));
			}
			
			String start = statsForm.getPeriodeDeb();
			String end = statsForm.getPeriodeFin();
			String diploma = statsForm.getDiplomaId();
			String result = manager.giveRdVNumber(start,end,diploma);
			
			request.setAttribute("result", result);
			request.setAttribute("start", start);
			request.setAttribute("end", end);
			request.setAttribute("diploma", diploma);

			return (mapping.findForward("success"));
		}
}
