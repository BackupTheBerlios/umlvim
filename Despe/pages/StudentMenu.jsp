<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>

<app:checkIdent page="">
	<table width="100%">
		<tr>
			<th align="left" valign="bottom">
				<bean:message key="title.student.menu" />
			</th>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/takeRdv">
					<bean:message key="menu.student.takerdv" />
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/printInscriptionFile">
					<bean:message key="menu.student.printfile" />
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/studentLogoff">
					<bean:message key="link.logoff" />
				</html:link>
			</td>
		</tr>
	</table>
</app:checkIdent>
