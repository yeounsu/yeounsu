<%@ page contentType="text/html; charset=EUC-KR"%>
<%@page import="java.util.Date" import="java.sql.*, java.net.*" %>
<%@page buffer ="16kb" %>
<%
	Date d = new Date();
%>
현재의 날짜와 시간은? <%=d.toLocaleString()%>