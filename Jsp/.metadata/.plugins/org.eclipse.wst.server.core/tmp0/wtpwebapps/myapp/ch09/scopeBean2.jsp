<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	//���ǿ� ����� Ư���� ���� ���� 
	session.removeAttribute("sBean");
//���� ��ü ��ü�� ������ ����, ��ȿȭ, �ʱ�ȭ
session.invalidate();
response.sendRedirect("scopeBean.jsp");
%>