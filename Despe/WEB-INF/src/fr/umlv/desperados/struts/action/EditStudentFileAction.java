/*
 * Créé le 3 févr. 2004
 *
 * Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
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
 * Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre&gt;Préférences&gt;Java&gt;Génération de code&gt;Code et commentaires
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
			page = "2";
		} 
		if ("1".equals(page)) {
			Set lodgingTypeList=manager.list(DatabaseInformationListManager .LODGING_TYPE);
						request.setAttribute( "lodgingTypeList",lodgingTypeList);
			Set famSituationList=manager.list(DatabaseInformationListManager .FAMILIAL_SITUATION);
						request.setAttribute( "famSituationList",famSituationList);
			Set handicapList=manager.list(DatabaseInformationListManager .HANDICAP);
						request.setAttribute( "handicapList",handicapList);
			Set militarySituationList=manager.list(DatabaseInformationListManager .MILITARY_SITUATION);
						request.setAttribute( "militarySituationList",militarySituationList);
			Set workedShareList=manager.list(DatabaseInformationListManager .WORKED_SHARED);
						request.setAttribute( "workedShareList",workedShareList);
			
		
		}
		if ("2".equals(page)) {
			Set yearsList=manager.years();
			Set frenchDepList=manager.list(DatabaseInformationListManager .FRENCH_DEP);
			Set baccalaureatList=manager.list(DatabaseInformationListManager .BAC_POST_95);
			Set bacPre95List=manager.list(DatabaseInformationListManager .BAC_PRE_95);
			Set bacMentionList=manager.list(DatabaseInformationListManager .BAC_MENTION);
			Set baccalaureatEstablishmentTypeList=manager.list(DatabaseInformationListManager .BAC_ESTABLISHMENT_TYPE);
			request.setAttribute( "bacMentionList",bacMentionList);
			request.setAttribute( "yearsList",yearsList);
			request.setAttribute( "frenchDepList",frenchDepList);
			request.setAttribute( "baccalaureatList",baccalaureatList);
			request.setAttribute( "bacPre95List",bacPre95List);
			request.setAttribute( "baccalaureatEstablishmentTypeList",baccalaureatEstablishmentTypeList);
		}
		if ("3".equals(page)) {
			Set SocialSecurityAffList=manager.list(DatabaseInformationListManager .SOCIAL_SECURITY_AFF);
			Set SocialSecurityNonAffList=manager.list(DatabaseInformationListManager .SOCIAL_SECURITY_NON_AFF);
			Set centerPaymentList=manager.list(DatabaseInformationListManager .PAYMENT_CENTER);
			Set mutualInsuranceCompanyList=manager.list(DatabaseInformationListManager .MUTUAL_COMPANY);
			request.setAttribute( "socialSecurityAffList",SocialSecurityAffList);
			request.setAttribute( "socialSecurityNonAffList",SocialSecurityNonAffList);
			request.setAttribute( "centerPaymentList",centerPaymentList);		
			request.setAttribute( "mutualInsuranceCompanyList",mutualInsuranceCompanyList);		
		}
		if("4".equals(page)){
			Set financialAssistanceList=manager.list(DatabaseInformationListManager .FINANCIAL_AID);
			Set purseList=manager.list(DatabaseInformationListManager .PURSE);
			request.setAttribute( "financialAssistanceList",financialAssistanceList);		
			request.setAttribute( "purseList",purseList);		
		}

		System.out.println("*****\nEditStudentAction: forwarding to "+page+"\n*****");
		return (mapping.findForward(page));
	}
}