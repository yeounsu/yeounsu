<%@page import="java.util.Enumeration"%>
<%@page import="shop.OrderBean"%>
<%@page import="java.util.Hashtable"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="cMgr"scope="session" class="shop.CartMgr"/>
<jsp:useBean id="orderMgr" class ="shop.OrderMgr"/>
<jsp:useBean id="pMgr" class ="shop.ProductMgr"/>
<%
	//���ǿ� ����� ��ٱ��� ����
	Hashtable<Integer, OrderBean> hCart = cMgr.getCartList();
	Enumeration<Integer> hCartKey = hCart.keys();
	String msg = "��ٱ��ϰ� ������ϴ�.";
	if(!hCart.isEmpty()){
		while(hCartKey.hasMoreElements()){
			OrderBean order = hCart.get(hCartKey.nextElement());
			//�ֹ�ó��
			orderMgr.insertOrder(order);
			//�������
			pMgr.reduceProduct(order);
			//��ٱ��Ͽ� �ֹ��� ��ǰ ����
			cMgr.deleteCart(order);
		}
		msg = "�ֹ�ó�� �Ͽ����ϴ�.";
	}
%>
<script>
alert("<%=msg%>");
location.herf = "orderList.jsp";
</script>