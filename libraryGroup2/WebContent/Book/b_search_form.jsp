<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<form action="<%=request.getContextPath()%>/Book/b_list.bkfc" method="post">
	<br>
	<center>
		<div class="input-group">
			<select style="width: 100px;" class="form-control" name="sk">
		        <option value="btitle">책 제목</option>
			    <option value="bwriter">작가</option>
			    <option value="bgenre">장르</option>
			    <option value="bpublisher">출판사</option>
	      	</select> 
			<input type="text" style="width: 300px;" class="form-control" placeholder="Search" name="sv">
			<button type="submit" class="btn btn-default" value="검색"><i class="glyphicon glyphicon-search"></i></button>
		</div>
	</center>
	<br>	
	<hr>
</form>