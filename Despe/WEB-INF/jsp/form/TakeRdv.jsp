<%@ page contentType="text/html;charset=UTF-8" language="java" 
import ="java.util.*, fr.umlv.desperados.planning.DatabaseRdvManager,fr.umlv.desperados.util.Constants"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<html:errors/>

<app:checkIdent>
	<br> 
	<html:form action="/takeRdv" >
		Selectionnner le jour de rendez vous qui vous convient: 
		<html:select property="date">
<%
			DatabaseRdvManager databaseRdvManager = (DatabaseRdvManager)application.getAttribute(Constants.RDV_DATABASE_KEY);
			Date[] tabd= databaseRdvManager.getFreeDays(true);
			for( int i = 0 ; i < tabd.length  ; ++i ) {
				int day = tabd[i].getDate();
				int year =1900+tabd[i].getYear();
				int month = 1+tabd[i].getMonth();
				int hour = tabd[i].getHours();
				int min = tabd[i].getMinutes();
				String date = day+"/"+month+"/"+year+" "+hour+":"+min;
				out.println("<option value=\""+date+"\">"+date+"</option>");
			}
 %> 
		</html:select> 
		<br><html:submit value="ok"/>
	</html:form>
</app:checkIdent>