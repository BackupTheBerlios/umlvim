// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.action;

import java.io.PrintWriter;

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
public class SaveUserAction extends Action {

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

		UserForm userForm = (UserForm) form;

//////////////
//FOR THE TEST
		String res = userForm.getFirstname()+" "+userForm.getName()
					+" ("+userForm.getLogin()+")"
					+"<BR>  mail: "+userForm.getEmail()
					+"<BR>  statut"+(userForm.getAdmin()?" Administrateur":" Simple utilisateur")
					+"<BR>  génération d'un mot de passe ? "+(userForm.getGeneratePassword()?"OUI":"NON");

		PrintWriter pw = response.getWriter();
		pw.println(res);
// TODO envoyer le mail
		return (mapping.findForward("success"));
//////////////


////////////////////////
//COMMENTED FOR THE TEST
// TODO A tester
//		HttpSession session = request.getSession();
//
//		String action = userForm.getAction();
//		if (action == null) {
//			action = "create";
//		}
//
//		UserManager manager = (UserManager)servlet.getServletContext().
//								getAttribute(Constants.USER_DATABASE_KEY);
//		if (log.isDebugEnabled()) {
//			log.debug("SaveRegistrationAction:  Processing " + action +
//					  " action");
//		}
//
//		// Is there a currently logged on user (unless creating)?
//		User user = (User) session.getAttribute(Constants.USER_KEY);
//		if (!"Create".equals(action) && (user == null)) {
//			if (log.isTraceEnabled()) {
//				log.trace(" User is not logged on in session "
//						  + session.getId());
//			}
//			return (mapping.findForward("logon"));
//		}
//
//		// Was this transaction cancelled?
//		if (isCancelled(request)) {
//			if (log.isTraceEnabled()) {
//				log.trace(" Transaction '" + action +
//						  "' was cancelled");
//			}
//			return (mapping.findForward("success"));
//		}
//
//		// Validate the transactional control token
//		ActionErrors errors = new ActionErrors();
//		if (log.isTraceEnabled()) {
//			log.trace(" Checking transactional control token");
//		}
//		if (!isTokenValid(request)) {
//			errors.add(ActionErrors.GLOBAL_ERROR,
//					   new ActionError("error.transaction.token"));
//		}
//		resetToken(request);
//
//		// Report any errors we have discovered back to the original form
//		if (!errors.isEmpty()) {
//			saveErrors(request, errors);
//			saveToken(request);
//			return (mapping.getInputForward());
//		}
//
//		// Update the user's persistent profile information
//		User userToSave = null;
//		FormUtilities.userFormToUser(userForm, userToSave);
//
//		if("create".equals(action)) {
//			manager.addUser(userToSave);
//		}
//		else {
//			manager.modifyUser(userToSave);
//		}
//
//		// Remove the obsolete form bean
//		if (mapping.getAttribute() != null) {
//			if ("request".equals(mapping.getScope()))
//				request.removeAttribute(mapping.getAttribute());
//			else
//				session.removeAttribute(mapping.getAttribute());
//		}
//
//		// Forward control to the specified success URI
//		if (log.isTraceEnabled()) {
//			log.trace(" Forwarding to success page");
//		}
//		return (mapping.findForward("success"));
////////////////////////
	}

}