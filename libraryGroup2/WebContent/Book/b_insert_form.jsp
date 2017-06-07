<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/module/top.jsp" %>

<h3>도서 등록</h3>
<!-- 도서코드는 자동으로 생성, 등록자는 세션에 입력된 정보에서 가져와 대입, 입고일은 책이 도서관에 등록된 날짜, 대여여부는 기본값 N이며 대출되고 반납될 때 마다 업데이트 -->
<form action="<%= request.getContextPath() %>/Book/b_insert_pro.bkfc" method="post">
	ISBN
	<input type="text" class="form-control" name="bisbn"/>
	도서명
	<input type="text" class="form-control" name="bname"/>
	장르
	<select name="bgenre" class="form-control">
		<option value="수필">수필</option>
		<option value="소설">소설</option>
		<option value="만화">만화</option>
	</select>
	저자
	<input type="text" class="form-control" name="bwriter"/>
	출판사
	<input type="text" class="form-control" name="bpublisher"/>
	출간일
	<input type="date" class="form-control" name="bdate"/>
	상세설명
	<input type="text" class="form-control" name="bdetail"/>
	<input type="submit" value="add"/>
</form>


<%@ include file="/module/footer.jsp" %>