<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
<title>Menu utilisateur</title>
<html:base/>
</head>

<body>


<html:form action="/userLogon" >
<table border="0" width="100%">
  <tr>
    <th align="right">
      <font size=2>login :</font>
    </th>
    <td align="left">
     <html:text property="login" size="10" maxlength="20" value=""/>
    </td>
  </tr>

  <tr>
    <th align="right">
      <font size=2>password:</font>
    </th>
    <td align="left">
      <html:password property="password" size="10" maxlength="20" redisplay="false"/>
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