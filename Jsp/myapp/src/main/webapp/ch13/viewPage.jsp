<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page %>
<%
//업로드 파일 저장 위치
	final String SAVEFOLDER = "C:/Jsp/myapp/src/main/webapp/ch13/storage/";
//업로드 파일 명
	final String ENCODING = "UTF-8";
//업로드 파일 크기
	final int MAXSIZE = 1024*1024*30; //30mb
	try{
		// MultiPartRequest 객체를 생성할 때 매개변수 들어가는 request는 null이 된다.
		MultipartRequest multi = new MultipartRequest(request, SAVEFOLDER,MAXSIZE ,ENCODING,new DefaultFileRenamePolicy());
		String user = request.getParameter("user");
		String title = request.getParameter("title");
		String originFile = multi.getOriginalFileName("myfile");
		String fileName = multi.getFilesystemName("myfile");
		String fileType = multi.getContentType("myfile");
		//파일 정보
		//File f = multi.getFile("myfile");
		File f = multi.getFile("myfile");
		long len = 0;
		if(f!=null)
			len = f.length();
		out.print("user :"+user + "<br>");
		out.print("title :"+user + "<br>");
		out.print("원본파일명 :"+user + "<br>");
		out.print("업로드 파일명 :"+user + "<br>");
		out.print("파일타입 :"+user + "<br>");
	}catch(Exception e){
		e.printStackTrace();
	}

%>