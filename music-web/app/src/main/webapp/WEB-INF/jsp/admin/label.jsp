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
				<h1>标签管理</h1>
				<ol class="breadcrumb">
					<li class="active">标签管理</li>
				</ol>
			</section>
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<form
										action="<%=request.getContextPath()%>/admin/label?monitorPageNum=0&pageSize=15"
										class="form-inline bottom-10" method="post" style="float: left">
									<input type="text" class="form-control" placeholder="请输入标签名"
										   value="${name}" name="name" maxlength="15">
									<input id="find" value="查找" type="submit" class="btn btn-primary" />
								</form>
								<div class="pull-right">
									<a href="<%=request.getContextPath()%>/admin/label/add" class="btn btn-success">
										新建标签</a>
								</div>
							</div>
							<div class="box-body">
								<table id="example1"
									   class="table table-hover table-striped table-bordered">
									<thead>
									<tr>
										<th>标签名</th>
										<th>标签描述</th>
										<th>标签类型</th>
										<th>操作</th>
									</tr>
									</thead>
									<tbody>
									<c:forEach items="${paging.object}" var="label">
										<tr>
											<td>${label.name}</td>
											<td>${label.describes}</td>
											<td>${label.type}</td>
											<td>
													<%--<a href="<%=request.getContextPath()%>/admin/show/addGroup?edit=1&id=${group.gid}">编辑</a>--%>
												<a href="#" class="btn-delete" data-id="${label.id}">删除</a>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="box-footer">
								<c:if test="${paging.totalRecord!=0}">
									<ul class="pagination">
										<li><a
												<c:if test="${paging.currentPage!=1 }"> href="<%=request.getContextPath()%>/admin/group?name=${name}&monitorPageNum=0&pageSize=15"</c:if>>首页</a>
										</li>
										<li><a
												<c:if test="${paging.currentPage!=1 }"> href="<%=request.getContextPath()%>/admin/group?name=${name}&monitorPageNum=${paging.prePage}&pageSize=15"</c:if>>
											<span aria-hidden="true">&laquo;</span>
										</a></li>
										<c:forEach begin="${paging.pageNumStart }"
												   end="${paging.pageNumEnd }" var="pageIndex">
											<c:if test="${paging.currentPage==pageIndex }">
												<li class="active"><a href="javascript:;">${pageIndex}</a></li>
											</c:if>
											<c:if test="${paging.currentPage!=pageIndex }">
												<li><a
														href="<%=request.getContextPath()%>/admin/group?name=${name}&monitorPageNum=${pageIndex}&pageSize=15">${pageIndex}</a></li>
											</c:if>
										</c:forEach>
										<li><a
												<c:if test="${paging.currentPage!=paging.totalPage }"> href="<%=request.getContextPath()%>/admin/group?name=${name}&monitorPageNum=${paging.nextPage}&pageSize=15"</c:if>>&raquo;</a>
										</li>
										<li><a
												<c:if test="${paging.currentPage!=paging.totalPage }"> href="<%=request.getContextPath()%>/admin/group?name=${name}&monitorPageNum=${paging.totalPage}&pageSize=15"</c:if>>尾页</a>
										</li>
									</ul>
								</c:if>
								<c:if test="${paging.totalRecord==0}">
									<div class="empty-table text-center" style="margin: 20px 0">
										<img src="<%=request.getContextPath()%>/assets/images/empty.jpg"
											 height="30" width="30"> <span>记录为空</span>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</section>
			</div>
		<!-- /.c页脚 -->
		<%@ include file="./common/footer.jsp"%>
	</div>
	<!-- ./wrapper -->
	<%@ include file="./common/script.jsp"%>
	<script>
		$(".btn-delete").click(function () {
			var id = $(this).attr("data-id");
			music.modal.confirm("确定要删除此标签",function () {
				$.post("<%=request.getContextPath()%>/admin/del",{id:id,type:6},function (data) {
					if(data.code == "200"){
						music.modal.alert("删除成功",window.location.reload());
					}else if(data.code == "201"){
						music.modal.alert("删除失败");
					}
				},"json");
			});
		});


	</script>
</body>
</html>

