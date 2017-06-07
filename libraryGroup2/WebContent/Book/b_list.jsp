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
			<td>도서상태</td>
			<td>대여</td>			
		</tr>
<%
	Bdao dao = new Bdao();
	ArrayList<Book> list = null;
	list = dao.bAllselect();
	
	
	
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
			<td><%= b.getBrental()%></td>
			<%
			String rental = b.getBrental();
			if(rental.equals("N")){ %>
			<td><a href="./Rental/r_insert_pro.rkfc?bisbn=<%= b.getISBN()%>">대여하기</a></td>
			<%}else{ %>
			<td>대여중</td>
			<%}
			String level = (String)session.getAttribute("S_LEVEL");
			if(level.equals("관리자")){
			%>
			<td><a href="./b_update_form.bkfc?bisbn=<%= b.getISBN()%>">수정</a></td>
			<td><a href="./b_delete_pro.bkfc?bisbn=<%= b.getISBN()%>">삭제</a></td>
			<% }%>
		</tr>
	<%}%>
	</table>

	
		<!-- delete modal -->
		<div id="bookdelete" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">도서 삭제</h4>
		      </div>
		      <div class="modal-body">
		        <p>정말 삭제하시겠습니까?</p>
		      </div>
		      <div class="modal-footer">
		        <button id="dbutton" type="button" class="btn btn-default" data-dismiss="modal">삭제</button>
		        <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		      </div>
		    </div>
		
		  </div>
		</div>
	</div>
	<div class="col-sm-1">
	</div>
</div>

<%@ include file="/module/footer.jsp" %>