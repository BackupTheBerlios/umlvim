<%@ taglib uri="/WEB-INF/tlds/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>

<html:html>

	<head>
		<STYLE TYPE="text/css">
		<!--
			A:link, A:visited
			{
				color: white;
				text-decoration: none;
			}
			A:link:hover, A:visited:hover
			{
				color: white;
				text-decoration: underline;
			}
		-->
		</STYLE>
		<html:base/>
		<title><bean:message key="global.title"/></title>
	</head>

	<body bgcolor="#FFFFFF">

		<table width="100%">
			<tr>
				<td  colspan="2" align="center" bgcolor="#7363ac">
					<!-- Header page information -->
					<tiles:insert attribute="header"/>
				</td>
			</tr>

			<tr>
				<td width="200" bgcolor="#b17fcb" valign="top">
					<!-- Menu bar -->
					<tiles:insert attribute="menubar"/>
				</td>
				<td align="center" bgcolor="#d0aed9">
					<!-- Main body information -->
					<tiles:insert attribute="body-content"/>
				</td>
			</tr>

			<tr>
				<td colspan="2" bgcolor="#7363ac">
					<!-- Footer page information -->
					<tiles:insert attribute="footer"/>
				</td>
			</tr>
		</table>

	</body>

</html:html>