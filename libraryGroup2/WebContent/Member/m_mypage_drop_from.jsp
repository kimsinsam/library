	<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />
<%@ page import = "member.dao.Mdao" %>
<%@ page import = "member.dto.Member" %>

<%@ include file="/module/top.jsp" %>
<div class="container-fluid">
	<div class="col-sm-1">
	</div>
	<div class="col-sm-10">
		<div class="container-fluid">
			<!-- ----------left---------- -->
			<div class="col-sm-2 left-background">
				<hr class="hr-color">
				<center>
					<h3><b>My Page</b></h3>
					<hr class="hr-color">
						<a href="<%= request.getContextPath()%>/Member/m_mypage_form.mkfc"><h4>회원정보수정</h4></a>
					<br>
						<a href="<%= request.getContextPath()%>/Member/m_mypage_form.mkfc"><h4>대여도서확인</h4></a>
					<br>
						<a href="#" data-toggle="modal" data-target="#bookdelete"><h4><b>회원탈퇴</b></h4></a>
				</center>
				<br>
			</div>
			
			<!-- --------------★화면 중앙 내용★------------- -->
			<%
			Member m = (Member)request.getAttribute("m");
			%>
			<div class="col-sm-10">
				<center>
					<form role="form" style="width: 300px; left: 50%;" action="<%= request.getContextPath() %>/mypage/mypage_pro.jsp" method="post">
						<div class="form-group">
						<label for="InputEmail">아이디</label>
						<input type="text" class="form-control" name="mid" value="<%= m.getMid() %>" readonly>
						</div>
						<div class="form-group">
						<label for="InputEmail">비밀번호</label>
						<input type="password" class="form-control" name="mpw" placeholder="비밀번호를 입력해주세요.">
						</div>
						<div class="form-group text-center">
						<button type="submit" class="btn btn-info">로그인<i class="fa fa-check spaceLeft"></i></button>
						<button type="submit" class="btn btn-warning">되돌아가기<i class="fa fa-times spaceLeft"></i></button>
						</div>
					</form>	
				</center>
			</div>
			<!-- -------------------------------------------------- -->
		</div>
	</div>
	<div class="col-sm-1">
	</div>
</div>
<%@ include file="/module/footer.jsp" %>