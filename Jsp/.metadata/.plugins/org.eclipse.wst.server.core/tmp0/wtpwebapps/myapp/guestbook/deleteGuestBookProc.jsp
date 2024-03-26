<%@page import="ch09.MUtil"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class = "guestbook.GuestBookMgr"></jsp:useBean>
<%
	int num = 0;
	if(request.getParameter("num")!=null){
		num = MUtil.parseInt(request, "num");
		mgr.deleteGuestbook(num);
		//방명록 원글 삭제시 관련된 댓글 모두 삭제
	}
	response.sendRedirect("showGuestBook.jsp");
%>