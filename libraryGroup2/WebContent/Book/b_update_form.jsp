<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/module/top.jsp" %>
<%@ page import = "book.dto.Book" %>
<h3>도서 수정</h3>
<!-- 도서코드는 자동으로 생성, 등록자는 세션에 입력된 정보에서 가져와 대입, 입고일은 책이 도서관에 등록된 날짜, 대여여부는 기본값 N이며 대출되고 반납될 때 마다 업데이트 -->
<%
	Book b = (Book)request.getAttribute("b");
%>
<form action="<%= request.getContextPath() %>/Book/b_update_pro.bkfc" method="post">
	ISBN
	<input type="text" class="form-control" name="bisbn" value="<%= b.getISBN()%>" readonly/>
	도서명
	<input type="text" class="form-control" name="bname" value="<%= b.getBtitle()%>"/>
	장르
	<select name="bgenre" class="form-control">
		<option value="수필">수필</option>
		<option value="소설">소설</option>
		<option value="만화">만화</option>
	</select>
	저자
	<input type="text" class="form-control" name="bwriter" value="<%= b.getBwriter()%>"/>
	출판사
	<input type="text" class="form-control" name="bpublisher" value="<%= b.getBpublisher()%>"/>
	출간일
	<input type="date" class="form-control" name="bdate"/>
	상세설명
	<input type="text" class="form-control" name="bdetail" value="<%= b.getBdetail()%>"/>
	<input type="submit" value="update"/>
</form>


<%@ include file="/module/footer.jsp" %>