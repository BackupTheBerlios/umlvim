<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
<title>Ajout d'un étudiant</title>
<html:base/>
</head>

<body>

<h1>
		<bean:message key="title.student.add" />
</h1>

<html:form action="/add/student">

	<table>
		<tr>
			<th align="right"> <bean:message key="prompt.student.patronymicName"/> : </th>
			<td align="left" valign="bottom">
			<html:text property="patronymicName" size="15" value="" />
			</td>
			<td><html:errors property="patronymicName"/></td>
		</tr>
		<tr>
			<th align="right"> <bean:message key="prompt.student.firstname1"/> : </th>
			<td align="left" valign="bottom">
			<html:text property="firstname1" size="15" value="" />
			</td>
			<td><html:errors property="firstname1"/></td>
		</tr>
			<tr>
			<th align="right"> <bean:message key="prompt.student.birthday"/> : </th>
			<td align="left" valign="bottom">
			<html:text property="birthday" size="10" value ="" maxlength="10"/>
			</td>
				<td><html:errors property="birthday"/></td>
		</tr>
		<tr>
			<td align="right"> <html:submit/> </td>
			<td align="left"> <html:reset/> </td>
		</tr>
	</table>
   </html:form>

</body>
</html:html>