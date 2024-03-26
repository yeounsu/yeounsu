<!-- script2.jsp -->
<%@page import="ch05.MyUtil"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%!
		public String randomColor(){
			Random r = new Random();
			String rgb = Integer.toHexString(r.nextInt(256));
			rgb += Integer.toHexString(r.nextInt(256));
			rgb += Integer.toHexString(r.nextInt(256));
			return "#"+rgb;
		}
%>
<%
		for(int i=0;i<10;i++){
			out.println("<font color="+randomColor()+">");
			out.println("오늘은 비오는 목요일<br>");
			out.println("</font>");
		}
%>
<hr>
<%
		for(int i=0;i<10;i++){
			out.println("<font color="+MyUtil.randomColor()+">");
			out.println("오늘은 비오는 목요일<br>");
			out.println("</font>");
		}
%>


