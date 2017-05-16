<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/meta.jsp"%>
	<title>管理员管理 - 仁美大学堂网站后台管理系统</title>
	<%@ include file="./common/css.jsp"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<%@ include file="./common/top.jsp"%>
		<!-- 左边导航栏 -->
		<%@ include file="./common/sidebar.jsp"%>
		<!-- C主要内容 -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>管理员管理</h1>
				<ol class="breadcrumb">
					<li><a href="<%=request.getContextPath()%>/"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=request.getContextPath()%>/admin/group?monitorPageNum=0&pageSize=15">用户管理</a></li>
					<li class="active">管理员管理</li>
				</ol>
			</section>
			<section class="content">
				<form action="" id="form-admin">
						<div class="box box-primary">
								<div class="box-header">
									<h1 class="box-title">编辑管理员</h1>
								</div>
								<div class="box-body">
									<div class="row">
										<div class="col-xs-4 col-xs-offset-1">
											<div class="form-group">
												<label>姓名</label>
												<input type="text" class="form-control" name="name"
													placeholder="用户的真实姓名，保存后不可更改" autocomplete="off" value="${administratorVo.name}"
													<c:if test="${edit==1}">disabled</c:if>>
											</div>
											<div class="form-group">
												<label>密码</label> <input type="password" name="password"
													class="form-control" placeholder="输入密码" autocomplete="off" 
													value="${administratorVo.password}">
											</div>
											<input type="hidden" value="${administratorVo.id}" class="aid">
										</div>
										<div class="col-xs-4 col-xs-offset-1">
											<div class="form-group">
												<label>角色</label> <select
													class="form-control gid">
													<c:forEach items="${adminGroups}" var="group">
														<option value="${group.id}"
															<c:if test="${administratorVo.groupId==group.id}">selected</c:if>>${group.name}</option>
													</c:forEach>
												</select>
											</div>
											<%--<div class="form-group">
												<label>密码</label> <input type="password" class="form-control"
													placeholder="确认密码">
											</div>--%>
										</div>
									</div>
								<div class="row" style="margin-top: 30px">
									<div class="col-xs-2 col-xs-offset-9">
										<div class="pull-right">
											<a
												href="<%=request.getContextPath()%>/admin/administrator?monitorPageNum=0&pageSize=15">
												<button type="button" class="btn btn-default">返回</button>
											</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<button type="submit" class="btn btn-primary btn-save">保存</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form>
				</section>
			</div>
		<!-- /.c页脚 -->
		<%@ include file="./common/footer.jsp"%>
	</div>
	<!-- ./wrapper -->
	<%@ include file="./common/script.jsp"%>
	<script>


	</script>
</body>
</html>

