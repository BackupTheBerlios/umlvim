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
import fr.umlv.desperados.account.UserUtilities;
import fr.umlv.desperados.mail.MailNotSentException;
import fr.umlv.desperados.mail.Mailer;
import fr.umlv.desperados.mail.Message;
import fr.umlv.desperados.mail.MessageFactory;
import fr.umlv.desperados.struts.form.UserForm;
import fr.umlv.desperados.struts.util.FormUtilities;
import fr.umlv.desperados.util.Constants;
import fr.umlv.desperados.util.ManagerException;

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

		ActionErrors errors = new ActionErrors();
		UserForm userForm = (UserForm) form;

		String action = userForm.getAction();
		if (log.isDebugEnabled()) {
			log.debug("SaveRegistrationAction:  Processing " + action + " action");
		}

		// Was this transaction cancelled?
		if (isCancelled(request)) {
			if (log.isTraceEnabled()) {
				log.trace(" Transaction '" + action +
						  "' was cancelled");
			}
			return (mapping.findForward("home"));
		}

		// Validate the transactional control token
		if (log.isTraceEnabled()) {
			log.trace(" Checking transactional control token");
		}
		if (!isTokenValid(request)) {
			errors.add(ActionErrors.GLOBAL_ERROR,
					   new ActionError("error.transaction.token"));
		}
		resetToken(request);

		// Report any errors we have discovered
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			saveToken(request);
			return (mapping.findForward("error"));
		}

		UserManager manager = (UserManager)servlet.getServletContext().
								getAttribute(Constants.USER_DATABASE_KEY);

		String err = null;
		try {
			if("delete".equals(action)) {
				doDeleteUser(manager, userForm);
			} else if("edit".equals(action)) {
				doEditUser(manager, userForm);
			} else {
				doCreateUser(manager, userForm);
			}
		} catch(UserAlreadyExistsException e) {
			err = "error.user.alreadyexist";
		} catch(UserNotFoundException e) {
			err = "error.user.dontexist";
		} catch(DeleteYourselfException e) {
			err = "error.admin.deleteyourself";
		} catch(LastAdminException e) {
			err = "error.admin.lastadmin";
		} catch(ManagerException e) {
			err = e.getMessage();
		} // TODO catcher l'exception MailNotSentException
		if(err != null) {
			errors.add(ActionErrors.GLOBAL_ERROR,
					   new ActionError(err));
		}

		// Remove the obsolete form bean
		if (mapping.getAttribute() != null) {
			if ("request".equals(mapping.getScope()))
				request.removeAttribute(mapping.getAttribute());
			else {
				HttpSession session = request.getSession();
				session.removeAttribute(mapping.getAttribute());
			}
		}

		// Report any errors we have discovered
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


	// --------------------------------------------------------- Private Methods


	private void doCreateUser(UserManager manager, UserForm form)
	throws UserAlreadyExistsException,
				ManagerException,
				MailNotSentException {

		User userToSave = new User();
		FormUtilities.userFormToUser(form, userToSave);

		// generate the login
		String login = UserUtilities.generateLogin(userToSave.getName(),
																					userToSave.getFirstname());
		int i = 1;
		while(manager.existUser(login)) {
			login = UserUtilities.generateLogin(userToSave.getName(),
																			userToSave.getFirstname(),
																			i);
			i++;
		}
		userToSave.setLogin(login);

		// generate randomly a new password
		userToSave.setPassword(UserUtilities.generatePassword());

		// add the User to the database
		manager.addUser(userToSave);

		mail(Message.CREATION_MESSAGE, userToSave);
	}

	private void doDeleteUser(UserManager manager, UserForm form)
		throws UserNotFoundException,
					ManagerException,
					MailNotSentException,
					DeleteYourselfException {

		String login = form.getLogin();
		if(loggedUser.getLogin().equals(login)) {
			throw new DeleteYourselfException();
		}
		User userDeleted = manager.removeUser(login);

		mail(Message.SUPPRESSION_MESSAGE, userDeleted);
	}

	private void doEditUser(UserManager manager, UserForm form)
		throws UserNotFoundException,
					ManagerException,
					MailNotSentException,
					LastAdminException {

		User userToSave = manager.getUser(form.getLogin());
		FormUtilities.userFormToUser(form, userToSave);

		// generate randomly a new password
		if(form.getGeneratePassword()) {
			userToSave.setPassword(UserUtilities.generatePassword());
		}

		if(userToSave.getLogin().equals(
					loggedUser.getLogin())) {
			throw new LastAdminException();
		}

		// update the User in the database
		manager.modifyUser(userToSave);

		mail(Message.MODIFICATION_MESSAGE, userToSave);
	}

	private void mail(String messageType, User user) throws MailNotSentException {
		MessageFactory factory = new MessageFactory();
		Mailer mailer = new Mailer();
		Message message = null;
		message = factory.createMessage(messageType, user);
		mailer.sendMail(user.getEmail(), message);
	}

	private class DeleteYourselfException extends Exception {}
	private class LastAdminException extends Exception {}
}