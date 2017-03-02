<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
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
<!-- 顶部导航 -->
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" id="menu-nav">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">音乐吧</a>
        </div>
        <!--会折叠的区域-->
        <div class="navbar-collapse collapse">
           <%-- <ul class="nav navbar-nav choose">
                <li class="active"><a href="<%=request.getContextPath()%>/index/index">音乐库</a></li>
                <li><a href="<%=request.getContextPath()%>/music/myMusic">我的音乐</a></li>
            </ul>--%>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${user == null}">
                        <li><a href="#" data-toggle="modal" data-target="#moddal-login">登录</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#moddal-signUp">注册</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="dropdown navbar-headimg">
                            <img src="<%=request.getContextPath()%>${user.headImg}" alt="${user.username}"  class="img-circle dropdown-toggle" data-toggle="dropdown">
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="<%=request.getContextPath()%>/user/showInfo">设置</a></li>
                                <li><a href="<%=request.getContextPath()%>/index/signOut">退出</a></li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
            <form class="navbar-form navbar-right" role="search" action="<%=request.getContextPath()%>/search/song" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="keyWord" placeholder="请输入搜索的歌曲">
                </div>
                <button type="submit" class="btn  search-btn"><img src="<%=request.getContextPath()%>/assets/images/search-bar.png" alt=""></button>
            </form>
        </div>
    </div>
</div>
<!--登录摸态框-->
<div class="modal fade" id="moddal-login" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">登录</h3>
            </div>
            <div class="modal-body">
                <form action="">
                    <div class="form-group">
                        <input type="text" placeholder="用户名" class="form-control username-in">
                        <input type="password" placeholder="密码" class="form-control passsword-in">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary signIn">登录</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!--注册摸态框-->
<div class="modal fade" id="moddal-signUp" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">注册</h3>
            </div>
            <div class="modal-body">
                <form action="">
                    <div class="form-group">
                        <input type="text" placeholder="用户名" class="form-control username-up">
                        <input type="password" placeholder="密码" class="form-control password-up">
                        <input type="password" placeholder="请再次输入密码" class="form-control password-ups">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary signUp">注册</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


        <!--背景-->
        <div class="container profile">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <h1>后台管理</h1>
                </div>
            </div>
        </div>

        <!--主要的内容-->
        <div class="container main-content">
            <ul class="nav nav-tabs" role="tablist" id="feature-tab">
                <li class="active"><a href="#my-music" role="tab" data-toggle="tab">用户列表</a></li>
                <li ><a href="#my-comment" role="tab" data-toggle="tab">评论列表</a></li>
            </ul>
            <%--用户列表--%>
            <div class="tab-content">
                <div class="tab-pane active" id="my-music">
                    <div class="row feature">
                        <div class="col-md-10">
                            <table class="table">
                                <tr>
                                    <th></th>
                                    <th>用户名</th>
                                    <th>邮箱</th>
                                    <th>性别</th>
                                    <th>年龄</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td> <img src="<%=request.getContextPath()%>${user.headImg}" class="comment-img img-circle" alt=""></td>
                                        <td>${user.username}</td>
                                        <td>${user.email}</td>
                                        <td>${user.sex}</td>
                                        <td>${user.age}</td>
                                        <td>
                                            <c:if test="${user.status == 0}">正常</c:if>
                                            <c:if test="${user.status == 1}">禁用</c:if>
                                            <c:if test="${user.status == 2}">管理员</c:if>
                                        </td>
                                        <td>
                                            <c:if test="${user.status == 0}"><label data-id="1" user-id="${user.id}" class="user-satsus">禁用</label></c:if>
                                            <c:if test="${user.status == 1}"><label data-id="0" user-id="${user.id}" class="user-satsus">启用</label></c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="tab-pane " id="my-comment">
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

<!--页脚-->
<%@ include file="footer.jsp" %>

<script>

    /*进行登录*/
    $(".signIn").click(function () {
        var username = $(".username-in").val();
        var password = $(".passsword-in").val();
        $.post("<%=request.getContextPath()%>/index/signIn",{username:username,password:password},function (data) {
            if(data.code == "200"){
                window.location.href = "<%=request.getContextPath()%>/music/myMusic";
            }else if(data.code == "201"){
                alert("登录失败");
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
                alert("注册成功");
            }else if(data.code == "201"){
                alert("注册失败");
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


    /* 进行删除评论操做*/
    $(".user-satsus").click(function () {
        var status =  $(this).attr("data-id");
        var uid =  $(this).attr("user-id");
        $.post("<%=request.getContextPath()%>/user/status",{status:status,uid:uid},function (data) {
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