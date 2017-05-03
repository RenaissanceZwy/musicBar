/**
 * Created by Administrator on 2016/11/17.
 */
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