<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html:html>
	<head>
		<title><bean:message key="global.title"/></title>
		<html:base/>
	</head>
	<body bgcolor="#FFFFFF">
		<table width="100%">
			<tr>
				<td  colspan="2" align="center">
					<!-- Header page information -->
					<tiles:insert attribute="header"/>
				</td>
			</tr>
			<tr>
				<td width="200">
					<!-- Menu bar -->
					<tiles:insert attribute="menubar"/>  
				</td>
				<td>
					<!-- Main body information -->
					<tiles:insert attribute="body-content"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- Footer page information -->
					<tiles:insert attribute="footer"/>
				</td>
			</tr>
		</table>
	</body>
</html:html>