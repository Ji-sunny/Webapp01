<%@ page contentType="text/html; charset=UTF-8"%>

<div class="mainHeader">
	<h3>Spring Framework</h3>
	<div class="loginBox">
		<img id="user" class="rounded-circle" src="<%=application.getContextPath()%>/resources/img/myphoto.jpg" width="50px"/>
		<button id="login" class="btn btn-info btn-sm">로그인</button>
		<button id="logout" onclick="fun1()" class="btn btn-danger btn-sm">로그아웃</button>
	</div>
</div>