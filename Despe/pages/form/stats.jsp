<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>

<app:checkLogon>
<html:form action="/stats">
	<table width="100%">
		<tr width="100%" colspan="4">
			<th align="left"><bean:message key="title.stats"/></th>
		</tr>
		<tr>
			<th align="left"><bean:message key="prompt.stats.periode"/></th>
			<td>du 
					<html:select property="dayStartId">
						<logic:iterate name="daysList" id="dayStart"
											type="java.lang.String">
								<option value="<bean:write name="dayStart"/>">
									<bean:write name="dayStart"/>
								</option>
						</logic:iterate>
					</html:select> / 
					<html:select property="monthStartId">
						<logic:iterate name="monthsList" id="monthStart"
											type="java.lang.String">
								<option value="<bean:write name="monthStart"/>">
									<bean:write name="monthStart"/>
								</option>
						</logic:iterate>
					</html:select>
			</td>
			<td>au 
					<html:select property="dayEndId">
						<logic:iterate name="daysList" id="dayEnd"
											type="java.lang.String">
								<option value="<bean:write name="dayEnd"/>">
									<bean:write name="dayEnd"/>
								</option>
						</logic:iterate>
					</html:select> / 
					<html:select property="monthEndId">
						<logic:iterate name="monthsList" id="monthEnd"
											type="java.lang.String">
								<option value="<bean:write name="monthEnd"/>">
									<bean:write name="monthEnd"/>
								</option>
						</logic:iterate>
					</html:select>
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<th align="left"> <bean:message key="prompt.stats.section"/></th>
			<td>
				<html:select property="diplomaId">
					<logic:iterate name="diplomaList" id="diploma"
											type="fr.umlv.desperados.diploma.Diploma">
						<option value="<bean:write name="diploma" property="id" />">
							<bean:write name="diploma" property="name" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr width="100%" colspan="4">
			<td></td>
			<td align="left">
				<html:submit><bean:message key="button.submit"/></html:submit>
				<html:cancel><bean:message key="button.cancel"/></html:cancel>
			</td>
		</tr>
	</table>
</html:form>
</app:checkLogon>