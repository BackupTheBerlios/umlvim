/*
 * Created on 10 janv. 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package fr.umlv.desperados.struts.util;

import fr.umlv.desperados.account.User;
import fr.umlv.desperados.struts.form.UserForm;

/**
 * @author ncuvelie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class FormUtilities {

	public static User userFormToUser(UserForm form) {
		User user = new User(form.getLogin());
		user.setName(form.getName());
		user.setFirstname(form.getFirstname());
		user.setEmail(form.getEmail());
		user.setAdmin(form.getAdmin());
		return user;
	}

	public static UserForm UserToUserForm(User user) {
		UserForm form = new UserForm();
		form.setLogin(user.getLogin());
		form.setName(user.getName());
		form.setFirstname(user.getFirstname());
		form.setEmail(user.getEmail());
		form.setAdmin(user.getAdmin());
		return form;
	}
}
