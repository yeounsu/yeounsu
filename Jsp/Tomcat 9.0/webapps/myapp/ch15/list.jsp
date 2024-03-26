<%@page import="ch15.UtilMgr"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch15.BoardMgr"></jsp:useBean>
<jsp:useBean id="cmgr" class = "ch15.BCommentMgr"></jsp:useBean>

<%
    int totalRecord = 0;
    int numPerPage = 10;
    int pagePerBlock = 15;
    int totalPage = 0;
    int totalBlock = 0;
    int nowPage = 1;
    int nowBlock = 1;
    
    // ��û�� numPerPage ó��
    if(request.getParameter("numPerPage") != null){
        numPerPage = UtilMgr.parseInt(request, "numPerPage");
    }
    
    // �˻��� �ʿ��� ����
    String keyField = ""; // name, subject, content
    String keyWord = "";
    if(request.getParameter("keyWord") != null){
        keyField = request.getParameter("keyField");
        keyWord = request.getParameter("keyWord");
    }
    
    if(request.getParameter("reload") != null &&
            request.getParameter("reload").equals("true")){
        keyField = "";
        keyWord = "";
    }
    
    totalRecord = mgr.getTotalCount(keyField, keyWord);
    
    int start = (nowPage * numPerPage) - numPerPage;
    int cnt = numPerPage;
    
    // ��ü ������ ����
    totalPage = (int)Math.ceil((double)totalRecord / numPerPage);
    // ��ü �� ����
    totalBlock = (int)Math.ceil((double)totalPage / pagePerBlock);
    // ���� ��
    nowBlock = (int)Math.ceil((double)nowPage / pagePerBlock);
%>
<tr align="center"></tr>

<!DOCTYPE html>
<html>
<head>
    <title>JSP Board</title>
    <link href="style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function check() {
            if(document.searchFrm.keyWord.value == ""){
                alert("�˻�� �Է��ϼ���.");
                document.searchFrm.keyWord.focus();
                return;
            }
            document.searchFrm.submit();
        }
        
        function list() {
            document.listFrm.action = "list.jsp";
            document.listFrm.submit();
        }
        
        function pageing(page) {
            document.readFrm.nowPage.value = page;
            document.readFrm.submit();
        }
        
        function block(block) {
            document.readFrm.nowPage.value = (block - 1) * <%=pagePerBlock%> + 1;
            document.readFrm.submit();
        }
        function read(num) {
            document.readFrm.num.value = num;
            document.readFrm.acrion="read.jsp";
            document.readFrm.submit();
        }
        function numPerFn(numPerPage){
        	document.readFrm.action = "list.jsp";
        	document.readFrm.numPerPage.value = numPerPage;
        	document.readFrm.submit();
        	
        }
    	function cDel(cnum) {
    		document.cFrm.cnum.value=cnum;
    		document.cFrm.flag.value="delete";
    		document.cFrm.submit();
    	}
    
        </script>
    
</head>
   <form name="readFrm">
            <input type="hidden" name="totalRecord" value="<%=totalRecord%>">
            <input type="hidden" name="numPerPage" value="<%=numPerPage%>">
            <input type="hidden" name="keyField" value="<%=keyField%>">
            <input type="hidden" name="keyWord" value="<%=keyWord%>">
            <input type="hidden" name="num">
        </form>
        <form name="readFrm">
            <input type="hidden" name="totalRecord" value="<%=totalRecord%>">
            <input type="hidden" name="numPerPage" value="<%=numPerPage%>">
            <input type="hidden" name="keyField" value="<%=keyField%>">
            <input type="hidden" name="keyWord" value="<%=keyWord%>">
            <input type="hidden" name="num">
        </form>
    </div>
<body bgcolor="#FFFFCC">
    <div align="center"><br/>
        <h2>JSP Board</h2><br/>
       
   
    
</body>
</html>
