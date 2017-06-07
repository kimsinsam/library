<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "member.dao.Mdao" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "member.dto.Member" %>

<%@ include file="/module/top.jsp" %>
<br>
<div class="container-fluid">
	<div class="col-sm-2">
	</div>
	<div class="col-sm-8">
	<%@ include file="/Member/m_search_form.jsp" %>
<!-- -------------------------------------------- -->
		<table class="table table-hover">
				<tr>
					<th>���̵�</th>
					<th>�̸�</th>
					<th>�������</th>
					<th>����ó</th>
					<th>�ּ�</th>
					<th>�̸���</th>
					<th>�뿩����</th>
					<th>�뿩Ƚ��</th>
					<th>����</th>
					<th>����</th>
					<th>����</th>
				</tr>
			<%
			ArrayList<Member> one = (ArrayList<Member>)request.getAttribute("get_alm");
			for(int i = 0; i<one.size() ; i++){
			Member m = one.get(i);
			%>
				<tr>
					<td><%= m.getMid()%></td>
					<td><%= m.getMname()%></td>
					<td><%= m.getMbirth()%></td>
					<td><%= m.getMaddr()%></td>
					<td><%= m.getMtel()%></td>
					<td><%= m.getMemail()%></td>
					<td><%= m.getMrental()%></td>
					<td><%= m.getMrentalno()%></td>
					<td><%= m.getMlevel()%></td>
					<td>
						<a href="<%= request.getContextPath() %>/Member/m_update_form.mkfc?send_id=<%= m.getMid()%>">����</a>			
					</td>
					<td>
						<a href="<%= request.getContextPath() %>/Member/m_delete_pro.mkfc?send_id=<%= m.getMid()%>">����</a>			
					</td>
				</tr>
		<%
		} 
		%>
		</table>
	</div>
	<div class="col-sm-2">
	</div>
</div>
<%@ include file="/module/footer.jsp" %>