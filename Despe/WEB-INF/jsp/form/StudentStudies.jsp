<%@ page import="java.util.Map" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>


<html:errors/>

<app:checkIdent>
	<jsp:useBean id="dossier" class="java.lang.String" scope="request"/>
	<html:form action="/save/file/studies">
	<table width="100%">
	<tr>
		<td width="70%">
			 <bean:message key="inscription.wasMLVLastYear"/>
		</td>
		<td align="left">
			<html:select property="wasMLVLastYear">
				<option value="0">NON</option>
				<option value="1">OUI</option>
			</html:select>
		</td>
	</tr> 	
	<tr>
			<td align="center">
				<b><bean:message key="inscription.firstInscription.title"/></b>
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="inscription.firstInscription.all"/>
			</td>
			<td>
				<bean:message key="inscription.years"/>
					<html:select property="yearsSup">
					<logic:iterate name="yearsList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="inscription.firstInscription.frenchUniv"/>
			</td>
			<td>
				<bean:message key="inscription.years"/>
					<html:select property="yearsFreUniv">
					<logic:iterate name="yearsList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="inscription.firstInscription.frenchUniv.establishment"/>
			</td>
			<td>
				<html:text property="establishment" />
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="inscription.firstInscription.frenchUniv.zip"/>
			</td>
			<td>
				<html:select property="frenchDep">
				<logic:iterate name="frenchDepList" id="entry"
									type="Map.Entry">
					<option value="<bean:write name="entry" property="key" />">
						<bean:write name="entry" property="value" />
					</option>
				</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="inscription.firstInscription.univMLV"/>
			</td>
			<td>
					<bean:message key="inscription.years"/>
					<html:select property="yearsEstab">
					<logic:iterate name="yearsList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td align="center">
				<b><bean:message key="inscription.bac.title"/></b><font size=-1><bean:message key="inscription.bac.comment"/></font>
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="inscription.bac.year"/>
			</td>
			<td>
					<html:select property="yearsBac" onchange="if(form.yearsBac.value>1995){form.baccalaureat.disabled=false;form.bacPre95.disabled=true;}else{form.baccalaureat.disabled=true;form.bacPre95.disabled=false;}">
					<logic:iterate name="yearsList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="inscription.bac.serie"/>
				<html:select property="baccalaureat">
				<logic:iterate name="baccalaureatList" id="entry"
									type="Map.Entry">
					<option value="<bean:write name="entry" property="key" />">
						<bean:write name="entry" property="value" />
					</option>
				</logic:iterate>
				</html:select>
			</td>
			<td>
				<html:select property="bacPre95">
				<logic:iterate name="bacPre95List" id="entry"
									type="Map.Entry">
					<option value="<bean:write name="entry" property="key" />">
						<bean:write name="entry" property="value" />
					</option>
				</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="inscription.bac.mention"/>
			</td>
			<td>
				<html:select property="bacMention">
				<logic:iterate name="bacMentionList" id="entry"
									type="Map.Entry">
					<option value="<bean:write name="entry" property="key" />">
						<bean:write name="entry" property="value" />
					</option>
				</logic:iterate>
				</html:select>
			</td>
		</tr>
		<tr>
			<td>
				<b><bean:message key="inscription.bac.estab"/></b>
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="inscription.bac.estab.type"/>
			</td>
			<td>
					<html:select property="baccalaureatEstablishmentType">
				<logic:iterate name="baccalaureatEstablishmentTypeList" id="entry"
									type="Map.Entry">
					<option value="<bean:write name="entry" property="key" />">
						<bean:write name="entry" property="value" />
					</option>
				</logic:iterate>
				</html:select>
			</td>
		</tr>	
	</table>
	<html:submit><bean:message key="button.next"/></html:submit>
	</html:form>
</app:checkIdent>