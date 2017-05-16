<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<header class="main-header">
    <!-- Logo -->
    <a href="<%=request.getContextPath() %>" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b></b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>音乐网站后台管理</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->

    <nav class="navbar navbar-static-top">
    <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">收缩菜单</span>
        </a>
        <div class="navbar-custom-menu">
            <a class="user-name" contenteditable="false">
                <img src="<%=request.getContextPath() %>/assets/images/300.jpg" class="user-image" alt="用户头像">
                <span>${currentAdmin.name}</span>
            </a>
            <a href="<%=request.getContextPath() %>/sign/out" class="user-name">
                <i class="fa fa-sign-out"></i>
                <span>退出登录</span>
            </a>
        </div>
    </nav>
</header>