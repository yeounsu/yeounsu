package ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ch03/myServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>MyServlet</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Fighting Korea!!!</h1>");
	        out.println("<img src='https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png'>");
	        out.println("</body>");
	        out.println("</html>");
	}
}






