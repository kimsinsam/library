<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/module/top.jsp" %>
<%@ page import = "book.dto.Book" %>
<h3>���� ����</h3>
<!-- �����ڵ�� �ڵ����� ����, ����ڴ� ���ǿ� �Էµ� �������� ������ ����, �԰����� å�� �������� ��ϵ� ��¥, �뿩���δ� �⺻�� N�̸� ����ǰ� �ݳ��� �� ���� ������Ʈ -->
<%
	Book b = (Book)request.getAttribute("b");
%>
<form action="<%= request.getContextPath() %>/Book/b_update_pro.bkfc" method="post">
	ISBN
	<input type="text" class="form-control" name="bisbn" value="<%= b.getISBN()%>" readonly/>
	������
	<input type="text" class="form-control" name="bname" value="<%= b.getBtitle()%>"/>
	�帣
	<select name="bgenre" class="form-control">
		<option value="����">����</option>
		<option value="�Ҽ�">�Ҽ�</option>
		<option value="��ȭ">��ȭ</option>
	</select>
	����
	<input type="text" class="form-control" name="bwriter" value="<%= b.getBwriter()%>"/>
	���ǻ�
	<input type="text" class="form-control" name="bpublisher" value="<%= b.getBpublisher()%>"/>
	�Ⱓ��
	<input type="date" class="form-control" name="bdate"/>
	�󼼼���
	<input type="text" class="form-control" name="bdetail" value="<%= b.getBdetail()%>"/>
	<input type="submit" value="update"/>
</form>


<%@ include file="/module/footer.jsp" %>