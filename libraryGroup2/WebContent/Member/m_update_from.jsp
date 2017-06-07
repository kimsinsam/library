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
			<%
			Member m = (Member)request.getAttribute("m");
			%>
			<h1><small><b>회원 정보 수정</b></small></h1>
			<hr>
			<form action="<%= request.getContextPath() %>/Member/m_update_pro.mkfc" method="post">
					  <div class="input-group">
					   	<b>아이디</b><br>
					   	<input type="text" class="" size="20" name="mid" value="<%= m.getMid() %>" readonly>
					  </div>
					  <br>
					    <div class="input-group">
					   	<b>비밀번호</b><br>
					   	<input type="text" class="" size="20" name="mpw" value="<%= m.getMpw() %>">
					  </div>
					  <br>
					  <hr>
					  <div class="input-group">
					   <b>이름</b><br>
					   <input type="text" class="" name="mname" value="<%= m.getMname() %>">
					  </div>
					  <br>
					  <div class="input-group">
					   <b>생년원일</b><br>
					   <input type="date" class="" name="mbirth" value="<%= m.getMbirth() %>">
					  </div>
					  <br>
					  <div class="input-group">
					   <b>주소</b><br>
					   <input type="text" class="" name="maddr" value="<%= m.getMaddr() %>">
					  </div>
					  <br>
					  <div class="input-group">
					   <b>연락처</b><br>
					   <input type="text" class="" name="mtel" value="<%= m.getMtel() %>">
					  </div>
					  <br>
					  <div class="input-group">
					   <b>이메일</b><br>
					   <input type="text" class="" name="memail" value="<%= m.getMemail() %>">
					  </div>
					  <br>
					  <div class="input-group">
					   <b>권한</b><br>
					   <select style="width: 120px;" class="form-control" name="mlevel">
					        <option value="일반회원">일반회원</option>
						    <option value="관리자">관리자<option>
				      	</select> 
					  </div>
					  <br>
					  <hr>
						<button class="" type="submit">수정완료</button>
			</form>
	
		</div>
	<div class="col-sm-1">
	</div>
</div>
<%@ include file="/module/footer.jsp" %>