<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />
<%@ include file="/module/top.jsp" %>

<div class="container-fluid">	
	<div class="col-sm-2">
	</div>
	<div class="col-sm-8">
	<br>
	<h1><small><b>ȸ������</b></small></h1>
      <hr>
		<form action="<%= request.getContextPath() %>/Member/m_insert_pro.mkfc" method="post">
		  <div class="input-group">
		   	<b>���̵�</b><br>
		   	<input id="mid" type="text" class="" name="mid">
			<button class="" type="button">�ߺ�Ȯ��</button>
		  </div>
		  <br>
		  <div class="input-group">
		   <b>��й�ȣ</b><br>
		   <input id="mpw" type="password" class="" name="mpw">
		  </div>
		  <br>
		  <hr>
		  <div class="input-group">
		   <b>�̸�</b><br>
		   <input id="mname" type="text" class="" name="mname">
		  </div>
		  <br>
		  <div class="input-group">
		   <b>�������</b><br>
		   <input id="mbirth" type="date" class="" name="mbirth">
		  </div>
		  <br>
		  <div class="input-group">
		   <b>�ּ�</b><br>
		   <input id="maddr" type="text" class="" name="maddr">
		   <button class="" type="button">�ּ�ã��</button>
		  </div>
		  <br>
		  <div class="input-group">
		   <b>����ó</b><br>
		   <input id="mtel" type="text" class="" name="mtel">
		   <button class="" type="button">����</button>
		  </div>
		  <br>
		  <div class="input-group">
		   <b>�̸���</b><br>
		   <input id="memail" type="text" class="" name="memail">
		  </div>
		  <br>
		  <hr>
		  <button class="" type="submit">ȸ������</button>
		</form>
      <br><br>
	</div>
	
	<div class="col-sm-2">
	</div>

</div>
<%@ include file="/module/footer.jsp" %>