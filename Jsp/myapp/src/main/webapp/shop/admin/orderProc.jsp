<%@page import="shop.UtilMgr"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="orderMgr" class = "shop.OrderMgr"></jsp:useBean>
<%
	String flag = request.getParameter("flag");
	int no = UtilMgr.parseInt(request,"no");
	String msg = "������ �߻� �Ͽ����ϴ�.";
	if(flag.equals("update")){
		String state = request.getParameter("state");
		if(orderMgr.updateOrder(no, state)){
			msg = "���� �Ͽ����ϴ�.";
		}
	}else if(flag.equals("delete")){
		if(orderMgr.deleteOrder(no)){
			msg = "���� �Ͽ����ϴ�.";
		}
	}
%>
<script>
alert("<%=msg%>");
location.href="orderMgr.jsp";
</script>