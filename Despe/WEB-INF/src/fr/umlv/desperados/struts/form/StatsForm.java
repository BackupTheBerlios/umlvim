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
	private String periodeDeb;
	
	/** periodeFin property */
	private String periodeFin;
    
	/** diplomaId property */
	private String diplomaId;
	
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
		periodeDeb = "";
		periodeFin = "";
		diplomaId = "";
	}
	
	/**
	 * @return
	 */
	public String getDiplomaId() {
		return diplomaId;
	}

	/**
	 * @return
	 */
	public String getPeriodeDeb() {
		return periodeDeb;
	}

	/**
	 * @return
	 */
	public String getPeriodeFin() {
		return periodeFin;
	}

	/**
	 * @param string
	 */
	public void setDiplomaId(String string) {
		diplomaId = string;
	}

	/**
	 * @param string
	 */
	public void setPeriodeDeb(String string) {
		periodeDeb = string;
	}

	/**
	 * @param string
	 */
	public void setPeriodeFin(String string) {
		periodeFin = string;
	}

}
