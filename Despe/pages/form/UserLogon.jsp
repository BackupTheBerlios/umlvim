<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 

<html:errors property="database"/>
<html:form action="/userLogon" focus="login">
	<table>
		<tr>
			<th> <bean:message key="prompt.user.login"/> : </th>
			<td> <html:text property="login" size="10" maxlength="8"/> </td>
			<td> <html:errors property="login"/> </td>
		</tr>
		<tr>
			<th> <bean:message key="prompt.user.password"/> : </th>
			<td> <html:password property="password" size="10" maxlength="8"/> </td>
			<td> <html:errors property="password"/> </td>
		</tr>
		<tr>
			<td> <html:submit> <bean:message key="button.submit"/> </html:submit> </td>
			<td> <html:cancel> <bean:message key="button.cancel"/> </html:cancel>
				&nbsp; <html:reset> <bean:message key="button.reset"/> </html:reset> </td>
		</tr>
	</table>
</html:form>
