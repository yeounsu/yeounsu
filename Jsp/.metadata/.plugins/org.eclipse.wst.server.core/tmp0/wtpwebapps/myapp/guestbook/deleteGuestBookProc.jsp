<%@page import="ch09.MUtil"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class = "guestbook.GuestBookMgr"></jsp:useBean>
<%
	int num = 0;
	if(request.getParameter("num")!=null){
		num = MUtil.parseInt(request, "num");
		mgr.deleteGuestbook(num);
		//���� ���� ������ ���õ� ��� ��� ����
	}
	response.sendRedirect("showGuestBook.jsp");
%>