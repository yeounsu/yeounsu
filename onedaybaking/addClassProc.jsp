<%@ page contentType="text/html; charset=UTF-8"%>

<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="cMgr" class="onedaybaking.addclassMgr" />
<jsp:useBean id="cBean" class="onedaybaking.ClassBean" />
<jsp:useBean id="caBean" class="onedaybaking.CateBean" />
<jsp:setProperty name="cBean" property="*"/>
<jsp:setProperty name="caBean" property="*"/>
<%
String id = (String)session.getAttribute("idKey");
int key = cMgr.getCatekey();
	boolean flag = cMgr.insertClass(cBean, key, id);
	boolean flag1 = cMgr.insertCate(caBean);
%>
<html>
<head>
<title>강의등록</title>
<link href="yeounsu.css" rel="stylesheet" type="text/css">
<html>
<body bgcolor="#FFFFCC">
<br/><br/>
<div align="center">
<%
if(flag && flag1){
	  out.println("<b>저장됨</b><p>");
	  out.println("<a href=panel1.jsp>ㅊㅊ</a>");
	}else{
	  out.println("<b>다시 입력하여 주십시오.</b><p>");
	  out.println("<a href=addClass.jsp>다시 가입</a>");
	}
%>
</div>
</body>
</html>

