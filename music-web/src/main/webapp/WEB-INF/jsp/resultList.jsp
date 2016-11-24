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

        /*查询结果列表*/
        .result-profle{
            background-image: url("<%=request.getContextPath()%>/assets/images/banner_pc.jpg");
            height: 300px;
        }
        .result-list{
            margin-top: 50px;
            font-size: 15px;
            line-height: 1.5;
        }
        .result-list .table>tbody>tr>td {
            padding: 10px;
        }

    </style>
</head>
<body>

<%@ include file="navbar.jsp" %>

<div class="result-profle">
</div>
<div class="container result-list">
    <div class="row">
        <div class="col-md-10">
            <c:if test="${result==1}">
                <table class="table">
                    <tr>
                        <th>歌曲</th>
                        <th>歌手</th>
                        <th>专辑</th>
                        <th>播放次数</th>
                    </tr>
                    <c:forEach items="${musicList}" var="music">
                        <tr>
                            <td>
                                <a href="<%=request.getContextPath()%>/music/play?id=${music.songId}">${music.musicName}</a>
                            </td>
                            <td>${music.singer}</td>
                            <td>${music.albumName}</td>
                            <td>${music.playNum}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${result==0}">
                <h3>很抱歉，没有找到相关歌曲</h3>
            </c:if>
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
                window.location.href = "<%=request.getContextPath()%>/index/index";
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
</script>
</body>
</html>