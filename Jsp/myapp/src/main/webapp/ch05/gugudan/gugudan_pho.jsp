<%@ page  contentType="text/html; charset=EUC-KR"%>

<style>
table {
	border-collapse : collapse;
}
tbody tr:nth-child(even){
	background : aliceblue;
}
tbody tr:hover {
	background: yellow
}
</style>
<h1 style="text-align:center"> ������ </h1>
<table border = "1">
	<tr>
		<% 
		for (int i=2; i<10 ; i++){%>
		<th style="background-color: lightskyblue">
		<%=i + " ��"%></th>
		<%}%>
	</tr>
	<tbody>
	<%for (int i=1; i <= 9 ; i++) {%>
	<tr>
	  <%for (int j=2; j<=9 ; j++){%>
	  <td ><%=j + " X " + i + " = " + j*i %></td>
	  <%}%>
	</tr>
	<%}%>  
	</tbody>
</table>