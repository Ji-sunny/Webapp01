<%--page 지시자 --%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						<div class="alert alert-primary" role="alert">
							로그인
						</div>
						<form name="joinform" onsubmit="login()" style="width:200px;">
							<div class="form-group">
							    <label for="mid">아이디</label>
							    <input type="text" class="form-control" id="mid" name="mid">
							   <small id="errorMid" class="form-text text-danger"></small>
						  	</div>
						  <div class="form-group">
						    <label for="mpassword">비밀번호</label><br/>
						    <input type="password" class="form-control" id="mpassword" name="mpassword">
						    <small id="errorMpassword" class="form-text text-danger"></small>
						  </div>
						  <button class="btn btn-primary">로그인</button>
						  <a href="boardlist2" class="btn btn-primary">뒤로가기</a>
						</form>
						
						<script type="text/javascript">
							function login() {
								//form테그의 기본 이동 기능을 취소 (refresh효과가 있음)
								event.preventDefault();
								//에러 초기화
								$("#errorMid").html("");
								$("#errorMpassword").html("");
								//입력값 받기
								const mid = $("#mid").val();
								var validation = true;
								if(mid === "") {
									$("#errorMid").html("필수 입력 사항입니다.");
									validation = false;
								}
								const mpassword = $("#mpassword").val();
								if (mpassword === "") {
									$("#errorMpassword").html("필수 입력 사항입니다.");
									validation = false;
								}
								if(!validation) {
									return;
								}
								//ajax 통신
								$.ajax({
									url: "login",
									method: "post",
									data: {mid:mid, mpassword:mpassword},
									success: function(data) {
										if(data.result === "success") {
											alert("로그인 성공");
											location.href = "boardlist2";
										} else if (data.result == "wrongmid") {
											$("#errorMid").html("아이디가 존재하지 않습니다.");
										} else {
											$("#errorMpassword").html("비밀번호가 존재하지 않습니다.");
										}
									}
								}); 
							}
							
							/* {이름: 변수} or 이름과 변수가 동일하면 {변수, 변수} */
						</script>
					</div>
				</div>
			</div>
		</div>
</body>
</html>