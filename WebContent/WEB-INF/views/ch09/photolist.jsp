<%--page 지시자 --%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul>
	<c:forEach var="fileName" items="${fileNames}">
		<li>
			<a href="photodownload?photo=${fileName}"> ${fileName}</a>
		</li>	
	</c:forEach>
</ul>