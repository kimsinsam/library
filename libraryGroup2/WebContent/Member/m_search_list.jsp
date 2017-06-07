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
					<th>아이디</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>연락처</th>
					<th>주소</th>
					<th>이메일</th>
					<th>대여여부</th>
					<th>대여횟수</th>
					<th>권한</th>
					<th>수정</th>
					<th>삭제</th>
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
						<a href="<%= request.getContextPath() %>/Member/m_update_form.mkfc?send_id=<%= m.getMid()%>">수정</a>			
					</td>
					<td>
						<a href="<%= request.getContextPath() %>/Member/m_delete_pro.mkfc?send_id=<%= m.getMid()%>">삭제</a>			
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