<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>

<app:checkLogon page="">
	<table>
		<tr align="left">
			<th><bean:message key="title.user.menu"/></th>
		</tr>
		<tr align="right">
			<td width="120">
				<html:link action="/editUser.do?action=create">
					<bean:message key="menu.user.addstudent"/>
				</html:link>
			</td>
		</tr>
		<tr align="right">
			<td width="120">
				<bean:message key="menu.user.searchstudent"/>
			</td>
		</tr>
		<tr align="right">
			<td width="120">
				<html:link action="/userLogoff.do">
					<bean:message key="link.logoff" />
				</html:link>
			</td>
		</tr>
	</table>
</app:checkLogon>
