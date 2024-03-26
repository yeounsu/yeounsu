<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="cMgr"scope="session" class="shop.CartMgr"/>
<jsp:useBean id="order" class ="shop.OrderBean"></jsp:useBean>
<%
	String id = (String)session.getAttribute("idKey");
	if(id==null){
		response.sendRedirect("login.jsp");
		return;
	}
	order.setId(id); // 장바구니 주문 세팅
	String flag = request.getParameter("flag");
	String msg="";
	if(flag.equals("insert")){
		msg = "장바구니에 저장 하였습니다.";
		cMgr.addCart(order);
	}else if(flag.equals("update")){
		msg = "장바구니에 수정 하였습니다.";
		cMgr.updateCart(order);
	}else if(flag.equals("delete")){
		msg = "장바구니에 삭제 하였습니다.";
		cMgr.deleteCart(order);
	}
	
%>
<script>
alert("<%=msg%>");
location.href ="cartList.jsp";
</script>