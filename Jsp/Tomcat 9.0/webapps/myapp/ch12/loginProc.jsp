<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch12.MemberMgr"></jsp:useBean>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	boolean result = mgr.loginChk(id,pwd);
	String msg = "�α��� ���� �Ͽ����ϴ�.";
	String url = "loginchk.jsp";
	if (result){
		//���ǿ� ������ �α��� id�� Ű �� idKey�� ���� - 30��
		session.setAttribute("idKey",id);
		msg = "�α��� ���� �Ͽ����ϴ�.";
		url = "loginOK.jsp";
	}

%>
<script>
	alert("<%=msg%>");
	location.href = "<%=url%>";
	</script>