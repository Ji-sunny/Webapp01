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
							게시물 보기
						</div>
						<form name="boardwriteform" action="boardwrite" method="post">
						  <div class="form-group">
						    <label for="btitle">제목</label>
						    <input type="text" value="${board.btitle}" readonly class="form-control" id="btitle" name="btitle">
						  </div>
						  <div class="form-group">
						    <label for="bwriter">글쓴이</label>
						    <input type="text" value="${board.bwriter}" readonly class="form-control" id="bwriter" name="bwriter">
						  </div>
						  <div class="form-group">
						    <label for="bdate">날짜</label>
						    <input type="text" 
						    		 value='<fmt:formatDate value="${board.bdate}" pattern="yyyy-MM-dd"/>' 
						    		readonly class="form-control" id="bdate" name="bdate">
						  </div>
						  <div class="form-group">
						    <label for="bhitcount">조회수</label>
						    <input type="text" value="${board.bhitcount}" readonly class="form-control" id="bhitcount" name="bhitcount">
						  </div>
						  
						  <div class="form-group">
						    <label for="bcontent">내용</label><br/>
						    <textarea class="form-control" readonly id="bcontent" name="bcontent" rows="10">${board.bcontent}</textarea>
						  </div>
						  
						  <div class="form-group">
						    <label for="bcontent">첨부 사진</label><br/>
						    <c:if test="${board.battachsname ne null}">
						  		<a class="btn btn-info ml-2" href="battach?bno=${board.bno}">다운로드</a>
						    	<img class="rounded" src="battach?bno=${board.bno}" width="200px"> <br/>
						    </c:if>
						  </div>
						  
						  
						  <a href="boardlist2" class="btn btn-primary">목록</a>
						  <c:if test="${sessionMid ==board.bwriter}">
							  <a href="boardupdate?bno=${board.bno}" class="btn btn-warning">수정</a>
							  <a href="boarddelete?bno=${board.bno}" class="btn btn-danger">삭제</a>
						  </c:if>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>