<%--page 지시자 --%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:forEach var="fileName" items="${fileNames}">
		<div style="display: flex; align-items: center; margin-bottom: 5px;"  >
			<img class="rounded-circle" src="photodownload?photo=${fileName}" width="50px" height="50px"/>
			<a href="photodownload?photo=${fileName}"> ${fileName}</a>
		</div>
	</c:forEach>

<%-- 
<ul>
	<c:forEach var="fileName" items="${fileNames}">
		<li>
			<a href="photodownload?photo=${fileName}"> ${fileName}</a>
		</li>	
	</c:forEach>
</ul> --%>