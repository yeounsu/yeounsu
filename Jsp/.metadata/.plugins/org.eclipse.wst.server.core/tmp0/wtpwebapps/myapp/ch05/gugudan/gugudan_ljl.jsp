<%@ page contentType="text/html; charset=EUC-KR" %>

<link href="gugudan.css" rel="stylesheet" type="text/css">

<table>
<caption>������(?) ������</caption>
	<thead>
		<tr>
			<%for(int i = 2; i <= 9; i++){%>
				<th><%=i+" ��"%> </th>
			<%}%>
		</tr>
	</thead>
	<tbody>
		<%for (int i = 1; i <= 9; i++) {%>
		<tr>
			<%for (int j = 2; j <= 9; j++) {%>
				<td><%=j+" x "+i+" = "+j*i%> </td>
			<%}%>
		</tr>
		<%}%>
	</tbody>

</table>
