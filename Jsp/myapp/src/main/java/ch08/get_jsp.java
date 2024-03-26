package ch08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class get_jsp
 */
@WebServlet("/get_jsp")
public class get_jsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html: charset=UTF-8");
		PrintWriter out = response.getWriter();
		String msg = request.getParameter("msg");
		out.print("msg:" + msg);
	}

}
