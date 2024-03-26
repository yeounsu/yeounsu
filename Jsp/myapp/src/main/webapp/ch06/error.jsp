<%@ page contentType="text/html; charset=EUC-KR"%>
<%@page isErrorPage="true"%>
<h1>Error Page</h1>
다음과 같은 예외가 발생 하였습니다. <br>
<%=exception.getMessage()%>