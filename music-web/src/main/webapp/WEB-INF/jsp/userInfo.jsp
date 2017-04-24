
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="common/css.jsp" %>
    <style>
        .navbar-headimg img{
            width:50px;
            height:50px;
            margin-left: 20px
        }
        .navbar-headimg .dropdown-menu{
            text-align:  center;
            width: 40px;
        }

        .myInfo{
            margin-top: 100px;
        }
        .myInfo .row{
            margin-bottom: 20px;
        }
        .myInfo .col-md-12{
            text-align: center;
        }
        .myInfo .uploadBtn{
            position: relative;
            transform: translate(-50%, -50%);
             top: -50px;
            left: 45%;
            filter: alpha(opacity=0);
            opacity: 0;
            cursor:pointer;
        }
        label{
            position: relative;
            left: 20%;
        }
        .myInfo .form-control{
            width: 60%;
            position: relative;
            left: 20%;
        }
        .myInfo img{
            width: 100px;
            height:100px;
        }
        .myInfo .save{
            width: 20%;
            position: relative;
            left: 40%;
        }
        .myInfo .save:hover{
            background-color: #31c27c;
            color: black;
            border: none;
        }
    </style>
</head>
<body>

<%@ include file="common/navbar.jsp" %>

<%--我的个人信息--%>
<div class="container myInfo">
    <div class="row">
        <div class="col-md-12">
            <img src="<%=request.getContextPath()%>${user.headImg}" alt="" class="img-circle">
            <input type="file" class="uploadBtn" id="fileupload" name="filedata" accept="image/*">
            <span>点击修改头像</span>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>用户名</label>
                <input type="text" class="username form-control" value="${user.username}" readonly>
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>密码</label>
                <input type="text" class="password form-control" value="${user.password}" >
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>年龄</label>
                <input type="text" class="age form-control" value="${user.age}" >
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <label>性别</label>
                <input type="text" class="sex form-control" value="${user.sex}" >
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>email</label>
                <input type="text" class="email form-control" value="${user.email}" >
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <input type="hidden" class="id form-control" value="${user.id}" >
            </div>
        </div>
        <div class="col-md-6">
            <div class="form-group">
                <input type="hidden" class="headImg form-control" value="${user.headImg}" >
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="form-group">
                <input type="button" value="保存" class="form-control save">
            </div>
        </div>
    </div>
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


    /*进行用户信息修改*/
    $(".save").click(function () {
        var id = $(".id").val();
        var username = $(".username").val();
        var password = $(".password").val();
        var age = $(".age").val();
        var sex = $(".sex").val();
        var email = $(".email").val();
        var headImg = $(".headImg").val();

        $.post("<%=request.getContextPath()%>/user/editInfo",
                {id:id,username:username,password:password,age:age,sex:sex,email:email,headImg:headImg},
                function (data) {
                    if(data.code == "200"){
                        alert("用户信息修改成功");
                        window.location.href="<%=request.getContextPath()%>/index/signOut";
                    }else if(data.code == "201"){
                        alert("用户信息修改失败");
                }
        },"json");


    });


    /*文件上传*/
    $('#fileupload').fileupload({
        url: '<%=request.getContextPath()%>/user/uploadImg',
        dataType: 'json',
        type: 'post',
        done: function(e, data) {
            $('#fileupload').next('span').html(data.files[0].name);
            $('#fileupload').prev('img').css('z-index', '100');
            $('#fileupload').next('span').html('上传成功');
            window.location.reload();
        },
        progressall: function(e, data) {
            $('#fileupload').next('span').html('上传中…');
        },
    });
</script>
</body>
</html>
