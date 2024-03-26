<%@page import="guestbook.CommentBean"%>
<%@page import="guestbook.GuestBookBean"%>
<%@page import="java.util.Vector"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mgr" class = "guestbook.GuestBookMgr"></jsp:useBean>
<jsp:useBean id="cmgr" class = "guestbook.CommentMgr"></jsp:useBean>
<%
	String id = (String)session.getAttribute("idKey");
	if(id == null){
		//현재 접속된 URL 리턴 
		StringBuffer url = request.getRequestURL();
		response.sendRedirect("login.jsp?url="+url);
		return;
	}
%>
<html>
<title>GuestBook</title>
<script type="text/javascript">
	function updateFn(num) {
		url = "updateGuestBook.jsp?num="+num;
		window.open(url, "GuestBook Update", "width=540, height=300");
	}
	
	function commentFn(frm){
		if(frm.comment.value == ""){
			alert("댓글을 입력하세요.");
		frm.comment.focus();
		return;
		}
		frm.submit();
	}
	function disFn(num){
		//alert(num);
		var v = "cmt" +num;
		var e = document.getElementById(v); //cmt11
		if(e.style.display=='none')
			e.style.display = 'block'; //보이는거
		else
			e.style.display = 'none'; //안보이는거
	}
	function delFn(cnum){
		document.delFrm.action = "commentProc.jsp";
		document.delFrm.cnum.value=cnum;
		document.delFrm.submit();
	}
</script>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#996600">
<div align="center">
<%@include file="postGuestBook.jsp" %>
<table width="520" cellspacing="0" cellpadding="3">
	<tr bgcolor="#F5F5F5"> 
		<td><b><%=login.getName()%></b></td>
		<td align="right">로그아웃</b></td>
	</tr>
</table>
<!-- GuestBook List Start -->

<%
	//login 객체는 27라인에 postGuestBook.jsp에서 session에서 가져옴
	Vector<GuestBookBean> vlist = mgr.listGuestBook(id, login.getGrade());
	//out.print(vlist.size());
%>
<%if(vlist.isEmpty()) {%>
<table width="520" cellspacing="0" cellpadding="7">
	<tr>
		<td>등록된 글이 없습니다.</td>
	</tr>
</table>
<%}else{%>
<%
for(int i =0; i<vlist.size();i++){
	//방명록글
	GuestBookBean bean = vlist.get(i);
	int num = bean.getNum();//방명록글 번호
	//방명록 글쓴이
	JoinBean writer = mgr.getJoin(bean.getId());

%>
<table  width="520" border="1" bordercolor="#000000" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table bgcolor="#F5F5F5">
				<tr>
					<td width="225">NO : <%=vlist.size()-i %> </td>					
					<td width="225">
						<img src="img/face.bmp" border="0" alt="이름">
						">
							<%=writer.getName()%>
						
					</td>					
					<td width="150" align="center">
						<%if(writer.getHp()==null||writer.getHp().equals("")){
								out.println("홈페이지가 없네요");
							}else{
						%>
						<a href="<%=writer.getHp()%>">
							<img alt="홈페이지" src="img/hp.bmp" border="0">
						</a>
						<%}%>
					</td>					
				</tr>
				<tr>
					<td colspan="3"><%=bean.getContents() %></td>					
				</tr>
				<tr>
					<td>IP : <%=bean.getIp() %></td>					
					<td><%=bean.getRegdate()+" "+bean.getRegtime() %></td>					
					<td>
						<!-- 
							수정, 삭제 : 로그인 id와 writer id가 동일 
							삭제 : 관리자
							비밀글 : secret 1일때 
						 -->
						 <%
						 	boolean chk = id.equals(writer.getId());
						 	if(chk||login.getGrade().equals("1")){
						 		if(chk){
						 			%>
						 			<a href = "javascript:updateFn('<%=num%>')">[수정]</a>
						 			<% }
						 			%>
						 			<a href = "deleteGuestBookProc.jsp?num=<%=num%>">[삭제]</a>
						 			<%
						 			
						 	}
						 	if(bean.getSecret().equals("1")){
						 		out.print("비밀글");
						 	}
						 %>
						 
			 
						 
					</td>						
				</tr>
			</table>
		</td>
	</tr>
</table>
<!-- Comment List Start -->
<div id="cmt<%=num %>"style="display:none">
<%
	Vector<CommentBean> cvlist = cmgr.listComment(num);
	//out.print(cvlist.size());
	if(!cvlist.isEmpty()){
		%>
		<table width="500" bgcolor="#F5F5F5">
		<%			
			for(int j=0;j<cvlist.size();j++){
				CommentBean cbean = cvlist.get(j);
		%>
			<tr>
				<td>
					<table width="500">
						<tr>
							<td><b><%=cbean.getCid()%></b>	</td>
							<td align="right">
							<!-- 삭제는 로그인 id와 댓글 쓴 id랑 동일 -->
							<%-- <a href="commentProc.jsp?flag=delete&cnum=<%=cbean.getCnum()%>">[삭제]</a>--%>
							<a href="#" onclick="javascript:delFn('<%=cbean.getCnum()%>')">[삭제]</a>
							</td>
						</tr>
						<tr>
							<td colspan="2"><%=cbean.getComment() %></td>
						</tr>
						<tr>
							<td><%=cbean.getCip()%></td>
							<td align="right"><%=cbean.getCregDate()%></td>
						</tr>
					</table>
				<hr>	
				</td>
			</tr>
		<%}//---for(Comment)%>
		</table>
		
	<%}//--if(comment)%>

</div>
<table width="500">
<tr><td>
	<button onclick="disFn('<%=num%>')">댓글<%=cvlist.isEmpty()?"":cvlist.size() %></button>
</td></tr>
</table>
<!-- Comment List End -->
<!-- Comment Form Start -->
<form name="cFrm" method="post" action="commentProc.jsp">
<table>
	<tr>
		<td>
			<textarea placeholder="댓글입력..." name="comment" rows="2" 
			cols="65" maxlength="1000"></textarea>
		</td>
		<td>
			<input type="button" value="댓글" onclick="commentFn(this.form)">
			<input type="hidden" name="flag" value="insert">
			<!-- 방명록 글번호 -->
			<input type="hidden" name="num" value="<%=bean.getNum()%>">
			<!-- 로그인 id -->
			<input type="hidden" name="cid" value="<%=login.getId()%>">
			<!-- 댓글 입력 ip 주소 -->
			<input type="hidden" name="cip" value="<%=request.getRemoteAddr()%>">
		</td>
	</tr>
</table>	
</form>
<!-- Comment List End -->
<%
}//--for
}//--if-else %>


<!-- GuestBook List End -->

<form method="post" name="delFrm">
	<input type="hidden" name="flag" value="delete">
	<input type="hidden" name="cnum">
</form>
</div>
</body>
</html>