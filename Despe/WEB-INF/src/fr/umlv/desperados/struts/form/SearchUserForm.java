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
public class SearchUserForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables

	/** login property */
	private String login;

	/** name property */
	private String name;

	/** byLogin property */
	private boolean byLogin;

	/** byName property */
	private boolean byName;

	// --------------------------------------------------------- Methods

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		login = null;
		name = null;
		byLogin = false;
		byName = false;
	}

	/** 
	 * Method validate
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if(!byLogin && !byName) {
			errors.add("choice",
						new ActionError("error.search.specify.oneatleast"));
		} else {
			if(byLogin && (login == null || login.equals(""))) {
				errors.add("login",
							new ActionError("error.search.specify"));
			}
			if(byName && (name == null || name.equals(""))) {
				errors.add("name",
							new ActionError("error.search.specify"));
			}
		}
		return errors;
	}

	/** 
	 * Returns the byLogin.
	 * @return boolean
	 */
	public boolean getByLogin() {
		return byLogin;
	}

	/** 
	 * Returns the byName.
	 * @return boolean
	 */
	public boolean getByName() {
		return byName;
	}

	/** 
	 * Returns the login.
	 * @return String
	 */
	public String getLogin() {
		return login;
	}

	/** 
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/** 
	 * Set the byLogin.
	 * @param byLogin The byLogin to set
	 */
	public void setByLogin(boolean byLogin) {
		this.byLogin = byLogin;
	}

	/** 
	 * Set the byName.
	 * @param byLogin The byName to set
	 */
	public void setByName(boolean byName) {
		this.byName = byName;
	}

	/** 
	 * Set the login.
	 * @param login The login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/** 
	 * Set the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
