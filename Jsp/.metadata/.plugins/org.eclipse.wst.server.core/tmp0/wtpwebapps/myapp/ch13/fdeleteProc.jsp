<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch13.FileloadMgr"/>
<%
//{"0","1","3","5"}	
String snum[] = request.getParameterValues("fch");
	int num[] = new int[snum.length-1];
	for(int i =0; i<num.length; i++){
		num[i] = Integer.parseInt(snum[i+1]);
	}
	//{1,3,5}
	mgr.deleteFile(num);
	response.sendRedirect("flist.jsp");
%>