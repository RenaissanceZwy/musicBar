<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String socketPath = request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Title</title>
    <%@ include file="include.jsp" %>
</head>
<body>

<input name="socketPath" value="${socketPath}">
<input type="button" value="发送" class="send">

<script>
    $(document).ready(function () {
        var socketPath =getRootPath_web();

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
            console.log("来自服务器的数据"+JSON.parse(event.data));
        }

        $(".send").click(function () {
            var data = {};//新建data对象，并规定属性名与相应的值
            data['fromId'] = '1';
            data['fromName'] = '赵文奕';
            data['toId'] = '1';
            data['messageText'] = '这是一条测试信息';
            webSocket.send(JSON.stringify(data));//将对象封装成JSON后发送至服务器

        });
    });



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
