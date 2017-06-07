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
				<td>대여코드</td>
				<td>대여ID</td>
				<td>대여자명</td>
				<td>ISBN</td>
				<td>도서명</td>
				<td>대출일</td>
				<td>반납일</td>
				<td>반납완료</td>
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
				<td><a href="./r_delete_pro.rkfc?rcode=<%= r.getRcode()%>&risbn=<%= r.getRisbn()%>">반납하기</a></td>			
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