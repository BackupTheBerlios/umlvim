<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html:form action="/setStyleSheet">
	<table>
		<tr>
			<th align="right"> <bean:message key="prompt.diploma.set"/></th>
			<td>
				<html:select property="styleSheetId">
					<logic:iterate name="styleSheetList" id="styleSheet"
											type="fr.umlv.desperados.stylesheet.StyleSheet">
						<option value="<bean:write name="styleSheet" property="filename" />">
							<bean:write name="styleSheet" property="name" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<th align="right">A quel document voulez-vous appliquer la feuille de style ?</th>
			<td>
				<html:select property="docTypeId">
					<logic:iterate name="docMap" id="docType">
						<option value="<bean:write name="docType" property="key" />">	
							<bean:write name="docType" property="value" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td></td>
			<td align="left"><html:submit/><html:cancel/></td>
		</tr>
	</table>
</html:form>
<hr>
<html:form action="/addStyleSheet" enctype="multipart/form-data">
	<table>
		<tr>
			<th align="right"'><bean:message key="prompt.stylesheet.add"/></th>
			<td><html:file property="theFile"/></td>
		</tr>
		<tr>
			<th aling="right">Nom de la feuille de style</th>
			<td><html:text property="theName"/></td>
		</tr>
		<tr>
			<td></td>
			<td align="left"><html:submit/><html:cancel/></td>
		</tr>	 
	</table>
</html:form>
<hr>
<html:form action="/removeStyleSheet">
	<table>
		<tr>
			<th align="right"> <bean:message key="prompt.stylesheet.remove"/> : </th>
			<td>
				<html:select property="styleSheetId">
					<logic:iterate name="styleSheetList" id="styleSheet"
											type="fr.umlv.desperados.stylesheet.StyleSheet">
						<option value="<bean:write name="styleSheet" property="filename" />">
							<bean:write name="styleSheet" property="name" />
						</option>
					</logic:iterate>
				</html:select>
			</td>		
		</tr>
		<tr>
			<td></td>
			<td align="left"><html:submit/><html:cancel/></td>
	</table>
</html:form>