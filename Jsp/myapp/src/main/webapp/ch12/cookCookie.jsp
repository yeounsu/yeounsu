<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	String cookieName = "myCookie";
//��Ű�� ����
	Cookie cookie = new Cookie(cookieName, "Apple");
	cookie.setMaxAge(60);//1��
	
	cookie.setValue("Melone");
	//������ ��Ű�� ���䰴ü�� ����
	response.addCookie(cookie);
%>
��Ű�� ��������ϴ�. <br>
��Ű ������ <a href="tasteCookie.jsp">���⼭ Ȯ��</a>