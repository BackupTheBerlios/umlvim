<%@ page contentType="text/html;charset=UTF-8" language="java" 
import ="java.util.*, fr.umlv.desperados.planning.DatabaseRdvManager,fr.umlv.desperados.util.Constants"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>


<html:html>
<head>
<title> visualisation des jour dispo </title>
<html:base/>
</head>

<body>

<html:errors/>

<br> 
<logic:present name="dateList">
<html:form action="/list/hour" >
Selectionnner le jour de rendez vous qui vous convient: 
	
			<html:select property="day">
						<logic:iterate name="dateList" id="onedate"
											type="java.lang.String">
							<option value="<%= onedate%>"><%= onedate%>
							
							</option>
						</logic:iterate>
					</html:select>
	 <br><html:submit value="ok"/>
 	
 </html:form>
  </logic:present>
<logic:present name="hourList">
	<html:form action="/take/rdv" >
	Selectionnner l'heure qui vous convient pour ce jour: 
	
			<html:select property="hour">
						<logic:iterate name="hourList" id="onehour"
											type="java.lang.String">
							<option value="<%= onehour %>"><%= onehour %>
							
							</option>
						</logic:iterate>
					</html:select>
		 <br><html:submit value="ok"/>
 	 </html:form>
 </logic:present>
 </body>
</html:html>
