package fr.umlv.desperados.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
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
 * @version $Revision: 1.5 $ $Date: 2004/02/12 15:22:45 $
 */

public final class UserLogoffAction extends Action {

    // ----------------------------------------------------- Instance Variables

    /**
     * The <code>Log</code> instance for this application.
     */
    private Log log =
        LogFactory.getLog("fr.umlv.fdesperados.struts");


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
    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
	throws Exception {

	// Extract attributes we will need
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute(Constants.USER_KEY);

	// Process this user logoff
	if (user != null) {
		if (log.isDebugEnabled()) {
			log.debug("UserLogoffAction: User '" + user.getLogin() +
						"' logged off in session " + session.getId());
		}
	} else {
		if (log.isDebugEnabled()) {
			log.debug("UserLogoffAction: User logged off in session " +
						session.getId());
		}
	}
	session.removeAttribute(Constants.USER_KEY);
	session.invalidate();

	// Forward control to the specified success URI
	return (mapping.findForward("success"));
    }
}