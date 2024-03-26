<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch14.MemberMgr"></jsp:useBean>
<jsp:useBean id="bean" class="ch14.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name ="bean"/>

<%
	boolean result = mgr.updateMember(bean);
if(result){
	

%>
<script>
alert("회원정보를 수정하였습니다.");
location.href = "login.jsp";
</script>
<% }else{%>
<script>
alert("회원정보 수정에 실패하였습니다.");
history.back();
</script>
<%} %>
	