<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	String name ="�����";
	String bloodType = request.getParameter("bloodType");
%>
<jsp:forward page ='<%=bloodType+".jsp" %>'>
<jsp:param name="name" value="<%=name %>"/>
</jsp:forward>