
<%@page import="ch16.UtilMgr"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch16.PollMgr"></jsp:useBean>
<%
	int listNum = UtilMgr.parseInt(request, "num");
	String itemNum[]= request.getParameterValues("itemnum");
	boolean result = mgr.updatePoll(listNum, itemNum);
	//out.print(result);
	String msg = "��ǥ�� �����Ͽ����ϴ�.";
	if(result) msg = "��ǥ�� �����Ͽ����ϴ�.";
%>
<script>
	alert("<%=msg%>");
	location.href = "pollList.jsp?num=<%=listNum%>";
</script>