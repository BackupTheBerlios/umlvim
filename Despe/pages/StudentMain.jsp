<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
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