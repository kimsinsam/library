<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.util.*" %>
<%@ page import = "rental.dto.*" %>
<%@ include file="/module/top.jsp" %>
	<div class="container-fluid">
		<div class="col-sm-2">
		</div>
		<div class="col-sm-8">
		<%@ include file="/Book/b_search_form.jsp" %>
		<table class="table table-hover">
			<tr>
				<td>�뿩�ڵ�</td>
				<td>�뿩ID</td>
				<td>�뿩�ڸ�</td>
				<td>ISBN</td>
				<td>������</td>
				<td>������</td>
				<td>�ݳ���</td>
				<td>�ݳ��Ϸ�</td>
			</tr>
			<tr>
				<%
				ArrayList<Rental> list = (ArrayList<Rental>)request.getAttribute("rlist");
				for(int i=0; i<list.size(); i++){
				Rental r = list.get(i);
				%>
				<td><%= r.getRcode()%></td>
				<td><%= r.getRid()%></td>
				<td><%= r.getRname()%></td>
				<td><%= r.getRisbn()%></td>
				<td><%= r.getRtitle()%></td>
				<td><%= r.getRdate()%></td>
				<td><%= r.getRreturn()%></td>
				<td><a href="./r_delete_pro.rkfc?rcode=<%= r.getRcode()%>&risbn=<%= r.getRisbn()%>">�ݳ��ϱ�</a></td>			
			</tr>

		<%}%>
		</table>
		<hr>
		<br>
		</div>
		<div class="col-sm-2">
		</div>
	</div>

<%@ include file="/module/footer.jsp" %>