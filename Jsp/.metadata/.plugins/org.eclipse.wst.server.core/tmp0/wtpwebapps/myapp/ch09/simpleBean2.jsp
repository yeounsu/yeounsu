<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="bean" class="ch09.SimpleBean"/>
<jsp:setProperty property = "*" name = "bean"/>
msg : <jsp:getProperty property="msg" name="bean"/><br>
cnt : <jsp:getProperty property="cnt" name="bean"/><br>

<%
	
%>