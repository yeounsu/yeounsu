<!-- request2.jsp -->
<%@page import="ch07.MyUtil"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%
		String protocol = request.getProtocol();
		int port = request.getServerPort();
		String remoteAddr = request.getRemoteAddr();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		//?이후 조건값
		String query = request.getQueryString();
		int age = Integer.parseInt(request.getParameter("age"));
		int age2 = MyUtil.parseInt(request, "age");
%>
protocol : <%=protocol %><br>
port : <%=port %><br>
remoteAddr : <%=remoteAddr %><br>
method : <%=method %><br>
uri : <%=uri %><br>
url : <%=url %><br>
query : <%=query %><br>

			
			
			
			
			
			
			
			