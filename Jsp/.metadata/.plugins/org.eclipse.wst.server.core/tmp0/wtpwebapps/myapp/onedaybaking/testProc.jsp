<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="bean" class="onedaybaking.ClassBean"/>

<%
	String classname = request.getParameter("classname");
	String classteacherinfo = request.getParameter("classteacherinfo");
	String offercontent = request.getParameter("offercontent");
	String categorygroup = request.getParameter("categorygroup");
	String categoryname = request.getParameter("categoryname");
	String classtime = request.getParameter("classtime");
	String address = request.getParameter("address");
	String addressdetail = request.getParameter("addressdetail");
	String classlevel = request.getParameter("classlevel");
	String classimg1 = request.getParameter("classimg1");
	String classimg2 = request.getParameter("classimg2");
	String classimg3 = request.getParameter("classimg3");
	String classimg4 = request.getParameter("classimg4");
	String classimg5 = request.getParameter("classimg5");
	String classcontent = request.getParameter("classcontent");
	String classteacherimg = request.getParameter("classteacherimg");
	String roomimg1 = request.getParameter("roomimg1");
	String rommimg2 = request.getParameter("rommimg2");
	String[] checkedItems = request.getParameterValues("classstatus");
	String classmin = request.getParameter("classmin");
	String classmax = request.getParameter("classmax");
	String classprice = request.getParameter("classprice");
%>
<%=classname %><br>
<%=classteacherinfo %><br>
<%=offercontent %><br>
<%=categorygroup %><br>
<%=categoryname %><br>
<%=classtime %><br>
<%=address %><br>
<%=addressdetail %><br>
<%=classlevel %><br>
<%=classimg1 %><br>
<%=classimg2 %><br>
<%=classimg3 %><br>
<%=classimg4 %><br>
<%=classimg5 %><br>
<%=classcontent %><br>
<%=classteacherimg %><br>
<%=roomimg1 %><br>
<%=rommimg2 %><br>
<%=classmin %><br>
<%=classmax %><br>
<%=classprice %><br>
<% for (String item : checkedItems) { %>
    <%=item %>
<% } %>


<!--


id값 겹치는거 다 바꿔주는중!!!
step1까지 끝


 -->
 
 