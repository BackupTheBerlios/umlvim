<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app"%>

<app:checkLogon>

<h1>Gestion des feuilles de style</h1>

<html:form action="/set/StyleSheet">
	<table width="100%">
		<tr>
			<td aling="left"><h3>Appliquer une feuille de style</h3></td>
		</tr>
		<tr>
			<th align="right"> <bean:message key="prompt.stylesheet.set"/></th>
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
<html:form action="/add/styleSheet" enctype="multipart/form-data">
	<table width="100%">
		<tr>
			<td aling="left"><h3>Ajouter une feuille de style</h3></td>
		</tr>
		<tr>
			<th align="right"'><bean:message key="prompt.stylesheet.add"/></th>
			<td><html:file property="theFile"/></td>
		</tr>
		<tr>
			<th align="right">Nom de la feuille de style</th>
			<td><html:text property="theName"/></td>
		</tr>
		<tr>
			<td></td>
			<td align="left"><html:submit/><html:cancel/></td>
		</tr>	 
	</table>
</html:form>
<hr>
<html:form action="/remove/styleSheet">
	<table width="100%">
		<tr>
			<td aling="left"><h3>Supprimer une feuille de style</h3></td>
		</tr>
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
</app:checkLogon>