<!-- mailSendProc.jsp -->
<%@page import="mail.GmailSend"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	String title = "�׽�Ʈ �����Դϴ�.";
	String id = request.getParameter("id");
	String toEmail = request.getParameter("email");
	String content = id+"/"+ toEmail;
	GmailSend.send(title, content,toEmail);
	response.sendRedirect("mailSend.jsp");
	

%>