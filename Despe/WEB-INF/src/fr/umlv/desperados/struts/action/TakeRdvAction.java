//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\action\\TakeRdvAction.java

package fr.umlv.desperados.struts.action;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.planning.DatabaseRdvManager;
import fr.umlv.desperados.planning.Rdv;
import fr.umlv.desperados.struts.form.RdvTackingForm;
import fr.umlv.desperados.student.StudentAccountInfo;

public class TakeRdvAction extends Action {

	/** 
	 * Method execute
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		RdvTackingForm viewConfForm = (RdvTackingForm) form;

		// Use the LoginForm to get the request parameters			
		String date = viewConfForm.getDate();
		Date rdvDate = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRANCE).parse(date);

		ServletContext context = servlet.getServletContext();
		DatabaseRdvManager databaseRdvManager = (DatabaseRdvManager) context.getAttribute("DATABASERDVMANAGER");

		// get student info
		StudentAccountInfo studentInfo = (StudentAccountInfo) request.getSession().getAttribute("STUDENTACOUNTINFO");

		Rdv rdv = new Rdv(studentInfo, rdvDate);

		boolean isReserved = databaseRdvManager.reserveRdv(rdv);

		String target;
		if (isReserved) {
			target = "success";
		}else{
			target = "failure";
		}

		return mapping.findForward(target);
	}
}
