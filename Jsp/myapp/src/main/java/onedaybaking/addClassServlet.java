package onedaybaking;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/onedaybaking/addClass")
public class addClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id  = (String)session.getAttribute("idKey");
		addclassMgr acmgr = new addclassMgr();
		acmgr.allInsertClass(request, id);
		String nowPage = request.getParameter("nowPage");
		String numPerPage = request.getParameter("numPerPage");
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		String url = "wish.jsp?nowPage=" +nowPage;
		url +="&numPerPage=" + "numPerPage";
		
		response.sendRedirect(url);
	}

}
