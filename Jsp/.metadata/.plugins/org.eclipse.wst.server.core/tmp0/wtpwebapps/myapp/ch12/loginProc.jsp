<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch12.MemberMgr"></jsp:useBean>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	boolean result = mgr.loginChk(id,pwd);
	String msg = "로그인 실패 하였습니다.";
	String url = "loginchk.jsp";
	if (result){
		//세션에 성공한 로그인 id를 키 값 idKey로 저장 - 30분
		session.setAttribute("idKey",id);
		msg = "로그인 성공 하였습니다.";
		url = "loginOK.jsp";
	}

%>
<script>
	alert("<%=msg%>");
	location.href = "<%=url%>";
	</script>