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

	/** byDiploma property */
	private boolean byIne;

	/** byDiploma property */
	private boolean byDiploma;

	/** byFirstname property */
	private boolean byFirstname;

	/** byName property */
	private boolean byName;

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
		byDiploma = false;
		byFirstname = false;
		byName = false;
		byIne = false;
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
		if (!byFirstname && !byName && !byDiploma && !byIne) {
			errors.add(
				"choice",
				new ActionError("error.search.specify.oneatleast"));
		} else {
			if (byFirstname && (firstname == null || firstname.equals(""))) {
				errors.add("firstname",new ActionError("error.search.specify"));
			}
			if (byName && (name == null || name.equals(""))) {
				errors.add("name", new ActionError("error.search.specify"));
			}
			if (byDiploma && (diploma == null || diploma.equals(""))) {
				errors.add("diploma", new ActionError("error.search.specify"));
			}
			if (byIne && (ine == null || ine.equals(""))) {
						errors.add("ine", new ActionError("error.search.specify"));
					}
		}
		return errors;
	}

	

	/**
	 * @return
	 */
	public boolean isByDiploma() {
		return byDiploma;
	}

	/**
	 * @return
	 */
	public boolean isByFirstname() {
		return byFirstname;
	}

	/**
	 * @return
	 */
	public boolean isByIne() {
		return byIne;
	}

	/**
	 * @return
	 */
	public boolean isByName() {
		return byName;
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
	 * @param b
	 */
	public void setByDiploma(boolean b) {
		byDiploma = b;
	}

	/**
	 * @param b
	 */
	public void setByFirstname(boolean b) {
		byFirstname = b;
	}

	/**
	 * @param b
	 */
	public void setByIne(boolean b) {
		byIne = b;
	}

	/**
	 * @param b
	 */
	public void setByName(boolean b) {
		byName = b;
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
