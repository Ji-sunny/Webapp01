<%--page 지시자 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
							<h5>EL(Expressions Language)를 이용해서 스칼라 값(숫자, 문자열, 논리값) 읽기</h5>
							<div>
							<%-- ${ }가 EL이며, getmethod()랑 비슷함 --%>
								<div>이름: ${name} </div>
								<div>나이: ${age}</div>
								<div>직업: ${job}</div>
							</div>
						</div>
						
						<div class="sector">
							<h5>DTO의 객체 데이터 읽기</h5>
							<div>
							<%-- ${ }가 EL --%>
								<div>목록: ${BestSeller.no} </div>
								<div>제목: ${BestSeller.title}</div>
								<div>내용: ${BestSeller.content}</div>
								<div>작가: ${BestSeller.writer}</div>
								<div>날짜: ${BestSeller.date}</div>
							</div>
						</div>
						
						<div class="sector">
							<h5>collection 이용하기</h5>
							<div>
								<%-- <%
								for(Board board : boardList) {
								}
								%> --%>
								<!-- taglib의 name이 'c'이다. forEach는 for과 동일하다. 
								items가 var로 들어가서 items수만큼 돈다 
								model에 boardList로 저장된 거를 가져와서 사용하겠다. -->
								<table style="width: auto;" class="table table-sm table-bordered">
									<tr>
										<th>번호</th>
										<th>제목</th>
										<th>내용</th>
										<th>작가</th>
										<th>날짜</th>
									</tr>
									<c:forEach var="board" items="${boardList}">
										<tr class="table-active">
											<td>${board.no}</td>
											<td>${board.title}</td>
											<td>${board.content}</td>
											<td>${board.writer}</td>
											<td><fmt:formatDate value="${board.date}" pattern="yyyy.MM.dd"/> </td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
			</div>
		</div>
</body>
</html>