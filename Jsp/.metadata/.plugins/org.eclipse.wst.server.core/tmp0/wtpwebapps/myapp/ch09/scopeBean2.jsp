<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	//세션에 저장된 특정한 값만 제거 
	session.removeAttribute("sBean");
//세션 객체 전체를 서버에 제거, 무효화, 초기화
session.invalidate();
response.sendRedirect("scopeBean.jsp");
%>