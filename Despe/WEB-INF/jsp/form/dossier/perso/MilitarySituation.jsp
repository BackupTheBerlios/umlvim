<%@ page import="java.util.Map" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<logic:present name="dossier" scope="request">

	<table>
			<tr align="center"><b> <bean:message key="inscription.militarySituation.title"/></b> </tr>
		<br/>
		<tr align="center">
				<html:select property="militarySituation">
					<logic:iterate name="militarySituationList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
		</tr>
		<tr>
			<td>  </td>
		</tr>
	</table>

</logic:present>