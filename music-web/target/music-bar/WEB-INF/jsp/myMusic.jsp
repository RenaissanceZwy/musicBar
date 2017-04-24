<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的音乐</title>
    <%@ include file="common/css.jsp" %>
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
        /*背景*/
        .profile{
            background-image: url("<%=request.getContextPath()%>/assets/images/bg_index_new.jpg");
            width: 100%;
            height:400px;
        }
        .profile .head-img{
            width: 100px;
            height: 100px;
        }
        .profile .row{
            text-align: center;
            vertical-align: middle;
            padding-top: 100px;
            color: snow;
        }

        /* 特性 */
        .main-content{
            margin: 50px auto;
            margin-bottom: 50px;
        }
        .feature .table>tbody>tr>td {
            padding: 10px;
            line-height: 3;
        }
        .main-content .row{
            padding-top: 20px;
        }

        /*评论区*/
        .comment-img{
            width: 50px;
            height: 50px;
            margin-right: 20px;
            float: left;
        }
        .comment .col-md-10{
            /* border: 1px solid black;*/
            padding-top: 5px;
        }
        .delete-comment{
            float: right;
            margin-top:-40px;
            cursor: pointer;
        }
        /*没有登录页面*/
        .up-sign{
            background-image: url("<%=request.getContextPath()%>/assets/images/bg_like.jpg");
            width: 100%;
            height: 600px;
            color: snow;
        }
        .up-sign .row{
            text-align: center;
            margin-top: 200px;
        }
        .up-sign .sign-btn{
            width: 150px;
            height: 40px;
            background-color: #31c27c;
            border: none;
            margin-top: 50px;
            font-size: 20px;
        }
        .footer{
            margin-top: 0px;
        }

    </style>
</head>
<body>
<!-- 顶部导航 -->
<%@ include file="common/navbar.jsp" %>
<c:choose>
    <c:when test="${user==null}">
        <div class="up-sign">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h1>音乐吧，您的音乐管家</h1>
                        <h2>立即登录，多端管理</h2>
                        <button class="sign-btn" data-toggle="modal" data-target="#moddal-login">立即登录</button>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <!--背景-->
        <div class="container profile">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <a href="<%=request.getContextPath()%>/user/showInfo">
                        <img src="<%=request.getContextPath()%>${user.headImg}" alt="" class="head-img img-circle">
                    </a>
                    <h3>${user.username}</h3>
                </div>
            </div>
        </div>

        <!--主要的内容-->
        <div class="container main-content">
            <ul class="nav nav-tabs" role="tablist" id="feature-tab">
                <li ><a href="#my-music" role="tab" data-toggle="tab">我的音乐</a></li>
                <li><a href="#my-collection" role="tab" data-toggle="tab">我的收藏</a></li>
               <%-- <li><a href="#my-download" role="tab" data-toggle="tab">我的下载</a></li>--%>
                <li class="active"><a href="#my-comment" role="tab" data-toggle="tab">我的评论</a></li>
            </ul>
            <%--最近播放--%>
            <div class="tab-content">
                <div class="tab-pane" id="my-music">
                    <div class="row feature">
                        <div class="col-md-10">
                            <table class="table">
                                <tr>
                                    <th>歌曲</th>
                                    <th>歌手</th>
                                    <th>专辑</th>
                                    <th>封面</th>
                                </tr>
                                <c:forEach items="${recentPlay}" var="music">
                                    <tr>
                                        <td><a href="<%=request.getContextPath()%>/music/play?id=${music.songId}">${music.musicName}</a></td>
                                        <td>${music.singer}</td>
                                        <td>${music.albumName}</td>
                                        <td><img src="${music.picUrl}" style="width:50px;height:50px" alt=""></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <%--我的收藏--%>
                <div class="tab-pane" id="my-collection">
                    <div class="row feature">
                        <div class="col-md-10">
                            <table class="table">
                                <tr>
                                    <th>歌曲</th>
                                    <th>歌手</th>
                                    <th>专辑</th>
                                    <th>封面 </th>
                                </tr>
                                <c:forEach items="${collectionMusic}" var="music">
                                    <tr>
                                        <td>
                                            <a href="<%=request.getContextPath()%>/music/play?id=${music.songId}">${music.musicName}</a>
                                        </td>
                                        <td>${music.singer}</td>
                                        <td>${music.albumName}</td>
                                        <td><img src="${music.picUrl}" style="width:50px;height:50px" alt=""></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
               <%-- &lt;%&ndash;我的下载&ndash;%&gt;
                <div class="tab-pane" id="my-download">
                    <div class="col-md-10">
                        <table class="table">
                            <tr>
                                <th>歌曲</th>
                                <th>歌手</th>
                                <th>专辑</th>
                                <th>播放次数</th>
                            </tr>
                            <c:forEach items="${favorite}" var="music">
                                <tr>
                                    <td>${music.musicName}</td>
                                    <td>${music.singer}</td>
                                    <td>${music.albumName}</td>
                                    <td>${music.playNum}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>--%>
                <div class="tab-pane active" id="my-comment">
                    <c:forEach items="${commentInfos}" var="comment">
                        <div class="row feature comment">
                            <div class="col-md-10">
                                <img src="<%=request.getContextPath()%>${comment.headImg}" class="comment-img img-circle" alt="">
                                <ul class="comment-text">
                                    <li>${comment.username} &nbsp;${comment.time} </li>
                                    <li> <h5>${comment.content}</h5></li>
                                </ul>
                                <div class="delete-comment"  data-id="${comment.id}">删除</div>
                                <hr>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>



<!--页脚-->
<%@ include file="common/footer.jsp" %>
<%@ include file="common/script.jsp" %>
<script>
    $(function () {
        var li = $(".choose").children(".active").removeClass("active");
        var nextLi = li.next("li").addClass("active");
        console.log("li"+li);
        console.log("nextLi"+nextLi);
    });
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

    /* 进行删除评论操做*/
    $(".delete-comment").click(function () {
        var cid =  $(this).attr("data-id");
        $.post("<%=request.getContextPath()%>/music/deleteComment",{cid:cid},function (data) {
            if(data.code == "200"){
                alert(""+data.message);
                window.location.reload();
            }else if(data.code == "201"){
                alert(""+data.message);
            }
        },"json");
    });

</script>
</body>
</html>