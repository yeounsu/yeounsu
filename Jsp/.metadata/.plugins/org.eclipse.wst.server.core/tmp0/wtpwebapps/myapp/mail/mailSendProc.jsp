<!-- mailSendProc.jsp -->
<%@page import="mail.GmailSend"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	String title = "테스트 제목입니다.";
	String id = request.getParameter("id");
	String toEmail = request.getParameter("email");
	String content = id+"/"+ toEmail;
	GmailSend.send(title, content,toEmail);
	response.sendRedirect("mailSend.jsp");
	

%>