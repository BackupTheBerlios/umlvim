/*
 * Created on 24 janv. 2004
 *
 */
package fr.umlv.desperados.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
// import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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

			ActionErrors errors = new  ActionErrors();

			return (mapping.findForward("success"));
		}
}
