<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	//Client�� ����� ��Ű ������ request�� ����
	Cookie cookies[] = request.getCookies();
	if(cookies!=null){
		for(int i = 0; i<cookies.length; i++){
			out.print("Cookie Name:" +cookies[i].getName() +"<br>");
			out.print("Cookie Value:" +cookies[i].getValue() +"<p>");
		}
	}
%>
<a href = "cookCookie.jsp">��Ű�丮</a>