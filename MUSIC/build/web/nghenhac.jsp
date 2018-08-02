

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.lang.String" %>
<!DOCTYPE html>
<html>
    <head>
        <title> MUSIC </title>
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
                <div class="col-md-12">
                    <div class="container-fluid text-center">
                        <video id="music-player" controls>
                            
                        </video> 
                    </div>
                    <p style="font-size:25px;"><span class="label label-info" id="rating"> Đánh giá: </span></p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div>
                        <div class="form-group">
                            <label for="usr" style="color:red;">Email:</label>
                            <input type="email" class="form-control" id="mail">
                        </div>
                        <div class="form-group" style="font-size:20px;">
                            <label style="color:red;">Nội dung: </label>
                            <textarea class="form-control" rows="5" id="commentvalue"></textarea>
                        </div>
                        <div class="text-right">
                            <button class="btn btn-default" id="submitcomment">Đăng bình luận</button>
                        </div>
                    </div> 
                </div>
                <div class="col-md-12" style="font-size:20px;" id="comment">
                    <p style="font-size:35px;"><span class="label label-info">Bình luận</span></p>

                  
                </div>
            </div>
        </div>
        <script>
            $(document).ready(function () {
                var musicId = '<%
                    if (request.getParameter("id") != null) {
                        if (request.getParameter("id") != "") {
                            out.print(request.getParameter("id"));
                        }
                    }

            %>';
                if (musicId != '') {
                    $.get("http://localhost:3000/music-info?id=" + musicId, function (data, status) {
                        var resData = JSON.parse(data);
                        document.getElementById("music-player").src = resData.nhac.link;
                        document.getElementsByTagName("title")[0].innerHTML += resData.nhac.tenbaihat;
                        var totalScore = 0;
                        for (var j = 0; j < resData.nhac.danhgia.length; j++) {
                            totalScore += Number(resData.nhac.danhgia[j].diem);
                        }
                        var ratedScore = Math.round(totalScore / resData.nhac.danhgia.length);
                        var ratingHTML = '(' + ratedScore + 'đ/' + resData.nhac.danhgia.length + ' lượt)';
                        var star = '';
                        var emptyStar = '';
                        for (var i = 0; i < 10; i++) {
                            if (i < ratedScore) {
                                star += '&#xe006;';
                            } else {
                                emptyStar += '&#xe007;';
                            }
                        }
                        
                        document.getElementById("rating").innerHTML += ratingHTML + ' <span class="glyphicon" style="color:yellow;">' + star + '</span><span class="glyphicon" style="color:yellow;">' + emptyStar + '</span>';
                         
                        var commentHTML = '';
                       for (var i = 0; i < resData.nhac.binhluan.length; i++) {
                            commentHTML += '<div class="well well-sm"><p>'
                                    + resData.nhac.binhluan[i].email + ':'
                                    + resData.nhac.binhluan[i].noidung + '</p><p class="text-right">Đăng lúc '
                                    + resData.nhac.binhluan[i].thoigian + '</p></div>';
                        }
                        document.getElementById("comment").innerHTML += commentHTML;
                       
                         
                    });
                }
            });
            //binh luan
            $('#submitcomment').click(function (){
                var musicId = '<%                    if (request.getParameter("id") != null) {
                        if (request.getParameter("id") != "") {
                            out.print(request.getParameter("id"));
                        }
                    }
 
                %>';
                if(musicId !== ''){
                   var commentvalue = document.getElementById('commentvalue').value;
                   var email= document.getElementById('mail').value;
                   if(commentvalue !== '' && email !== ''){
                       $.get("http://localhost:3000/add-comment",
                                {
                                    id: musicId,
                                    email: email,
                                    noidung: commentvalue
                                 },
                            function(data, status){
                                var resData = JSON.parse(data);
                                alert(resData.message);
                        });
                   }
                }
            });
        </script>
    </body>
</html>
