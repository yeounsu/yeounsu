
<%@ page contentType="text/html; charset=UTF-8"%>
<%
//name이라는 이름의 객체를 받아오겠다 (includeTang.html에서)
	String name = request.getParameter("name" );	
%>
<!-- include 액션태그 호출시 요청정보 (request)도 같이 넘어감. -->
<jsp:include page="includeTagTop1.jsp" flush="true"/>
include 액션태그의 Body입니다.