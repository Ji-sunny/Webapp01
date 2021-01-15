<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mainHeader">
	<h3><a href="<%=application.getContextPath()%>/">Spring Framework</a></h3>
	<div class="loginBox">
		<c:if test="${loginStatus == null}">
			<a class="btn btn-info btn-sm" href="<%=application.getContextPath()%>/ch08/content">로그인</a>
		</c:if>
		
		<c:if test="${loginStatus != null}">
			<img class="rounded-circle" src="<%=application.getContextPath()%>/resources/img/myphoto.jpg" width="50px"/>
			<a class="btn btn-danger btn-sm" href="<%=application.getContextPath()%>/ch08/logout">로그아웃</a>
		</c:if>
	</div>
</div>