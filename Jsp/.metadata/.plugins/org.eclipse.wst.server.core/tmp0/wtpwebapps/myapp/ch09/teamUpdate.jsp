<%@page import="java.util.Vector"%>
<%@page import="ch09.MUtil"%>
<%@page import="ch09.TeamBean"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mgr" class="ch09.TeamMgr"/>
<% Vector<String> vlist = mgr.getTeamList(); %>
<%
    int num;
    String numParam = request.getParameter("num");
    if (numParam == null || numParam.isEmpty()) {
        // "num" 파라미터가 전달되지 않았거나 비어있는 경우, 기본값인 0으로 설정하거나 처리할 방법을 결정할 수 있습니다.
        // 여기서는 임의의 음수(-1)를 설정하겠습니다.
        num = -1;
    } else {
        num = MUtil.parseInt(request, "num");
    }

    TeamBean bean = mgr.getTeam(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team Mgr</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function selectTeam(team){
	document.frm.team.value = team;
}
</script>
</head>
<body>
<div align="center">
<h1>Team Update</h1>
<form name="frm" method="post" action="teamUpdateProc.jsp">
<table border="1">
<tr>
	<td width="50" align="center">번호</td>
	<td width="150">
		<input name="num" value="<%=num%>" readonly>
	</td>
</tr>
<tr>
	<td width="50" align="center">이름</td>
	<td width="150"><input name="name" value="<%=bean.getName()%>"></td>
</tr>
<tr>
	<td align="center">사는곳</td>
	<td><input name="city" value="<%=bean.getCity()%>"></td>
</tr>
<tr>
	<td align="center">나이</td>
	<td ><input name="age" value="<%=bean.getAge()%>"></td>
</tr>
<tr>
	<td align="center">팀명</td>
	<td>
	<input name ="team" value="<%=bean.getTeam()%>" size ="20">
	<select id ="teamselect" onchange="selectTeam(this.value)">
	<option >팀 선택</option>
		<%for(int i =0; i<vlist.size(); i++){ %>
		<option value="<%=vlist.get(i) %>"><%=vlist.get(i) %></option>
		<%} %>
	</select>
	</td>
</tr>
<tr>
	<td align="center" colspan="2">
		<input type="submit" value="UPDATE">
	</td>
</tr>
</table>
</form><p>
<a1 href="teamRead.jsp?num=<%=num%>">READ</a>
</div>
</body>
</html>
