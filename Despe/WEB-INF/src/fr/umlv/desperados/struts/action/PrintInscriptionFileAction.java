/*
 * Créé le 16 janv. 2004
 *
 */
package fr.umlv.desperados.struts.action;



import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

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

import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.student.StudentManager;
import fr.umlv.desperados.stylesheet.StyleSheet;
import fr.umlv.desperados.stylesheet.StyleSheetManager;
import fr.umlv.desperados.util.Constants;
import fr.umlv.desperados.util.PDFTools;

/**
 * @author ndedanil
 *
 */
public class PrintInscriptionFileAction extends Action {

	/**
		 * The <code>Log</code> instance for this application.
		 */
	 private Log log = LogFactory.getLog("fr.umlv.desperados.struts");


	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession();
		
		
		
		Student student = (Student)session.getAttribute(Constants.STUDENT_KEY);
		if (student == null) {
			if (log.isWarnEnabled()) {
				errors.add(ActionErrors.GLOBAL_ERROR,
					new ActionError("error.mustbelogged"));
				saveErrors(request, errors);
			}
			return (mapping.findForward("error"));
		}

		StudentManager manager =
			(StudentManager) servlet.getServletContext().getAttribute(
				Constants.STUDENT_DATABASE_KEY);
				
		StyleSheetManager ssManager = 
			(StyleSheetManager)servlet.getServletContext().getAttribute(
				Constants.STYLESHEET_DATABASE_KEY);

		if (manager == null) {
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.missing"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("failure"));
		}

		StyleSheet s = ssManager.getStyleSheet(1);
		
		InputStream isStyleSheet = new FileInputStream(servlet.getServletContext().getRealPath("/")
																								+"/stylesheet/"+s.getFilename());
		InputStream isStudent = new ByteArrayInputStream(student.toXML().getBytes());
		InputStream is = PDFTools.generatePDF(isStudent,isStyleSheet);

		response.setContentType("application/pdf");
		OutputStream writer = response.getOutputStream();
		byte[] buffer = new byte[1024];
		while(is.read(buffer)>0) {
			writer.write(buffer);
		}
		return null;
	}
}