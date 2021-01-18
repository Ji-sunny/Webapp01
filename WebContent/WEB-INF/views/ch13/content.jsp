<%--page 지시자 --%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%--import 속성 --%>
 <%@ page import = "java.util.*" %>
 <%@ page import = "java.text.*" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/main.css">
	</head>
	
	<body>
		<div class="wrap">
			<%--헤더 --%>
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
			<%-- 아래와 같은 방법은 복사 붙여넣기라서 동일한 내용이 있으면 에러가 난다.
			<%@ include file="/WEB-INF/views/include/header.jsp" %> --%>
			
			<%--내용 --%>
			<div class="mainCenter">
				<jsp:include page="/WEB-INF/views/include/menu.jsp"></jsp:include>
				<div class="content">
					<div class="sector">
						<h5>의존성 주입</h5>
						<div>
							<a class="btn btn-primary btn-sm"  href="service1">Ch13Service1 사용</a>
							<a class="btn btn-primary btn-sm"  href="service2">Ch13Service2 사용</a>
						</div>
					</div>
					
					<div class="sector">
						<h5>XML를 이용한 Setter</h5>
						<div>
							<a class="btn btn-primary btn-sm"  href="service3">Ch13Service3 사용</a>
							<a class="btn btn-primary btn-sm"  href="service4">Ch13Service4 사용</a>
						</div>
					</div>
					
					<div class="sector">
						<h5>DAO > Service > Controller</h5>
						<div>
							<a class="btn btn-primary btn-sm"  href="service5">Ch13Service5 사용</a>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>