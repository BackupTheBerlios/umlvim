<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<app:checkLogon>

	<h1>
		<bean:message key="title.user.searchstudent" />
	</h1>

	<html:errors property="database" />
	<html:errors property="choice" />
	<html:form action="/search/student?type=student">
		<table>
			<tr>
				<td colspan="3" align="center">
					<bean:message key="prompt.searchuser.by" />
				</td>
			</tr>

			<!-- INE -->
			<tr>
				<th align="right"> <bean:message key="prompt.student.ine"/> : </th>
				<td align="left"> <html:text property="ine" size="15" /> </td>
				<td> <html:errors property="ine" /> </td>
			</tr>

			<!-- NAME -->
			<tr>
				<th align="right"> <bean:message key="prompt.student.name" /> : </th>
				<td align="left"> <html:text property="name" size="15" /> </td>
				<td> <html:errors property="name" /> </td>
			</tr>

			<!-- FIRSTNAME -->
			<tr>
				<th align="right"> <bean:message key="prompt.student.firstname"/> : </th>
				<td align="left"> <html:text property="firstname" size="15" /> </td>
				<td> <html:errors property="firstname" /> </td>
			</tr>

			<!-- DIPLOMA -->
			<tr>
				<th align="right"> <bean:message key="prompt.student.diploma"/> : </th>
				<td align="left"> 		
					<html:select property="diploma">
					<option value=0 selected>Pas de critère</option> 
						<logic:iterate name="diplomaList" id="diploma"
											type="fr.umlv.desperados.diploma.Diploma">
							<option value="<bean:write name="diploma" property="id" />">
								<bean:write name="diploma" property="name" />
							</option>
						</logic:iterate>
					</html:select></td>
				<td> <html:errors property="diploma" /> </td>
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
	<logic:present name="studentlist">
		<table width="100%">
			<tr>
				<th> <bean:message key="prompt.student.ine" /> </th>
				<th> <bean:message key="prompt.student.firstname" /> </th>
				<th> <bean:message key="prompt.student.name" /> </th>
				<th> <bean:message key="prompt.student.birthday" /> </th>
				<th> <bean:message key="prompt.student.diploma" /> </th>
			</tr>
				<%! boolean b = true; %>
				
				<logic:iterate name="studentlist" length="<%=lenght%>" offset="<%=offset%>"
							id="onestudent" type="fr.umlv.desperados.student.Student">
					<% b = !b; %>
					
					<tr >
						<td align="center">
							<bean:write name="onestudent" property="ine" />
						</td>
							<td align="center">
							<bean:write name="onestudent" property="firstname1" />
						</td>
						<td align="center">
							<bean:write name="onestudent" property="patronymicName" />
						</td>
						<td align="center">
							<bean:write name="onestudent" property="birthday" />
						</td>
						<td align="center">
											<logic:iterate name="diplomaList" id="diploma"
																type="fr.umlv.desperados.diploma.Diploma">
												<logic:equal name="diploma" scope="page"
															property="id" value="<%= new Integer(onestudent.getMLVDiplomaId()).toString() %>">
													<bean:write name="diploma" property="name" />
												</logic:equal>
											</logic:iterate>
						</td>
					<td align="right">
							<html:link action="/edit/student?action=edit"
										paramId="id" paramName="onestudent" paramProperty="id">
								<bean:message key="link.user.editstudent" />
							</html:link>
							<html:link action="/edit/student?action=delete"
										paramId="id" paramName="onestudent" paramProperty="id">
							<bean:message key="link.user.deletestudent" />
							</html:link>
						</td> 
					</tr>
				</logic:iterate>
		</table>
		
	</logic:present>

</app:checkLogon>