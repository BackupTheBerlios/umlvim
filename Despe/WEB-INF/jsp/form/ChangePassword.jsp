<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<app:checkLogon>
	<bean:message key="prompt.user.chpass.confirm" />
	<html:form action="changePassword">
		<table>
			<tr>
				<td> <html:submit> <bean:message key="button.confirm"/> </html:submit> </td>
				<td> <html:cancel> <bean:message key="button.cancel"/> </html:cancel> </td>
			</tr>
		</table>
	</html:form>
</app:checkLogon>