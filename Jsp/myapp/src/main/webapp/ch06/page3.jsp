<!-- charset : client���� ���� �ڵ��� ���ڵ� -->
<!--  pageEncoding : ���� JSP�������� ���ڵ� -->
<!--  pageEncoding�� ������ charset�� �� �� ������ �Ѵ�. -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="EUC-KR" 
		trimDirectiveWhitespaces="false"
		isELIgnored="false"

%>
<%
	String site = "JSPStudy.co.kr";
	request.setAttribute("site", site);
%>
����Ʈ �� : <%=site%><br>
<!-- EL���� -->
����Ʈ �� : ${site} 