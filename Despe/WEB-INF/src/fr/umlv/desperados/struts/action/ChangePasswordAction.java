package fr.umlv.desperados.struts.action;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

		// save the old password (in case of failure while sending mail)
		String oldPassword = loggedUser.getPassword(); 

		// generate randomly a new password
		String newPass = UserUtilities.generatePassword();
			MessageDigest messageDigest;
						try {
							messageDigest = MessageDigest.getInstance("MD5");
							byte[] crytpNewPass = messageDigest.digest(newPass.getBytes("US-ASCII"));
							
							loggedUser.setPassword(new String(crytpNewPass,"US-ASCII")); 
							//userToSave.setPassword(UserUtilities.generatePassword());
		
		
						}catch (NoSuchAlgorithmException e) {
							// TODO Bloc catch auto-généré
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Bloc catch auto-généré
							e.printStackTrace();
						}
		
		
		
	//	loggedUser.setPassword(UserUtilities.generatePassword());

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
			loggedUser.setPassword(newPass);
			MessageFactory factory = new MessageFactory();
			Mailer mailer = new Mailer();
			Message message = factory.createMessage(Message.MODIFICATION_MESSAGE, loggedUser);
			mailer.sendMail(loggedUser.getEmail(), message);
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