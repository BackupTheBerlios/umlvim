// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.action;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.planning.DatabaseRdvManager;
import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.util.Constants;

/** 
 * SaveUserAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:action path="/saveUser" name="userForm" attribute="userForm" input="/form/userDetails.jsp" validate="true"
 */
public final class ListRdvAction extends Action {

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

		DatabaseRdvManager databaseRdvManager =
					(DatabaseRdvManager) servlet.getServletContext().getAttribute(
						Constants.RDV_DATABASE_KEY);

	
			//			get student info
					 Student student = (Student) request.getSession().getAttribute(Constants.STUDENT_KEY);
			
					// check if the student is ravel
					DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
					Calendar calCurrent = GregorianCalendar.getInstance();
					int bYear = new Integer(student.getBacYear()).intValue();
					boolean isRavel = (  bYear == calCurrent.get(Calendar.YEAR));
			
						
			String[] tabd= databaseRdvManager.getFreeDays(isRavel);
   	   	
			  if(tabd!=null){
			  		request.setAttribute("dateList", tabd);
				}
			return (mapping.findForward("takerdv"));
	}

}