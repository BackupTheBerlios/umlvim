<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>

<app:checkLogon>

	<h1>
		<bean:message key="title.user.searchstudent" />
	</h1>

	<html:errors property="database" />
	<html:errors property="choice" />
	<html:form action="/search/student">
		<table>
			<tr>
				<td colspan="3" align="center">
					<bean:message key="prompt.searchuser.by" />
				</td>
			</tr>

			<!-- INE -->
			<tr>
				<td> <html:checkbox property="byIne" value="true" /> </td>
				<th align="right"> <bean:message key="prompt.student.ine"/> : </th>
				<td align="left"> <html:text property="ine" size="15" /> </td>
				<td> <html:errors property="ine" /> </td>
			</tr>

			<!-- NAME -->
			<tr>
				<td> <html:checkbox property="byName" value="true" /> </td>
				<th align="right"> <bean:message key="prompt.student.name" /> : </th>
				<td align="left"> <html:text property="name" size="15" /> </td>
				<td> <html:errors property="name" /> </td>
			</tr>

			<!-- FIRSTNAME -->
			<tr>
				<td> <html:checkbox property="byFirstname" value="true" /> </td>
				<th align="right"> <bean:message key="prompt.student.firstname"/> : </th>
				<td align="left"> <html:text property="firstname" size="15" /> </td>
				<td> <html:errors property="firstname" /> </td>
			</tr>

			<!-- DIPLOMA -->
			<tr>
				<td> <html:checkbox property="byDiploma" value="true" /> </td>
				<th align="right"> <bean:message key="prompt.student.diploma"/> : </th>
				<td align="left"> <!-- ###########
				LISTE DEROULANTE DES DIPLOMES
				################################### --> </td>
				<td> <html:errors property="diploma" /> </td>
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
	<logic:present name="studentlist">
		<table width="100%">
			<tr>
				<th> <bean:message key="prompt.user.ine" /> </th>
				<th> <bean:message key="prompt.user.firstname" /> </th>
				<th> <bean:message key="prompt.user.name" /> </th>
				<th> <bean:message key="prompt.user.birthday" /> </th>
				<th> <bean:message key="prompt.user.diploma" /> </th>
			</tr>
				<%! boolean b = true; %>
				<logic:iterate name="userlist" length="<%=lenght%>" offset="<%=offset%>"
							id="oneuser" type="fr.umlv.desperados.account.User">
					<% b = !b; %>
					<tr bgcolor="<%= b?"#945da0":"#945da8" %>">
						<td align="center">
							<bean:write name="oneuser" property="ine" />
						</td>
						<td align="center">
							<bean:write name="oneuser" property="name" />
						</td>
						<td align="center">
							<bean:write name="oneuser" property="firstname" />
						</td>
						<td align="center">
							<bean:write name="oneuser" property="birthday" />
						</td>
						<td align="center">
							<bean:write name="oneuser" property="diploma" />
						</td>
						<td align="right">
							<html:link action="edit/student?action=edit"
										paramId="id" paramName="onestudent" paramProperty="id" >
								<bean:message key="link.user.editstudent" />
							</html:link>
							<html:link action="edit/student?action=delete"
										paramId="id" paramName="onestudent" paramProperty="id" >
								<bean:message key="link.user.deletestudent" />
							</html:link>
						</td>
					</tr>
				</logic:iterate>
		</table>
		
	</logic:present>

</app:checkLogon>