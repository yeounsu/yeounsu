<!-- ch05/script.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<!-- 선언문(Declaration) -->
<%!
		//필드선언
		String dec = "선언문 변수";

		//메소드 선언
		public String decMethod(){
			return dec;
		}
%>
<!-- 스크립트릿(Scriptlet) _jspService 구현 -->
<%
		String scriptlet = "스크립트릿";
		out.println("내장객체를 이용한 출력 : " + dec + "<p>");
		System.out.println("서버 콘솔창에 출력");
%>
<!-- 표현식(Expression) -->
선언문1 : <%=dec %><br>
선언문2 : <%=decMethod() %><br>
스크립트릿1 : <%=scriptlet %><br>
<!-- JSP 주석(Comment) -->
<%
		String comment = "Comment";
%>
<!-- HTML 주석 -->
<%
		//한줄 주석
		/*여러줄 주석 & 부분주석*/
%>
<!-- JSP주석1 <%=comment %> -->
<%-- JSP주석2 : <%=comment%> --%>








