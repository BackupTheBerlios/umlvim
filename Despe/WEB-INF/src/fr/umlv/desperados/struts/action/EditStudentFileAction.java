/*
 * Cr�� le 3 f�vr. 2004
 *
 * Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
package fr.umlv.desperados.struts.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.student.DatabaseInformationListManager;
import fr.umlv.desperados.util.Constants;

/**
 * @author gdupont
 *
 * Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre&gt;Pr�f�rences&gt;Java&gt;G�n�ration de code&gt;Code et commentaires
 */
public class EditStudentFileAction extends StudentAction {
	
	public ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		ActionErrors errors = new  ActionErrors();

		// Load student
		HttpSession session = request.getSession();

		DatabaseInformationListManager manager =
			(DatabaseInformationListManager) servlet.getServletContext().getAttribute(
				Constants.INFORMATION_DATABASE_KEY);
		if (manager == null) {
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.missing"));
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}

		String page = request.getParameter("page");
		if(page == null) {
			//TODO mettre 1 au lieu de 3
			page = "1";
		} 
		if ("1".equals(page)) {
			Set lodgingTypeList=manager.list(DatabaseInformationListManager .LODGING_TYPE);
						request.setAttribute( "lodgingTypeList",lodgingTypeList);
			
			
		
		}
		if ("2".equals(page)) {
		}
		if ("3".equals(page)) {
				Set SocialSecurityAffList=manager.list(DatabaseInformationListManager .SOCIAL_SECURITY_AFF);
				request.setAttribute( "socialSecurityAffList",SocialSecurityAffList);
				Set SocialSecurityNonAffList=manager.list(DatabaseInformationListManager .SOCIAL_SECURITY_NON_AFF);
				request.setAttribute( "socialSecurityNonAffList",SocialSecurityNonAffList);
				Set centerPaymentList=manager.list(DatabaseInformationListManager .PAYMENT_CENTER);
				request.setAttribute( "centerPaymentList",centerPaymentList);		
				Set mutualInsuranceCompanyList=manager.list(DatabaseInformationListManager .MUTUAL_COMPANY);
				request.setAttribute( "mutualInsuranceCompanyList",mutualInsuranceCompanyList);		
			}
			if("4".equals(page)){
				Set financialAssistanceList=manager.list(DatabaseInformationListManager .FINANCIAL_AID);
				request.setAttribute( "financialAssistanceList",financialAssistanceList);		
				Set purseList=manager.list(DatabaseInformationListManager .PURSE);
						request.setAttribute( "purseList",purseList);		
			}

		System.out.println("*****\nEditStudentAction: forwarding to "+page+"\n*****");
		return (mapping.findForward(page));
	}
}