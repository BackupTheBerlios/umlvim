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
import fr.umlv.desperados.account.UserAlreadyExistsException;
import fr.umlv.desperados.account.UserManager;
import fr.umlv.desperados.account.UserNotFoundException;
import fr.umlv.desperados.struts.form.UserForm;
import fr.umlv.desperados.struts.util.FormUtilities;
import fr.umlv.desperados.util.Constants;

/** 
 * SaveUserAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:action path="/saveUser" name="userForm" attribute="userForm" input="/form/userDetails.jsp" validate="true"
 */
public class SaveUserAction extends AdminAction {

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

		UserForm userForm = (UserForm) form;
		HttpSession session = request.getSession();

		String action = userForm.getAction();
		if (action == null) {
			action = "create";
		}

		UserManager manager = (UserManager)servlet.getServletContext().
								getAttribute(Constants.USER_DATABASE_KEY);
		if (log.isDebugEnabled()) {
			log.debug("SaveRegistrationAction:  Processing " + action +
					  " action");
		}

		// Was this transaction cancelled?
		if (isCancelled(request)) {
			if (log.isTraceEnabled()) {
				log.trace(" Transaction '" + action +
						  "' was cancelled");
			}
			return (mapping.findForward("success"));
		}

		// Validate the transactional control token
		ActionErrors errors = new ActionErrors();
		if (log.isTraceEnabled()) {
			log.trace(" Checking transactional control token");
		}
		if (!isTokenValid(request)) {
			errors.add(ActionErrors.GLOBAL_ERROR,
					   new ActionError("error.transaction.token"));
		}
		resetToken(request);

		// Update the user's persistent profile information
		User userToSave = new User(userForm.getLogin());
		FormUtilities.userFormToUser(userForm, userToSave);

		String err = null;
		try {
			if("create".equals(action))
				manager.addUser(userToSave);
			else
				manager.modifyUser(userToSave);
		} catch(UserAlreadyExistsException e) {
				err = "error.user.alreadyexist";
		} catch(UserNotFoundException e) {
			err = "error.user.dontexist";
		}
		if(err != null) {
			errors.add("database",
					   new ActionError(err));
		}

		// Remove the obsolete form bean
		if (mapping.getAttribute() != null) {
			if ("request".equals(mapping.getScope()))
				request.removeAttribute(mapping.getAttribute());
			else
				session.removeAttribute(mapping.getAttribute());
		}

		// Report any errors we have discovered back to the original form
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			saveToken(request);
			return (mapping.findForward("error"));
		}

		// Forward control to the specified success URI
		if (log.isTraceEnabled()) {
			log.trace(" Forwarding to success page");
		}
		return (mapping.findForward("success"));
	}

}