<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/pages/layouts/DefaultLayout.jsp" flush="true">

	<tiles:put name="header" value="/pages/common/Header.jsp" />	
	<tiles:put name="menubar" value="/pages/UserMenu.jsp" />
	<tiles:put name="body-content" value="/pages/Main.jsp" />
	<tiles:put name="footer" value="/pages/common/Copyright.jsp" />

</tiles:insert>