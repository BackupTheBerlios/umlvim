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
import fr.umlv.desperados.struts.form.UserForm;
import fr.umlv.desperados.struts.util.FormUtilities;
import fr.umlv.desperados.util.Constants;

/** 
 * EditUserAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:action path="/editUser" name="userForm" attribute="userForm" input="/form/userDetails.jsp" validate="true"
 */
public class EditUserAction extends Action {

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

		ActionErrors errors = new ActionErrors();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		// Is there a currently logged on user?
		User user = (User) session.getAttribute(Constants.USER_KEY);
		if (user == null || !user.getAdmin()) {
			
			if (log.isWarnEnabled()) {
				log.warn(" User is not logged on as admin in session "
							+ session.getId());
				errors.add(ActionErrors.GLOBAL_ERROR,
							new ActionError("error.mustbeloggedasadmin"));
				saveErrors(request, errors);
			}
			return (mapping.findForward("error"));
		}

		if (action == null)
			action = "create";

		if (log.isDebugEnabled()) {
			log.debug("EditRegistrationAction:  Processing " + action +
						" action");
		}

		// Is there a currently logged on user?
		User userToEdit = null;
		if (!"create".equals(action)) {
			UserManager manager = (UserManager) servlet.getServletContext()
										.getAttribute(Constants.USER_DATABASE_KEY);
			String login = (String)request.getParameter("login");
			System.out.println("**LOGIN="+login+"**");
			userToEdit = manager.getUser(login);
		}

		// Populate the user registration form
		if (form == null) {
			if (log.isTraceEnabled()) {
				log.trace(" Creating new RegistrationForm bean under key "
						  + mapping.getAttribute());
			}
			form = new UserForm();
			if ("request".equals(mapping.getScope()))
				request.setAttribute(mapping.getAttribute(), form);
			else
				session.setAttribute(mapping.getAttribute(), form);
		}
		UserForm userForm = (UserForm) form;
		if (userToEdit != null) {
			if (log.isTraceEnabled()) {
				log.trace(" Populating form from " + userToEdit);
			}
			FormUtilities.UserToUserForm(userToEdit, userForm);
			userForm.setGeneratePassword(false);
		}
		userForm.setAction(action);

		// Set a transactional control token to prevent double posting
		if (log.isTraceEnabled()) {
			log.trace(" Setting transactional control token");
		}
		saveToken(request);

		// Forward control to the edit user registration page
		if (log.isTraceEnabled()) {
			log.trace(" Forwarding to 'success' page");
		}
		return (mapping.findForward("success"));

	}

}