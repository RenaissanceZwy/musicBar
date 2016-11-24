<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <%@ include file="include.jsp" %>
    <style>
        *{ margin:0; padding:0; list-style:none;}
        *, *:before, *:after {
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }
        html {
            min-height: 100%;
        }
        body {
            padding-top: 50px;
            padding-bottom: 0px;
            color: #5a5a5a;
        }
        /*导航栏*/

        /* 轮播广告 */
        .carousel {
            height: 500px;
            margin-bottom: 60px;
        }

        .carousel .item {
            height:500px;
            background-color: #000;
        }

        .carousel .item img {
            width: 100%;
            height: 100%;
        }
        .carousel-caption p {
            margin-bottom: 20px;
            font-size: 20px;
            line-height: 1.8;
        }

        /*热门歌曲*/
        .hot-song{
            margin-bottom: 50px;
        }
        .hot-song .col-md-12{
            text-align: center;
            margin-bottom: 30px;
        }
        .hot-song .col-md-3 img{
            width: 100%;
        }
        .hot-song .col-md-3{
            background-color: #4cae4c;
            padding: 0px;
            margin-right:0px;
        }
        .hot-song .description{
            height: 100px;
            width:100%;
            background-color:rgb(51,51,51) ;
        }
        .hot-song .description{
            text-align: center;
            font-size: 15px;
            color: snow;
            padding:20px;
        }

        /*排行榜*/
        .rank{
            background-image: url("<%=request.getContextPath()%>/assets/images/bg_index_top2.jpg");
            width:100%;
            padding-top: 50px;
            padding-bottom: 50px;
            color: snow;
        }
        .rank h1{
            text-align: center;
            margin-bottom: 30px;
        }
        .rank-container{
            width: 90%;
            padding-bottom: 50px;
            position: relative;
        }
        .rank-container .row{
            height: 100%;
        }
        .rank1{
            background-image: url("<%=request.getContextPath()%>/assets/images/bg_index_top6.jpg");
            height: 500px;
            padding-top: 50px;
        }
        .rank2{
            background-image: url("<%=request.getContextPath()%>/assets/images/bg_index_top1.jpg");
            height: 500px;
            padding-top: 50px;
        }
        .rank3{
            background-image: url("<%=request.getContextPath()%>/assets/images/bg_index_top3.jpg");
            height: 500px;
            padding-top: 50px;

        }
        .rank4{
            background-image: url("<%=request.getContextPath()%>/assets/images/bg_index_top4.jpg");
            height: 500px;
            padding-top: 50px;

        }
        .rank-container h3{
            text-align: center;
            margin-bottom: 50px;
        }
        .rank-container .list a {
            color: snow;
        }
        .rank-container ul li{
            list-style-type: decimal;
            margin-bottom: 20px;
            margin-left: 100px;
        }


        /*响应式布局*/
        @media (max-width: 768px) {
            .carousel {
                height: 200px;
                margin-bottom: 30px;
            }
            .carousel .item {
                height: 200px;
            }

            .carousel img {
                min-height: 200px;
            }

            .carousel-caption p {
                font-size: 16px;
                line-height: 1.4;
            }
        }


    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>

<!-- 广告轮播 -->
<div id="ad-carousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
        <li data-target="#ad-carousel" data-slide-to="1"></li>
        <li data-target="#ad-carousel" data-slide-to="2"></li>
        <li data-target="#ad-carousel" data-slide-to="3"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img src="<%=request.getContextPath()%>/assets/images/41260.jpg" alt="1 slide">
        </div>
        <div class="item">
            <img src="<%=request.getContextPath()%>/assets/images/50472.jpg" alt="2 slide">
        </div>
        <div class="item">
            <img src="<%=request.getContextPath()%>/assets/images/50587.jpg" alt="3 slide">
        </div>
        <div class="item">
            <img src="<%=request.getContextPath()%>/assets/images/50735.jpg" alt="4 slide">
        </div>
    </div>
    <a class="left carousel-control" href="#ad-carousel" data-slide="prev"><span
            class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="right carousel-control" href="#ad-carousel" data-slide="next"><span
            class="glyphicon glyphicon-chevron-right"></span></a>
</div>

