<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> MUSIC</title>
        <meta  http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="header.jsp" %>
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
                    <p style="font-size:25px; color:white;"><span class="glyphicon glyphicon-menu-hamburger"></span>CA KHÚC
                        <span style="font-size:25px; float:right;">Xem tất cả</span>
                    </p>
                </div>
            </div>
            <div class="row" id="musiclist">
               
            </div>
        </div>
        <script>
            $(document).ready(function () {
                var preparedImgSlideHtml = '';
                var preparedImgSlideSizeHtml = '';
                $.get("http://localhost:3000/music-list/quoc-gia/han-quoc", function (data, status) {
                    var resData = JSON.parse(data);
                    for(var i = 0; i < resData.length; i++){
                        var totalScore = 0;
                        for(var j = 0; j < resData[i].nhac.danhgia.length; j++){
                            totalScore += Number(resData[i].nhac.danhgia[j].diem);
                        }
                        var ratedScore = Math.round(totalScore/resData[i].nhac.danhgia.length);
                        var preparedHtml = '<div class="col-md-3"><div class="container-fluid grayhover"><a href="/MUSIC/nghenhac.jsp?id='+ resData[i]._id +'"><img class="img-responsive" src="' + resData[i].nhac.hinhanh + '"  style="margin-top:5px;" alt=" + resData[i].nhac.tenbaihat + "></a><p>'
                                + resData[i].nhac.tenbaihat + '</p><p>Đánh giá:('
                                + ratedScore + '/10<span class="glyphicon glyphicon-star"></span>) '
                                + resData[i].nhac.danhgia.length + ' lượt</p><p><span class="glyphicon glyphicon-eye-open" style="color:red"></span>'
                                + resData[i].nhac.luotxem + '  <span class="glyphicon glyphicon-comment" style="color:red"></span> '
                                + resData[i].nhac.binhluan.length + '</p></div></div>';
                        document.getElementById('musiclist').innerHTML += preparedHtml;
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