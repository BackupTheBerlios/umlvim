/*
 * Créé le 16 janv. 2004
 *
 */
 
package fr.umlv.desperados.struts.form;

import javax.servlet.http.HttpServletRequest;

//import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * @author ndedanil
 *
 */
public class SetStyleSheetForm extends ActionForm {
	
	// --------------------------------------------------------- Instance Variables
    
	/** styleSheetId property */
	private String styleSheetId;

	/** docTypeId property */
	private int docTypeId;
	
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
	styleSheetId = "";
	docTypeId = 0;
	}

	/**
	 * Returns the styleSheetId
	 * @return String
	 */
	public String getStyleSheetId() {
	return styleSheetId;
	}

	/**
	 * Set the styleSheetId
	 * @param styleSheetId The styleSheetId to set
	 */
	public void setStyleSheetId(String styleSheetId) {
	this.styleSheetId = styleSheetId;
	}

	/**
	 * Returns the docTypeId
	 * @return String
	 */
	public int getDocTypeId() {
	return docTypeId;
	}

	/**
	 * Set the docTypeId
	 * @param docTypeId The docTypeId to set
	 */
	public void setDocTypeId(int docTypeId) {
	this.docTypeId = docTypeId;
	}
}
