<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/app.tld" prefix="app" %>

<app:checkLogon page=""/>

<tiles:insert page="/pages/layouts/defaultLayout.jsp" flush="true">

	<tiles:put name="header" value="/pages/common/header.jsp" />	
	<tiles:put name="menubar" value="/pages/userMenu.jsp" />
	<tiles:put name="body-content" value="/pages/main.jsp" />
	<tiles:put name="footer" value="/pages/common/copyright.jsp" />

</tiles:insert>