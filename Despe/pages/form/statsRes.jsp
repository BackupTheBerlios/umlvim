<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app"%>

<app:checkLogon>
	Du <bean:write name="start" /> au <bean:write name="end" />, il y a 
	<bean:write name="result" />
	inscription(s) pour la section choisie.
</app:checkLogon>