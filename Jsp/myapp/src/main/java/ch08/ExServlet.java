package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ExServlet")
public class ExServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		response.setContentType("text/html; charset=URF-8");
	//응답스트림
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>이클립스로 서블릿 만들기</h1>");
		out.println("세션ID : " + session.getId());
		out.println("</body>");
		out.println("</html>");
	}

}
