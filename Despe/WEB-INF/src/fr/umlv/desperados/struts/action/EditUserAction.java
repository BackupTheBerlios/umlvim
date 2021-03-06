// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.account.User;
import fr.umlv.desperados.account.UserManager;
import fr.umlv.desperados.account.UserNotFoundException;
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
public class EditUserAction extends AdminAction {

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
	public ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action == null)
			action = "create";

		if (log.isDebugEnabled()) {
			log.debug("EditRegistrationAction:  Processing " + action +
						" action");
		}

		// Save the user form into the context
		UserForm userForm = (UserForm)form;
		if(userForm == null) {
			userForm = new UserForm();
		}
		if ("request".equals(mapping.getScope()))
			request.setAttribute(mapping.getAttribute(), userForm);
		else
			session.setAttribute(mapping.getAttribute(), userForm);


		// get the userToEdit to fill the form (unless action is 'creation')
		if (!"create".equals(action)) {
			User userToEdit = null;
			UserManager manager = (UserManager) servlet.getServletContext()
										.getAttribute(Constants.USER_DATABASE_KEY);
			if(manager == null) {
				errors.add("database",
							new ActionError("error.database.missing"));
			} else {
				String login = (String)request.getParameter("login");
				try {
					userToEdit = manager.getUser(login);
				} catch(UserNotFoundException e) {
					errors.add("database",
							   new ActionError("error.user.dontexist"));
				}
			}
			if (userToEdit != null) {
				if (log.isTraceEnabled()) {
					log.trace(" Populating form from " + userToEdit);
				}
				FormUtilities.UserToUserForm(userToEdit, userForm);
				userForm.setGeneratePassword(false);
			}
		}
		userForm.setAction(action);

		if(!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

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