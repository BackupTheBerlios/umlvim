<%@ page import="java.util.Map" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<logic:present name="dossier" scope="request">

	<table>
		<tr align="center"><b> <bean:message key="inscription.socioprofSituation.title"/></b><bean:message key="inscription.socioprofSituation.comment"/>
		</tr>
		<tr>
			<td>
				 <bean:message key="inscription.socioprofSituation.work"/>
			</td>
			<td>
				<html:select property="emlpoyed">
					<option value="0" selected="selected">NON</option>
					<option value="1" selected="selected">OUI</option>
				</html:select>
			</td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.socioprofSituation.work.type"/> </td>
			<td> <html:text property="workNature" /> </td>
		</tr>
		<tr align=center>
			<td>
			<u><bean:message key="inscription.socioprofSituation.activity"/></u><bean:message key="inscription.socioprofSituation.activity.comment"/>
			</td>
		</tr>
		<tr>
			<td>
				 <bean:message key="inscription.socioprofSituation.quotite"/>
			</td>
			<td>
				<html:select property="workedShare">
					<logic:iterate name="workedShareList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.socioprofSituation.profChef"/> </td>
			<td> <html:text property="headFamilyProfession" /> </td>
		</tr>
	</table>

</logic:present>