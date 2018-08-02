<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#hangNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span> 
            </button>
        </div>
        <div class="collapse navbar-collapse" id="hangNavbar">
            <ul class="nav navbar-nav navbar-left">
                <li class="active"><a href="index.jsp"><span class="glyphicon glyphicon-home"></span></a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Thể loại
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="theloai-nhactre.jsp">Nhạc Trẻ</li>
                        <li><a href="theloai-nhacbolero.jsp">Nhạc Bolero</a></li>
                        <li><a href="theloai-nhacthieunhi.jsp">Nhạc Thiếu Nhi</a></li>
                        <li><a href="theloai-nhacaumy.jsp">Nhạc Âu Mỹ</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Quốc gia
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="quocgia-aumy.jsp">Âu Mỹ</a></li>
                        <li><a href="quocgia-trungquoc.jsp">Trung Quốc</a></li>
                        <li><a href="quocgia-vietnam.jsp">Việt Nam</a></li>
                        <li><a href="quocgia-hanquoc.jsp">Hàn Quốc</a></li>
                    </ul>
                </li>
                <li><a href="#"><span class="glyphicon glyphicon-star"></span> Top CA KHÚC</a></li> 
            </ul>
            <%@include file="tim-kiem.jsp" %>
        </div>
    </div>
</nav>