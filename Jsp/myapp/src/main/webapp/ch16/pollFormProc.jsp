
<%@page import="ch16.UtilMgr"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch16.PollMgr"></jsp:useBean>
<%
	int listNum = UtilMgr.parseInt(request, "num");
	String itemNum[]= request.getParameterValues("itemnum");
	boolean result = mgr.updatePoll(listNum, itemNum);
	//out.print(result);
	String msg = "투표에 실패하였습니다.";
	if(result) msg = "투표에 성공하였습니다.";
%>
<script>
	alert("<%=msg%>");
	location.href = "pollList.jsp?num=<%=listNum%>";
</script>