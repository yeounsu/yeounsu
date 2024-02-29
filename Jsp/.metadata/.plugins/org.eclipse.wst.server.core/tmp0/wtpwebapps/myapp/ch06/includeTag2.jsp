<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String siteName = request.getParameter("siteName" );
%>
요청한 사이트 : <%=siteName%>
<!-- 추가적인 요청값이 있을 때 param을 사용한다. -->
<jsp:include page="includeTagTop2.jsp" flush="true">
	<jsp:param  name="id" value="aaa"/>
	<jsp:param  name="pwd" value="1234"/>
</jsp:include>