<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<html:html>
<head>
<title>Ajout d'un étudiant</title>
<html:base/>
</head>

<body>

<h1>
			<logic:equal name="StudentForm" scope="request"
				 property="action" value="create">
		<bean:message key="title.student.add" />
	</logic:equal>
	<logic:equal name="StudentForm" scope="request"
				 property="action" value="delete">
		<bean:message key="title.student.delete" />
	</logic:equal>              
</h1>

<html:form action="/save/student">
	<html:hidden property="action" />
	
	<logic:equal name="StudentForm" scope="request"
		 property="action" value="delete">
		<bean:message key="prompt.student.delete.comfirm"  arg0="<%=(String)request.getAttribute("name") %>"  arg1="<%=(String)request.getAttribute("firstname") %>" arg2="<%=(String)request.getAttribute("birthday") %>"/>
		<html:hidden property="id" />
			</logic:equal>

	
	
	<table>
			<logic:notEqual name="StudentForm" scope="request"
				 property="action" value="delete">
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
		</logic:notEqual> <!-- for action='delete' -->
		
		<tr>
			<logic:equal name="StudentForm" scope="request"
				 property="action" value="delete">	
			<td align="center"> <html:submit value="Supprimer"/> </td>
			</logic:equal>
			<logic:notEqual name="StudentForm" scope="request"
				 property="action" value="delete">	
			<td align="right"> <html:submit value="Ajouter"/> </td>
			<td align="left"> <html:reset/> </td>
			</logic:notEqual> 
		</tr>
	</table>
   </html:form>

</body>
</html:html>