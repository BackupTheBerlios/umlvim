<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:errors property="database" />
<html:form action="/userLogon" focus="name">
	<table>
		<tr>
			<th> <bean:message key="prompt.student.name" /> : </th>
			<td> <html:text property="name" size="15" /> </td>
			<td> <html:errors property="name" /> </td>
			<td width="20">  </td>
			<th> <bean:message key="prompt.student.firstname" /> : </th>
			<td> <html:text property="firstname" size="15" /> </td>
			<td> <html:errors property="firstname" /> </td>
		</tr>
		<tr>
			<th> <bean:message key="prompt.student.birthday" /> : </th>
			<td> <html:text property="birthday" size="15" maxlength="10" /> </td>
			<td> <html:errors property="birthday" /> </td>
		</tr>
		<tr>
			<td> <html:submit> <bean:message key="button.submit" /> </html:submit> </td>
			<td> <html:cancel> <bean:message key="button.cancel" /> </html:cancel>
				&nbsp; <html:reset> <bean:message key="button.reset" /> </html:reset> </td>
		</tr>
	</table>
</html:form>
