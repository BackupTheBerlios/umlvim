<%@ page import="java.util.Map" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<app:checkIdent>
	<h1>	<bean:message key="title.student.edit" />	</h1>
	<br>
<html:form action="/save/student">
	<table width="100%">
		<tr>
			<th align="left">
				<bean:message key="prompt.student.edit.affiliation"/><br/>
				<bean:message key="prompt.student.edit.affiliation.comment"/>
			</th>
			<td>
				<html:select property="affiliation">
					<logic:iterate name="socialSecurityAffList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td align="center"  colspan="4">
				<html:submit><bean:message key="button.submit"/></html:submit>
				<html:cancel><bean:message key="button.cancel"/></html:cancel>
			</td>
		</tr>
	</table>
</html:form>
</app:checkIdent >