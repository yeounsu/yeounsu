<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="cMgr"scope="session" class="shop.CartMgr"/>
<jsp:useBean id="order" class ="shop.OrderBean"></jsp:useBean>
<%
	String id = (String)session.getAttribute("idKey");
	if(id==null){
		response.sendRedirect("login.jsp");
		return;
	}
	order.setId(id); // ��ٱ��� �ֹ� ����
	String flag = request.getParameter("flag");
	String msg="";
	if(flag.equals("insert")){
		msg = "��ٱ��Ͽ� ���� �Ͽ����ϴ�.";
		cMgr.addCart(order);
	}else if(flag.equals("update")){
		msg = "��ٱ��Ͽ� ���� �Ͽ����ϴ�.";
		cMgr.updateCart(order);
	}else if(flag.equals("delete")){
		msg = "��ٱ��Ͽ� ���� �Ͽ����ϴ�.";
		cMgr.deleteCart(order);
	}
	
%>
<script>
alert("<%=msg%>");
location.href ="cartList.jsp";
</script>