<%@ page import="java.util.Map" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<logic:present name="dossier" scope="request">

	<table>
			<tr align="center"><b> <bean:message key="inscription.address.title"/></b> </tr>
		<tr>
			<td> <bean:message key="inscription.address.fixe"/> </td>
			<td> <html:text property="addressFixe" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.address.zip"/> </td>
			<td> <html:text property="zip" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.address.city"/> </td>
			<td> <html:text property="city" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.address.country"/> </td>
			<td> <html:text property="country" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.address.phone"/> </td>
			<td> <html:text property="phone" /> </td>
		</tr>
		<tr>
				<td> <bean:message key="inscription.address.temp.type"/> </td>
				<td>
				<html:select property="lodgingType">
					<logic:iterate name="lodgingTypeList" id="entry"
											type="Map.Entry">
						<option value="<bean:write name="entry" property="key" />">
							<bean:write name="entry" property="value" />
						</option>
					</logic:iterate>
				</html:select>
				</td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.address.temp"/> </td>
			<td> <html:text property="addressTemp" /> </td>
		</tr>
				<tr>
			<td> <bean:message key="inscription.address.zip"/> </td>
			<td> <html:text property="zipTemp" /> </td>
		</tr>
				<tr>
			<td> <bean:message key="inscription.address.city"/> </td>
			<td> <html:text property="cityTemp" /> </td>
		</tr>
				<tr>
			<td> <bean:message key="inscription.address.country"/> </td>
			<td> <html:text property="countryTemp" /> </td>
		</tr>
				<tr>
			<td> <bean:message key="inscription.address.phone"/> </td>
			<td> <html:text property="phoneTemp" /> </td>
		</tr>
	</table>

</logic:present>