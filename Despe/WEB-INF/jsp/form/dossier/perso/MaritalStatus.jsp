<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<logic:present name="dossier" scope="request">

	<table>
			<tr align="center"><b> <bean:message key="inscription.maritalStatus.title"/></b> </tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.name.patro"/> </td>
			<td> <html:text property="patronymicName" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.name.usage"/> </td>
			<td> <html:text property="name" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.prenom1"/> </td>
			<td> <html:text property="firstname1" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.prenom2"/> </td>
			<td> <html:text property="firstname2" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.INE"/> </td>
			<td> <html:text property="ine" /> </td>
			<td> <bean:message key="inscription.maritalStatus.INE.comment"/> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.birthday"/> </td>
			<td> <html:text property="birthday" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.birthplace"/> </td>
			<td> <html:text property="birthplace" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.birthDep"/> </td>
			<td> <html:text property="birthdep" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.sex"/> </td>
			<td> <html:text property="sex" /> </td>
		</tr>
		<tr>
			<td> <bean:message key="inscription.maritalStatus.nationality"/> </td>
			<td> <html:text property="nationality" /> </td>
			<td> <bean:message key="inscription.maritalStatus.nationality.comment"/> </td>
		</tr>
	</table>

</logic:present>