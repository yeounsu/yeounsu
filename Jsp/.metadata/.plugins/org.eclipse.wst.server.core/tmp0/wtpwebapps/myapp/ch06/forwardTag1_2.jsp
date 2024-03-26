<%@ page contentType="text/html; charset=EUC-KR"%>
<%
//include와 forward 액션태그는 요청정보 그대로 넘어옴.
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

	
%>
<!--  이 페이지에서 Client 브라우저 응답 -->
id : <%=id%><br>
pwd : <%=pwd%><br>
