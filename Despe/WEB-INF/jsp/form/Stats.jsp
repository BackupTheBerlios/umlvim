<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app"%>

<app:checkLogon>
	<h1>	<bean:message key="title.stats" />	</h1>
	<br>
<html:form action="/stats">
	<table width="100%">
		<tr>
			<th align="left"><bean:message key="prompt.stats.periode"/></th>
			<td>
				du <html:text property="dayStart" size="10" maxlength="10" /> (jj/mm/aaaa)
			</td>
			<td>
				au <html:text property="dayEnd" size="10" maxlength="10" /> (jj/mm/aaaa)
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<th align="left"> <bean:message key="prompt.stats.section"/></th>
			<td>
				<html:select property="diplomaId">
					<option value="-2" selected="selected">TOUTES</option>
					<logic:iterate name="diplomaList" id="diploma"
											type="fr.umlv.desperados.diploma.Diploma">
						<option value="<bean:write name="diploma" property="id" />">
							<bean:write name="diploma" property="name" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		</tr>
			<td>
				&nbsp;
			</td>
		<tr>
		<tr>
			<td align="center"  colspan="4">
				<html:submit><bean:message key="button.submit"/></html:submit>
				<html:cancel><bean:message key="button.cancel"/></html:cancel>
			</td>
		</tr>
	</table>
</html:form>
</app:checkLogon>