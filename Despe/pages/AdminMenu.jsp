<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>

<app:checkLogon admin="true" page="">
	<table>
		<tr align="left">
			<th><bean:message key="title.admin.menu"/></th>
		</tr>
		<tr align="right">
			<td width="120">
				<html:link action="/editUser.do?action=create">
					<bean:message key="menu.admin.adduser"/>
				</html:link>
			</td>
		</tr>
		<tr align="right">
			<td width="120">
				<html:link action="/search.do?type=user">
					<bean:message key="menu.admin.searchuser"/>
				</html:link>
			</td>
		</tr>
		<tr align="right">
			<td width="120">
				<html:link action="/listStyleSheet">
					<bean:message key="menu.admin.stylesheet"/>
				</html:link>
			</td>
		</tr>
	</table>
</app:checkLogon>

<jsp:include page="UserMenu.jsp" />