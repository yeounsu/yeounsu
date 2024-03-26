<%@ page contentType="text/html; charset=EUC-KR"%>
<%
	String cookieName = "myCookie";
//쿠키를 생성
	Cookie cookie = new Cookie(cookieName, "Apple");
	cookie.setMaxAge(60);//1분
	
	cookie.setValue("Melone");
	//생성된 쿠키를 응답객체를 저장
	response.addCookie(cookie);
%>
쿠키를 만들었습니다. <br>
쿠키 내용은 <a href="tasteCookie.jsp">여기서 확인</a>