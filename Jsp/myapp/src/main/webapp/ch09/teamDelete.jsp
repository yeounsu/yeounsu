
<%@page import="ch09.MUtil"%>
<%@page import="ch09.TeamBean"%>
<jsp:useBean id ="mgr" class="ch09.TeamMgr"/>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%
/*
    int num = 0;
    if(request.getParameter("num")==null || !MUtil.isNumeric(request.getParameter("num"))){
      
        response.sendRedirect("teamList.jsp");
        return;
    } else {
        num = MUtil.parseInt(request, "num");
    }


    TeamMgr mgr = new TeamMgr();
    mgr.deleteTeam(num);

    response.sendRedirect("teamList.jsp");
    */
    
    int num = MUtil.parseInt(request,"num");
    mgr.deleteTeam(num);
    response.sendRedirect("teamList.jsp");
%>