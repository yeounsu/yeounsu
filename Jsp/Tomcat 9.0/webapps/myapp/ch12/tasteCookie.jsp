<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	//Client에 저장된 쿠키 정보는 request에 저장
	Cookie cookies[] = request.getCookies();
	if(cookies!=null){
		for(int i = 0; i<cookies.length; i++){
			out.print("Cookie Name:" +cookies[i].getName() +"<br>");
			out.print("Cookie Value:" +cookies[i].getValue() +"<p>");
		}
	}
%>
<a href = "cookCookie.jsp">쿠키요리</a>