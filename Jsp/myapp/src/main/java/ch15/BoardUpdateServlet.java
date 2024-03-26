package ch15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/ch15/BoardUpdateServlet")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	 * 1. delete 기능과 동일하게 inPass와 dbPass가 일치를 해야지 수정이되어야 한다.
	 * 2. BoardMgr에 수정 메소드 매개변수가 MultipartRequest인 것을 고려해야한다. 
	 * 3. nowPage, numPerPage 넘겨줘야한다. 
	 * 4. 수정후에 read.jsp로 리턴한다. 
	 * */
	
			//입력된 비번과 sesseion에 저장된 비번 비교
			HttpSession session = request.getSession();
			BoardBean bean = (BoardBean)session.getAttribute("bean");
			String dbPass = bean.getPass();
		
			MultipartRequest multi = new MultipartRequest(request, BoardMgr.SAVEFOLDER, BoardMgr.MAXSIZE, BoardMgr.ENCODING, new DefaultFileRenamePolicy());
			String inPass = multi.getParameter("pass");
			if(dbPass.equals(inPass)) {
				BoardMgr mgr = new BoardMgr();
				mgr.updateBoard(multi);
				String nowPage = multi.getParameter("nowPage");
				String numPerPage = multi.getParameter("numPerPage");
				response.sendRedirect("read.jsp?nowPage="+nowPage + "&numPerPage=" + numPerPage+"&num="+bean.getNum());
				
			}else{
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('입력하신 비밀번호가 아닙니다')");
				out.println("history.back()");
				out.println("</script>");
			}
	}
		
		
	

}
