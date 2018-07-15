<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> MUSIC Trang chủ </title>
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
                                <li><a href="#">Nhạc Trẻ</a></li>
				<li><a href="#">Nhạc Thiếu Nhi</a></li>
				<li><a href="#">Nhạc Bolero</a></li>
				<li><a href="#">Nhạc Âu Mỹ</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Album
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
                <div class="col" style="position:relative;">
                    <a href="" style="position:absolute; z-index:1; top:0px; left:0px;"><img class="img-responsive" src="image/beat.png"></img></a>
                    <div id="hangCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators" id='imgslidesize'>
                            <li data-target="#hangCarousel" data-slide-to="0" class="active" ></li>
                            <li data-target="#hangCarousel" data-slide-to="1"></li>
                            <li data-target="#hangCarousel" data-slide-to="2"></li>
                            <li data-target="#hangCarousel" data-slide-to="3"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox" id='imgslide'>
                            <!--
                            <div class="item active">
                                <img class="img-responsive center-block" src="src/img/testimg.jpg" alt="avenger">
                            </div>
                            -->
                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#hangCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Trước</span>
                        </a>
                        <a class="right carousel-control" href="#hangCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Tiếp</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col">
                    <p style="font-size:25px; color:white;"><span class="glyphicon glyphicon-menu-hamburger"></span>Ca khúc HOT
                        <span style="font-size:25px; float:right;">Xem tất cả</span>
                    </p>
                </div>
            </div>
            <div class="row" id="movielist">
                <!--
                <div class="col-md-3">
                    <div class="container-fluid grayhover">
                        <a href="#"><img class="img-responsive" src="src/img/liehuoruge.jpg"  style="margin-top:5px;" alt="liehouruge"></a>
                        <p>Liệt hỏa như ca - Liehuo Ruge(2018)</p>
                        <p>Đánh giá:(8/10<span class="glyphicon glyphicon-star"></span>) 100 lượt</p>
                        <p><span class="glyphicon glyphicon-eye-open" style="color:red"></span>12000  <span class="glyphicon glyphicon-comment" style="color:red"></span> 200</p>
                    </div>
                </div>
               -->
            </div>
        </div>
        <script>
            $(document).ready(function () {
                var preparedImgSlideHtml = '';
                var preparedImgSlideSizeHtml = '';
                $.get("http://localhost:3000/movie-list", function (data, status) {
                    var resData = JSON.parse(data);
                    for(var i = 0; i < resData.length; i++){
                        var totalScore = 0;
                        for(var j = 0; j < resData[i].nhac.danhgia.length; j++){
                            totalScore += Number(resData[i].nhac.danhgia[j].diem);
                        }
                        var ratedScore = Math.round(totalScore/resData[i].nhac.danhgia.length);
                        var preparedHtml = '<div class="col-md-3"><div class="container-fluid grayhover"><a href="/web/thongtin.jsp?id='+ resData[i]._id +'"><img class="img-responsive" src="' + resData[i].nhac.hinhanh + '"  style="margin-top:5px;" alt=" + resData[i].nhac.tenbaihat + "></a><p>'
                                + resData[i].nhac.tenbaihat + '</p><p>Đánh giá:('
                                + ratedScore + '/10<span class="glyphicon glyphicon-star"></span>) '
                                + resData[i].nhac.danhgia.length + ' lượt</p><p><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
                                + resData[i].phim.luotxem + '  <span class="glyphicon glyphicon-comment" style="color:red"></span> '
                                + resData[i].nhac.binhluan.length + '</p></div></div>';
                        document.getElementById('movielist').innerHTML += preparedHtml;
                        if(i === 0){
                            preparedImgSlideSizeHtml += '<li data-target="#hangCarousel" data-slide-to="' + i + '" class="active"></li>';
                            //poster
                            preparedImgSlideHtml += '<div class="item active"><img class="img-responsive center-block" src="'
                                + resData[i].nhac.poster + '" alt="' + resData[i].nhac.tenbaihat + '"></div>';
                        }
                        else{
                            preparedImgSlideSizeHtml += '<li data-target="#hangCarousel" data-slide-to="' + i + '"></li>';
                            //poster
                            preparedImgSlideHtml += '<div class="item"><img class="img-responsive center-block" src="'
                                + resData[i].nhac.poster + '" alt="' + resData[i].nhac.tenbaihat + '"></div>';
                        }
                    }
                    document.getElementById('imgslidesize').innerHTML = preparedImgSlideSizeHtml;
                    document.getElementById('imgslide').innerHTML = preparedImgSlideHtml;
                });
            });
        </script>
    </body>
</html>