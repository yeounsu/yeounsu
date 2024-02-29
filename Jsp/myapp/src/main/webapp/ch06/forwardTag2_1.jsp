<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	String name ="¼ÕÈï¹Î";
	String bloodType = request.getParameter("bloodType");
%>
<jsp:forward page ='<%=bloodType+".jsp" %>'>
<jsp:param name="name" value="<%=name %>"/>
</jsp:forward>