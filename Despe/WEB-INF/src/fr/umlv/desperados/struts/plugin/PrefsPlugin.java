/*
 * Created on 13 janv. 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package fr.umlv.desperados.struts.plugin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/**
 * @author ncuvelie
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PrefsPlugin implements PlugIn {

	private String confPath;

	public String getConfPath() {
		return confPath;
	}

	public void setConfPath(String path) {
		confPath = path;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.PlugIn#init(org.apache.struts.action.ActionServlet, org.apache.struts.config.ModuleConfig)
	 */
	public void init(ActionServlet servlet, ModuleConfig config)
		throws ServletException {

		String absoltuePath = (servlet.getServletContext()).getRealPath("/");
		String prefix = config.getPrefix();
		String path = absoltuePath + prefix + confPath;
		System.out.println("***" + path + "***");

		InputStream is = null;
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.out.println(
				"Cannot found or open the file : " + path);
		}

		//	Import preference data
		try {
			Preferences.importPreferences(is);
		} catch (InvalidPreferencesFormatException e) {
			System.err.println(
				"InvalidPreferencesFormatException in PlugIn PrefsPlugin : "
					+ e);
		} catch (IOException e) {
			System.err.println(
				"IOException in PlugIn PrefsPlugin : " + e);
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.PlugIn#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
}