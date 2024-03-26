package ch08;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ㄷㅌㄴㄷㄱ핃ㅅ2
 */
@WebServlet("/exSevlet2")
public class exServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  //서블릿 라이프 사이클 : init -> service -> destroy
	
//@Override 치ㅑ둣rk dycjddl dlTdm fEo akek tlfgod
	//@override 서비스 종료 및 서블릿 코드가 수정이 될때ㄴ
    public exServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
