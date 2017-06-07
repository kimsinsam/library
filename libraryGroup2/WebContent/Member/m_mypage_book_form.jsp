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
						<a href="<%= request.getContextPath()%>/Member/m_mypage_form.mkfc"><h4><b>ȸ����������</b></h4></a>
					<br>
						<a href="<%= request.getContextPath()%>/Member/check_rental.bkfc"><h4>�뿩����Ȯ��</h4></a>
					<br>
				</center>
				<br>
			</div>
			
			<!-- --------------��ȭ�� �߾� �����------------- -->
			<div class="col-sm-8">
			<%
			Member m = (Member)request.getAttribute("m");
			%>
				<h3><b>���� ȭ��</b></h3>
				<hr>
				<form action="<%= request.getContextPath() %>/Member/m_update_pro.mkfc" method="post">
						  <div class="input-group">
						   	<b>���̵�</b><br>
						   	<input type="text" class="" size="20" name="mid" value="<%= m.getMid() %>" readonly>
						  </div>
						  <br>
						    <div class="input-group">
						   	<b>��й�ȣ</b><br>
						   	<input type="text" class="" size="20" name="mpw" value="<%= m.getMpw() %>">
						  </div>
						  <br>
						  <hr>
						  <div class="input-group">
						   <b>�̸�</b><br>
						   <input type="text" class="" name="mname" value="<%= m.getMname() %>">
						  </div>
						  <br>
						  <div class="input-group">
						   <b>�������</b><br>
						   <input type="date" class="" name="mbirth" value="<%= m.getMbirth() %>">
						  </div>
						  <br>
						  <div class="input-group">
						   <b>�ּ�</b><br>
						   <input type="text" class="" name="maddr" value="<%= m.getMaddr() %>">
						  </div>
						  <br>
						  <div class="input-group">
						   <b>����ó</b><br>
						   <input type="text" class="" name="mtel" value="<%= m.getMtel() %>">
						  </div>
						  <br>
						  <div class="input-group">
						   <b>�̸���</b><br>
						   <input type="text" class="" name="memail" value="<%= m.getMemail() %>">
						  </div>
						  <br>
						  <!-- <b>����</b><br> -->
						  <div class="input-group">
						   <input type="hidden" name="mlevel" value="�Ϲ�ȸ��">
						  </div>
						  <hr>
							<button class="" type="submit">�����Ϸ�</button>
							<br>
				</form>
				
			</div>
			<!-- --------------right-------------- -->
			<div class="col-sm-2">
			</div>
		</div>
	</div>
	<div class="col-sm-1">
	</div>
</div>
<%@ include file="/module/footer.jsp" %>