//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\action\\SetupPlanningAction.java

package fr.umlv.desperados.struts.action;

import java.io.IOException;
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

		PlanningConfForm planningForm = (PlanningConfForm) form;

		String beginAM = planningForm.getBeginAM();
		String endAM = planningForm.getEndAM();
		String nbCorrectorAM = planningForm.getNbCorrectorAM();
		String nbRavelAM = planningForm.getNbRavelAM();
		String rdvDurationAM = planningForm.getRdvDurationAM();

		String beginPM = planningForm.getBeginPM();
		String endPM = planningForm.getEndPM();
		String nbCorrectorPM = planningForm.getNbCorrectorPM();
		String nbRavelPM = planningForm.getNbRavelPM();
		String rdvDurationPM = planningForm.getRdvDurationPM();

		String fromDate = planningForm.getFromDate();
		String toDate = planningForm.getToDate();

		ServletContext context = servlet.getServletContext();
		DatabaseRdvManager databaseRdvManager =
			(DatabaseRdvManager) context.getAttribute(
				Constants.RDV_DATABASE_KEY);
			PlanningConf planningConf = (PlanningConf) context.getAttribute(Constants.PLANNING_CONF_DATABASE_KEY);
		DateFormat dateFormat =
			DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);

		DateFormat timeFormat =
			DateFormat.getTimeInstance(DateFormat.SHORT, Locale.FRANCE);

		try {

			Date fromDateD = dateFormat.parse(fromDate);
			Date toDateD = dateFormat.parse(toDate);

			Date beginAMT = timeFormat.parse(beginAM);
			Date endAMT = timeFormat.parse(endAM);

			Date beginPMT = timeFormat.parse(beginPM);
			Date endPMT = timeFormat.parse(endPM);

			int nbCorrectorAMI = Integer.parseInt(nbCorrectorAM);
			int nbCorrectorPMI = Integer.parseInt(nbCorrectorPM);

			int nbRavelAMI = Integer.parseInt(nbRavelAM);
			int nbRavelPMI = Integer.parseInt(nbRavelPM);

			int rdvDurationAMI = Integer.parseInt(rdvDurationAM);
			int rdvDurationPMI = Integer.parseInt(rdvDurationPM);


			Calendar calbeginAM = new GregorianCalendar();
			calbeginAM.setTime(beginAMT);
			Calendar calbeginAMTmp = new GregorianCalendar();
					calbeginAMTmp.setTime(beginAMT);
			
			Calendar calendAM = new GregorianCalendar();
			calendAM.setTime(endAMT);
			
			Calendar calbeginPM = new GregorianCalendar();
			calbeginPM.setTime(beginPMT);
			calbeginPM.set(Calendar.AM_PM,Calendar.PM);
			Calendar calbeginPMTmp = new GregorianCalendar();
			calbeginPMTmp.setTime(beginPMT);
		calbeginPMTmp.set(Calendar.AM_PM,Calendar.PM);
			
			Calendar calendPM = new GregorianCalendar();
			calendPM.setTime(endPMT);
			
						
			
			// ajout dans le fichier de planning de la nouvelle configuration
				HalfDayConf am = new HalfDayConf(calbeginAM,calendAM,rdvDurationAMI,nbCorrectorAMI,nbRavelAMI,true);
				HalfDayConf pm = new HalfDayConf(calbeginPM,calendPM,rdvDurationPMI,nbCorrectorPMI,nbRavelPMI,false);


			
			// calcule du nombre de jour entre les date de debut et de fin
			Calendar calFromDate = new GregorianCalendar();
			calFromDate.setTime(fromDateD);
			Calendar calToDate = new GregorianCalendar();
			calToDate.setTime(toDateD);
			calToDate.add(GregorianCalendar.DAY_OF_YEAR,1);
		
		
			while(calFromDate.before((Object)calToDate))
				{
					int dayInWeek=calFromDate.get(GregorianCalendar.DAY_OF_WEEK);
					
					if(dayInWeek!=GregorianCalendar.SATURDAY && dayInWeek!=GregorianCalendar.SUNDAY)
					{
						// Ajout de la configuration du jour
						DayConf day = new DayConf(am,pm,calFromDate.get(Calendar.DAY_OF_MONTH));
						planningConf.setConf(calFromDate,day);
					
						//ajout des rendez-vous du matin dans la bd
						calFromDate.set(Calendar.HOUR,calbeginAM.get(Calendar.HOUR));
						calFromDate.set(Calendar.MINUTE,calbeginAM.get(Calendar.MINUTE));
						while(calbeginAMTmp.before(calendAM))
						{
							databaseRdvManager.confRdv(calFromDate.getTime(),nbRavelAMI,nbCorrectorAMI-nbRavelAMI);
							calFromDate.add(Calendar.MINUTE,rdvDurationAMI);
							calbeginAMTmp.add(Calendar.MINUTE,rdvDurationAMI); 
						}
						
						//ajout des rendez-vous de l'aprés midi dans la bd
						calFromDate.set(Calendar.AM_PM,Calendar.PM);
						calFromDate.set(Calendar.HOUR,calbeginPM.get(Calendar.HOUR));
						calFromDate.set(Calendar.MINUTE,calbeginPM.get(Calendar.MINUTE));
						while(calbeginPMTmp.before(calendPM))
						{
							databaseRdvManager.confRdv(calFromDate.getTime(),nbRavelPMI,nbCorrectorPMI-nbRavelPMI);
							calFromDate.add(Calendar.MINUTE,rdvDurationPMI);
							calbeginPMTmp.add(Calendar.MINUTE,rdvDurationPMI);
						}
							
				
					
		
			calFromDate.set(Calendar.HOUR,calbeginAM.get(Calendar.HOUR));
			calFromDate.set(Calendar.MINUTE,calbeginAM.get(Calendar.MINUTE));
			calbeginAMTmp.set(Calendar.MINUTE,calbeginAM.get(Calendar.MINUTE));
			calbeginAMTmp.set(Calendar.HOUR,calbeginAM.get(Calendar.HOUR));
			calbeginPMTmp.set(Calendar.MINUTE,calbeginPM.get(Calendar.MINUTE));
			calbeginPMTmp.set(Calendar.HOUR,calbeginPM.get(Calendar.HOUR));
			//on avance d'un jour 
					}
			 calFromDate.add(GregorianCalendar.DAY_OF_YEAR,1);
						
		}

		} catch (ParseException e) {
			target = "error";
			e.printStackTrace();
		} catch (NumberFormatException e) {
			target = "error";
			e.printStackTrace();
			} catch (IOException e1) {
				target = "error";
					e1.printStackTrace();
			}

		return mapping.findForward(target);
	}

}
