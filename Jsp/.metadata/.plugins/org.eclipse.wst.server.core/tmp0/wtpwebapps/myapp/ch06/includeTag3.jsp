<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String name = "남주혁";
	String bloodType = request.getParameter("bloodType");
%>
<!-- 표현식에서 "" 값이 필요할 때는 ''으로 시작한다. -->
<jsp:include page='<%=bloodType+ ".jsp"%>'>

	<jsp:param name = "name" value="<%=name %>"/>
</jsp:include>