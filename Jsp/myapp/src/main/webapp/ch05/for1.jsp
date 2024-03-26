<!-- for1.jsp -->
<%@page contentType="text/html; charset=UTF-8"%>
1에서 10까지의 합은?
<%
		int sum = 0;
		for(int i = 0;i<11;i++){
			sum+=i;
		}
		out.println("sum : " + sum);
%>
<%
		String subject[] = {"Java","JSP","Android","Spring"};
%>
<table border="1">
	<tr> 
		<th>번호</th>
		<th>과목</th>
	</tr>
	<!-- 표현식을 사용하지 않고 out.println만 사용 출력 -->
	<!-- out.println &  out.print  : 출력의 차이점-->
	<%
			for(int i=0;i<subject.length;i++){
				out.println("<tr align='center'>");
				out.println("<td>"+(i+1)+"</td>");
				out.println("<td>"+subject[i]+"</td>");
				out.println("</tr>");
			} 
	%>
</table>







