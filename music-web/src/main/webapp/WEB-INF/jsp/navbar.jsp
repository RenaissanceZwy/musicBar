
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <ul class="nav navbar-nav choose">
                <li class="active"><a href="<%=request.getContextPath()%>/index/index">音乐库</a></li>
                <li><a href="<%=request.getContextPath()%>/music/myMusic">我的音乐</a></li>
            </ul>
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

