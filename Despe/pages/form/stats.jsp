<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:form action="/stats">
	<table width="100%">
		<tr width="100%" colspan="3">
			<th align="left"><bean:message key="title.stats"/></th>
		</tr>
		<tr>
			<th align="left"><bean:message key="prompt.stats.periode"/></th>
			<td>du <html:text property="periodeDeb"/></td>
			<td>au <html:text property="periodeFin"/></td>
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
		<tr width="100%" colspan="3">
			<td></td>
			<td align="center"><html:submit/><html:cancel/></td>
		</tr>
	</table>
</html:form>