<!-- script3.jsp -->
<%@page contentType="text/html; charset=UTF-8"%>
<!-- SUN 정책이 자바코드를 0%화 위해서 액션태그 제공 -->
<jsp:declaration>
	String str = "선언문 변수";
</jsp:declaration>
<jsp:scriptlet>
	String msg = "스크립트릿 변수";
</jsp:scriptlet>
<jsp:expression>
	str + " : " + msg
</jsp:expression>
