<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
<title>Menu utilisateur</title>
<html:base/>
</head>

<body>


<html:form action="/setupConf" >
<table border="0" width="100%">
  
    
    periode :</font><BR>
     Du <html:text property="fromDate" size="10" maxlength="20" value=""/>
     au <html:text property="toDate" size="10" maxlength="20" value=""/><BR><br>
    
    horaire :<BR>
  	Matin :	  de <html:text property="beginAM" size="10" maxlength="20" value=""/>
         a <html:text property="endAm" size="10" maxlength="20" value=""/><br>
  	aprem :	  de <html:text property="beginPM" size="10" maxlength="20" value=""/>
         a <html:text property="endPM" size="10" maxlength="20" value=""/>
   <br><br>
   
   Duree du rendez vous:<br>
   Matin <html:text property="rdvDurationAM" size="10" maxlength="20" value=""/>             
   Aprem <html:text property="rdvDurationPM" size="10" maxlength="20" value=""/><br><br>
   
   nombre de correcteur: <br>
   Matin  <html:text property="nbCorrectorAM" size="10" maxlength="20" value=""/>
   Aprem <html:text property="nbCorrectorPM" size="10" maxlength="20" value=""/>
  
  <br><br>        
 	Nombre d etudiants ravel:<br>
   Matin  <html:text property="nbRavelAM" size="10" maxlength="20" value=""/>
   Aprem <html:text property="nbRavelPM" size="10" maxlength="20" value=""/>
 	
   <br> <html:submit value="Ok"/>
   
</table>
</html:form>



</body>
</html:html>