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
							글쓰기
						</div>
						<form name="boardwriteform" action="boardwrite" method="post">
							<div class="form-group">
							    <label for="bwriter">글쓴이</label>
							    <input type="text" class="form-control" id="bwriter" name="bwriter" readonly value="${sessionMid}">
						  	</div>
						  <div class="form-group">
						    <label for="btitle">제목</label>
						    <input type="text" class="form-control" id="btitle" name="btitle">
						    <small class="form-text text-muted">필수입력입니다.</small>
						  </div>
						  <div class="form-group">
						    <label for="bcontent">내용</label><br/>
						    <textarea class="form-control" id="bcontent" name="bcontent" rows="10"></textarea>
						  </div>
						  <button class="btn btn-primary">저장</button>
						  <a href="boardlist2" class="btn btn-primary">뒤로가기</a>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>