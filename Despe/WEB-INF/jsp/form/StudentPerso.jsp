<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/app.tld" prefix="app" %>

<html:errors/>

<app:checkIdent>
	<jsp:useBean id="dossier" class="java.lang.String" scope="request"/>
	<html:form action="/save/file/perso">
		<jsp:include page="/WEB-INF/jsp/form/dossier/perso/MaritalStatus.jsp"/>
		<jsp:include page="/WEB-INF/jsp/form/dossier/perso/FamilySituation.jsp"/>
		<jsp:include page="/WEB-INF/jsp/form/dossier/perso/MilitarySituation.jsp"/>
		<jsp:include page="/WEB-INF/jsp/form/dossier/perso/Address.jsp"/>
		<jsp:include page="/WEB-INF/jsp/form/dossier/perso/SocioProfSituation.jsp"/>
		<html:submit/>
	</html:form>
</app:checkIdent>