<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>

<app:checkLogon admin="true">

	<h1>
		<bean:message key="title.admin.searchuser" />
	</h1>

	<html:errors property="database" />
	<html:errors property="choice" />
	<html:form action="/search/user">
		<table>
			<tr>
				<td colspan="3" align="center">
					<bean:message key="prompt.searchuser.by" />
				</td>
			</tr>
			<!-- LOGIN -->
			<tr>
				<td> <html:checkbox property="byLogin" value="true" /> </td>
				<th align="right"> <bean:message key="prompt.user.login"/> : </th>
				<td align="left"> <html:text property="login" size="10" maxlength="8"/> </td>
				<td> <html:errors property="login" /> </td>
			</tr>

			<!-- NAME -->
			<tr>
				<td> <html:checkbox property="byName" value="true" /> </td>
				<th align="right"> <bean:message key="prompt.user.name"/> : </th>
				<td align="left"> <html:text property="name" size="15"/> </td>
				<td> <html:errors property="name" /> </td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<html:submit> <bean:message key="button.search" /> </html:submit>
				</td>
			</tr>
		</table>
	</html:form>

	<bean:parameter id="offset" name="start" value="10" />
	<bean:parameter id="lenght" name="size" value="10" />
	<logic:present name="userlist">
		<table width="100%">
			<tr>
				<th> <bean:message key="prompt.user.login" /> </th>
				<th> <bean:message key="prompt.user.firstname" /> </th>
				<th> <bean:message key="prompt.user.name" /> </th>
			</tr>
				<%! boolean b = true; %>
				<logic:iterate name="userlist" length="<%=lenght%>" offset="<%=offset%>"
							id="oneuser" type="fr.umlv.desperados.account.User">
					<% b = !b; %>
					<tr bgcolor="<%= b?"#945da0":"#945da8" %>">
						<td align="center">
							<bean:write name="oneuser" property="login" />
						</td>
						<td align="center">
							<bean:write name="oneuser" property="name" />
						</td>
						<td align="center">
							<bean:write name="oneuser" property="firstname" />
						</td>
						<td align="right">
							<html:link action="edit/user?action=edit"
										paramId="login" paramName="oneuser" paramProperty="login" >
								<bean:message key="link.admin.edituser" />
							</html:link>
							<html:link action="edit/user?action=delete"
										paramId="login" paramName="oneuser" paramProperty="login" >
								<bean:message key="link.admin.deleteuser" />
							</html:link>
						</td>
					</tr>
				</logic:iterate>
		</table>
		
	</logic:present>

</app:checkLogon>