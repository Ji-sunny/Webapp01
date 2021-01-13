<%--page 지시자 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
							<h5>스크립트릿/표현식</h5>
							<div>
								<%--Scriptlet --%>
								<%
								Date now = new Date();
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
								String strNow = sdf.format(now);
								%>
								<%--Expression --%>
								<%--<%=라는 뜻은 =다음에 오는 값을 넣겠다라는 뜻 --%>
								오늘 날짜 : <%= strNow %>
							</div>
						</div>
						
						<div class="sector">
							<h5>스크립트릿/표현식</h5>
							<div>
								<%for(int i=1; i<=6; i++){%>
								<h<%=i%>>Hello JSP</h<%=i%>>
								<%} %> 
							</div>
						</div>
				</div>
			</div>
	</div>
</body>
</html>