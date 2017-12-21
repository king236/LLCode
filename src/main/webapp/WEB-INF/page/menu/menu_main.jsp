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
				<!--         <div class="panel panel-default">
            <div class="panel-heading">查询条件</div>
            <div class="panel-body">
                <form id="formSearch" class="form-horizontal">
                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-sm-1" for="txt_search_departmentname">部门名称</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_departmentname">
                        </div>
                        <label class="control-label col-sm-1" for="txt_search_statu">状态</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="txt_search_statu">
                        </div>
                        <div class="col-sm-4" style="text-align:left;">
                            <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>       
 -->
				<div id="toolbar" class="btn-group">
					<button id="btn_add" type="button" class="btn btn-primary"
						onclick="addMenu()">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
					</button>
					<button id="btn_edit" type="button" class="btn btn-success">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
					</button>
					<button id="btn_delete" type="button" class="btn btn-info">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
					</button>
				</div>
				<table id="tb_departments"></table>

				<!-- /.box-body -->
				<div id="menumodal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="menumodal-title">新增用户</h4>
							</div>
							<div class="modal-body">
								<form id='menuform' role="form">
									<input type="hidden" id="menuId" name="id" />
									<div class="row">
										<div class="col-md-12">
											<div class="form-group">
												<label>菜单名：</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-book"></i>
													</div>
													<input type="text" class="required form-control"
														name="menuName" placeholder="输入菜单名称" tabIndex="1" />
												</div>
											</div>
											<div class="form-group">
												<label>菜单URL：</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-list"></i>
													</div>
													<input type="text" class="required form-control"
														name="menuUrl" placeholder="输入菜单URL" tabIndex="2">
												</div>
											</div>
											<div class="form-group">
												<label>父节点URL：</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-align-left"></i>
													</div>
													<input type="text" class="required form-control"
														name="parentMenuUrl" placeholder="父节点URL" tabIndex="3">
												</div>
											</div>
											<div class="form-group">
												<label>用户状态：</label>
												<div class="radio">
													<label> <input type="radio" id="statusRadio1"
														value="1" name="status" tabIndex="4" checked> 启用
													</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio"
														id="statusRadio0" value="0" name="status" tabIndex="5">
														禁用
													</label>
												</div>
											</div>


											<div class="form-group">
												<label>备注：</label>
												<div class="input-group">
													<div class="input-group-addon">
														<i class="fa fa-comment"></i>
													</div>
													<input type="text" class="form-control" name="comment"
														placeholder="输入备注信息" tabIndex="6">
												</div>
											</div>
										</div>
									</div>
									<!-- /.row -->
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" id='menusave' class="btn btn-primary"
									onclick="submitCheck()" tabIndex="7">保存</button>
								<button type="button" class="btn btn-primary"
									data-dismiss="modal" tabIndex="8">关闭</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
			</div>
			<!-- /.box -->


		</div>
		<!-- end panel-body -->
	<%@include file="/WEB-INF/page/footer.jsp"%>
</div>

<script src="${pageContext.request.contextPath}/bootstrap-table/dist/bootstrap-table-extends-tree.js" ></script>
<script src="${pageContext.request.contextPath}/bootstrap-switch/js/bootstrap-switch.js" ></script>
<script src="${pageContext.request.contextPath}/js/menu.js" ></script>
<script src="${pageContext.request.contextPath}/js/validate.js" ></script>
<script type="text/javascript">
</script>
</body>
</html>