<!--热门歌曲-->
<div class="hot-song container">
    <div class=" row">
        <div class="col-md-12">
            <h1>- 热门歌曲 -</h1>
        </div>
    </div>
    <div class="row">
        <c:forEach items="${playRank}" var="music">
            <div class="col-md-3 col-sm-6">
                <a href="<%=request.getContextPath()%>/music/play?id=${music.songId}">
                    <img src="${music.picUrl}" alt="">
                </a>
                <div class="description">
                    <h4>${music.musicName}-${music.singer}</h4>
                    <p>播放量：${music.playNum}</p>
                </div>
            </div>
         </c:forEach>
    </div>
</div>

<!--排行榜-->
<div class="rank">
    <h1>- 排行榜 -</h1>
    <div class="rank-container container">
        <div class="row">
            <div class="col-md-3 rank1">
                <h3>播放排行榜</h3>
                <ul class="list">
                    <c:forEach items="${playRank}" var="music">
                        <li>
                            <h4>
                                <a href="<%=request.getContextPath()%>/music/play?id=${music.songId}">${music.musicName}</a>
                            </h4>
                            <p>${music.singer}</p>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-md-3 rank2">
                <h3>下载排行榜</h3>
                <ul class="list">
                    <li>
                        <h4>July</h4>
                        <p>吴亦凡</p>
                    </li>
                    <li>
                        <h4>曾经的你</h4>
                        <p>萧敬腾</p>
                    </li>
                    <li>
                        <h4>一定要幸福</h4>
                        <p>张靓颖</p>
                    </li>
                    <li>
                        <h4>安静的夜</h4>
                        <p>本兮</p>
                    </li>
                </ul>
            </div>
            <div class="col-md-3 rank3">
                <h3>收藏排行榜</h3>
                <ul class="list">
                    <c:forEach items="${collectRank}" var="music">
                        <li>
                            <h4> <a href="<%=request.getContextPath()%>/music/play?id=${music.songId}">${music.musicName}</a></h4>
                            <p>${music.singer}</p>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-md-3 rank4">
                <h3>新歌排行榜</h3>
                <ul class="list">
                    <li>
                        <h4>July</h4>
                        <p>吴亦凡</p>
                    </li>
                    <li>
                        <h4>曾经的你</h4>
                        <p>萧敬腾</p>
                    </li>
                    <li>
                        <h4>一定要幸福</h4>
                        <p>张靓颖</p>
                    </li>
                    <li>
                        <h4>安静的夜</h4>
                        <p>本兮</p>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>

<!--页脚-->
<%@ include file="footer.jsp" %>



<script>
    /*进行登录*/
    $(".signIn").click(function () {
        var username = $(".username-in").val();
        var password = $(".passsword-in").val();
        $.post("<%=request.getContextPath()%>/index/signIn",{username:username,password:password},function (data) {
            if(data.code == "200"){
                if(data.object == "0"){
                    window.location.href = "<%=request.getContextPath()%>/index/index";
                }
                if(data.object == "2"){
                    window.location.href = "<%=request.getContextPath()%>/admin/index";
                }
            }else if(data.code == "201"){
                alert(data.message);
            }
        },"json");
    });

    /*进行注册*/
    $(".signUp").click(function () {
        var username = $(".username-up").val();
        var password = $(".password-up").val();
        var password2 = $(".password-ups").val();
        if(password != password2){
            alert("您输入的两次密码不一致")
        }
        $.post("<%=request.getContextPath()%>/index/signUp",{username:username,password:password},function (data) {
            if(data.code == "200"){
                alert(data.message);
                window.location.href = "<%=request.getContextPath()%>/index/index";
            }else if(data.code == "201"){
                alert(data.message);
            }
        },"json");
    })


    /*热门歌曲鼠标滑过事件*/
    $(".hot-song .col-md-3 a").hover(function () {
        var description = $(this).next(".description");
        description.css("background-color","rgb(49,194,124)");
        $(this).parent(".col-md-3").css("box-shadow","5px 5px 5px 5px #888888");
    },function () {
        var box = $(this).parent(".col-md-3");
        var index = box.index();
        if(index == 0 || index == 2){
            $(this).next(".description").css("background-color","rgb(51,51,51)");
            box.css("box-shadow","none");
        }else{
            $(this).next(".description").css("background-color","rgb(65,65,65)");
            box.css("box-shadow","none");
        }

    });

    /*var w =$(".rank-container .col-md-3").width();
    var h =$(".rank-container .col-md-3").height();
    $(".rank-container .col-md-3").hover(function () {
        $(this).animate({height:h+20,width:w+20,top:"-10px"},450);
    },function () {
        $(this).animate({height:h,width:w,left:"0px",top:"10px"},450);
    });*/
</script>
</body>
</html>