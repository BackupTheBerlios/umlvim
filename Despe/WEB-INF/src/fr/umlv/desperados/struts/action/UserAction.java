package fr.umlv.desperados.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.account.User;
import fr.umlv.desperados.util.Constants;

/**
 * Implementation of <strong>Action</strong> that processes a
 * user logoff.
 *
 * @author Craig R. McClanahan
 * @version $Revision: 1.1 $ $Date: 2004/02/07 16:57:47 $
 */

public abstract class UserAction extends Action {

	// ----------------------------------------------------- Instance Variables

	/**
	 * The <code>Log</code> instance for this application.
	 */
	protected Log log = LogFactory.getLog("fr.umlv.fdesperados.struts");

	protected User loggedUser = null;

	// --------------------------------------------------------- Public Methods

	/**
	 * Process the specified HTTP request, and create the corresponding HTTP
	 * response (or forward to another web component that will create it).
	 * Return an <code>ActionForward</code> instance describing where and how
	 * control should be forwarded, or <code>null</code> if the response has
	 * already been completed.
	 *
	 * @param mapping The ActionMapping used to select this instance
	 * @param actionForm The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 *
	 * @exception Exception if business logic throws an exception
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		// Extract attributes we will need
		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession();

		if (isUserLogged(session) == false) {
			if (log.isWarnEnabled()) {
				log.warn("UserAction: User is not logged on in session "
						+ session.getId());
			}
			errors.add(ActionErrors.GLOBAL_ERROR,
				new ActionError("error.mustbeloggedasuser"));
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}
		return doExecute(mapping, form, request, response);
	}

	protected final boolean isUserLogged(HttpSession session) {
		// Is there a currently logged on user as admin?
		loggedUser = (User) session.getAttribute(Constants.USER_KEY);
		return (loggedUser != null);
	}

	protected abstract ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
	throws Exception;
}