<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<bean:message key="prompt.user.chpass.sendbymail" />
<html:form action="lostPassword">
	<html:hidden property="password" value="password" />
	<table>
		<tr>
			<th> <bean:message key="prompt.user.login"/> : </th>
			<td> <html:text property="login" size="10" maxlength="8"/> </td>
			<td> <html:errors property="login"/> </td>
		</tr>
		<tr>
			<td align="right"> <html:submit> <bean:message key="button.submit"/> </html:submit> </td>
			<td align="left"> <html:cancel> <bean:message key="button.cancel"/> </html:cancel> </td>
		</tr>
	</table>
</html:form>