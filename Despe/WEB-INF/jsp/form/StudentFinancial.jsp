<%@ page import="java.util.Map" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<app:checkIdent>
	<h1>	<bean:message key="title.student.edit" />	</h1>
	<br>
<html:form action="/save/file/financial">
	<table width="100%">
		<tr>
			<th align=left>
				<bean:message key="prompt.student.edit.financialAssistance"/><br/>
			</th>
		</tr>
		<tr>
			<td align=center>

				<html:select property="financialAssistance">
					<logic:iterate name="financialAssistanceList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
				</td>
		</tr>
		<tr>
			<th align=left>
				<bean:message key="prompt.student.edit.purse"/><br/>
			</th>
		</tr>
		<tr>
			<td align=center>

				<html:select property="purse">
					<logic:iterate name="purseList" id="entry"
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