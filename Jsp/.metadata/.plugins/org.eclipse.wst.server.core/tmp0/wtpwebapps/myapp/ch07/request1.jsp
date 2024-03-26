<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	String name = request.getParameter("name");
	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");
	String hobby[] = request.getParameterValues("hobby");
%>
name : <%=name %><br>
studentNum : <%=studentNum %><br>
gender : <%=gender %><br>
major : <%=major %><br>
hobby : <%
	for(int i = 0; i<hobby.length; i++){
		out.println(hobby[i] + "&nbsp;");
	}
%>