// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.diploma.DiplomaManager;
import fr.umlv.desperados.struts.form.SearchStudentForm;
import fr.umlv.desperados.student.StudentManager;
import fr.umlv.desperados.util.Constants;

/** 
 * SaveUserAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:action path="/saveUser" name="userForm" attribute="userForm" input="/form/userDetails.jsp" validate="true"
 */
public final class SearchStudentAction extends UserAction {

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

		SearchStudentForm searchForm = (SearchStudentForm) form;
		if(form == null) {
			return (mapping.findForward("itself"));
		}

		// validate the form
		ActionErrors errors = searchForm.validate(mapping, request);
		if(!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("itself"));
		}

		StudentManager manager = (StudentManager)servlet.getServletContext().
								getAttribute(Constants.STUDENT_DATABASE_KEY);
		DiplomaManager diplomaManager = (DiplomaManager) servlet.getServletContext().
								getAttribute(Constants.DIPLOMA_DATABASE_KEY);

		if(manager == null || diplomaManager==null) {
			errors.add("database",
			   new ActionError("error.database.missing"));
			log.warn("SearchUserAction: Database is missing");
		}

		if(!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		// TODO à mettre dans DatabaseDiplomaManager.searchStudent()
		String ine = (searchForm.getIne()).replace('*','%');
		String name = (searchForm.getName()).replace('*','%');
		String firstname = (searchForm.getFirstname()).replace('*','%');
		//
		int diplomaId = Integer.parseInt(searchForm.getDiplomaId());
		List studentList = manager.searchStudent(ine,name,firstname,diplomaId);

		if(studentList != null) {
			request.setAttribute("studentlist", studentList);
		}

		List diplomaList = diplomaManager.listDiploma();
		if(diplomaList != null) {
			request.setAttribute("diplomaList", diplomaList);
		}

		return (mapping.findForward("itself"));
	}

}