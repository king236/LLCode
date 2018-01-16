<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@include file="/WEB-INF/page/common.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-switch/css/bootstrap-switch.css" />
</head>
<body>
<body class="hold-transition skin-blue-light sidebar-mini">
<div class="wrapper">
	<%@include file="/WEB-INF/page/header.jsp"%>
	<%@include file="/WEB-INF/page/left-menue.jsp"%>
	
	<div class="content-wrapper">
			<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				用户管理 <small>系统用户列表</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${requestContext.contextPath}/admin/index.html"><i class="fa fa-home"></i> 首页</a></li>
				<li>系统设置</li>
				<li class="active">用户管理</li>
			</ol>
		</section>

			<div class="panel-body" style="padding-bottom: 0px;">
				<div class="ibox-content">
				<div class="form-group">
					<button id="btnAdd" type="button" class="btn btn-primary "
						onclick="addModel()">
						<i class="fa fa-plus"></i>&nbsp;添加
					</button>
					<button id="btnEdit" type="button" class="btn btn-info "
						onclick="editModel()">
						<i class="fa fa-pencil"></i> 编辑
					</button>
					<button id="btnDel" type="button" class="btn btn-danger "
						onclick="delData()">
						<i class="fa fa-remove"></i>&nbsp;&nbsp;<span class="bold">删除</span>
					</button>
				</div>

				<div class="form-group">
					<div class="input-group">
						<input id="txtSearchKey" type="text" class="input form-control"
							placeholder="搜索关键字" /> <span class="input-group-btn">
							<button id="btnSearch" class="btn btn btn-primary" type="button">
								<i class="fa fa-search"></i> 搜索
							</button>
						</span>
					</div>
				</div>

				<div class="jqGrid_wrapper">
					<table id="table_list"></table>
					<div id="pager_list"></div>
				</div>
			</div>
			</div>
			<!-- /.box -->


		</div>
		<!-- end panel-body -->
	<%@include file="/WEB-INF/page/footer.jsp"%>
</div>
<%-- <script src="${pageContext.request.contextPath}/js/content/base.js"></script> --%>
<script src="${pageContext.request.contextPath}/js/content/list.js"></script>

<script>
		function addModel() {
			$("#btnAdd").button("loading");
			window.location.href = "/user/editPage/add";
		}

		function editModel() {//编辑
			var row = JucheapGrid.GetData();
			if (row != null) {
				$("#btnEdit").button("loading");
				window.location.href = "/user/getUserInfo/" + row.id;
			} else {
				parent.layer.alert("请选择要编辑的数据");
			}
		}

		function delData() {//删除
			XPage.DelData("/user/delete");
		}

		function searchData() {//搜索
			var json = {
				keywords : $("#txtSearchKey").val()
			};
			XPage.Search(json);
		}
		$(document).ready(function() {
			var config = {
				title : '用户列表',
				url : '/user/getUserList',
				colNames : [ '主键', '用户名称', '邮箱', '创建时间', '是否有效'],
				colModel : [ {
					name : 'id',
					index : 'id',
					width : 100,
					key : true,
					hidden : true
				}, {
					name : 'nickname',
					index : 'nickname',
					width : 100,
				}, {
					name : 'email',
					index : 'email',
					width : 100,
				}, {
					name : 'createTime',
					index : 'createTime',
					formatter : formatDate,
					width : 100,
				}, {
					name : 'status',
					index : 'status',
					formatter : formatStatus,
					width : 100,
				} ]
			};
			JucheapGrid.Load(config);
			//$("#btnSearch").bind("click", searchData);
		});
		
		if('${edit}'=='false'){
			parent.layer.msg('保存失败，请重试！', { icon: 5, anim:6 ,offset: 't'});  
		}
		if('${edit}'=='true'){
			parent.layer.msg('保存成功！', { icon: 6, anim:6 ,offset: 't'});  
		}
	</script>
</body>
</html>