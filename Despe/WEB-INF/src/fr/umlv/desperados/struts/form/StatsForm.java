/*
 * Created on 24 janv. 2004
 *
 */
package fr.umlv.desperados.struts.form;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

//import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author Arnaud FRICOTTEAU
 *
 */
public class StatsForm extends ActionForm {
	
	// --------------------------------------------------------- Instance Variables

	/** periodeDeb property */
	private String dayStart = "01/01/2004";

	/** periodeDeb property */
	private String dayEnd = "01/01/2004";
	    
	/** diplomaId property */
	private String diplomaId = "-1";
	
	// --------------------------------------------------------- Methods

	/** 
	 * Method validate
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
				 HttpServletRequest resquest) {
	
		ActionErrors errors = new ActionErrors();
		
		// Test if dates formats are correct
		String formatRegexp = "\\d\\d/\\d\\d/\\d\\d\\d\\d"; // resources.getMessage("date.format.regexp");
		
		if (!dayStart.matches(formatRegexp))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.format.date.start", dayStart));

		if (!dayEnd.matches(formatRegexp))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.format.date.end", dayEnd));

		//	Parse the two dates and try an exeption if it don't exist
		Date startDate = null;
		Date endDate = null;
	
		DateFormat formatDate = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRANCE);
		formatDate.setLenient(false);
	
		try {
			startDate = formatDate.parse(dayStart);
		} catch (ParseException e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.date.start.no.exist", dayStart));
		}
		
		try {
				endDate = formatDate.parse(dayEnd);
		} catch (ParseException e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.date.end.no.exist", dayEnd));
		}
	
		//	Test if the second date is after the first
		if(((startDate != null)&&(endDate != null)) && (startDate.after(endDate)))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.reversed.dates"));
		
	return errors;
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		dayStart = "01/01/2004";
		dayEnd = "01/01/2004";
		diplomaId = "-1";
	}
	
	/**
	 * @return
	 */
	public String getDiplomaId() {
		return diplomaId;
	}

	/**
	 * @param string
	 */
	public void setDiplomaId(String string) {
		diplomaId = string;
	}

	/**
	 * @return
	 */
	public String getDayStart() {
		return dayStart;
	}

	/**
	 * @param string
	 */
	public void setDayStart(String string) {
		dayStart = string;
	}

	/**
	 * @return
	 */
	public String getDayEnd() {
		return dayEnd;
	}

	/**
	 * @param string
	 */
	public void setDayEnd(String string) {
		dayEnd = string;
	}

}