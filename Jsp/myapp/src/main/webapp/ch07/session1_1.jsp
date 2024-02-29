<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String season = request.getParameter("season");
String fruit = request.getParameter("fruit");

//세션에 저장된 id값을 리턴
String id = (String)/*만들어준 객체 타입을 꼭 넣어줘야한다.*/session.getAttribute("idKey");
int intervalTime = session.getMaxInactiveInterval();
if(id != null){
%>
<b><%=id%></b>님이 좋아하는 계절과 과일은<p>
<b><%=season%></b>과 <b><%=fruit%></b>입니다.<p>
세션ID : <%=session.getId()%><br>
세션 유지 시간 : <%=intervalTime%>초
<%
}else{
	out.print("세션의 시간이 경과하였거나, 다른 이유로 연결을 할 수 없습니다.");
	
}
%>