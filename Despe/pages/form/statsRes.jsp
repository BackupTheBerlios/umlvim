<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app"%>

<app:checkLogon>
	Du <bean:write name="start" /> au <bean:write name="end" />, il y a 
	<bean:write name="result" />
	inscription(s) pour la section choisie.
</app:checkLogon>