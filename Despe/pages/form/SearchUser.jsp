<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>

<app:checkLogon admin="true">

	<h1>
		<bean:message key="title.admin.searchuser" />
	</h1>

	<html:form action="/searchUser">
		<table>
			<tr>
				<td colspan="3" align="center">
					<bean:message key="prompt.searchuser.by" />
				</td>
			</tr>
			<!-- LOGIN -->
			<tr>
				<td> <html:checkbox property="byLogin" value="true" /> </td>
				<th align="right"> <bean:message key="prompt.user.login"/> : </th>
				<td align="left"> <html:text property="login" size="10" maxlength="8"/> </td>
				<td> <html:errors property="login" /> </td>
			</tr>

			<!-- NAME -->
			<tr>
				<td> <html:checkbox property="byName" value="true" /> </td>
				<th align="right"> <bean:message key="prompt.user.name"/> : </th>
				<td align="left"> <html:text property="name" size="15"/> </td>
				<td> <html:errors property="name" /> </td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<html:submit> <bean:message key="button.search" /> </html:submit>
				</td>
			</tr>
		</table>
	</html:form>
	<html:errors property="database" />

</app:checkLogon>