<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>

<app:checkLogon page="">
	<table border="1">
		<tr>
			<th> <bean:message key="title.user.menu" /> </th>
		</tr>
		<tr>
			<td width="120" valign="top">
				<html:link action="/editUser.do?action=create">
					<bean:message key="menu.user.addstudent"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td width="120" valign="top">
				<bean:message key="menu.user.searchstudent"/>
			</td>
		</tr>
		<tr>
			<td width="120" valign="top">
				<html:link action="/studentLogoff.do">déconnexion</html:link>
			</td>
		</tr>
	</table>
</app:checkLogon>
