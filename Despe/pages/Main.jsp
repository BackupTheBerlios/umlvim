<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="fr.umlv.desperados.util.Constants" %>

<app:checkLogon>
	<html>
		<body>
			<h1>
				Bienvenue,
				<bean:write name="<%=Constants.USER_KEY%>" property="firstname"/>
				<bean:write name="<%=Constants.USER_KEY%>" property="name"/> !!
			</h1>
		</body>
	</html>
</app:checkLogon>