<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ page import="fr.umlv.desperados.util.Constants" %>

<app:checkIdent>
	<html>
		<body>
			<h1>
				Bienvenue,
				<bean:write name="<%=Constants.STUDENT_KEY%>" property="firstname1"/>
				<bean:write name="<%=Constants.STUDENT_KEY%>" property="patronymicName"/> !!
			</h1>
		</body>
	</html>
</app:checkIdent>