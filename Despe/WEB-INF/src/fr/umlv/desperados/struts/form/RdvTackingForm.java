// Created by Xslt generator for Eclipse.
// XSL :  not found (java.io.FileNotFoundException:  (Aucun fichier ou répertoire de ce type))
// Default XSL used : easystruts.jar$org.easystruts.xslgen.JavaClass.xsl

package fr.umlv.desperados.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * RdvTackingForm.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-14-2004
 * 
 * XDoclet definition:
 * @struts:form name="rdvTackingForm"
 */
public class RdvTackingForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods
	private String date;

	private String day;
	
	private String hour;

	/** 
	 * Method validate
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		throw new UnsupportedOperationException("Generated method 'validate(...)' not implemented.");
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

	}





	/**
	 * @return
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @return
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * @param string
	 */
	public void setDate(String string) {
		date = string;
	}

	/**
	 * @param string
	 */
	public void setDay(String string) {
		day = string;
	}

	/**
	 * @param string
	 */
	public void setHour(String string) {
		hour = string;
	}

}
