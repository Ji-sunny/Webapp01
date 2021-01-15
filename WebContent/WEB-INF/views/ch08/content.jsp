<%--page 지시자 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
							<h5>HttpSession 객체를 이용한 스칼라 값(숫자, 문자열, 논리값) 전달</h5>
							<div>
								<a class="btn btn-info btn-sm" href="method1">delivery1</a>
							</div>
						</div>
						
						<div class="sector">
							<h5>HttpSession 객체를 이용한 객체 전달</h5>
							<div>
								<a class="btn btn-info btn-sm" href="method2">delivery2</a>
							</div>
						</div>
						
						<div class="sector">
							<h5>HttpSession 객체를 이용한 collection 전달</h5>
							<div>
								<a class="btn btn-info btn-sm" href="method3">delivery3</a>
							</div>
						</div>
						
						<div class="sector">
							<h5>HttpSession 객체를 이용한 login</h5>
							<div>
								<c:if test="${loginStatus == null}">
									<div>
										<form method="post" action="login">
											<input type="text" name="uid" placeholder="아이디"> <br/>
											<input type="password" name="upw" placeholder="패스워드"> <br/>
											<button class="btn btn-success btn-sm">로그인</button>
										</form>
									</div>
								</c:if>

								<c:if test="${loginStatus != null}">
									<div>
									 	<a class="btn btn-danger btn-sm" href="logout">로그아웃</a>
									</div>
								</c:if>
							</div>
						</div>
						<c:if test="${loginStatus !=null}">
							<div class="sector">
								<h5>게시물 입력</h5>
								<c:if test="${board ==null}">
									<div>
										<a class="btn btn-danger btn-sm" href="board">게시물 입력</a>
									</div>
								</c:if>
								
								<c:if test="${board !=null}">
									<div>
										<form method="post" action="boardWrite">
											<input type="text" name="title" placeholder="제목"/> <br/>
											<textarea rows="10" cols="50" name="content" placeholder="내용"></textarea> <br/>
											<button class="btn btn-success btn-sm">저장</button>
										</form>
									</div>
								</c:if>
							</div>
						</c:if>
					</div>
			</div>
		</div>
</body>
</html>