// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

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
import fr.umlv.desperados.account.UserManager;
import fr.umlv.desperados.account.UserNotFoundException;
import fr.umlv.desperados.struts.form.UserLogonForm;
import fr.umlv.desperados.util.Constants;

/** 
 * UserLogonAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:action path="/userLogon" name="userlogonForm" attribute="userLogonForm" input="/form/userLogon.jsp" validate="true"
 */
public class UserLogonAction extends Action {

	// ----------------------------------------------------- Instance Variables


	/**
	 * The <code>Log</code> instance for this application.
	 */
	private Log log =
		LogFactory.getLog("fr.umlv.desperados.struts");


	// --------------------------------------------------------- Public Methods

	/** 
	 * Method execute
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = form.validate(mapping, request);
		// validate the form
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("logon"));
		}

		UserLogonForm userLogonForm = (UserLogonForm) form;
		User user = null;

		UserManager manager = (UserManager)servlet.getServletContext().
			getAttribute(Constants.USER_DATABASE_KEY);

		if (manager == null) {
			errors.add("database",
			   new ActionError("error.database.missing"));
			log.warn("UserLogonAction: Database is missing");
		}
		else {
			try {
				user = manager.getUser(userLogonForm.getLogin());
				String password = userLogonForm.getPassword();
				if (!password.equals(user.getPassword())) {
					errors.add("password",
					   new ActionError("error.password.mismatch"));
				}
			} catch (UserNotFoundException e) {
				errors.add("database",
				   new ActionError("error.user.dontexist"));
			}
		}

/////////////////////
// COMMENTED FOR TEST
//		// Report any errors we have discovered back to the original form
//		if (!errors.isEmpty()) {
//			saveErrors(request, errors);
//			return (mapping.findForward("failure"));
//		}
		if(userLogonForm.getLogin().equals("ncuvelie")) {
			user = new User("ncuvelie");
			user.setName("CUVELIER");
			user.setFirstname("Nicolas");
			user.setEmail("ncuvelie@etudiant.univ-mlv.fr");
			user.setAdmin(true);
			user.setPassword("evvJRJ4J");
		} else {
			user = new User("niko");
			user.setName("CUVELIER");
			user.setFirstname("Nicolas");
			user.setEmail("ncuvelie@etudiant.univ-mlv.fr");
			user.setAdmin(false);
			user.setPassword("tototo");
		}
///////////////////

		// Save our logged-in user in the session
		HttpSession session = request.getSession();
		session.setAttribute(Constants.USER_KEY, user);
		if (log.isDebugEnabled()) {
			log.trace("UserLogonAction: User '" + user.getLogin() +
					  "' logged on in session " + session.getId());
		}

		// Remove the obsolete form bean
		if (mapping.getAttribute() != null) {
			if ("request".equals(mapping.getScope()))
				request.removeAttribute(mapping.getAttribute());
			else
				session.removeAttribute(mapping.getAttribute());
		}

		// Forward control to the specified success URI
		return (mapping.findForward("success"));
	}

}
