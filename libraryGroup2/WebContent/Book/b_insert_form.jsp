<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/module/top.jsp" %>

<h3>���� ���</h3>
<!-- �����ڵ�� �ڵ����� ����, ����ڴ� ���ǿ� �Էµ� �������� ������ ����, �԰����� å�� �������� ��ϵ� ��¥, �뿩���δ� �⺻�� N�̸� ����ǰ� �ݳ��� �� ���� ������Ʈ -->
<form action="<%= request.getContextPath() %>/Book/b_insert_pro.bkfc" method="post">
	ISBN
	<input type="text" class="form-control" name="bisbn"/>
	������
	<input type="text" class="form-control" name="bname"/>
	�帣
	<select name="bgenre" class="form-control">
		<option value="����">����</option>
		<option value="�Ҽ�">�Ҽ�</option>
		<option value="��ȭ">��ȭ</option>
	</select>
	����
	<input type="text" class="form-control" name="bwriter"/>
	���ǻ�
	<input type="text" class="form-control" name="bpublisher"/>
	�Ⱓ��
	<input type="date" class="form-control" name="bdate"/>
	�󼼼���
	<input type="text" class="form-control" name="bdetail"/>
	<input type="submit" value="add"/>
</form>


<%@ include file="/module/footer.jsp" %>