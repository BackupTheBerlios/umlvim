<%@ page contentType="text/html;charset=UTF-8" language="java" 
import ="java.util.*, fr.umlv.desperados.planning.DatabaseRdvManager"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>


<html:html>
<head>
<title> visualisation des jour dispo </title>
<html:base/>
</head>

<body>

<html:errors/>

<br> 


<html:form action="/takeRdvAction" >
Selectionnner le jour de rendez vous qui vous convient: 
<html:select property="date">
<%
	DatabaseRdvManager databaseRdvManager = (DatabaseRdvManager)application.getAttribute("DATABASERDVMANAGER");
  
  	Date[] tabd= databaseRdvManager.getFreeDays(true);
   	   	
	for( int i = 0 ; i < tabd.length  ; ++i ){
	
		int day = tabd[i].getDay();
	 	int year = tabd[i].getYear();
	 	int month = tabd[i].getMonth();
	 	
	   String date = day+"/"+month+"/"+year;
 		out.println("<option value=\""+date+"\">"+date+"</option>");
 		
	  }
	  
 %> 
</html:select> 
 <br><html:submit value="ok"/>
 </html:form>


</body>
</html:html>