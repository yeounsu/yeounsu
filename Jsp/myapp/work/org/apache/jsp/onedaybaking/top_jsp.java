/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-04-02 07:21:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.onedaybaking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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

      out.write("<!-- top.jsp -->\r\n");
      out.write("\r\n");

	String type = (String)session.getAttribute("type");
	String id = (String)session.getAttribute("idKey");
	if (type == null)
		type = "item";

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	function setType(type) {\r\n");
      out.write("		document.getElementById('type').value = type;\r\n");
      out.write("		session.setAttribute(\"type\", type);\r\n");
      out.write("		response.sendRedirect(type + \".jsp\");\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	var intervalId;\r\n");
      out.write("	var currentIndex = 0; // 현재 배너 인덱스\r\n");
      out.write("	var banners = [\r\n");
      out.write("		'img/img01.jpg',\r\n");
      out.write("		'img/img02.jpg',\r\n");
      out.write("		'img/img03.jpg',\r\n");
      out.write("		'img/img04.jpg',\r\n");
      out.write("		'img/img05.jpg',\r\n");
      out.write("		'img/img06.jpg'\r\n");
      out.write("	];\r\n");
      out.write("	\r\n");
      out.write("	var totalImages = banners.length;\r\n");
      out.write("\r\n");
      out.write("	function updateImageNumber() {\r\n");
      out.write("		// 현재 이미지 번호와 전체 이미지 번호 업데이트\r\n");
      out.write("		document.getElementById('imageNumber').innerText = (currentIndex + 1) + \" / \" + totalImages;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function changeBanner(index) {\r\n");
      out.write("		// 현재 배너 숨기기\r\n");
      out.write("		document.getElementById('banner').style.display = 'none';\r\n");
      out.write("		\r\n");
      out.write("		// 다음 배너 인덱스로 이동\r\n");
      out.write("		currentIndex = index;\r\n");
      out.write("		\r\n");
      out.write("		// 다음 배너 표시\r\n");
      out.write("		document.getElementById('banner').src = banners[currentIndex];\r\n");
      out.write("		document.getElementById('banner').style.display = 'block';\r\n");
      out.write("		\r\n");
      out.write("		// INDEX 번호 변경\r\n");
      out.write("		updateImageNumber();\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function moveLeft() {\r\n");
      out.write("		// 좌측으로 이동 (이전 배너)\r\n");
      out.write("		currentIndex = (currentIndex - 1 + banners.length) % banners.length;\r\n");
      out.write("		changeBanner(currentIndex);\r\n");
      out.write("		resetInterval();\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function moveRight() {\r\n");
      out.write("		// 우측으로 이동 (다음 배너)\r\n");
      out.write("		currentIndex = (currentIndex + 1) % banners.length;\r\n");
      out.write("		changeBanner(currentIndex);\r\n");
      out.write("		resetInterval();\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	function resetInterval() {\r\n");
      out.write("		// 현재 실행 중인 인터벌을 중지\r\n");
      out.write("		clearInterval(intervalId);\r\n");
      out.write("		\r\n");
      out.write("		// 클릭 동작이 끝난 후 3초 간격으로 인터벌 재설정\r\n");
      out.write("		intervalId = setInterval(function() { moveRight(); }, 3000);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	// 페이지 로드 후 일정 시간마다 changeBanner 함수 호출\r\n");
      out.write("	window.onload = function () {\r\n");
      out.write("		\r\n");
      out.write("		intervalId  = setInterval(function() { moveRight() }, 3000);\r\n");
      out.write("\r\n");
      out.write("		// 현재 페이지 URL 가져오기\r\n");
      out.write("		var currentPageUrl = window.location.href;\r\n");
      out.write("		\r\n");
      out.write("		// 만약 현재 페이지가 top.jsp라면 다른 페이지로 이동\r\n");
      out.write("		if (currentPageUrl.indexOf(\"top.jsp\") !== -1) {\r\n");
      out.write("			window.location.href = \"main.jsp\"; // 이동할 페이지의 URL로 변경\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		if (currentPageUrl.indexOf(\"main.jsp\") !== -1) {\r\n");
      out.write("			document.getElementById('bannerContainer').style.display = 'block';\r\n");
      out.write("		} else {\r\n");
      out.write("			document.getElementById('bannerContainer').style.display = 'none';\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		if (window.location.pathname.indexOf(\"item.jsp\") !== -1) {\r\n");
      out.write("			document.getElementById('item').style.color = \"#C57B37\";\r\n");
      out.write("			document.getElementById('class').style.color = \"#000\";\r\n");
      out.write("		} else if (window.location.pathname.indexOf(\"class.jsp\") !== -1) {\r\n");
      out.write("			document.getElementById('item').style.color = \"#000\";\r\n");
      out.write("			document.getElementById('class').style.color = \"#C57B37\";\r\n");
      out.write("		}\r\n");
      out.write("	};\r\n");
      out.write("</script>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("	<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n");
      out.write("	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<link href=\"top_style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("	\r\n");
      out.write("	<style>\r\n");
      out.write("		.top_parent {\r\n");
      out.write("			text-align: center;\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		.top_child {\r\n");
      out.write("			display: inline-block;\r\n");
      out.write("			width: 150px;\r\n");
      out.write("			height: 40px;\r\n");
      out.write("			line-height: 40px;\r\n");
      out.write("			background-color: #DAD1CD;\r\n");
      out.write("			border-radius: 25px;\r\n");
      out.write("			margin: 0 30px;\r\n");
      out.write("			cursor: pointer;\r\n");
      out.write("		}\r\n");
      out.write("	</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<nav class=\"navbar\" id=\"header_bar\">\r\n");
      out.write("		<ul class=\"header_top\">\r\n");
      out.write("	");
 if (id == null || id.equals("")) { 
      out.write("\r\n");
      out.write("			<li><a href=\"#\">공지사항</a></li>\r\n");
      out.write("			<li><a href=\"login.jsp\">로그인</a></li>\r\n");
      out.write("			<li><a href=\"signin.jsp\">회원가입</a></li>\r\n");
      out.write("	");
 } else { 
      out.write("\r\n");
      out.write("			<li><a href=\"#\">공지사항</a></li>\r\n");
      out.write("			<li><a href=\"myinfo.jsp\">내 정보</a></li>\r\n");
      out.write("			<li><a href=\"logout.jsp\">로그아웃</a></li>\r\n");
      out.write("	");
 } 
      out.write("\r\n");
      out.write("		</ul>\r\n");
      out.write("	</nav>\r\n");
      out.write("	<div style=\"width: 65%; margin: 10px auto 0 auto; align: center\">\r\n");
      out.write("		<form method=\"post\" action=\"topProc.jsp\">\r\n");
      out.write("			<input type=\"hidden\" name=\"type\" id=\"type\" value=\"\">\r\n");
      out.write("			<table style=\"width: 100%; align: center\">\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td width=\"120\"><a href=\"main.jsp\"><img src=\"img/logo2.png\" width=\"120\" height=\"100\"></a></td>\r\n");
      out.write("					<td align=\"center\" width=\"70\"><button class=\"navButton\" onclick=\"setType('item')\" id=\"item\">상품</button></td>\r\n");
      out.write("					<td align=\"center\" width=\"70\"><button class=\"navButton\" onclick=\"setType('class')\" id=\"class\" >클래스</button></td>\r\n");
      out.write("					<td width=\"450\" align=\"right\"><div style=\"width: 95%;\"><input type=\"text\" class=\"form-control\" placeholder=\"검색어를 입력해주세요.\"></div></td>\r\n");
      out.write("					<td width=\"230\" align=\"right\">\r\n");
      out.write("						<ul class=\"header_info\">\r\n");
      out.write("							<li><a href=\"wish.jsp\"><img src=\"img/heart.png\" width=\"30\" height=\"30\"><span class=\"item\">찜목록</span></a></li>\r\n");
      out.write("							<li><a href=\"myinfo.jsp\"><img src=\"img/people.png\" width=\"30\" height=\"30\"><span class=\"item\">내 정보</span></a></li>\r\n");
      out.write("							<li><a href=\"#\"><img src=\"img/cart.png\"  width=\"30\" height=\"30\"><!-- <span class=\"notification-dot\"></span> --><span class=\"item\">장바구니</span></a></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div id=\"bannerContainer\" style=\"margin-top: 50px; text-align: right; display: block;\">\r\n");
      out.write("		<img id=\"banner\" src=\"img/img01.jpg\" alt=\"배너 이미지\" width=\"100%\" height=\"300\">\r\n");
      out.write("		<div id=\"imageNumber\"  style=\"margin-right: 20%;\">1 / 6</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	<div style=\"width: 65%; margin: 10px auto 0 auto; align: center\">\r\n");
      out.write("		<table style=\"width: 100%; align: center\">\r\n");
      out.write("			<tr align=\"center\">\r\n");
      out.write("				<td width=\"100%\" colspan=\"5\"><br>\r\n");
      out.write("					<div class=\"top_parent\">\r\n");
      out.write("						<div class=\"top_child\" onclick=\"location.href = ''\"><img src=\"img/cookie.png\" width=\"20\" height=\"20\"> 제과</div>\r\n");
      out.write("						<div class=\"top_child\" onclick=\"location.href = ''\"><img src=\"img/bread.png\" width=\"20\" height=\"20\"> 제빵</div>\r\n");
      out.write("						<div class=\"top_child\" onclick=\"location.href = ''\"><img src=\"img/coffee.png\" width=\"20\" height=\"15\"> 바리스타</div>\r\n");
      out.write("					");

						if (type.equals("class")) {
					
      out.write("\r\n");
      out.write("						<div class=\"top_child\" onclick=\"location.href = ''\"><img src=\"img/calendar.png\" width=\"20\" height=\"20\"> 클래스 등록</div>\r\n");
      out.write("					");
 } else { 
      out.write("\r\n");
      out.write("						<div class=\"top_child\" onclick=\"location.href = ''\"><img src=\"img/box.png\" width=\"20\" height=\"20\"> 상품 등록</div>\r\n");
      out.write("					");
 } 
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("	</div>\r\n");
      out.write("	<hr style=\"margin-top: 30px;\">\r\n");
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
