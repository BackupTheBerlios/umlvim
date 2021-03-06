//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\G�NIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\plugin\\InitManagersPlugin.java

package fr.umlv.desperados.struts.plugin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import org.xml.sax.SAXException;

import fr.umlv.desperados.account.DatabaseUserManager;
import fr.umlv.desperados.diploma.DatabaseDiplomaManager;
import fr.umlv.desperados.planning.DatabaseRdvManager;
import fr.umlv.desperados.planning.PlanningConf;
import fr.umlv.desperados.struts.database.StrutsDatabaseRequestor;
import fr.umlv.desperados.student.DatabaseInformationListManager;
import fr.umlv.desperados.student.DatabaseStudentManager;
import fr.umlv.desperados.stylesheet.DatabaseStyleSheetManager;
import fr.umlv.desperados.util.Constants;

public class InitManagersPlugin implements PlugIn {

	private StrutsDatabaseRequestor strutsDatabaseRequestor;

	public void init(ActionServlet servlet, ModuleConfig config)
		throws javax.servlet.ServletException {

		System.err.println("\n\nlancement du pluggin\n\n");

		String absoltuePath = (servlet.getServletContext()).getRealPath("/");
		String prefix = config.getPrefix();
		String path = absoltuePath + prefix;

		try {
			// db requestor init
			Driver dDriverOracle =
				(java.sql.Driver) Class
					.forName("oracle.jdbc.driver.OracleDriver")
					.newInstance();
			DriverManager.registerDriver(dDriverOracle);
			Connection cCon =
				DriverManager.getConnection(
					"jdbc:oracle:thin:@hibiscus:1521:test",
					"desperados",
					"totofaitduvelo");
			strutsDatabaseRequestor = new StrutsDatabaseRequestor(cCon);

			// managers init
			DatabaseRdvManager databaseRdvManager =
				DatabaseRdvManager.getInstance(strutsDatabaseRequestor);

			DatabaseDiplomaManager databaseDiplomaManager =
				DatabaseDiplomaManager.getInstance(strutsDatabaseRequestor);

			DatabaseUserManager databaseUserManager =
				DatabaseUserManager.getInstance(strutsDatabaseRequestor);

			DatabaseStyleSheetManager databaseStyleSheetManager =
				DatabaseStyleSheetManager.getInstance(strutsDatabaseRequestor);

			DatabaseStudentManager databaseStudentManager =
				DatabaseStudentManager.getInstance(
					strutsDatabaseRequestor, path
						+ "/WEB-INF/src/fr/umlv/desperados/struts/studentDatabase.properties");
						
						
			DatabaseInformationListManager databaseInformationListmanager =
				DatabaseInformationListManager.getInstance(strutsDatabaseRequestor ,path
					+"/WEB-INF/src/fr/umlv/desperados/struts/Database.properties");
				
			PlanningConf planningConf = new PlanningConf(path + "/WEB-INF/planningConf.xml");

			// context visible manager init
			ServletContext context = servlet.getServletContext();
			context.setAttribute(Constants.RDV_DATABASE_KEY,
												databaseRdvManager);
			context.setAttribute(Constants.DIPLOMA_DATABASE_KEY,
												databaseDiplomaManager);
			context.setAttribute(Constants.USER_DATABASE_KEY,
												databaseUserManager);
			context.setAttribute(Constants.STUDENT_DATABASE_KEY,
												databaseStudentManager);
			context.setAttribute(Constants.STYLESHEET_DATABASE_KEY,
												databaseStyleSheetManager);
			context.setAttribute(Constants.INFORMATION_DATABASE_KEY,  databaseInformationListmanager);
												
			context.setAttribute(
				Constants.PLANNING_CONF_DATABASE_KEY,
				planningConf);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (ParserConfigurationException e3) {
			e3.printStackTrace();
		} catch (SAXException e3) {
			e3.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.PlugIn#destroy()
	 */
	public void destroy() {
		if(strutsDatabaseRequestor != null) {
			strutsDatabaseRequestor.closeConnection();
		}
	}
}
