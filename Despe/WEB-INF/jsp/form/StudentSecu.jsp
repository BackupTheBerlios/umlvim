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
			<th align=left>
				<bean:message key="prompt.student.edit.affiliation"/>
				<bean:message key="prompt.student.edit.affiliation.comment"/>
			</th>
		</tr>
		<tr>	
			<td>
				<table width="95%" align=center border=1>
				<tr>
				<td>
				<bean:message key="prompt.student.edit.affiliation.affiliation"/><br/>
				<font size=-2><bean:message key="prompt.student.edit.affiliation.affiliation.comment"/></font><br/>
				<html:select property="affiliation">
					<logic:iterate name="socialSecurityAffList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
				</td>
				<td>
				<bean:message key="prompt.student.edit.affiliation.nonAffiliation"/><br/>
				<font size=-2><bean:message key="prompt.student.edit.affiliation.nonAffiliation.comment"/></font><br/>
				<html:select property="nonAffiliation">
					<logic:iterate name="socialSecurityNonAffList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
				</td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
			<th align=left>
				<bean:message key="prompt.student.edit.centerPayment"/><br/>
			</th>
		</tr>
		<tr>
			<td align=center>

				<html:select property="centerPayment">
					<logic:iterate name="centerPaymentList" id="entry"
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
				<bean:message key="prompt.student.edit.mutualInsuranceCompany"/><br/>
			</th>
		</tr>
		<tr>
			<td align=center>

				<html:select property="mutualInsuranceCompany">
					<logic:iterate name="mutualInsuranceCompanyList" id="entry"
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