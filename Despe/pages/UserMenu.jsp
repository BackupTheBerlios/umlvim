<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<app:checkLogon page="">
	<table width="100%">
		<tr>
			<th align="left" valign="bottom">
				<bean:message key="title.user.menu"/>
			</th>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/addStudent">
					<bean:message key="menu.user.addstudent"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/search?type=student">
					<bean:message key="menu.user.searchstudent"/>
				</html:link>
			</td>
		</tr>
		<tr align="right">
			<td width="120">
				<html:link action="/confPlanning">
					<bean:message key="planning.setup.conf" />
				</html:link>
			</td>
		</tr>
		<tr align="right">
			<td width="120">
				<html:link action="/stats/prepare">
					<bean:message key="menu.user.stats" />
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/userLogoff">
					<bean:message key="link.logoff" />
				</html:link>
			</td>
		</tr>

	</table>
</app:checkLogon>
