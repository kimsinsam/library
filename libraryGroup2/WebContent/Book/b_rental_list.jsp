<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%@ page import = "book.dao.Bdao" %>
<%@ page import = "book.dto.Book" %>
<%@ page import = "java.util.ArrayList" %>
<%@ include file="/module/top.jsp" %>
<br>
<div class="container-fluid">
	<div class="col-sm-1">
	</div>
	<div class="col-sm-10">
	<%@ include file="/Book/b_search_form.jsp" %>
		<table class="table table-hover">
		<tr>
			<td>ISBN</td>
			<td>������</td>
			<td>�۰�</td>
			<td>�帣</td>
			<td>���ǻ�</td>
			<td>������</td>
			<td>�󼼼���</td>
			<td>�ݳ��ϱ�</td>			
		</tr>
<%
	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("book");
	
	
	
	for(int i=0; i<list.size(); i++){
		Book b = list.get(i);
		%>
		<tr>
			<td><%= b.getISBN()%></td>
			<td><%= b.getBtitle()%></td>
			<td><%= b.getBwriter()%></td>
			<td><%= b.getBgenre()%></td>
			<td><%= b.getBpublisher()%></td>
			<td><%= b.getBdate()%></td>
			<td><%= b.getBdetail()%></td>
			<td><a href="./r_delete_pro.rkfc?rcode=<%= b.getRcode()%>&risbn=<%= b.getISBN()%>">�ݳ��ϱ�</a></td>	
		</tr>
		<%} %>
	</table>

<%@ include file="/module/footer.jsp" %>