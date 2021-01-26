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
						<h5>게시판 목록</h5>
						<div>
							<table class="table table-bordered">
							 <thead>
							    <tr>
							      <th>번호</th>
							      <th>제목</th>
							      <th>글쓴이</th>
							      <th>조회수</th>
							      <th>날짜</th>
							    </tr>
							  </thead>
							  <tbody>
							  	<c:forEach var="board" items="${list}">
							  		<tr>
							  			<td>${board.bno}</td>
							  			<td>${board.btitle}</td>
							  			<td>${board.bwriter}</td>
							  			<td>${board.bhitcount}</td>
							  			<td><fmt:formatDate value="${board.bdate}" pattern="yyyy.MM.dd"/> </td>
							  		</tr>
							  	</c:forEach>
							  </tbody>
							</table>
							<div class="d-flex align-items-center justify-content-between">
								<c:if test="${sessionMid != null}">
									<a href="boardwrite" class="btn btn-outline-success btn-sm mr-1">글쓰기 </a>
								</c:if>
								<c:if test="${sessionMid == null}">
									<div></div>
								</c:if>
								<div>
									<a href="boardlist2?pageNo=1" class="btn btn-outline-info btn-sm mr-1">처음 </a>
									<c:if test="${pager.groupNo>1}">
										<a href="boardlist2?pageNo=${pager.startPageNo-1}" class="btn btn-outline-info btn-sm mr-1">이전 </a>
									</c:if>
									<c:forEach var="i" begin="${pager.startPageNo}" end="${pager.endPageNo}">
										<c:if test="${i==pager.pageNo}">
											<a href="boardlist2?pageNo=${i}" class="btn btn-warning btn-sm mr-1">${i}</a>
										</c:if>
										<c:if test="${i!=pager.pageNo}">
											<a href="boardlist2?pageNo=${i}" class="btn btn-outline-warning btn-sm mr-1">${i}</a>
										</c:if>
									</c:forEach>
									<c:if test="${pager.groupNo < pager.totalGroupNo}">
										<a href="boardlist2?pageNo=${pager.endPageNo+1}" class="btn btn-outline-info btn-sm mr-1">다음 </a>
									</c:if>
									<a href="boardlist2?pageNo=${pager.totalPageNo}" class="btn btn-outline-info btn-sm mr-1">맨끝 </a>
								</div>
							</div>
						</div>
					</div>	
					
				</div>
			</div>
		</div>
</body>
</html>