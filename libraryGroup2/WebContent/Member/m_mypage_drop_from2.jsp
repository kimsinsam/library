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
						<a href="<%= request.getContextPath()%>/Member/m_mypage_drop_from.mkfc"><h4><b>회원탈퇴</b></h4></a>
				</center>
				<br>
			</div>
			
			<!-- --------------★화면 중앙 내용★------------- -->
			<div class="col-sm-10">
			<%
			Member m = (Member)request.getAttribute("m");
			%>
				<form action="<%= request.getContextPath() %>/Member/m_mypage_drop_pro.mkfc" method="post">
						  <hr><br>
						  <center><h2><b>탈퇴 하시겠습니까?</b></h2><br></center>
						  <br>
						  <center><button class="btn btn-default" type="submit">승인</button></center>
				</form>
			</div>
		</div>
	</div>
	<div class="col-sm-1">
	</div>
</div>
<%@ include file="/module/footer.jsp" %>