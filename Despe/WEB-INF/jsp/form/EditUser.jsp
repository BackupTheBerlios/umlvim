<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<html:errors/>

<h1>
	<logic:equal name="UserForm" scope="request"
				 property="action" value="create">
		<bean:message key="title.user.create" />
	</logic:equal>
	<logic:equal name="UserForm" scope="request"
				 property="action" value="edit">
		<bean:message key="title.user.edit" arg0="<%= (String)request.getParameter("login") %>" />
	</logic:equal>
	<logic:equal name="UserForm" scope="request"
				 property="action" value="view">
		<bean:message key="title.user.view" arg0="<%= (String)request.getParameter("login") %>" />
	</logic:equal>
	<logic:equal name="UserForm" scope="request"
				 property="action" value="delete">
		<bean:message key="title.user.delete" arg0="<%= (String)request.getParameter("login") %>" />
	</logic:equal>
</h1>

<app:checkLogon admin="true" page="">

	<html:form action="/save/user">
		<html:hidden property="action" />
		<table>

			<logic:equal name="UserForm" scope="request"
				 property="action" value="delete">
				<bean:message key="prompt.user.delete.comfirm" />
				<html:hidden property="login" />
			</logic:equal>

			<logic:notEqual name="UserForm" scope="request"
				 property="action" value="delete">

				<!-- LOGIN -->
				<logic:notEqual name="UserForm" scope="request"
							 property="action" value="create">
					<tr>
						<th align="right"> <bean:message key="prompt.user.login"/> : </th>
						<td align="left"> <bean:write name="UserForm" property="login"/> </td>
					</tr>
					<html:hidden property="login"/>
				</logic:notEqual>

				<!-- NAME -->
				<tr>
					<th align="right"> <bean:message key="prompt.user.name"/> : </th>
					<logic:equal name="UserForm" scope="request"
								 property="action" value="view">
						<td align="left"> <bean:write name="UserForm" property="name"/> </td>
					</logic:equal>
					<logic:notEqual name="UserForm" scope="request"
								 property="action" value="view">
						<td align="left"> <html:text property="name" size="15"/> </td>
						<td align="left"> <html:errors property="name"/> </td>
					</logic:notEqual>
				</tr>

				<!-- FIRSTNAME -->
				<tr>
					<th align="right"> <bean:message key="prompt.user.firstname"/> : </th>
					<logic:equal name="UserForm" scope="request"
								 property="action" value="view">
						<td align="left"> <bean:write name="UserForm" property="firstname"/> </td>
					</logic:equal>
					<logic:notEqual name="UserForm" scope="request"
								 property="action" value="view">
						<td align="left"> <html:text property="firstname" size="15"/> </td>
						<td align="left"> <html:errors property="firstname"/> </td>
					</logic:notEqual>
				</tr>

				<!-- MAIL -->
				<tr>
					<th align="right"> <bean:message key="prompt.user.email"/> : </th>
					<logic:equal name="UserForm" scope="request"
								 property="action" value="view">
						<td align="left"> <bean:write name="UserForm" property="email"/> </td>
					</logic:equal>
					<logic:notEqual name="UserForm" scope="request"
								 property="action" value="view">
						<td align="left"> <html:text property="email" size="25"/> </td>
						<td align="left"> <html:errors property="email"/> </td>
					</logic:notEqual>
				</tr>

				<!-- ADMIN -->
				<tr>
					<logic:equal name="UserForm" scope="request"
								 property="action" value="view">
						<logic:equal name="UserForm" scope="request"
									property="admin" value="true">
							<td colspan="2" align="center">
								<bean:message key="prompt.user.isadmin" arg0="<%= (String)request.getParameter("login") %>"/>
							</td>
						</logic:equal>
					</logic:equal>
					<logic:notEqual name="UserForm" scope="request"
								 property="action" value="view">
						<td align="right"> <html:checkbox property="admin"/> </td>
						<th align="left"> <bean:message key="prompt.user.admin"/> </th>
					</logic:notEqual>
				</tr>

				<!-- GENERATE NEW PASSWORD -->
				<tr>
					<logic:equal name="UserForm" scope="request"
								 property="action" value="edit">
						<td align="right"> <html:checkbox property="generatePassword"/> </td>
						<td align="left"> <bean:message key="prompt.user.generatePassword"/> </td>
					</logic:equal>
				</tr>

			</logic:notEqual> <!-- for action='delete' -->

			<!-- BUTTONS -->
			<tr>
				<logic:equal name="UserForm" scope="request"
							 property="action" value="view">
					<td align="right"> <html:submit> <bean:message key="link.admin.edituser"/> </html:submit> </td>
					<td align="left"> <html:submit> <bean:message key="link.admin.deleteuser"/> </html:submit> </td>
				</logic:equal>
				<logic:notEqual name="UserForm" scope="request"
							 property="action" value="view">
					<td align="right"> <html:submit/> </td>
					<td align="left"> <html:cancel/> </td>
				</logic:notEqual>
			</tr>

		</table>
	</html:form>
</app:checkLogon>