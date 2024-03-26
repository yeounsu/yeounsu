<!-- pollInsertProc.jsp -->
<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="mgr" class="ch16.PollMgr"/>
<jsp:useBean id="plBean" class="ch16.PollListBean"/>
<jsp:setProperty property="*" name="plBean"/>
<jsp:useBean id="piBean" class="ch16.PollItemBean"/>
<jsp:setProperty property="*" name="piBean"/>
<%
boolean result = mgr.insertPoll(plBean, piBean);
out.print(result);
%>