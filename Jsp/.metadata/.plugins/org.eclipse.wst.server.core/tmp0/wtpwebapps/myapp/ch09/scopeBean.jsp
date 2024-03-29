<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="pBean" scope = "page" class="ch09.ScopeBean"></jsp:useBean>
<jsp:useBean id="sBean" scope = "session" class="ch09.ScopeBean"></jsp:useBean>
<!-- 

	Scope가 session이면 id가 동일한 객체가 있는지 없는지 검색 (session안에)
	-> 없으면 객체를 생성
	-> 있으면 그 객체를 재사용을 하는 형질이 있다
	-> 그러나 session이 객체가 종료 또는 제거가 되면 안에 있는 객체도 같이 사라짐

 -->
 <% session.setAttribute("sBean",sBean); %>
 <jsp:setProperty property="num" name="pBean" value="<%= pBean.getNum() + 10 %>"/>
 <jsp:setProperty property="num" name="sBean" value="<%= sBean.getNum() + 10 %>"/>
 <h3>Scope Bean</h3>
 pBean num : <jsp:getProperty property="num" name="pBean"/> <br>
 
 sBean num : <jsp:getProperty property="num" name="sBean"/><br>
 <a href="scopeBean2.jsp">세션종료</a>