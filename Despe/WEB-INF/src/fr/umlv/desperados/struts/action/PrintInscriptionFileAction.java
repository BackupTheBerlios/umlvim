/*
 * Créé le 16 janv. 2004
 *
 */
package fr.umlv.desperados.struts.action;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

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
import fr.umlv.desperados.planning.RdvList;
import fr.umlv.desperados.planning.DatabaseRdvManager;
import fr.umlv.desperados.student.DatabaseInformationListManager;
import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.student.StudentManager;
import fr.umlv.desperados.stylesheet.DatabaseStyleSheetManager;
import fr.umlv.desperados.stylesheet.StyleSheet;
import fr.umlv.desperados.stylesheet.StyleSheetManager;
import fr.umlv.desperados.util.Constants;
import fr.umlv.desperados.util.XSLTools;
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

		Student student = (Student) session.getAttribute(Constants.STUDENT_KEY);
		User user = (User) session.getAttribute(Constants.USER_KEY);
		String type = request.getParameter("type");

		int docType;
		if (type.equals("inscr"))
			docType =  DatabaseStyleSheetManager.INSCRIPTION_DOCUMENT;
		else if(type.equals("conf")) {
			docType = DatabaseStyleSheetManager.CONFIRMATION_DOCUMENT;
			if (student.getAppointmentDate() == null) {
				errors.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("error.rdv.not.taken"));
			}
		}
		else
			docType = DatabaseStyleSheetManager.RDV_LIST_DOCUMENT;


		if (student == null && user==null) {
			if (log.isWarnEnabled()) {
				errors.add(
					ActionErrors.GLOBAL_ERROR,
					new ActionError("error.mustbelogged"));
				saveErrors(request, errors);
			}
			return (mapping.findForward("error"));
		}

		StudentManager manager =
			(StudentManager) servlet.getServletContext().getAttribute(
				Constants.STUDENT_DATABASE_KEY);

		StyleSheetManager ssManager =
			(StyleSheetManager) servlet.getServletContext().getAttribute(
				Constants.STYLESHEET_DATABASE_KEY);

		DatabaseInformationListManager listManager =
			(DatabaseInformationListManager)servlet.getServletContext().getAttribute(
				Constants.INFORMATION_DATABASE_KEY);
		
		DatabaseRdvManager rdvManager =
			(DatabaseRdvManager) servlet.getServletContext().getAttribute(
				Constants.RDV_DATABASE_KEY);
		
		if (manager == null) {
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.missing"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		StyleSheet s = ssManager.getStyleSheet(docType);

		String stringWorkingDirectory = System.getProperty( "java.io.tmpdir" ).replace( '\\', '/' );
   		String fileName = s.getFilename();
		String filePath = servlet.getServletContext().getRealPath("/") + "stylesheet/" + fileName;
	
		InputStream is;
	
		if(fileName.endsWith("sxw")) {
			String destFile = stringWorkingDirectory+"/";
			int index = fileName.lastIndexOf(".");
			destFile += fileName.substring(0, index) + student.getId() + fileName.substring(index,fileName.length());
			System.out.println("destFile = "+destFile);
			PDFTools.copy(filePath, destFile);
			PDFTools tools = new PDFTools(destFile); 
			
			tools.modifyFile(student, listManager);
			is = new FileInputStream(tools.convertDocument());
		}
				
		else {
			InputStream isStyleSheet = new FileInputStream(filePath);
			InputStream isObj;
			if(docType==2 || docType==1) {
				isObj = new ByteArrayInputStream(student.toXML().getBytes());
			}
			else {
				RdvList rdvList = new RdvList(rdvManager.listRdv(new Date()));
				isObj = new ByteArrayInputStream(rdvList.toXML().getBytes());
			}
			is = XSLTools.generatePDF(isObj, isStyleSheet);
		}
		response.setContentType("application/pdf");	
		OutputStream writer = response.getOutputStream();
		byte[] buffer = new byte[1024];
		while(is.read(buffer)>0)
			writer.write(buffer);

		return null;
	}
}