<%@ taglib uri="/WEB-INF/tlds/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/WEB-INF/jsp/layouts/DefaultLayout.jsp" flush="true">

	<tiles:put name="header" value="/WEB-INF/jsp/common/Header.jsp" />	
	<tiles:put name="menubar" value="/WEB-INF/jsp/Menu.jsp" />
	<tiles:put name="body-content" value="/WEB-INF/jsp/Main.jsp" />
	<tiles:put name="footer" value="/WEB-INF/jsp/common/Copyright.jsp" />

</tiles:insert>