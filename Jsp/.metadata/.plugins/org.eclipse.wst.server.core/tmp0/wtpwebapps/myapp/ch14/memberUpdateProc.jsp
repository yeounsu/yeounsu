<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch14.MemberMgr"></jsp:useBean>
<jsp:useBean id="bean" class="ch14.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name ="bean"/>

<%
	boolean result = mgr.updateMember(bean);
if(result){
	

%>
<script>
alert("ȸ�������� �����Ͽ����ϴ�.");
location.href = "login.jsp";
</script>
<% }else{%>
<script>
alert("ȸ������ ������ �����Ͽ����ϴ�.");
history.back();
</script>
<%} %>
	