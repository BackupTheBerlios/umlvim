<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<h1>
	<logic:equal name="UserForm" scope="request"
				 property="action" value="create">
		<bean:message key="title.user.create" />
	</logic:equal>
	<logic:equal name="UserForm" scope="request"
				 property="action" value="edit">
		<bean:message key="title.user.edit" arg0="<%= (String)request.getParameter("login") %>" />
	</logic:equal>
</h1>

<html:form action="/saveUser">
	<html:hidden property="action"/>
	<table>
		<logic:equal name="UserForm" scope="request"
					 property="action" value="edit">
			<tr>
				<th align="right"> <bean:message key="prompt.user.login"/> : </th>
				<td align="left"> <bean:write name="UserForm" property="login"/> </td>
			</tr>
			<html:hidden property="login"/>
		</logic:equal>
		<tr>
			<th align="right"> <bean:message key="prompt.user.name"/> : </th>
			<td align="left"> <html:text property="name" size="15"/> </td>
			<td align="left"> <html:errors property="name"/> </td>
		</tr>
		<tr>
			<th align="right"> <bean:message key="prompt.user.firstname"/> : </th>
			<td align="left"> <html:text property="firstname" size="15"/> </td>
			<td align="left"> <html:errors property="firstname"/> </td>
		</tr>
		<tr>
			<th align="right"> <bean:message key="prompt.user.email"/> : </th>
			<td align="left"> <html:text property="email" size="25"/> </td>
			<td align="left"> <html:errors property="email"/> </td>
		</tr>
		<tr>
			<td align="right"> <html:checkbox property="admin"/> </td>
			<th align="left"> <bean:message key="prompt.user.isadmin"/> </th>
		</tr>
		<tr>
			<td align="right"> <html:checkbox property="generatePassword"/> </td>
			<td align="left"> <bean:message key="prompt.user.generatePassword"/> </td>
		</tr>
		<tr>
			<td align="right"> <html:submit/> </td>
			<td align="left"> <html:cancel/>&nbsp;<html:reset/> </td>
		</tr>
	</table>
</html:form>