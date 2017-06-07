<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form action="<%=request.getContextPath()%>/Member/m_search_list.mkfc" method="post">
	<center>
	<div class="input-group">
		<select style="width: 100px;" class="form-control" name="sk">
	        <option value="mid">아이디</option>
		    <option value="mlevel">권한</option>
		    <option value="mname">이름</option>
		    <option value="memail">이메일</option>
      	</select> 
		<input type="text" style="width: 300px;" class="form-control" placeholder="Search" name="sv">
		<button type="submit" class="btn btn-default" value="검색"><i class="glyphicon glyphicon-search"></i></button>
	</div>
	</center>
	<br>	
</form>