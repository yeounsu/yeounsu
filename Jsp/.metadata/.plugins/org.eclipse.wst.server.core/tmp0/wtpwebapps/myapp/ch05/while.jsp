<!-- while.jsp -->
<%@page import="ch05.MyUtil"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%
			String msg = request.getParameter("msg");
			int number = Integer.parseInt(request.getParameter("number"));
			int cnt = 0;
			while(number>cnt){
%>
			<font color="<%=MyUtil.randomColor()%>">
			<%=msg%></font><p> 
<%
				cnt++;
			}//--while
%>