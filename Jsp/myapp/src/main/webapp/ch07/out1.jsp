<%@ page contentType="text/html; charset=UTF-8" buffer="5kb"%>
<%
		
%>
<%
	int totalBuffer = out.getBufferSize();
	int remainBuffer = out.getRemaining();
	int useBuffer = totalBuffer - remainBuffer;
	out.println("출력 버퍼의 크기:"+totalBuffer+"<br>");
	out.println("남은 버퍼의 크기:"+remainBuffer+"<br>");
	out.println("사용 버퍼의 크기:"+useBuffer+"<br>");
	
	String arr[]= {"Java","Jsp","Android","Spring"};
	//out.println & 표현식 출력 각각
	for(int i=0; i<arr.length;i++){
		out.println(arr[i]+"<br>");
		
	}
%>
<hr>
<%for(int i=0; i<arr.length;i++){%>
<%=arr[i]%><br>
<%}%>