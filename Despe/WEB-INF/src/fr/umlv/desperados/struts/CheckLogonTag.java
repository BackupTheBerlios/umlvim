package fr.umlv.desperados.struts;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.config.ModuleConfig;

import fr.umlv.desperados.util.Constants;

/**
 * Check for a valid User logged on in the current session.  If there is no
 * such user, forward control to the logon page.
 *
 */

public final class CheckLogonTag extends TagSupport {

	// --------------------------------------------------- Instance Variables

	/**
	 * The key of the session-scope bean we look for.
	 */
	private String name = Constants.USER_KEY;

	/**
	 * The page to which we should forward for the user to log on.
	 */
	private String page = "/pages/form/UserLogon.jsp";

	// ----------------------------------------------------------- Properties

	/**
	 * Return the bean name.
	 */
	public String getName() {
		return (this.name);
	}

	/**
	 * Set the bean name.
	 *
	 * @param name The new bean name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the forward page.
	 */
	public String getPage() {
		return (this.page);
	}

	/**
	 * Set the forward page.
	 *
	 * @param page The new forward page
	 */
	public void setPage(String page) {
		this.page = page;
	}

	// ------------------------------------------------------- Public Methods

	/**
	 * Perform our logged-in user check by looking for the existence of
	 * a session scope bean under the specified name.  If this bean is not
	 * present, body is skipped and the specified logon page is included.
	 *
	 * @exception JspException if a JSP exception has occurred
	 */
	public int doStartTag() throws JspException {

		// Is there a valid user logged on?
		boolean valid = false;
		HttpSession session = pageContext.getSession();
		if ((session != null) && (session.getAttribute(name) != null)) {
			valid = true;
		}

		// include page based on the results
		if (valid) {
			return (EVAL_BODY_INCLUDE);
		} else {
			ModuleConfig config = (ModuleConfig)pageContext.getServletContext()
						.getAttribute(org.apache.struts.Globals.MODULE_KEY);
			try {
				pageContext.include(config.getPrefix() + page);
			} catch (ServletException e) {
				throw new JspException(e.toString());
			} catch (IOException e) {
				throw new JspException(e.toString());
			}
			return (SKIP_BODY);
		}
	}

	/**
	 * Do nothing.
	 *
	 * @exception JspException if a JSP exception has occurred
	 */
	public int doEndTag() throws JspException {
		return (EVAL_PAGE);
	}

	/**
	 * Release any acquired resources.
	 */
	public void release() {
		super.release();
		this.name = Constants.USER_KEY;
		this.page = "/pages/form/UserLogon.jsp";
	}
}