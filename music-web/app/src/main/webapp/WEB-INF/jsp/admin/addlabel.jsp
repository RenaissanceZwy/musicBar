<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="./common/meta.jsp"%>
	<title>音乐网站后台管理系统</title>
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
				<h1>标签管理</h1>
				<ol class="breadcrumb">
					<li class="active">标签管理</li>
				</ol>
			</section>
			<section class="content">
				<form action="" id="form-admin">
					<div class="box box-primary">
						<div class="box-header">
							<h1 class="box-title">新建标签</h1>
						</div>
						<div class="box-body">
							<div class="row">
								<div class="col-xs-4 col-xs-offset-1">
									<div class="form-group">
										<label>标签名</label>
										<input type="text" class="form-control" name="name"
											   placeholder="标签名" autocomplete="off"
										>
									</div>
								</div>
								<div class="col-xs-4 col-xs-offset-1">
									<div class="form-group">
										<label>描述</label>
										<input type="text" class="form-control" name="describes"
											   placeholder="标签描述" autocomplete="off"
										>
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
												href="<%=request.getContextPath()%>/admin/label?monitorPageNum=0&pageSize=15">
											<button type="button" class="btn btn-default">返回</button>
										</a>&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="button" class="btn btn-primary btn-save">保存</button>
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
		$(".btn-save").click(function () {
			var name = $("input[name='name']").val();
			var describes = $("input[name='describes']").val();

				$.post("<%=request.getContextPath()%>/label/add",{name:name,describes:describes},function (data) {
					if(data.code == "200"){
						music.modal.alert("新增成功",window.location.href="<%=request.getContextPath()%>/admin/label");
					}else if(data.code == "201"){
						music.modal.alert("新增失败");
					}
				},"json");

		});


	</script>
</body>
</html>

