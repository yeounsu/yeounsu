<%@ page contentType="text/html; charset=EUC-KR"%>
<%
response.setHeader("Cache-Control","no-store");  
response.setHeader("Pragma","no-cache");  
response.setDateHeader("Expires",0);  
if (request.getProtocol().equals("HTTP/1.1"))        
	response.setHeader("Cache-Control", "no-cache");
%>
response2.jsp 페이지입니다.