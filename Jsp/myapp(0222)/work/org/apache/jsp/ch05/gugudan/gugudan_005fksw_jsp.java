/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-02-22 06:54:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.ch05.gugudan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ch05.MyUtil;

public final class gugudan_005fksw_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(1);
    _jspx_imports_classes.add("ch05.MyUtil");
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
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"> \r\n");
      out.write("<head> \r\n");
      out.write("<title>Gugudan</title> \r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("/* 	.bg1 { background-color:#dd4132; }\r\n");
      out.write("	.bg2 { background-color:#f7786b; }\r\n");
      out.write("	.bg3 { background-color:#f7cac9; }\r\n");
      out.write("	.bg4 { background-color:#fae03c; }\r\n");
      out.write("	.bg5 { background-color:#79c753; }\r\n");
      out.write("	.bg6 { background-color:#034f84; }\r\n");
      out.write("	.bg7 { background-color:#91A8d0; }\r\n");
      out.write("	.bg8 { background-color:#98ddde; }\r\n");
      out.write("	.bg9 { background-color:#91A8d0; }\r\n");
      out.write("	\r\n");
      out.write("	table {\r\n");
      out.write("  overflow: hidden;\r\n");
      out.write("} */\r\n");
      out.write("td:nth-of-type(1):hover, td:nth-of-type(1):hover + td\r\n");
      out.write(", td:nth-of-type(1):hover + td + td\r\n");
      out.write(", td:nth-of-type(1):hover + td + td + td\r\n");
      out.write(", td:nth-of-type(1):hover + td + td + td + td\r\n");
      out.write(", td:nth-of-type(1):hover + td + td + td + td + td\r\n");
      out.write(", td:nth-of-type(1):hover + td + td + td + td + td+ td\r\n");
      out.write(", td:nth-of-type(1):hover + td + td + td + td + td+ td+ td\r\n");
      out.write(", td:nth-of-type(1):hover + td + td + td + td + td+ td+ td+ td\r\n");
      out.write("{\r\n");
      out.write("	background-color: black;\r\n");
      out.write("}\r\n");
      out.write("td:hover{\r\n");
      out.write("	background-color: ");
      out.print(MyUtil.randomColor() );
      out.write(";\r\n");
      out.write("}\r\n");
      out.write("table tr:nth-child(even) {\r\n");
      out.write("  background-color : #91A8d0;\r\n");
      out.write("}\r\n");
      out.write("table tr:nth-child(odd){\r\n");
      out.write("	background-color : #98ddde;\r\n");
      out.write("}\r\n");
      out.write("table tr:nth-child(1){\r\n");
      out.write("	background-color : lightgray;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/*\r\n");
      out.write("td:nth-of-type(2):hover{\r\n");
      out.write("	background-color:#91A8d0;\r\n");
      out.write("}\r\n");
      out.write("td:hover + td{\r\n");
      out.write("	background-color: #f7786b;\r\n");
      out.write("}\r\n");
      out.write("td:hover+td+td{\r\n");
      out.write("	background-color: #f7cac9;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td:hover + td + td + td{\r\n");
      out.write("	background-color: #fae03c;\r\n");
      out.write("}\r\n");
      out.write("td:hover + td + td + td + td{\r\n");
      out.write("	background-color: #79c753;\r\n");
      out.write("}\r\n");
      out.write("-td:hover - td{\r\n");
      out.write("	background-color: #79c753;\r\n");
      out.write("}\r\n");
      out.write("tr.row:hover{\r\n");
      out.write("	background-color: #000000;\r\n");
      out.write("}\r\n");
      out.write("*/\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head> \r\n");
      out.write("<body> \r\n");
      out.write("<h2 align=\"center\">구구단을 외자</h2> \r\n");
      out.write("<table class=\"bgColors\" align=\"center\" border=\"1\" > \r\n");
      out.write("<tr bgcolor=\"lightgrey\"> \r\n");
      out.write("	<td></td> \r\n");
      out.write("	");
 for (int i = 2; i < 10; i++) { 
      out.write(" \r\n");
      out.write("	<td align=\"center\" width=\"80\" > \r\n");
      out.write("	");
      out.print(i);
      out.write("\r\n");
      out.write("	</td> \r\n");
      out.write("	");
 } 
      out.write(" \r\n");
      out.write("	");
 for (int i = 1; i < 10; i++) { 
      out.write(" \r\n");
      out.write("<tr> \r\n");
      out.write("	<td align=\"center\" bgcolor=\"lightgrey\" width=\"50\">\r\n");
      out.print(i);
      out.write("</td> \r\n");
 for (int j = 2; j < 10; j++) { 
      out.write(" \r\n");
      out.write("<td align=\"center\">\r\n");
      out.print(j);
      out.write(' ');
      out.write('X');
      out.write(' ');
      out.print(i);
      out.write(' ');
      out.write('=');
      out.write(' ');
      out.print(j * i);
      out.write("\r\n");
      out.write("</td> \r\n");
 } 
      out.write("\r\n");
      out.write(" </tr> \r\n");
      out.write(" ");
 } 
      out.write(" </tr> \r\n");
      out.write("</table> \r\n");
      out.write("</body> ");
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
