//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\action\\TakeRdvAction.java

package fr.umlv.desperados.struts.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.planning.DatabaseRdvManager;
import fr.umlv.desperados.planning.Rdv;
import fr.umlv.desperados.struts.form.RdvTackingForm;
import fr.umlv.desperados.student.Student;
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

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

		RdvTackingForm viewConfForm = (RdvTackingForm) form;

		ActionErrors errors = new ActionErrors();

		// Use the LoginForm to get the request parameters			
		String date = viewConfForm.getDate();
		System.out.println("date :" + date);
		try {
			
			Date rdvDate = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, Locale.FRANCE).parse(date);
			System.out.println("date :" + rdvDate);
			ServletContext context = servlet.getServletContext();
			DatabaseRdvManager databaseRdvManager = (DatabaseRdvManager) context.getAttribute(Constants.RDV_DATABASE_KEY);

			// get student info
			Student student = (Student) request.getSession().getAttribute(Constants.STUDENT_KEY);

			// check if the student already have a rdv
			if (student.getAppointmentDate() != null) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rdv.allready.taken"));
			} else { // set the rdv date in the db

				DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
				//Date dateBac = df.parse(student.getBacYear());

				//Calendar calDateBac = new GregorianCalendar();
				Calendar calCurrent = GregorianCalendar.getInstance();
				//calDateBac.setTime(dateBac);
				

				int bYear = new Integer(student.getBacYear()).intValue();
				boolean isRavel = (  bYear == calCurrent.get(Calendar.YEAR));

				Rdv rdv = new Rdv(rdvDate, Integer.toString(student.getId()), student.getPatronymicName(), student.getFirstname1(), isRavel);

				databaseRdvManager.addRdv(rdv);

			}
		} catch (ParseException e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.global"));
		}

		request.setAttribute("date", date);

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward("error");
		}

		return mapping.findForward("success");
	}
}
