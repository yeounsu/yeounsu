/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-03-04 05:42:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.guestbook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import guestbook.CommentBean;
import guestbook.GuestBookBean;
import java.util.Vector;
import guestbook.JoinBean;

public final class showGuestBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/guestbook/postGuestBook.jsp", Long.valueOf(1709192083988L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(4);
    _jspx_imports_classes.add("guestbook.CommentBean");
    _jspx_imports_classes.add("java.util.Vector");
    _jspx_imports_classes.add("guestbook.GuestBookBean");
    _jspx_imports_classes.add("guestbook.JoinBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      guestbook.GuestBookMgr mgr = null;
      mgr = (guestbook.GuestBookMgr) _jspx_page_context.getAttribute("mgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (mgr == null){
        mgr = new guestbook.GuestBookMgr();
        _jspx_page_context.setAttribute("mgr", mgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      guestbook.CommentMgr cmgr = null;
      cmgr = (guestbook.CommentMgr) _jspx_page_context.getAttribute("cmgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (cmgr == null){
        cmgr = new guestbook.CommentMgr();
        _jspx_page_context.setAttribute("cmgr", cmgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');

	String id = (String)session.getAttribute("idKey");
	if(id == null){
		//현재 접속된 URL 리턴 
		StringBuffer url = request.getRequestURL();
		response.sendRedirect("login.jsp?url="+url);
		return;
	}

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<title>GuestBook</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	function updateFn(num) {\r\n");
      out.write("		url = \"updateGuestBook.jsp?num=\"+num;\r\n");
      out.write("		window.open(url, \"GuestBook Update\", \"width=540, height=300\");\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function commentFn(frm){\r\n");
      out.write("		if(frm.comment.value == \"\"){\r\n");
      out.write("			alert(\"댓글을 입력하세요.\");\r\n");
      out.write("		frm.comment.focus();\r\n");
      out.write("		return;\r\n");
      out.write("		}\r\n");
      out.write("		frm.submit();\r\n");
      out.write("	}\r\n");
      out.write("	function disFn(num){\r\n");
      out.write("		//alert(num);\r\n");
      out.write("		var v = \"cmt\" +num;\r\n");
      out.write("		var e = document.getElementById(v); //cmt11\r\n");
      out.write("		if(e.style.display=='none')\r\n");
      out.write("			e.style.display = 'block'; //보이는거\r\n");
      out.write("		else\r\n");
      out.write("			e.style.display = 'none'; //안보이는거\r\n");
      out.write("	}\r\n");
      out.write("	function delFn(cnum){\r\n");
      out.write("		document.delFrm.action = \"commentProc.jsp\";\r\n");
      out.write("		document.delFrm.cnum.value=cnum;\r\n");
      out.write("		document.delFrm.submit();\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body bgcolor=\"#996600\">\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      guestbook.JoinBean login = null;
      synchronized (session) {
        login = (guestbook.JoinBean) _jspx_page_context.getAttribute("login", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (login == null){
          login = new guestbook.JoinBean();
          _jspx_page_context.setAttribute("login", login, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>GuestBook</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	function checkInputs() {\r\n");
      out.write("		frm = document.postFrm;\r\n");
      out.write("		if(frm.contents.value==\"\"){\r\n");
      out.write("			alert(\"내용을 입력해 주세요.\");\r\n");
      out.write("			frm.contents.focus();\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		frm.submit();\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div align=\"center\">\r\n");
      out.write("		<table cellspacing=\"0\" cellpadding=\"3\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td bgcolor=\"#F5F5F5\"><font size=\"4\"><b>글올리기</b></font></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		<form name=\"postFrm\" method=\"post\" action=\"postGuestBookProc.jsp\">\r\n");
      out.write("			<table border=\"1\" bordercolor=\"#000000\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>\r\n");
      out.write("						<table>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td height=\"40\" align=\"center\">\r\n");
      out.write("								<img src=\"img/face.bmp\" border=\"0\" alt=\"성명\"> \r\n");
      out.write("								<input title=\"이름을 적어주세요\" name=\"name\" size=\"9\" \r\n");
      out.write("								maxlength=\"20\" value=\"");
      out.print(login.getName());
      out.write("\" readonly>\r\n");
      out.write("								<img src=\"img/email.bmp\" border=\"0\" alt=\"메일\">\r\n");
      out.write("								<input title=\"전자메일 주소를 적는 곳이군요\" name=\"email\" size=\"20\"\r\n");
      out.write("									maxlength=\"80\" value=\"");
      out.print(login.getEmail());
      out.write("\"> \r\n");
      out.write("								<img src=\"img/hp.bmp\" border=\"0\" alt=\"홈페이지\"> \r\n");
      out.write("								<input title=\"홈페이지도 있으면 알려주세요.\" name=\"hp\" size=\"20\"\r\n");
      out.write("									maxlength=\"80\" value=\"");
      out.print(login.getHp());
      out.write("\">\r\n");
      out.write("									</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td align=\"center\">\r\n");
      out.write("									<textarea title=\"좋은 글 남겨주세요\"\r\n");
      out.write("										name=\"contents\" cols=\"60\" rows=\"6\">하이~~~</textarea>\r\n");
      out.write("								</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("							<tr>\r\n");
      out.write("								<td width=\"500\" height=\"30\" colspan=\"3\" align=\"center\">\r\n");
      out.write("									<!-- table start -->\r\n");
      out.write("									<input type=\"hidden\" name=\"id\" value=\"");
      out.print(login.getId());
      out.write("\">\r\n");
      out.write("									<input type=\"hidden\" name=\"ip\" value=\"");
      out.print(request.getRemoteAddr());
      out.write("\">\r\n");
      out.write("									<input type=\"button\" value=\"글올리기\" onclick=\"javascript:checkInputs()\"> \r\n");
      out.write("									<input type=\"reset\" value=\"고치기\">\r\n");
      out.write("									<input type=\"checkbox\" name=\"secret\" value=\"1\">비밀글\r\n");
      out.write("									<!--table end  -->\r\n");
      out.write("								</td>\r\n");
      out.write("							</tr>\r\n");
      out.write("						</table>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<table width=\"520\" cellspacing=\"0\" cellpadding=\"3\">\r\n");
      out.write("	<tr bgcolor=\"#F5F5F5\"> \r\n");
      out.write("		<td><b>");
      out.print(login.getName());
      out.write("</b></td>\r\n");
      out.write("		<td align=\"right\">로그아웃</b></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<!-- GuestBook List Start -->\r\n");
      out.write("\r\n");

	//login 객체는 27라인에 postGuestBook.jsp에서 session에서 가져옴
	Vector<GuestBookBean> vlist = mgr.listGuestBook(id, login.getGrade());
	//out.print(vlist.size());

      out.write('\r');
      out.write('\n');
if(vlist.isEmpty()) {
      out.write("\r\n");
      out.write("<table width=\"520\" cellspacing=\"0\" cellpadding=\"7\">\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td>등록된 글이 없습니다.</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
}else{
      out.write('\r');
      out.write('\n');

for(int i =0; i<vlist.size();i++){
	//방명록글
	GuestBookBean bean = vlist.get(i);
	int num = bean.getNum();//방명록글 번호
	//방명록 글쓴이
	JoinBean writer = mgr.getJoin(bean.getId());


      out.write("\r\n");
      out.write("<table  width=\"520\" border=\"1\" bordercolor=\"#000000\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td>\r\n");
      out.write("			<table bgcolor=\"#F5F5F5\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td width=\"225\">NO : ");
      out.print(vlist.size()-i );
      out.write(" </td>					\r\n");
      out.write("					<td width=\"225\">\r\n");
      out.write("						<img src=\"img/face.bmp\" border=\"0\" alt=\"이름\">\r\n");
      out.write("						\">\r\n");
      out.write("							");
      out.print(writer.getName());
      out.write("\r\n");
      out.write("						\r\n");
      out.write("					</td>					\r\n");
      out.write("					<td width=\"150\" align=\"center\">\r\n");
      out.write("						");
if(writer.getHp()==null||writer.getHp().equals("")){
								out.println("홈페이지가 없네요");
							}else{
						
      out.write("\r\n");
      out.write("						<a href=\"");
      out.print(writer.getHp());
      out.write("\">\r\n");
      out.write("							<img alt=\"홈페이지\" src=\"img/hp.bmp\" border=\"0\">\r\n");
      out.write("						</a>\r\n");
      out.write("						");
}
      out.write("\r\n");
      out.write("					</td>					\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td colspan=\"3\">");
      out.print(bean.getContents() );
      out.write("</td>					\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>IP : ");
      out.print(bean.getIp() );
      out.write("</td>					\r\n");
      out.write("					<td>");
      out.print(bean.getRegdate()+" "+bean.getRegtime() );
      out.write("</td>					\r\n");
      out.write("					<td>\r\n");
      out.write("						<!-- \r\n");
      out.write("							수정, 삭제 : 로그인 id와 writer id가 동일 \r\n");
      out.write("							삭제 : 관리자\r\n");
      out.write("							비밀글 : secret 1일때 \r\n");
      out.write("						 -->\r\n");
      out.write("						 ");

						 	boolean chk = id.equals(writer.getId());
						 	if(chk||login.getGrade().equals("1")){
						 		if(chk){
						 			
      out.write("\r\n");
      out.write("						 			<a href = \"javascript:updateFn('");
      out.print(num);
      out.write("')\">[수정]</a>\r\n");
      out.write("						 			");
 }
						 			
      out.write("\r\n");
      out.write("						 			<a href = \"deleteGuestBookProc.jsp?num=");
      out.print(num);
      out.write("\">[삭제]</a>\r\n");
      out.write("						 			");

						 			
						 	}
						 	if(bean.getSecret().equals("1")){
						 		out.print("비밀글");
						 	}
						 
      out.write("\r\n");
      out.write("						 \r\n");
      out.write("			 \r\n");
      out.write("						 \r\n");
      out.write("					</td>						\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<!-- Comment List Start -->\r\n");
      out.write("<div id=\"cmt");
      out.print(num );
      out.write("\"style=\"display:none\">\r\n");

	Vector<CommentBean> cvlist = cmgr.listComment(num);
	//out.print(cvlist.size());
	if(!cvlist.isEmpty()){
		
      out.write("\r\n");
      out.write("		<table width=\"500\" bgcolor=\"#F5F5F5\">\r\n");
      out.write("		");
			
			for(int j=0;j<cvlist.size();j++){
				CommentBean cbean = cvlist.get(j);
		
      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td>\r\n");
      out.write("					<table width=\"500\">\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td><b>");
      out.print(cbean.getCid());
      out.write("</b>	</td>\r\n");
      out.write("							<td align=\"right\">\r\n");
      out.write("							<!-- 삭제는 로그인 id와 댓글 쓴 id랑 동일 -->\r\n");
      out.write("							");
      out.write("\r\n");
      out.write("							<a href=\"#\" onclick=\"javascript:delFn('");
      out.print(cbean.getCnum());
      out.write("')\">[삭제]</a>\r\n");
      out.write("							</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td colspan=\"2\">");
      out.print(cbean.getComment() );
      out.write("</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td>");
      out.print(cbean.getCip());
      out.write("</td>\r\n");
      out.write("							<td align=\"right\">");
      out.print(cbean.getCregDate());
      out.write("</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</table>\r\n");
      out.write("				<hr>	\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		");
}//---for(Comment)
      out.write("\r\n");
      out.write("		</table>\r\n");
      out.write("		\r\n");
      out.write("	");
}//--if(comment)
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<table width=\"500\">\r\n");
      out.write("<tr><td>\r\n");
      out.write("	<button onclick=\"disFn('");
      out.print(num);
      out.write("')\">댓글");
      out.print(cvlist.isEmpty()?"":cvlist.size() );
      out.write("</button>\r\n");
      out.write("</td></tr>\r\n");
      out.write("</table>\r\n");
      out.write("<!-- Comment List End -->\r\n");
      out.write("<!-- Comment Form Start -->\r\n");
      out.write("<form name=\"cFrm\" method=\"post\" action=\"commentProc.jsp\">\r\n");
      out.write("<table>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td>\r\n");
      out.write("			<textarea placeholder=\"댓글입력...\" name=\"comment\" rows=\"2\" \r\n");
      out.write("			cols=\"65\" maxlength=\"1000\"></textarea>\r\n");
      out.write("		</td>\r\n");
      out.write("		<td>\r\n");
      out.write("			<input type=\"button\" value=\"댓글\" onclick=\"commentFn(this.form)\">\r\n");
      out.write("			<input type=\"hidden\" name=\"flag\" value=\"insert\">\r\n");
      out.write("			<!-- 방명록 글번호 -->\r\n");
      out.write("			<input type=\"hidden\" name=\"num\" value=\"");
      out.print(bean.getNum());
      out.write("\">\r\n");
      out.write("			<!-- 로그인 id -->\r\n");
      out.write("			<input type=\"hidden\" name=\"cid\" value=\"");
      out.print(login.getId());
      out.write("\">\r\n");
      out.write("			<!-- 댓글 입력 ip 주소 -->\r\n");
      out.write("			<input type=\"hidden\" name=\"cip\" value=\"");
      out.print(request.getRemoteAddr());
      out.write("\">\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>	\r\n");
      out.write("</form>\r\n");
      out.write("<!-- Comment List End -->\r\n");

}//--for
}//--if-else 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- GuestBook List End -->\r\n");
      out.write("\r\n");
      out.write("<form method=\"post\" name=\"delFrm\">\r\n");
      out.write("	<input type=\"hidden\" name=\"flag\" value=\"delete\">\r\n");
      out.write("	<input type=\"hidden\" name=\"cnum\">\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
