<%@page import="ch15.UtilMgr"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%
    int totalRecord = UtilMgr.parseInt(request, "totalRecord");
    int numPerPage = 10;
    int pagePerBlock = 15;
    int totalPage = 0;
    int totalBlock = 0;
    int nowPage = 1;
    int nowBlock = 1;
    
    if(request.getParameter("nowPage") != null){
        nowPage = UtilMgr.parseInt(request, "nowPage");
    }
    int start = (nowPage * numPerPage) - numPerPage;
    
    totalPage = (int)Math.ceil((double)totalRecord / numPerPage);
    totalBlock = (int)Math.ceil((double)totalPage / pagePerBlock);
    nowBlock = (int)Math.ceil((double)nowPage / pagePerBlock); // 수정: 현재 페이지의 블럭 번호를 계산
    
%>
<!DOCTYPE html>
<html>
<head>
    <title>페이징 & 블럭 처리 테스트</title>
</head>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
    function pageing(page){
        document.readFrm.nowPage.value = page;
        document.readFrm.submit();
    }
    function block(block){
        document.readFrm.nowPage.value = (block - 1) * <%=pagePerBlock%> + 1; // 수정: 블럭 클릭 시 페이지 계산
        document.readFrm.submit();
    }
</script>
<body bgcolor="#FFFFCC">
<div align="center"><br/>
<h2>페이징 & 블럭 처리 테스트</h2>
<table>
    <tr>
        <td  width="700" align="center">
        Total : <%=totalRecord%> Articles(
        <font color="red"><%=nowPage+"/"+totalPage%> Pages</font>
        )
        </td>
    </tr>
</table>
<table>
    <tr>
        <td>게시물 번호 : &nbsp;</td>
        <%
            int listSize = totalRecord - start;
            for(int i = 0; i < numPerPage; i++){
                if(i == listSize) break;
        %>
        <td align="center"><%=totalRecord - start - i %></td>
        <% } %>
    </tr>
</table>
<table>
    <tr>
        <td>
        <% if(nowBlock > 1){ %>
            <a href="javascript:block('<%=nowBlock - 1%>')">prev...</a>
        <% } %>
        <% 
            int pageStart = (nowBlock - 1) * pagePerBlock + 1;
            int pageEnd = (pageStart + pagePerBlock) < totalPage ? pageStart + pagePerBlock : totalPage + 1;
            for(; pageStart < pageEnd; pageStart++){
        %>
        <a href="javascript:pageing('<%=pageStart%>')">
            <% if(nowPage == pageStart){ %> <font color="blue"> <% } %>
            [<%=pageStart%>]
            <% if(nowPage == pageStart){ %> </font> <% } %>
        </a>
        <% } %>
        <% if(nowBlock < totalBlock){ %> <!-- 수정: 현재 블럭이 총 블럭보다 작을 때만 다음 블럭 링크를 생성 -->
            <a href="javascript:block('<%=nowBlock + 1%>')">...next</a>
        <% } %>
        </td>
    </tr>
</table>
<form name="readFrm">
    <input type="hidden" name="totalRecord" value="<%=totalRecord%>">
    <input type="hidden" name="nowPage" value="<%=nowPage%>">
</form>
<hr width="60%"/>
<b>
totalRecord : <%=totalRecord%>&nbsp;
numPerPage : <%=numPerPage%>&nbsp;
pagePerBlock : <%=pagePerBlock%>&nbsp;
totalPage : <%=totalPage%>&nbsp;<br/>
totalBlock : <%=totalBlock%>&nbsp;
nowPage : <%=nowPage%>&nbsp;
nowBlock : <%=nowBlock%>&nbsp;
</b>
<p/>
<input type="button" value="TotalRecord 입력폼"
 onClick="javascript:location.href='pageView.html'">
</div>
</html>
