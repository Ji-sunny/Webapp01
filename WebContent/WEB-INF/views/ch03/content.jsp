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
							<h5>GET 방식 데이터 전달</h5>
							<div>
								<!-- enter나 space를 두지 않음 -->
								<a class="btn btn-info btn-sm" href="method4?param1=Daily&param2=5&param5=2021-01-14">데이터 전달</a>
							</div>
						</div>
						
						<div class="sector">
							<h5>POST 방식 데이터 전달</h5>
							<div>
								<form method="POST" action="method1">
									<input type="text" name="param1" value="Daily"> <br/>
									<input type="number" name="param2" value="5"> <br/>
									<input type="number" name="param3" value="3.14"> <br/>
									<input type="checkbox" name="param4" checked="checked"> <br/><!--  0은 false, 1은 true -->
									<input type="date" name="param5" value="2021-12-25"> <br/>
									<button class="btn btn-info btn-sm">데이터 전달</button>
								</form>
							</div>
						</div>
						<div class="sector">
							<h5>요청 파라미터명과 매개변수명이 다를 때 방식 데이터 전달</h5>
							<div>
								<form method="POST" action="method2">
									<input type="text" name="param1" value="데일리"> <br/>
									<input type="number" name="param2" value="5"> <br/>
									<input type="number" name="param3" value="3.14"> <br/>
									<input type="checkbox" name="param4" checked="checked"> <br/><!--  0은 false, 1은 true -->
									<input type="date" name="param5" value="2021-12-25"> <br/>
									<button class="btn btn-info btn-sm">데이터 전달</button>
								</form>
							</div>
						</div>
						<div class="sector">
							<h5>Defalt 값</h5>
							<div>
								<form method="POST" action="method3">
									<input type="text" name="param1" value="Daily"> <br/>
									<input type="number" name="param2" value="5"> <br/>
									<button class="btn btn-info btn-sm">데이터 전달</button>
								</form>
							</div>
						</div>
					</div>
			</div>
	</div>
</body>
</html>