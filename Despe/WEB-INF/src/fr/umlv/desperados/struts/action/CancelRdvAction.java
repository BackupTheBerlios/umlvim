//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\action\\CancelRdvAction.java

package fr.umlv.desperados.struts.action;

import java.text.DateFormat;
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
import fr.umlv.desperados.student.Student;
import fr.umlv.desperados.util.Constants;

public class CancelRdvAction extends Action {

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
	{
		if(isCancelled(request)) {
			return (mapping.findForward("cancelled"));
		}

		ActionErrors errors = new ActionErrors();

		// get student info
		Student student = (Student) request.getSession().getAttribute(Constants.STUDENT_KEY);

		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);

		ServletContext context = servlet.getServletContext();
		DatabaseRdvManager databaseRdvManager =
				(DatabaseRdvManager) context.getAttribute(Constants.RDV_DATABASE_KEY);

		Rdv rdv = databaseRdvManager.getRdv(student.getId());

		if (rdv == null)
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rdv.not.allready.taken"));
		else {
			databaseRdvManager.removeRdv(rdv);
			student.setAppointmentDate(null);
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return mapping.findForward("error");
		}
		return mapping.findForward("success");
	}
}