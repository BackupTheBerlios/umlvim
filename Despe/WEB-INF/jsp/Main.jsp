<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
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