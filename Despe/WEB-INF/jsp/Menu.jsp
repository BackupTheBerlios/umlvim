<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app"%>

<app:checkLogon admin="true" page="">
	<table width="100%">
		<tr>
			<th align="left" valign="bottom">
				<bean:message key="title.admin.menu"/>
			</th>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/edit/user?action=create">
					<bean:message key="menu.admin.adduser"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/search/user">
					<bean:message key="menu.admin.searchuser"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/list/styleSheet">
					<bean:message key="menu.admin.stylesheet"/>
				</html:link>
			</td>
		</tr>
	</table>
</app:checkLogon>

<app:checkLogon page="">
	<table width="100%">
		<tr>
			<th align="left" valign="bottom">
				<bean:message key="title.user.menu"/>
			</th>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/add/student">
					<bean:message key="menu.user.addstudent"/>
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/search/student">
					<bean:message key="menu.user.searchstudent"/>
				</html:link>
			</td>
		</tr>
		<tr align="right">
			<td width="120">
				<html:link action="/confPlanning">
					<bean:message key="planning.setup.conf" />
				</html:link>
			</td>
		</tr>
		<tr align="right">
			<td width="120">
				<html:link action="list/diploma">
					<bean:message key="menu.user.stats" />
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/userLogoff">
					<bean:message key="link.logoff" />
				</html:link>
			</td>
		</tr>
	</table>
</app:checkLogon>

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
				<html:link action="/cancelRdv">
					<bean:message key="menu.student.cancelrdv" />
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/printInscriptionFile?type=inscr">
					<bean:message key="menu.student.printfile" />
				</html:link>
			</td>
		</tr>
		<tr>
			<td align="right" valign="top">
				<html:link action="/printInscriptionFile?type=conf">
					<bean:message key="menu.student.printconf" />
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