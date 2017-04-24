<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>播放音乐</title>
    <%@ include file="common/css.jsp" %>
    <style>
        body{
            filter: alpha(opacity=60);
        }
        /*歌曲信息*/
        .bg-profile{
            background-image: url("<%=request.getContextPath()%>/assets/images/bg_profile_unlogin.jpg");
        }
        .main-content{
            margin-top: 50px;
            padding: 50px;
        }
        .song-profile{
            width: 100%;
           /* height:250px;*/
        }
        .song-info{
            padding: 20px;
            color: snow;
        }
        .song-text li{
            margin-bottom: 20px;
        }
        .song-btn{
            margin-top: 50px;
        }
        .song-btn input{
            background-color: transparent;
            border-radius: 0px;
            color: snow;
            width: 100px;
        }
        .song-btn input:hover{
            background-color: #31c27c;
            color: black;
            border: none;
        }
        .song-btn li{
            margin-right: 20px;
            float: left;
        }
        .song-player{
            margin-left: 10px;
        }
        /*评论展示*/
        .comment-display{
            padding: 0px 50px 50px 50px;
        }
        .comment-input{
            width: 80%;
            float: left;
        }
        .comment-submit{
            width: 20%;
        }
        .comment-submit:hover{
            background-color: #31c27c;
            color: black;
            border: none;
        }
        /*评论区*/
        .comment-img{
            width: 50px;
            height: 50px;
            margin-right: 20px;
            float: left;
        }
        .comment-item .col-md-10{
            /* border: 1px solid black;*/
            padding-top: 5px;
        }
        .comment-like{
            float: right;
            margin-top:-40px;
            cursor: pointer;
        }
        .delete-comment{
            float: right;
            margin-top:-40px;
            margin-right:60px;
            cursor: pointer;
        }
        @media (max-width: 768px) {
            .song-profile{
                width: 150px;
                height:150px;
            }
            .song-info{
                font-size: 10px;
                color: snow;
            }
            .song-info h2{
                font-size: 20px;
            }
            .song-btn{
                margin-top: 10px;
            }
            .song-player{
                margin-left: 0px;
                margin-top: 30px;
            }
        }
    </style>
</head>
<body>
<!-- 顶部导航 -->
<%@ include file="common/navbar.jsp" %>

<!--歌曲信息-->
<div class="bg-profile">
    <div class="main-content container">
        <div class="row">
            <div class="col-md-3 col-sm-4">
                <img src="${music.picUrl}" class="song-profile" alt="">
            </div>
            <div class="col-md-4 col-sm-3 song-info">
                <ul class="song-text list-unstyled">
                    <li><h2>${music.musicName}</h2></li>
                    <li>歌手:${music.singer}</li>
                    <li>专辑:${music.albumName}</li>
                </ul>
                <ul class="song-btn list-unstyled">
                    <%--<li><input type="button" class="form-control" value="播放"></li>--%>
                    <c:if test="${collected == false}">
                        <li><input type="button" class="form-control collect" value="收藏" type-id="1"></li>
                    </c:if>
                    <c:if test="${collected == true}">
                        <li><input type="button" class="form-control cancel-collect" value="取消收藏"></li>
                    </c:if>
                    <%--<li><input type="button" class="form-control" value="下载"></li>--%>
                </ul>
            </div>
            <div class="col-md-4 col-sm-4 song-player">
                <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=86
                        src="http://music.163.com/outchain/player?type=2&id=${music.songId}&auto=0&height=66"></iframe>
            </div>
        </div>
    </div>
</div>
<!--评论展示区域-->
<div class="comment-display container">
    <!-- 评论框-->
    <div class="row">
        <div class="col-md-10">
            <hr>
            <form action="">
                <div class="form-group">
                    <input type="text" placeholder="请输入您的评论" class="form-control comment-input">
                    <input type="hidden"  class="songId" value="${music.songId}">
                </div>
                <div class="form-group">
                    <input type="button" class="form-control comment-submit" value="提交">
                </div>
            </form>
        </div>
    </div>
    <c:forEach items="${commentInfo}" var="comment">
        <div class="row comment-item">
            <div class="col-md-10">
                <img src="<%=request.getContextPath()%>${comment.headImg}" class="comment-img img-circle" alt="">
                <ul class="comment-text list-unstyled">
                    <li>${comment.username} &nbsp;</li>
                    <li> <h5>${comment.content}</h5></li>
                </ul>
                <c:if test="${user.id == comment.uid}">
                    <div class="delete-comment" data-id="${comment.id}">删除</div>
                </c:if>
                <div class="comment-like" data-id="${comment.id}">点赞(${comment.likeNum})</div>
                <hr>
            </div>
        </div>
    </c:forEach>
</div>

<!--页脚-->
<%@ include file="common/footer.jsp" %>
<%@ include file="common/script.jsp" %>
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
            }else if(data.code == "201"){
                alert(data.message);
            }
        },"json");
    })


   /* 进行评论操做*/
  $(".comment-submit").click(function () {
      var content = $(".comment-input").val();
      var mid = $(".songId").val();
      $.post("<%=request.getContextPath()%>/music/comment",{content:content,mid:mid},function (data) {
          if(data.code == "200"){
              alert(""+data.message);
              window.location.reload();
          }else if(data.code == "201"){
              alert(""+data.message);
          }
      },"json");

  });
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

    /* 进行点赞评论操做*/
    $(".comment-like").click(function () {
        var cid = $(this).attr("data-id");
        $.post("<%=request.getContextPath()%>/music/likeComment",{cid:cid},function (data) {
            if(data.code == "200"){
                alert(""+data.message);
                window.location.reload();
            }else if(data.code == "201"){
                alert(""+data.message);
            }
        },"json");
    });


    /*进行收藏操作*/
    $(".collect").click(function () {
        var songId = $(".songId").val();
        var type =  $(this).attr("type-id");
        $.post("<%=request.getContextPath()%>/music/collect",{songId:songId,type:type},function (data) {
            if(data.code == "200"){
                alert(""+data.message);
                window.location.reload();
            }else if(data.code == "201"){
                alert(""+data.message);
            }
        },"json");
    });

    $(".cancel-collect").click(function () {
        var songId = $(".songId").val();
        $.post("<%=request.getContextPath()%>/music/cancel",{mid:songId},function (data) {
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