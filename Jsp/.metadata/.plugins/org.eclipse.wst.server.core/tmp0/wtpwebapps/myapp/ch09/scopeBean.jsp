<%@ page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="pBean" scope = "page" class="ch09.ScopeBean"></jsp:useBean>
<jsp:useBean id="sBean" scope = "session" class="ch09.ScopeBean"></jsp:useBean>
<!-- 

	Scope�� session�̸� id�� ������ ��ü�� �ִ��� ������ �˻� (session�ȿ�)
	-> ������ ��ü�� ����
	-> ������ �� ��ü�� ������ �ϴ� ������ �ִ�
	-> �׷��� session�� ��ü�� ���� �Ǵ� ���Ű� �Ǹ� �ȿ� �ִ� ��ü�� ���� �����

 -->
 <% session.setAttribute("sBean",sBean); %>
 <jsp:setProperty property="num" name="pBean" value="<%= pBean.getNum() + 10 %>"/>
 <jsp:setProperty property="num" name="sBean" value="<%= sBean.getNum() + 10 %>"/>
 <h3>Scope Bean</h3>
 pBean num : <jsp:getProperty property="num" name="pBean"/> <br>
 
 sBean num : <jsp:getProperty property="num" name="sBean"/><br>
 <a href="scopeBean2.jsp">��������</a>