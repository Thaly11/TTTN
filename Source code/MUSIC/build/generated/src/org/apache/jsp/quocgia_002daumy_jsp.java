package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class quocgia_002daumy_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/tim-kiem.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title> MUSIC </title>\n");
      out.write("        <meta  http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-theme.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("<nav class=\"navbar navbar-inverse\">\n");
      out.write("    <div class=\"container-fluid\">\n");
      out.write("        <div class=\"navbar-header\">\n");
      out.write("            <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#hangNavbar\">\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span>\n");
      out.write("                <span class=\"icon-bar\"></span> \n");
      out.write("            </button>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"hangNavbar\">\n");
      out.write("            <ul class=\"nav navbar-nav navbar-left\">\n");
      out.write("                <li class=\"active\"><a href=\"index.jsp\"><span class=\"glyphicon glyphicon-home\"></span></a></li>\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Thể loại\n");
      out.write("                        <span class=\"caret\"></span></a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                      <li><a href=\"theloai-nhactre.jsp\">Nhạc Trẻ</li>\n");
      out.write("                        <li><a href=\"theloai-nhacbolero.jsp\">Nhạc Bolero</a></li>\n");
      out.write("                        <li><a href=\"theloai-nhacthieunhi.jsp\">Nhạc Thiếu Nhi</a></li>\n");
      out.write("                        <li><a href=\"theloai-nhacaumy.jsp\">Nhạc Âu Mỹ</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"dropdown\">\n");
      out.write("                    <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Quốc gia\n");
      out.write("                        <span class=\"caret\"></span></a>\n");
      out.write("                    <ul class=\"dropdown-menu\">\n");
      out.write("                        <li><a href=\"quocgia-aumy.jsp\">Âu Mỹ</a></li>\n");
      out.write("                        <li><a href=\"quocgia-trungquoc.jsp\">Trung Quốc</a></li>\n");
      out.write("                        <li><a href=\"quocgia-vietnam.jsp\">Việt Nam</a></li>\n");
      out.write("                        <li><a href=\"quocgia-hanquoc.jsp\">Hàn Quốc</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"#\"><span class=\"glyphicon glyphicon-star\"></span> Top CA KHÚC</a></li> \n");
      out.write("            </ul>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("    <li>\n");
      out.write("        <form class=\"form-inline\" action=\"\" method=\"GET\" style=\"position: relative; margin-top:8px;\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <input type=\"text\" id=\"timphim\" name=\"timphim\" class=\"form-control\" placeholder=\"Tìm ca khúc...\">\n");
      out.write("            </div>\n");
      out.write("            <button type=\"submit\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-search\"></span></button>\n");
      out.write("            <div class=\"list-group\" id=\"suggestbox\" style=\"position: absolute; z-index: 1;\"></div>\n");
      out.write("        </form>\n");
      out.write("    </li>\n");
      out.write("    <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Đăng ký</a></li>\n");
      out.write("    <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Đăng nhập</a></li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</nav>");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col\" style=\"position:relative;\">\n");
      out.write("                    <a href=\"\" style=\"position:absolute; z-index:1; top:0px; left:0px;\"><img class=\"img-responsive\"src=\"image/beat.png\"></img></a>\n");
      out.write("                    <div id=\"hangCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                        <!-- Indicators -->\n");
      out.write("                        <ol class=\"carousel-indicators\" id='imgslidesize'>\n");
      out.write("                            <li data-target=\"#hangCarousel\" data-slide-to=\"0\" class=\"active\" ></li>\n");
      out.write("                            <li data-target=\"#hangCarousel\" data-slide-to=\"1\"></li>\n");
      out.write("                            <li data-target=\"#hangCarousel\" data-slide-to=\"2\"></li>\n");
      out.write("                            <li data-target=\"#hangCarousel\" data-slide-to=\"3\"></li>\n");
      out.write("                        </ol>\n");
      out.write("\n");
      out.write("                        <!-- Wrapper for slides -->\n");
      out.write("                        <div class=\"carousel-inner\" role=\"listbox\" id='imgslide'>\n");
      out.write("                            <!--\n");
      out.write("                            <div class=\"item active\">\n");
      out.write("                                <img class=\"img-responsive center-block\" src=\"src/img/testimg.jpg\" alt=\"avenger\">\n");
      out.write("                            </div>\n");
      out.write("                            -->\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Left and right controls -->\n");
      out.write("                        <a class=\"left carousel-control\" href=\"#hangCarousel\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\n");
      out.write("                            <span class=\"sr-only\">Trước</span>\n");
      out.write("                        </a>\n");
      out.write("                        <a class=\"right carousel-control\" href=\"#hangCarousel\" role=\"button\" data-slide=\"next\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\n");
      out.write("                            <span class=\"sr-only\">Tiếp</span>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col\">\n");
      out.write("                    <p style=\"font-size:25px; color:white;\"><span class=\"glyphicon glyphicon-menu-hamburger\"></span>Phim lẻ\n");
      out.write("                        <span style=\"font-size:25px; float:right;\">Xem tất cả</span>\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("             <div class=\"row\" id=\"musiclist\">\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var preparedImgSlideHtml = '';\n");
      out.write("                var preparedImgSlideSizeHtml = '';\n");
      out.write("                $.get(\"http://localhost:3000/music-list/quoc-gia/au-my\", function (data, status) {\n");
      out.write("                    var resData = JSON.parse(data);\n");
      out.write("                    for(var i = 0; i < resData.length; i++){\n");
      out.write("                        var totalScore = 0;\n");
      out.write("                        for(var j = 0; j < resData[i].nhac.danhgia.length; j++){\n");
      out.write("                            totalScore += Number(resData[i].nhac.danhgia[j].diem);\n");
      out.write("                        }\n");
      out.write("                        var ratedScore = Math.round(totalScore/resData[i].nhac.danhgia.length);\n");
      out.write("                        var preparedHtml = '<div class=\"col-md-3\"><div class=\"container-fluid grayhover\"><a href=\"/MUSIC/nghenhac.jsp?id='+ resData[i]._id +'\"><img class=\"img-responsive\" src=\"' + resData[i].nhac.hinhanh + '\"  style=\"margin-top:5px;\" alt=\" + resData[i].nhac.tenbaihat + \"></a><p>'\n");
      out.write("                                + resData[i].nhac.tenbaihat + '</p><p>Đánh giá:('\n");
      out.write("                                + ratedScore + '/10<span class=\"glyphicon glyphicon-star\"></span>) '\n");
      out.write("                                + resData[i].nhac.danhgia.length + ' lượt</p><p><span class=\"glyphicon glyphicon-eye-open\" style=\"color:red\"></span>'\n");
      out.write("                                + resData[i].nhac.luotxem + '  <span class=\"glyphicon glyphicon-comment\" style=\"color:red\"></span> '\n");
      out.write("                                + resData[i].nhac.binhluan.length + '</p></div></div>';\n");
      out.write("                        document.getElementById('musiclist').innerHTML += preparedHtml;\n");
      out.write("                        if(i === 0){\n");
      out.write("                            preparedImgSlideSizeHtml += '<li data-target=\"#hangCarousel\" data-slide-to=\"' + i + '\" class=\"active\"></li>';\n");
      out.write("                            //poster\n");
      out.write("                            preparedImgSlideHtml += '<div class=\"item active\"><img class=\"img-responsive center-block\" src=\"'\n");
      out.write("                                + resData[i].nhac.poster + '\" alt=\"' + resData[i].nhac.tenbaihat + '\"></div>';\n");
      out.write("                        }\n");
      out.write("                        else{\n");
      out.write("                            preparedImgSlideSizeHtml += '<li data-target=\"#hangCarousel\" data-slide-to=\"' + i + '\"></li>';\n");
      out.write("                            //poster\n");
      out.write("                            preparedImgSlideHtml += '<div class=\"item\"><img class=\"img-responsive center-block\" src=\"'\n");
      out.write("                                + resData[i].nhac.poster + '\" alt=\"' + resData[i].nhac.tenbaihat + '\"></div>';\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    document.getElementById('imgslidesize').innerHTML = preparedImgSlideSizeHtml;\n");
      out.write("                    document.getElementById('imgslide').innerHTML = preparedImgSlideHtml;\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
