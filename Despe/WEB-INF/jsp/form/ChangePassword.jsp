<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<app:checkLogon>
	<bean:message key="prompt.user.chpass.confirm" />
	<html:form action="changePassword">
		<table>
			<tr>
				<td> <html:submit/> </td>
				<td> <html:cancel/> </td>
			</tr>
		</table>
	</html:form>
</app:checkLogon>