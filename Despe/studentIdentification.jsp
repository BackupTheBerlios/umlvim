<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
<title>Menu utilisateur</title>
<html:base/>
</head>

<body>


<html:form action="/studentIdentification" >
<table border="0" width="100%">
  <tr>
    <th align="right">
      <font size=2>nom :</font>
    </th>
    <td align="left">
     <html:text property="nom" size="15" maxlength="20" value=""/><br>
   <td>
  </tr>
  
    <tr>
    <th align="right">
      <font size=2>prenom :</font>
    </th>
    <td align="left">
     <html:text property="prenom" size="15" maxlength="20" value=""/>
    </td>
  </tr>
  
     <tr>
    <th align="right">
      <font size=2>date de naissance :</font>
    </th>
    <td align="left">
     <html:text property="dateNaissance" size="10" maxlength="20" value="jj/mm/aaaa"/>
    </td>
  </tr>

  <tr>
    <td colspan="2" align="center">
      <html:submit value="Ok"/>
    </td>
  </tr>

</table>
</html:form>


</body>
</html:html>