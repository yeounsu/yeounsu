<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch14.MemberMgr"></jsp:useBean>
<jsp:useBean id="bean" class="ch14.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="bean"/>
<%
	boolean result = mgr.insertMember(bean);
String msg = "가입실패";
String location = "member.jsp";
if(result){
	msg = "가입성공";
	location = "login.jsp";
	//가입과 동시에 로그인 처리
	session.setAttribute("idKey",bean.getId());
	
}
%>
<script type = "text/javascript">
alert("<%=msg%>");
location.href = "<%=location%>";
</script>