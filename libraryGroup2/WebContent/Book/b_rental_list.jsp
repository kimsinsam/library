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
			<td>도서명</td>
			<td>작가</td>
			<td>장르</td>
			<td>출판사</td>
			<td>출판일</td>
			<td>상세설명</td>
			<td>반납하기</td>			
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
			<td><a href="./r_delete_pro.rkfc?rcode=<%= b.getRcode()%>&risbn=<%= b.getISBN()%>">반납하기</a></td>	
		</tr>
		<%} %>
	</table>

<%@ include file="/module/footer.jsp" %>