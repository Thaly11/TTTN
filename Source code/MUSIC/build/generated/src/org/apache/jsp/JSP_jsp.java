package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class JSP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Persons Manage Page</title>\n");
      out.write("<style>\n");
      out.write("table,th,td {\n");
      out.write("\tborder: 1px solid black;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t");
      out.write("\n");
      out.write("\t<c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error ne null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t<strong style=\"color: red;\"><c:out\n");
      out.write("\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></c:out></strong>\n");
      out.write("\t</c:if>\n");
      out.write("\t<c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.success ne null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t<strong style=\"color: green;\"><c:out\n");
      out.write("\t\t\t\tvalue=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.success}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></c:out></strong>\n");
      out.write("\t</c:if>\n");
      out.write("\t<c:url value=\"/addPerson\" var=\"addURL\"></c:url>\n");
      out.write("\t<c:url value=\"/editPerson\" var=\"editURL\"></c:url>\n");
      out.write("\n");
      out.write("\t");
      out.write("\n");
      out.write("\t<c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.person ne null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t<form action='<c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${editURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></c:out>' method=\"post\">\n");
      out.write("\t\t\tID: <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.person.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("\t\t\t\treadonly=\"readonly\" name=\"id\"><br> Name: <input\n");
      out.write("\t\t\t\ttype=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.person.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"name\"><br>\n");
      out.write("\t\t\tCountry: <input type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.person.country}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("\t\t\t\tname=\"country\"><br> <input type=\"submit\"\n");
      out.write("\t\t\t\tvalue=\"Edit Person\">\n");
      out.write("\t\t</form>\n");
      out.write("\t</c:if>\n");
      out.write("\n");
      out.write("\t");
      out.write("\n");
      out.write("\t<c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.person eq null}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t<form action='<c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${addURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></c:out>' method=\"post\">\n");
      out.write("\t\t\tName: <input type=\"text\" name=\"name\"><br> Country: <input\n");
      out.write("\t\t\t\ttype=\"text\" name=\"country\"><br> <input type=\"submit\"\n");
      out.write("\t\t\t\tvalue=\"Add Person\">\n");
      out.write("\t\t</form>\n");
      out.write("\t</c:if>\n");
      out.write("\n");
      out.write("\t");
      out.write("\n");
      out.write("\t<c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty requestScope.persons}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t<table>\n");
      out.write("\t\t\t<tbody>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<th>ID</th>\n");
      out.write("\t\t\t\t\t<th>Name</th>\n");
      out.write("\t\t\t\t\t<th>Country</th>\n");
      out.write("\t\t\t\t\t<th>Edit</th>\n");
      out.write("\t\t\t\t\t<th>Delete</th>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.persons}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"person\">\n");
      out.write("\t\t\t\t\t<c:url value=\"/editPerson\" var=\"editURL\">\n");
      out.write("\t\t\t\t\t\t<c:param name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></c:param>\n");
      out.write("\t\t\t\t\t</c:url>\n");
      out.write("\t\t\t\t\t<c:url value=\"/deletePerson\" var=\"deleteURL\">\n");
      out.write("\t\t\t\t\t\t<c:param name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></c:param>\n");
      out.write("\t\t\t\t\t</c:url>\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t<td><c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></c:out></td>\n");
      out.write("\t\t\t\t\t\t<td><c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></c:out></td>\n");
      out.write("\t\t\t\t\t\t<td><c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${person.country}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></c:out></td>\n");
      out.write("\t\t\t\t\t\t<td><a\n");
      out.write("\t\t\t\t\t\t\thref='<c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${editURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" escapeXml=\"true\"></c:out>'>Edit</a></td>\n");
      out.write("\t\t\t\t\t\t<td><a\n");
      out.write("\t\t\t\t\t\t\thref='<c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${deleteURL}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" escapeXml=\"true\"></c:out>'>Delete</a></td>\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t</c:forEach>\n");
      out.write("\t\t\t</tbody>\n");
      out.write("\t\t</table>\n");
      out.write("\t</c:if>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
