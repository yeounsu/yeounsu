<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch14.MemberMgr"></jsp:useBean>
<jsp:useBean id="bean" class="ch14.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>
<%
	boolean result = mgr.insertMember(bean);
String msg = "���Խ���";
String location = "member.jsp";
if(result){
	msg = "���Լ���";
	location = "login.jsp";
	//���԰� ���ÿ� �α��� ó��
	session.setAttribute("idKey",bean.getId());
	
}
%>
<script type = "text/javascript">
alert("<%=msg%>");
location.href = "<%=location%>";
</script>