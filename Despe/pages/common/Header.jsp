<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<table width="100%">
	<tr>
		<td align="center">
			<html:link href="http://www.univ-mlv.fr" target="blank">
				<html:img src="<%= request.getContextPath()+"/pages/images/logo_umlv.gif" %>"/>
			</html:link>
		</td>
		<td width="30">
<%--
			<table>
				<tr>
					<td>
						<html:img src="<%= request.getContextPath()+"/pages/images/english_flag.gif" %>"
									height="20" width="30" />
					</td>
				</tr>
				<tr>
					<td>
						<html:img src="<%= request.getContextPath()+"/pages/images/french_flag.gif" %>"
									height="20" width="30" />
					</td>
				</tr>
			</table>
--%>
		</td>
	</tr>
</table>