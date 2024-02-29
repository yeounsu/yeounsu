<!-- declaration1.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%!
		//필드 : JVM 초기화
		int a;
		int b = 1;
		int c = a + 10;
		//메소드안에 메소드 선언불가
		public int plus(){
			int d = a + b;
			return d;
		}
%>
<!-- 표현식안에는 변수 및 메소드 호출 -->
<%=plus()%>
<%=Math.max(10, 20) %>

