<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app"%>

<app:checkLogon admin="true" page="">
	<table width="100%">
		<tr>
			<th align="left" valign="bottom">
				<bean:message key="title.admin.menu"/>
			</th>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/edit/user?action=create">
					<bean:message key="menu.admin.adduser"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/search/user">
					<bean:message key="menu.admin.searchuser"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/list/styleSheet">
					<bean:message key="menu.admin.stylesheet"/>
				</html:link>
			</td>
		</tr>
	</table>
</app:checkLogon>
