// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Bad file descriptor))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.account.UserManager;
import fr.umlv.desperados.struts.form.SearchUserForm;
import fr.umlv.desperados.util.Constants;

/** 
 * SaveUserAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:action path="/saveUser" name="userForm" attribute="userForm" input="/form/userDetails.jsp" validate="true"
 */
public final class SearchUserAction extends AdminAction {

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

		SearchUserForm searchForm = (SearchUserForm) form;
		ActionErrors errors = searchForm.validate(mapping, request);
////////////////////
//COMMENTED FOR TEST
//		UserManager manager = (UserManager)servlet.getServletContext().
//								getAttribute(Constants.USER_DATABASE_KEY);
//		if(manager == null) {
//			errors.add("database",
//			   new ActionError("error.database.missing"));
//			log.warn("UserLogonAction: Database is missing");
//		}
//
//		if(!errors.isEmpty()) {
//			saveErrors(request, errors);
//			return (mapping.findForward("searchuser"));
//		}
		PrintWriter pw = response.getWriter();
		pw.println("Searching login='"+searchForm.getLogin()+"' name='"+searchForm.getName()+"'");		

//		List userList = manager.searchUser(searchForm.getLogin(), searchForm.getName());
//		request.setAttribute("userList", userList);
////////////////////

		return (mapping.findForward("searchuser"));
	}

}