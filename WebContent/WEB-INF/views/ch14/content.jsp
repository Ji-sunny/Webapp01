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
						<h5>연결 테스트</h5>
						<div>
							<a class="btn btn-primary btn-sm"  href="javascript:conntest()">연결 테스트</a>
							
							<script type="text/javascript">
								const conntest = function() {
									$.ajax({
										url: "conntest",
										method:"get",
										success: function(data) {
											$("#result1").html(data);
										}
									})
								};
							</script>
							<div id="result1"></div>
						</div>
					</div>
					
					<div class="sector">
						<h5>json 응답 받기</h5>
						<div>
							<a class="btn btn-primary btn-sm"  href="javascript:jsonresponse1()">객체 받기</a>
							<!-- controller에 있는 {}를 받음 -->
							<script type="text/javascript">
								const jsonresponse1 = function() {
									$.ajax({
										url: "jsonresponse1",
										method:"get",
										success: function(data) {
											console.log(data);
											$("#name").html(data.name);
											$("#age").html(data.age);
											$("#carKind").html(data.car.kind);
											$("#carColor").html(data.car.color);
											for(var h of data.hobby) {
												$("#hobby").append(h+", ");
											}
										}
									});
								};
							</script>
							<div id="result2">
								<div id="name"></div>
								<div id="age"></div>
								<div id="carKind"></div>
								<div id="carColor"></div>
								<div id="hobby"></div>
							</div>
							
							<a class="btn btn-primary btn-sm"  href="javascript:jsonresponse2()">배열[] 받기</a>
							<script type="text/javascript">
								const jsonresponse2 = function() {
									$.ajax({
										url:"jsonresponse2",
										success: function(data) {
											console.log(data);
											for(var i=0; i<data.length; i++) {
												var board = data[i];
												$("#result3 tbody").append("<tr>");
												$("#result3 tbody").append("<td>" +board.bno+"</td>");
												$("#result3 tbody").append("<td>" +board.btitle+"</td>");
												$("#result3 tbody").append("<td>" +board.bwriter+"</td>");
												$("#result3 tbody").append("</tr>");
											}
										}
									})
								};
							</script>
							<div id="result3">
								<table class="table">
									<thead>
										<tr>
											<td>번호</td>
											<td>제목</td>
											<td>글쓴이</td>
										</tr>
									</thead>
									<tbody>
										
									</tbody>
								</table>
							</div>
						</div>
					</div>
					
					<div class="sector">
						<h5>PK로 검색하기</h5>
						<div>
							<a class="btn btn-primary btn-sm"  href="employee?employee_id=100">사번이 100번인 사원의 정보</a>
							<a class="btn btn-primary btn-sm"  href="employee?employee_id=101">사번이 101번인 사원의 정보</a> <br/>
							<a class="btn btn-primary btn-sm"  href="javascript:getEmployee(100)">사번이 100번인 사원의 정보</a>
							<a class="btn btn-primary btn-sm"  href="javascript:getEmployee(101)">사번이 101번인 사원의 정보</a>
							<script type="text/javascript">
								function getEmployee(eid) {
									$.ajax({
										url:"employee2",
										data:{employee_id: eid},
										success: function(data) {
											$("#eno").html(data.employee_id);
											$("#firstName").html(data.first_name);
											$("#lastName").html(data.last_name);
										}
									})
								};
							</script>
							<div id="result4">
								사번:<span id="eno"></span><br/>
								이름:<span id="firstName"></span><br/>
								성:<span id="lastName"></span><br/>
							</div>
							
						</div>
					</div>
					
					
				</div>
			</div>
		</div>
</body>
</html>