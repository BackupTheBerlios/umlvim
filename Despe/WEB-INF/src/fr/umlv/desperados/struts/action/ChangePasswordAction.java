// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

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
import fr.umlv.desperados.mail.Mailer;
import fr.umlv.desperados.mail.Message;
import fr.umlv.desperados.mail.MessageFactory;
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

		ActionErrors errors = new ActionErrors();

		// save the old password (in case of failure while sending mail)
		String oldPassword = loggedUser.getPassword(); 

		// generate randomly a new password
		loggedUser.setPassword(UserUtilities.generatePassword());

		UserManager manager = (UserManager)servlet.getServletContext().
								getAttribute(Constants.USER_DATABASE_KEY);
		if(manager == null) {
			errors.add(ActionErrors.GLOBAL_ERROR,
					   new ActionError("error.database.missing"));
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		String err = null;
		try {
			// update the User in the database
			manager.modifyUser(loggedUser);

			// send mail to the user
			MessageFactory factory = new MessageFactory();
			Mailer mailer = new Mailer();
			Message message = factory.createMessage(Message.MODIFICATION_MESSAGE, loggedUser);
			mailer.sendMail(loggedUser.getEmail(), message);
		} catch(UserNotFoundException e) {
			err = "error.user.dontexist";
		} catch(ManagerException e) {
			err = e.getMessage();
		} // TODO catcher l'exception MailNotSentException
		if(err != null) {
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