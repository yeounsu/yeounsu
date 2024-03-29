<!-- read.jsp -->
<%@page import="java.util.Vector"%>
<%@page import="ch15.BoardBean"%>
<%@page import="ch15.UtilMgr"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mgr" class="ch15.BoardMgr"/>
<%
		//read.jsp?nowPage=1&numPerPage=10&keyField=&keyWord=&num=3
		String nowPage = request.getParameter("nowPage");
		String numPerPage = request.getParameter("numPerPage");
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		int num = UtilMgr.parseInt(request, "num");

		mgr.upCount(num);
		BoardBean bean = mgr.getBoard(num);
		
		String name = bean.getName();
		String subject = bean.getSubject();
		String regdate = bean.getRegdate();
		String content = bean.getContent();
		String filename = bean.getFilename();
		int filesize = bean.getFilesize();
		String ip = bean.getIp();
		int count = bean.getCount();	
		//읽어온 게시물을 수정, 삭제를 위해서 세션에 저장
		session.setAttribute("bean",bean);
%>
<!DOCTYPE html>
<html>
<head>
<title>JSP Board</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function list() {
		document.listFrm.action = "list.jsp";
		document.listFrm.submit();
	}
	function down(filename) {
		document.downFrm.filename.value=filename;
		document.downFrm.submit();
	}
	function delFn(){
		const pass = document.getElementById("passId");
		//alert(pass.value);
		if(pass.value.length==0){
			alert("비밀번호를 입력하세요");
			pass.focus();
			return;
		}
		document.delFrm.pass.value = pass.valuel
		document.delFrm.submit();
	}

</script>
</head>
<body bgcolor="#FFFFCC">
<br/><br/>
<table align="center" width="600" cellspacing="3">
 <tr>
  <td bgcolor="#9CA2EE" height="25" align="center">글읽기</td>
 </tr>
 <tr>
  <td colspan="2">
   <table cellpadding="3" cellspacing="0" width="100%"> 
    <tr> 
  <td align="center" bgcolor="#DDDDDD" width="10%"> 이 름 </td>
  <td bgcolor="#FFFFE8"><%=name%></td>
  <td align="center" bgcolor="#DDDDDD" width="10%"> 등록날짜 </td>
  <td bgcolor="#FFFFE8"><%=regdate%></td>
 </tr>
 <tr> 
    <td align="center" bgcolor="#DDDDDD"> 제 목</td>
    <td bgcolor="#FFFFE8" colspan="3"><%=subject%></td>
   </tr>
   <tr> 
     <td align="center" bgcolor="#DDDDDD">첨부파일</td>
     <td bgcolor="#FFFFE8" colspan="3">
		<%if(filename!=null&&!filename.equals("")){ %>
		<a href="javascript:down('<%=filename %>')">
		<%=filename %>
		</a>
		<font color="blue">
		(<%=UtilMgr.intFormat(filesize) %>bytes)
		</font>
		<%}else{out.print("첨부된 파일이 없습니다."); %>
     </td>
   </tr>
   <tr> 
    <td align="center" bgcolor="#DDDDDD">비밀번호</td>
    <td bgcolor="#FFFFE8" colspan="3">
    	<input type="password" name="pass" id="passId">
    </td>
   </tr>
   <tr> 
    <td colspan="4"><br/><pre><%=content%></pre><br/></td>
   </tr>
   <tr>
    <td colspan="4" align="right">
     IP주소 : <%=ip%> / 조회수  <%=count%>
    </td>
   </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td align="center" colspan="2">
 <!-- 댓글 입력폼 Start -->
     
 <!-- 댓글 입력폼 End -->

 <!-- 댓글 List Start -->

 <!-- 댓글 List End -->
 [ <a href="javascript:list()" >리스트</a> | 
 <a href="update.jsp?nowPage=<%=nowPage%>&num=<%=num%>&numPerPage=<%=numPerPage%>" >수 정</a> |
 <a href="reply.jsp?nowPage=<%=nowPage%>&numPerPage=<%=numPerPage%>" >답 변</a> |
 <a href="javascript:delFn()">삭 제</a> ]<br/>
  </td>
 </tr>
</table>
<form method="post" name="downFrm" action="download.jsp">
	<input type="hidden" name="filename">
</form>

<form name="listFrm">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
	<input type="hidden" name="numPerPage" value="<%=numPerPage%>">
	<%if(!(keyWord==null||keyWord.equals(""))){%>
	<input type="hidden" name="keyField" value="<%=keyField%>">
	<input type="hidden" name="keyWord" value="<%=keyWord%>">
	<%}%>
</form>

<form name="delFrm" action="boardDelete" method="post">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
	<input type="hidden" name="numPerPage" value="<%=numPerPage%>">
	<%if(!(keyWord==null||keyWord.equals(""))){%>
	<input type="hidden" name="keyField" value="<%=keyField%>">
	<input type="hidden" name="keyWord" value="<%=keyWord%>">
	<%}}%>
	<input type="hidden" name="pass">
</form>
</body>
</html>






