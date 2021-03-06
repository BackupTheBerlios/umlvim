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

	<%-- AFFICHAGE DU FORMULAIRE --%>

	<html:form action="/searchstudent">
		<table>
			<tr>
				<td colspan="3" align="center">
					<bean:message key="prompt.searchuser.by" />
				</td>
			</tr>

			<%-- INE --%>
			<tr>
				<th align="right"> <bean:message key="prompt.student.ine"/> : </th>
				<td align="left"> <html:text property="ine" size="15" /> </td>
				<td> <html:errors property="ine" /> </td>
			</tr>

			<%-- NAME --%>
			<tr>
				<th align="right"> <bean:message key="prompt.student.name" /> : </th>
				<td align="left"> <html:text property="name" size="15" /> </td>
				<td> <html:errors property="name" /> </td>
			</tr>

			<%-- FIRSTNAME --%>
			<tr>
				<th align="right"> <bean:message key="prompt.student.firstname"/> : </th>
				<td align="left"> <html:text property="firstname" size="15" /> </td>
				<td> <html:errors property="firstname" /> </td>
			</tr>

			<%-- DIPLOMA --%>
			<tr>
				<th align="right"> <bean:message key="prompt.student.diploma"/> : </th>
				<td align="left"> 		
					<html:select property="diplomaId">
						<option value=0>Tous les dipl�mes</option>
						<logic:present name="diplomaList">
							<%! String selected = null; %>
							<logic:iterate name="diplomaList" id="diploma"
													type="fr.umlv.desperados.diploma.Diploma">
								<% selected = null; %>
								<logic:present name="SearchStudentForm" scope="request">
									<logic:equal name="SearchStudentForm" scope="request"
														property="diplomaId" value="<%= diploma.getId() %>">
										<% selected = "SELECTED"; %>
									</logic:equal>
								</logic:present>
								<option value="<bean:write name="diploma" property="id" />" <%= selected %> >
									<bean:write name="diploma" property="name" />
								</option>
							</logic:iterate>
						</logic:present>
					</html:select>
				</td>
				<td> <html:errors property="diploma" /> </td>
			</tr>

			<tr>
				<td colspan="3" align="right">
					<html:submit> <bean:message key="button.search" /> </html:submit>
				</td>
			</tr>
		</table>
	</html:form>


	<%-- AFFICHAGE DES R�SULTATS --%>

	<logic:present name="studentlist" scope="session">
		<bean:parameter id="offset" name="start" value="0" />
		<bean:parameter id="lenght" name="size" value="10" />
		<table  border="1" width="100%">
			<tr>
				<th> <bean:message key="prompt.student.ine" /> </th>
				<th> <bean:message key="prompt.student.firstname" /> </th>
				<th> <bean:message key="prompt.student.name" /> </th>
				<th> <bean:message key="prompt.student.birthday" /> </th>
				<th> <bean:message key="prompt.student.diploma" /> </th>
			</tr>
			<%! boolean b = true; %>

			<logic:iterate name="studentlist" length="<%=lenght%>" offset="<%=offset%>"
						id="onestudent" type="fr.umlv.desperados.student.Student" scope="session">
				<% b = !b; %>

				<tr bgcolor="<%= b?"#945da0":"#945da8" %>">
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
						<logic:present name="diplomaList">
							<logic:iterate name="diplomaList" id="diploma"
													type="fr.umlv.desperados.diploma.Diploma">
								<logic:equal name="diploma" scope="page" property="id"
													value="<%= new Integer(onestudent.getMLVDiplomaId()).toString() %>">
									<bean:write name="diploma" property="name" />
								</logic:equal>
							</logic:iterate>
						</logic:present>
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

		<table>
			<tr>
				<td>
					<logic:greaterThan parameter="start" value="0">
						<html:link action="<%= "search/student?start=" + (new Integer(offset).intValue() - new Integer(lenght).intValue()) %>" >
							<bean:message key="button.previous"/>
						</html:link>
					</logic:greaterThan>
				</td>
				<td>
					<jsp:useBean id="studentlist" type="java.util.List" scope="session"/>
					<logic:lessThan parameter="start" value="<%= new Integer(studentlist.size() - new Integer(lenght).intValue()).toString() %>">
						<html:link action="<%= "search/student?start=" + (new Integer(offset).intValue() + new Integer(lenght).intValue()) %>" >
							<bean:message key="button.next"/>
						</html:link>
					</logic:lessThan>
				</td>
			</tr>
		</table>
	</logic:present>

</app:checkLogon>