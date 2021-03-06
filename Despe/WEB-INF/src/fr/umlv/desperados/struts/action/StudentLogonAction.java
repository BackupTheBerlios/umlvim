// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.action;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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

import fr.umlv.desperados.struts.form.StudentLogonForm;
import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.student.StudentBirthdayException;
import fr.umlv.desperados.student.StudentManager;
import fr.umlv.desperados.student.StudentNotFoundException;
import fr.umlv.desperados.util.Constants;

/** 
 * UserLogonAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:action path="/userLogon" name="userlogonForm" attribute="userLogonForm" input="/form/userLogon.jsp" validate="true"
 */
public class StudentLogonAction extends Action {

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

		Locale locale = request.getLocale();

		if(form == null) {
			return (mapping.findForward("itself"));
		}

		// validate the form
		ActionErrors errors = form.validate(mapping, request);
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("itself"));
		}

		StudentLogonForm studentLogonForm = (StudentLogonForm) form;
		Student student = null;

		StudentManager manager = (StudentManager)servlet.getServletContext().
			getAttribute(Constants.STUDENT_DATABASE_KEY);
		
		if (manager == null) {
			errors.add("database",
			   new ActionError("error.database.missing"));
			log.warn("StudentLogonAction: Database is missing");
		}
		else {
			Date birthday = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE)
								.parse(studentLogonForm.getBirthday());
			int studentId = -1;
			try{
						studentId = manager.existStudent(studentLogonForm.getPatronymicName(),
												studentLogonForm.getFirstname1(),
												birthday);
			}catch(StudentBirthdayException e){
				errors.add(ActionErrors.GLOBAL_ERROR,
								   new ActionError("error.student.badBirthday"));
			}
			
			try {
				student = manager.getStudent(studentId);
			} catch(StudentNotFoundException e) {
				errors.add(ActionErrors.GLOBAL_ERROR,
				   new ActionError("error.student.dontexist"));
			}
		}

		// Report any errors we have discovered back to the original form
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		// Save our logged-in user in the session
		HttpSession session = request.getSession();
		session.setAttribute(Constants.STUDENT_KEY, student);
		if (log.isDebugEnabled()) {
			log.trace("StudentLogonAction: Student '" + student.getId() +
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
		return (mapping.findForward("home"));
	}
}