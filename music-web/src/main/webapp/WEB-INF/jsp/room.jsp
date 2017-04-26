<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String socketPath = request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>聊天室</title>
    <%@ include file="common/css.jsp" %>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css" type="text/css" />
    <style>
        .chat-thread  .left:before{
            left: -80px;
            background-image: url("<%=request.getContextPath()%>${toUser.headImg}");
        }
        .chat-thread  .right:before {
            right: -80px;
            background-image: url("<%=request.getContextPath()%>${user.headImg}");
        }
        .container{
            margin: 24px auto 0 auto;
            padding: 0 20px 0 0;
        }
    </style>
</head>
<body>
<div id="convo" data-from="Sonu Joshi">
    <ul class="chat-thread">
        <li class="left">Are we meeting today?</li>
        <li class="right">yes, what time suits you?</li>
        <li class="left">I was thinking after lunch, I have a meeting in the morning</li>
        <li class="right">Are we meeting today?</li>
        <li class="left">yes, what time suits you?</li>
        <li class="right">I was thinking after lunch, I have a meeting in the morning</li>
        <li class="left">Are we meeting today?</li>
        <li class="right">yes, what time suits you?</li>
        <li class="left">I was thinking after lunch, I have a meeting in the morning</li>
        <li class="right">Are we meeting today?</li>
        <li class="left">yes, what time suits you?</li>
        <li class="right">I was thinking after lunch, I have a meeting in the morning</li>
    </ul>
</div>
</br></br>
<div class="container">
    <div class="form-inline">
        <input type="text" class="form-control msgText" name="msgText" style="width: 60%;margin-left: 15%">
        <input type="button" value="发送" data-name="${user.username}" data-id="${user.id}" data-toid="${toUser.id}" class="btn btn-primary send" style="width: 10%">
    </div>
</div>

<script src='<%=request.getContextPath()%>/assets/js/jquery-1.11.1.min.js'></script>
<script>
    $(document).ready(function () {
       // $(".chat-thread").scrollTop(100);

        var webSocket = new WebSocket("ws://"+"localhost:8085/music/"+"ws");
        webSocket.onopen = function(event){
            console.log("连接成功");
            console.log(event);
        };
        webSocket.onerror = function(event){
            console.log("连接失败");
            console.log(event);
        };
        webSocket.onclose = function(event){
            console.log("Socket连接断开");
            console.log(event);
        };
        webSocket.onmessage = function(event){
            //接受来自服务器的消息
            $(".chat-thread").append("<li class='left'>"+JSON.parse(event.data).messageText+"</li>");
            scroll_down();
            console.log("来自服务器的数据"+JSON.parse(event.data).messageText);
        }

        $(".send").click(function () {
            var data = {};//新建data对象，并规定属性名与相应的值
            data['fromId'] = $(this).attr("data-id");
            data['fromName'] = $(this).attr("data-name");
            data['toId'] = $(this).attr("data-toid");
            data['messageText'] = $("input[name='msgText']").val();
            $(".chat-thread").append("<li class='right'>"+data['messageText']+"</li>");
            $("input[name='msgText']").val("");//清空发送框的内容
            scroll_down();
            webSocket.send(JSON.stringify(data));//将对象封装成JSON后发送至服务器

        });
    });


    function scroll_down() {
        var height = $('.chat-thread li').innerHeight();
        $('.chat-thread').scrollTop(height*($('.chat-thread li').length+1));
    }

    function getRootPath_web() {
        //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
        var curWwwPath = window.document.location.href;
        //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
        var pathName = window.document.location.pathname;
        var pos = curWwwPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8083
        var localhostPaht = curWwwPath.substring(7, pos);
        //获取带"/"的项目名，如：/uimcardprj
        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        return (localhostPaht + projectName);
    }
</script>

</body>
</html>
