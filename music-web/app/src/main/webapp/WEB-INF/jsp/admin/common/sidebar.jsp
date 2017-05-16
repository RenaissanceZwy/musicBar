<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<ul class="sidebar-menu">
				<li class="treeview <c:if test="${page_type==100}">active</c:if>">
					<a href="<%=request.getContextPath()%>/admin/user">
						<i class="fa fa-users"></i>
						<span>用户管理</span>
						<span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
				</li>

				<li class="treeview <c:if test="${page_type==200}">active</c:if>">
					<a href="<%=request.getContextPath()%>/admin/comment">
						<i class="fa fa-home"></i>
						<span>评论管理</span>
						<span class="pull-right-container">
						</span>
					</a>
				</li>

				<li class="treeview <c:if test="${page_type==300}">active</c:if>">
					<a href="<%=request.getContextPath()%>/admin/post">
						<i class="fa fa-sitemap"></i>
						<span>帖子管理</span>
							<span class="pull-right-container">
						</span>
					</a>
				</li>

				<li class="treeview <c:if test="${page_type==400}">active</c:if>">
					<a href="<%=request.getContextPath()%>/admin/music">
						<i class="fa fa-graduation-cap"></i>
						<span>音乐管理</span>
							<span class="pull-right-container">
						</span>
					</a>

				</li>

			<li class="treeview <c:if test="${page_type==500}">active</c:if>">
				<a href="<%=request.getContextPath()%>/admin/album">
					<i class="fa fa-video-camera"></i>
					<span>专辑管理</span>
					<span class="pull-right-container">
					</span>
				</a>
			</li>

			<li class="treeview <c:if test="${page_type==600}">active</c:if>">
				<a href="<%=request.getContextPath()%>/admin/label">
					<i class="fa fa-video-camera"></i>
					<span>标签管理</span>
					<span class="pull-right-container">
					</span>
				</a>
			</li>

		</ul>
	</section>
	<input type="hidden" name="admin_powers" value="${powers}">
	<!-- /.sidebar -->
</aside>