<%@ page import="java.util.Map" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<logic:present name="dossier" scope="request">

	<table>
		<tr align="center"><b> <bean:message key="inscription.familySituation.title"/></b> </tr>
		<br/>
		<tr align="center">
				<html:select property="famSituation">
					<logic:iterate name="famSituationList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
		</tr>
		<tr>
				<td> <bean:message key="inscription.familySituation.handicap"/> </td>
				<td>
				<html:select property="handicap">
					<logic:iterate name="handicapList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
				</td>
				<td><bean:message key="inscription.familySituation.handicap.comment"/></td>
				
		</tr>
	</table>

</logic:present>