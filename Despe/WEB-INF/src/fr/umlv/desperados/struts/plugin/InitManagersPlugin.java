//Source file: C:\\DOCUMENTS AND SETTINGS\\NCUVELIE\\MES DOCUMENTS\\GÉNIE LOG\\SRC\\fr\\umlv\\desperados\\struts\\plugin\\InitManagersPlugin.java

package fr.umlv.desperados.struts.plugin;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
//import javax.sql.DataSource;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
//import org.apache.struts.action.Action;

import fr.umlv.desperados.account.DatabaseUserManager;
import fr.umlv.desperados.planning.DatabaseRdvManager;
import fr.umlv.desperados.struts.database.StrutsDatabaseRequestor;
import fr.umlv.desperados.util.Constants;
public class InitManagersPlugin implements PlugIn {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.PlugIn#init(org.apache.struts.action.ActionServlet, org.apache.struts.config.ModuleConfig)
	 */
	public InitManagersPlugin() {
	}

	public StrutsDatabaseRequestor strutsDatabaseRequestor;
	public DatabaseRdvManager databaseRdvManager;
	public DatabaseUserManager databaseUserManager;

	public void init(ActionServlet servlet, ModuleConfig config)
		throws javax.servlet.ServletException {

		System.err.println("\n\nlancement du pluggin\n\n");

		//ServletContext context=servlet.getServletContext();
		//DataSource datasource=(DataSource)context.getAttribute(Action.DATA_SOURCE_KEY);

		try {

			ServletContext context = servlet.getServletContext();

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
			databaseRdvManager =
				DatabaseRdvManager.getInstance(strutsDatabaseRequestor);
			databaseUserManager =
				DatabaseUserManager.getInstance(strutsDatabaseRequestor);

			// context visible manager init
			context.setAttribute(
				Constants.RDV_DATABASE_KEY,
				databaseRdvManager);
			context.setAttribute(
				Constants.USER_DATABASE_KEY,
				databaseUserManager);

		} catch (ClassNotFoundException e) {
			System.err.println("\n\\nclasse not found exceptionn\n\n");
			e.printStackTrace();
		} catch (InstantiationException e1) {
			System.err.println("\n\nInstantiationException\n\n");
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			System.err.println("IllegalException");
			e1.printStackTrace();
		} catch (SQLException e2) {
			System.err.println("\n\nSQLException\n\n");
			e2.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.PlugIn#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

		strutsDatabaseRequestor.closeConnection();

	}
}
