//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\action\\SetupPlanningAction.java

package fr.umlv.desperados.struts.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.desperados.planning.DatabaseRdvManager;
import fr.umlv.desperados.planning.DayConf;
import fr.umlv.desperados.planning.HalfDayConf;
import fr.umlv.desperados.planning.PlanningConf;
import fr.umlv.desperados.struts.form.PlanningConfForm;
import fr.umlv.desperados.util.Constants;

public class SetupPlanningAction extends Action {

	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {

		String target = "success";

		ServletContext context = servlet.getServletContext();
		DatabaseRdvManager databaseRdvManager =
			(DatabaseRdvManager) context.getAttribute(
				Constants.RDV_DATABASE_KEY);
		
		PlanningConfForm planningForm = (PlanningConfForm) form;
				
		
		
		// ajout dans le fichier de planning de la nouvelle configuration
		HalfDayConf am = new HalfDayConf();
		HalfDayConf pm = new HalfDayConf();
		
		
		
		DayConf day = new DayConf(am,pm,2);
		// ajout dans la base de donnée du nouveau rendez vous		
				

		return mapping.findForward(target);
	}

}
