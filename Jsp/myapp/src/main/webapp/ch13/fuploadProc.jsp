<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mgr" class="ch13.FileloadMgr"></jsp:useBean>
<%
	String flag = request.getParameter("flag"); //의미없는 값
	mgr.uploadFile(request);
	response.sendRedirect("flist.jsp");
%>