/*
 * Created on 24 janv. 2004
 *
 */
package fr.umlv.desperados.struts.form;

import javax.servlet.http.HttpServletRequest;

//import org.apache.struts.action.ActionError;
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
	private String dayStartId = "1";

	/** periodeDeb property */
	private String monthStartId = "1";

	/** periodeDeb property */
	private String dayEndId = "1";

	/** periodeDeb property */
	private String monthEndId = "1";
	    
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
	return errors;
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		dayStartId = "1";
		monthStartId = "1";
		dayEndId = "1";
		monthEndId = "1";
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
	public String getDayStartId() {
		return dayStartId;
	}

	/**
	 * @param string
	 */
	public void setDayStartId(String string) {
		dayStartId = string;
	}

	/**
	 * @return
	 */
	public String getDayEndId() {
		return dayEndId;
	}

	/**
	 * @return
	 */
	public String getMonthEndId() {
		return monthEndId;
	}

	/**
	 * @return
	 */
	public String getMonthStartId() {
		return monthStartId;
	}

	/**
	 * @param string
	 */
	public void setDayEndId(String string) {
		dayEndId = string;
	}

	/**
	 * @param string
	 */
	public void setMonthEndId(String string) {
		monthEndId = string;
	}

	/**
	 * @param string
	 */
	public void setMonthStartId(String string) {
		monthStartId = string;
	}

}