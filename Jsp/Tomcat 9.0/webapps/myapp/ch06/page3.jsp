<!-- charset : client에게 보낼 코드의 인코딩 -->
<!--  pageEncoding : 현재 JSP페이지의 인코딩 -->
<!--  pageEncoding이 없으면 charset이 둘 다 관여를 한다. -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page pageEncoding="EUC-KR" 
		trimDirectiveWhitespaces="false"
		isELIgnored="false"

%>
<%
	String site = "JSPStudy.co.kr";
	request.setAttribute("site", site);
%>
사이트 명 : <%=site%><br>
<!-- EL문법 -->
사이트 명 : ${site} 