<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />
</head>
<body>
<%
	String S_NAME = (String)session.getAttribute("S_NAME");
	String S_LEVEL = (String)session.getAttribute("S_LEVEL");
	System.out.println(S_NAME + "<-- S_NAME top.jsp");
	System.out.println(S_LEVEL + "<-- S_LEVEL top.jsp");
	/* 로그인 전 화면 */
if(S_LEVEL == null){
%>
	<div class="container-fluid">
		<div class="col-sm-1">
		</div>
			<nav class="navbar navbar-inverse col-sm-10">
				<div class="container-fluid">
					<a class="navbar-brand" href="<%= request.getContextPath() %>/index.jsp"><b>KSMART DIGITAL LIBRARY </b><span class="glyphicon glyphicon-book"></a>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#"data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
							<li><a href="<%=request.getContextPath()%>/Member/m_insert_form.mkfc">회원가입</a></li>
						</ul>
					</div>
				</div>
			</nav>
		<div class="col-sm-1">
		</div>
	</div>
<!-- Modal -->
<div class="container">
	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog"> 
		<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<center><h4 class="modal-title"><b>Login</b></h4></center>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="col-sm-12">
							<form action="<%=request.getContextPath()%>/Login/login_pro.mkfc" method="post">     	
								아이디
								<input type="text" name="id" class="form-control"/>
								비밀번호
								<input type="password" name="pw" class="form-control"/>
								<br>
								<center><button class="btn btn-default" style=width:100%;><b>로그인</b></button></center>
								<br>
							</form>
						</div>       
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" value="아이디/비밀번호 찾기" name="aaa"><b>아이디/비밀번호 찾기</b></button>
						<button class="btn btn-default" value="회원가입" name="add"><b>회원가입</b></button>       
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 01 로그인 전화면 End -->
<%
}else{
	if(S_LEVEL.equals("일반회원")){
%>   
	<div class="container-fluid">
		<div class="col-sm-1">
		</div>
			<nav class="navbar navbar-inverse col-sm-10">
				<div class="container-fluid">
					<a class="navbar-brand" href="<%= request.getContextPath() %>/index.jsp"><b>KSMART DIGITAL LIBRARY </b><span class="glyphicon glyphicon-book"></a>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a><span class="glyphicon glyphicon-user"></span> <b><%= S_NAME %></b> 님 로그인 중</a></li>
							<li><a href="<%= request.getContextPath() %>/Login/logout_pro.mkfc">Logout <span class="glyphicon glyphicon-log-in"></span></a><li>
							<li><a href="<%= request.getContextPath()%>/Member/m_mypage_form.mkfc">My Page</span></a></li>
						</ul>
					</div>
				</div>
			</nav>
		<div class="col-sm-1">
		</div>
	</div>
<%	
}else if(S_LEVEL.equals("관리자")){ %>
	<div class="container-fluid">
		<div class="col-sm-1">
		</div>
			<nav class="navbar navbar-inverse col-sm-10">
				<div class="container-fluid">
					<a class="navbar-brand" href="<%= request.getContextPath() %>/index.jsp"><b>KSMART DIGITAL LIBRARY </b><span class="glyphicon glyphicon-book"></a>
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="<%= request.getContextPath()%>/Member/m_search_list.mkfc">회원관리</a></li>
							<li class="active"><a href="<%= request.getContextPath()%>/Book/b_list.bkfc">도서관리</a></li>
							<li class="active"><a href="<%= request.getContextPath()%>/Rental/r_search_list.rkfc">대여관리</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a><span class="glyphicon glyphicon-user"></span> <b><%= S_NAME %></b> 님 <b><%= S_LEVEL %></b> 권한 로그인 중</a></li>
							<li><a href="<%= request.getContextPath() %>/Login/logout_pro.mkfc">Logout <span class="glyphicon glyphicon-log-in"></span></a><li>
						</ul>
					</div>
				</div>
			</nav>
		<div class="col-sm-1">
		</div>
	</div>
<%	}
} 
%>

<div id="div">		 