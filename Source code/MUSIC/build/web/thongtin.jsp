<%-- 
    Document   : thongtin
    Created on : Jul 15, 2018, 11:21:21 AM
    Author     : THUYTHA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> MUSIC Thông tin bài hát </title>
        <meta  http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
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
                        <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Thể loại
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Nhạc VPOP</a></li>
				<li><a href="#">Nhạc Thiếu Nhi</a></li>
				<li><a href="#">Nhạc Bolero</a></li>
				<li><a href="#">Nhạc Âu Mỹ</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Quốc Gia
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Âu Mỹ</a></li>
				<li><a href="#">Việt Nam</a></li>
				<li><a href="#">Trung Quốc </a></li>
				<li><a href="#">Hàn Quốc</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Video</a></li> 
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span> TOP CA KHÚC</a></li> 
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <form class="form-inline" action="" method="GET" style="position: relative; margin-top:8px;">
                                <div class="form-group">
                                    <input type="text" id="timphim" name="timphim" class="form-control" placeholder="Tìm bài hát...">
                                </div>
                                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                                <div class="list-group" id="suggestbox" style="position: absolute; z-index: 1;"></div>
                            </form>
                        </li>
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Đăng ký</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Đăng nhập</a></li>
                    </ul>
                </div>

            </div>
        </nav>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <div class="container-fluid" style="background-color:lightgray; border-radius:5px;">
                        <img class="img-responsive" id="preview-img" src=""  style="margin-top:5px;" alt="">
                        <div class="text-center">
                            <a href="<%
                    if (request.getParameter("id") != null) {
                        if (request.getParameter("id") != "") {
                            out.print("/web/xemphim.jsp?id=" + request.getParameter("id"));
                        }
                    }

            %>"><button class="btn btn-danger btn-lg">Nghe bài hát</button></a>
                        </div>
                    </div>					
                </div>
                <div class="col-md-7">
                    <div class="container-fluid" style="font-size:25px; background-color:lightgray; border-radius:5px;" id="movie-info">
                        <p class="text-center" style="font-size:35px;"><span class="label label-info">Thông tin ca khúc</span></p>
                       
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form action="">
                        <div class="form-group" style="font-size:20px;">
                            <label>Thêm bình luận mới về bài hát này: </label>
                            <textarea class="form-control" rows="5" name="comment"></textarea>
                        </div>
                        <div class="text-right">
                            <button type="submit" class="btn btn-default">Đăng bình luận</button>
                        </div>
                    </form> 
                </div>
                <div class="col-md-12" style="font-size:20px;" id="comment">
                    <p style="font-size:35px;"><span class="label label-info">Bình luận</span></p>
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                var movieId = '<%
                    if (request.getParameter("id") != null) {
                        if (request.getParameter("id") != "") {
                            out.print(request.getParameter("id"));
                        }
                    }

            %>';
                if (movieId != '') {
                    $.get("http://localhost:3000/movie-info?id=" + movieId, function (data, status) {
                        var resData = JSON.parse(data);
                        document.getElementById("preview-img").src = resData.nhac.tenbaihat;
                        document.getElementsByTagName("title")[0].innerHTML += resData.nhac.tenbaihat;
                        var totalScore = 0;
                        for(var j = 0; j < resData.nhac.danhgia.length; j++){
                            totalScore += Number(resData.nhac.danhgia[j].diem);
                        }
                        var ratedScore = Math.round(totalScore/resData.nhac.danhgia.length);
                        var ratingHTML = '('+ ratedScore +'đ/'+ resData.nhac.danhgia.length +' lượt)';
                        var star = '';
                        var emptyStar = '';
                        for(var i = 0; i < 10; i++){
                            if(i < ratedScore){
                                star += '&#xe006;';
                            }
                            else{
                                emptyStar += '&#xe007;';
                            }
                        }
                        ratingHTML = '<p>'+ ratingHTML + ' <span class="glyphicon" style="color:yellow;">'+ star +'</span><span class="glyphicon" style="color:yellow;">'+ emptyStar +'</span>' + '</p>';
                        var commentHTML = '';
                        for(var i = 0; i < resData.nhac.binhluan.length; i++){
                            commentHTML += '<div class="well well-sm"><p>' 
                                    + resData.nhac.binhluan[i].email + ':'
                                    + resData.nhac.binhluan[i].noidung +'</p><p class="text-right">Đăng lúc ' 
                                    + resData.nhac.binhluan[i].thoigian +'</p></div>';
                        }
                        document.getElementById("comment").innerHTML += commentHTML;
                        var infoHTML = '<p>Tên Bài hát: '+ resData.nhac.tenbaihat +'</p><p>Ca sĩ: '
                                + resData.nhac.casi +'</p><p>Sáng tác: '
                                + resData.nhac.sangtac +'</p><p>Thể loại: '
                                + resData.nhac.theloai +'</p><p>Quốc gia: '
                                + resData.nhac.quocgia  +'</p><p>Lượt xem: '
                                + resData.nhac.luotxem +'</p>' + ratingHTML;
                        document.getElementById("movie-info").innerHTML += infoHTML;
                    });
                }
            });
        </script>
    </body>
</html>