//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\form\\UserForm.java

package fr.umlv.desperados.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * UserForm.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 01-07-2004
 * 
 * XDoclet definition:
 * @struts:form name="userForm"
 */
public class SearchStudentForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables

	/** firstname property */
	private String firstname;

	/** name property */
	private String name;

	/** diploma property */
	private String diploma;

	/** diploma property */
	private String ine;

	
	// --------------------------------------------------------- Methods

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		name = null;
		firstname = null;
		 ine= null;
		 diploma = "0";
			}

	/** 
	 * Method validate
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 * @return ActionErrors
	 */
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
			if ((firstname == null || firstname.equals("")) && (name == null || name.equals("")) && (name == null || name.equals("")) && diploma.equals("0") && (ine == null || ine.equals(""))) {
					errors.add(
										"choice",
										new ActionError("error.search.specify.oneatleast"));
			}
			return errors;
		}

	


	/**
	 * @return
	 */
	public String getDiploma() {
		return diploma;
	}

	/**
	 * @return
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @return
	 */
	public String getIne() {
		return ine;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param string
	 */
	public void setDiploma(String string) {
		diploma = string;
	}

	/**
	 * @param string
	 */
	public void setFirstname(String string) {
		firstname = string;
	}

	/**
	 * @param string
	 */
	public void setIne(String string) {
		ine = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

}
