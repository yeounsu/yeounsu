<%@ page  contentType="text/html; charset=EUC-KR"%>
<h1>������</h1>
<table border="1">
	<tr bgcolor=#ccccff>
	<%for(int i=2;i<=9;i++) {%>
	
		<th><%=i + "��" %></th>
		<%} %>
		<tr>
		<%for(int i=1;i<=9;i++) {%>
		<tr bgcolor=#D5C2EE>
		<%
			for(int j=2;j<=9;j++){
		%>
		<td><%=j + " X " + i + " = " +j * i %></td>
		<%} %>
		<tr>
		<%} %>
</table>