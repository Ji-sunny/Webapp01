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
							회원가입
						</div>
						<form enctype="multipart/form-data" name="joinform" action="join" method="post" style="width:200px;">
							<div class="form-group">
							    <label for="mid">아이디</label>
							    <input type="text" class="form-control" id="mid" name="mid">
						  	</div>
						  <div class="form-group">
						    <label for="mname">이름</label>
						    <input type="text" class="form-control" id="mname" name="mname">
						  </div>
						 
						  <div class="form-group">
						    <label for="mpassword">비밀번호</label><br/>
						    <input type="password" class="form-control" id="mpassword" name="mpassword">
						  </div>
						   <div class="form-group">
						    <label for="mphoto">프로필 사진</label><br/>
						    <input type="file" id="mphoto" name="mphoto">
						    <small class="form-text text-danger">옵션 입력 사항입니다.</small>
						  </div>
						  <button class="btn btn-primary">가입</button>
						  <a href="boardlist2" class="btn btn-primary">뒤로가기</a>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>