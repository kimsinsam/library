<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<form action="<%=request.getContextPath()%>/Book/b_list.bkfc" method="post">
	<br>
	<center>
		<div class="input-group">
			<select style="width: 100px;" class="form-control" name="sk">
		        <option value="btitle">å ����</option>
			    <option value="bwriter">�۰�</option>
			    <option value="bgenre">�帣</option>
			    <option value="bpublisher">���ǻ�</option>
	      	</select> 
			<input type="text" style="width: 300px;" class="form-control" placeholder="Search" name="sv">
			<button type="submit" class="btn btn-default" value="�˻�"><i class="glyphicon glyphicon-search"></i></button>
		</div>
	</center>
	<br>	
	<hr>
</form>