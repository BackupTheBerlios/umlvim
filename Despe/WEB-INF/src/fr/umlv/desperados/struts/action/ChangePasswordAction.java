package fr.umlv.desperados.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.account.UserManager;
import fr.umlv.desperados.account.UserNotFoundException;
import fr.umlv.desperados.account.UserUtilities;
import fr.umlv.desperados.mail.MailNotSentException;
import fr.umlv.desperados.mail.Mailer;
import fr.umlv.desperados.mail.Message;
import fr.umlv.desperados.mail.MessageFactory;
import fr.umlv.desperados.util.Constants;
import fr.umlv.desperados.util.ManagerException;

public class ChangePasswordAction extends UserAction {

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

		if(isCancelled(request)) {
			return (mapping.findForward("cancelled"));
		}

		ActionErrors errors = new ActionErrors();

		UserManager manager = (UserManager)servlet.getServletContext().
								getAttribute(Constants.USER_DATABASE_KEY);
		if(manager == null) {
			errors.add(ActionErrors.GLOBAL_ERROR,
					   new ActionError("error.database.missing"));
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		// save the old password (in case of failure while sending mail)
		String oldPassword = loggedUser.getPassword(); 

		// generate randomly a new password in plain text and its corresponding crypted password
		String plainTextPassword = UserUtilities.generatePassword();
		String cryptedPassword = UserUtilities.cryptPassword(plainTextPassword);

		loggedUser.setPassword(cryptedPassword);

		String err = null;
		try {
			// update the User in the database
			manager.modifyUser(loggedUser);

			// Set the password in plain text, to create Message
			loggedUser.setPassword(plainTextPassword);
			// Create the message to send by mail to the User
			MessageFactory factory = new MessageFactory();
			Message message = factory.createMessage(Message.MODIFICATION_MESSAGE, loggedUser);
			// send the message to the user
			Mailer mailer = new Mailer();
			mailer.sendMail(loggedUser.getEmail(), message);
			// set the crypted password again
			loggedUser.setPassword(cryptedPassword);
		} catch(UserNotFoundException e) {
			err = "error.user.dontexist";
		} catch(ManagerException e) {
			err = e.getMessage();
		} catch(MailNotSentException e) {
			err = "error.mail.notSent";
		}
		if(err != null) {
			loggedUser.setPassword(oldPassword);
			errors.add(ActionErrors.GLOBAL_ERROR,
					   new ActionError(err));
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		// Forward control to the specified success URI
		if (log.isTraceEnabled()) {
			log.trace(" Forwarding to success page");
		}
		return (mapping.findForward("success"));
	}
}