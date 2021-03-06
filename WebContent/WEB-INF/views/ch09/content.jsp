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
						<h5>파일 업로드</h5>
						<div>
							<form method="post" enctype="multipart/form-data" action="photoupload">
								<input type="text" name="uid" placeholder="아이디"/><br/>
								<input type="text" name="uname" placeholder="성명"/><br/>
								<input type="text" name="upassword" placeholder="패스워드"/><br/>
								<input type="file" name="uphoto"/><br/>
								<!-- <input type="file" name="attach" placeholder="파일 선택" multiple="multiple"/><br/> 사진을 배열로 받음-->
								<input class="btn btn-primary btn-sm" type="submit" value="회원가입"/>
							</form>
						</div>
					</div>
					
					<div class="sector">
						<h5>파일 리스트</h5>
						<div>
							<script type="text/javascript">
								$(function() {
									$.ajax({
										url: "photolist",
										success: function(data) {
											$("#photolist").html(data);
										}
									})
								});
							</script>
							<div id="photolist"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>