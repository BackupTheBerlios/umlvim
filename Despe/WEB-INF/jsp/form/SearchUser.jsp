<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<app:checkLogon admin="true">

	<h1>
		<bean:message key="title.admin.searchuser" />
	</h1>

	<html:errors property="database" />
	<html:errors property="choice" />
	<html:form action="/searchuser">
		<table>
			<tr>
				<td colspan="3" align="center">
					<bean:message key="prompt.searchuser.by" />
				</td>
			</tr>
			<!-- LOGIN -->
			<tr>
				<th align="right"> <bean:message key="prompt.user.login"/> : </th>
				<td align="left"> <html:text property="login" size="10" maxlength="8"/> </td>
				<td> <html:errors property="login" /> </td>
			</tr>

			<!-- NAME -->
			<tr>
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

	<bean:parameter id="offset" name="start" value="0" />
	<bean:parameter id="lenght" name="size" value="10" />
	<logic:present name="userlist" scope="session">
		<table width="100%">
			<tr>
				<th> <bean:message key="prompt.user.login" /> </th>
				<th> <bean:message key="prompt.user.name" /> </th>
				<th> <bean:message key="prompt.user.firstname" /> </th>
			</tr>
				<%! boolean b = true; %>
				<logic:iterate name="userlist" length="<%=lenght%>" offset="<%=offset%>"
							id="oneuser" type="fr.umlv.desperados.account.User" scope="session">
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

		<table>
			<tr>
				<td>
					<logic:greaterThan parameter="start" value="0">
						<html:link action="search/user">
							<bean:message key="button.previous"/>
						</html:link>
					</logic:greaterThan>
				</td>
				<td>
					<jsp:useBean id="userlist" type="java.util.List" scope="session"/>
					<logic:lessThan parameter="offset" value="<%= new Integer(userlist.size() - new Integer(lenght).intValue()).toString() %>">
						<html:link action="search/user">
							<bean:message key="button.next"/>
						</html:link>
					</logic:lessThan>
				</td>
			</tr>
		</table>

	</logic:present>

</app:checkLogon>