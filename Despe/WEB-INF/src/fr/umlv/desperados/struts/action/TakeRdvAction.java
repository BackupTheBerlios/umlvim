//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\action\\TakeRdvAction.java

package fr.umlv.desperados.struts.action;

import java.text.DateFormat;
import java.text.ParseException;
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
import fr.umlv.desperados.util.Constants;

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

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {

		RdvTackingForm viewConfForm = (RdvTackingForm) form;

		String target = "success";

		// Use the LoginForm to get the request parameters			
		String date = viewConfForm.getDate();
		System.out.println("date :" + date);
		try {
			Date rdvDate =
				DateFormat
					.getDateTimeInstance(
						DateFormat.SHORT,
						DateFormat.SHORT,
						Locale.FRANCE)
					.parse(date);
			System.out.println("date :" + rdvDate);
			ServletContext context = servlet.getServletContext();
			DatabaseRdvManager databaseRdvManager =
				(DatabaseRdvManager) context.getAttribute(
					Constants.RDV_DATABASE_KEY);
			//
			//			// get student info
			//			Student student =
			//				(Student) request.getSession().getAttribute(Constants.STUDENT_KEY);
			//				
			//			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,Locale.FRANCE);
			//			Date dateBac = df.parse(student.getBacYear());

			//		boolean isRavel =(dateBac.getMonth() == new Date(System.currentTimeMillis()).getYear());

			Rdv rdv = new Rdv(rdvDate, "2", "test", "test", true);

			databaseRdvManager.addRdv(rdv);

		} catch (ParseException e) {
			e.printStackTrace();
			target = "error";

		}

		request.setAttribute("date", date);
		return mapping.findForward(target);
	}
}
