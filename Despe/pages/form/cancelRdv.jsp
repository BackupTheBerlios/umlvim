<%@ page contentType="text/html;charset=UTF-8" language="java" 
import ="java.util.*, fr.umlv.desperados.planning.DatabaseRdvManager"%>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>


<html:html>
<head>
<title> visualisation des jour dispo </title>
<html:base/>
</head>

<body>


Votre rendez-vous  sera annule.<br> 
Voulez effectuer cette action ?<br>

<html:link action="/cancel/rdv" >ok</html:link>

</body>
</html:html>
