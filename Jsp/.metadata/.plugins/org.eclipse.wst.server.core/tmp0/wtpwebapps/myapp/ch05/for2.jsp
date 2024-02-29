<!-- for2.jsp -->
<%@page contentType="text/html; charset=UTF-8"%>
1번.1에서 10까지의 합을 식과 함께 출력(only 표현식)<br>
(1 + 2 + 3+ .... 9 + 10 = 55)<br>
<%
		int sum = 0;
		for(int i = 1;i<11;i++){
			if(i<10){
			%>
			<%=i + "  + "%>
			<%}else{%>
			<%=i + " = " %>
			<%	
			}
			sum+=i;
		}
%>
<%=sum%><p>
2번.1에서 10까지의 합을 식과 함께 출력(out.println 사용)<br>
<%
		sum = 0;
		for(int i = 1;i<11;i++){
			if(i<10) out.println(i + "  + ");
			else out.println(i + "  = ");
			sum+=i;	
		}
		out.println(sum);
%>		
		




