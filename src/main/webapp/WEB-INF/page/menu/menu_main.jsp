<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%@include file="/WEB-INF/page/common.jsp"%>
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

			<!-- Main content -->
			<section class="content">
				<!-- Your Page Content Here -->
				<div class="row">
					<div class="col-xs-12">
						<div id="content-box" class="box">
							<div class="box-header">
								<h3 class="box-title">
									<button class="btn btn-primary" onclick="addUser()">新增</button>
								</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="row">
									<div class="col-sm-12">
										<table id="usertable" class="table table-bordered table-striped">
											<thead>
												<tr>
													<th style="width: 4%; min-width: 60px">用户名</th>
													<th style="width: 8%; min-width: 80px">手机</th>
													<th class="hidden-xs hidden-sm" style="width: 8%">座机</th>
													<th class="hidden-xs" style="width: 10%">E-mail</th>
													<th class="hidden-xs" style="width: 8%">QQ</th>
													<th style="width: 6%; min-width: 80px">用户状态</th>
													<th style="width: 8%; min-width: 80px">所属分组</th>
													<th class="hidden-xs hidden-sm" style="width: 16%">备注</th>
													<th class="hidden-md hidden-xs hidden-sm" style="width: 15%">上次登陆时间</th>
													<th style="width: 8%; min-width: 80px">操作</th>
												</tr>
											</thead>
											<tbody id="usertable-tbody">
											</tbody>
										</table>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-5">
										<div style="padding-top: 8px; white-space: nowrap;">
											<span>每页条数： </span><select id="usertable-size">
												<option value="10">10</option>
												<option value="15">15</option>
												<option value="20">20</option>
											</select>&nbsp;&nbsp;&nbsp;&nbsp;<span id="usertable-info">显示 1 到 10, 共 12 条数据</span>
										</div>
									</div>
									<div class="col-sm-7">
										<nav>
											<ul id="usertable-page" class="pagination pull-right" style="margin: 2px 0px; white-space: nowrap;">
												<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												</a></li>
												<li><a href="#">1</a></li>
												<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</ul>
										</nav>
									</div>
								</div>
							</div>
							<!-- /.box-body -->
							<div id="usermodal" class="modal fade">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="usermodal-title">新增用户</h4>
										</div>
										<div class="modal-body">
											<form id='userform' role="form">
												<input type="hidden" id="userid" name="id" />
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label>用户名：</label>
															<div class="input-group">
																<div class="input-group-addon">
																	<i class="fa fa-user"></i>
																</div>
																<input type="text" class="required form-control" name="username" placeholder="输入用户名" tabIndex="1" />
															</div>
														</div>
														<div class="form-group">
															<label>密码：</label>
															<div class="input-group">
																<div class="input-group-addon">
																	<i class="fa fa-lock"></i>
																</div>
																<input type="password" class="form-control" name="password" placeholder="输入密码" tabIndex="2">
															</div>
														</div>
														<div class="form-group">
															<label>确认密码：</label>
															<div class="input-group">
																<div class="input-group-addon">
																	<i class="fa fa-lock"></i>
																</div>
																<input type="password" class="form-control" name="password2" placeholder="再次输入密码" tabIndex="3">
															</div>
														</div>
														<div class="form-group">
															<label>用户分组：</label>
															<div class="input-group">
																<select class="form-control" name="groupName"><option value="未分组">未分组</option> <#list
																	groupNameList as groupName>
																	<option value="${groupName}">${groupName}</option> </#list>
																</select>
															</div>
														</div>
														<div class="form-group">
															<label>用户状态：</label>
															<div class="radio">
																<label> <input type="radio" id="statusRadio1" value="1" name="status" tabIndex="5"> 启用
																</label> &nbsp;&nbsp;&nbsp; <label> <input type="radio" id="statusRadio0" value="0" name="status"
																	tabIndex="6" checked> 禁用
																</label>
															</div>
														</div>
													</div>
													<!-- /.col-lg-6 -->
													<div class="col-md-6">
														<div class="form-group">
															<label>手机：</label>
															<div class="input-group">
																<div class="input-group-addon">
																	<i class="fa fa-mobile"></i>
																</div>
																<input type="tel" class="form-control" name="cellPhone" placeholder="输入手机号" tabIndex="7" />
															</div>
														</div>
														<div class="form-group">
															<label>座机：</label>
															<div class="input-group">
																<div class="input-group-addon">
																	<i class="fa fa-phone"></i>
																</div>
																<input type="tel" class="form-control" name="telephone" placeholder="输入座机号" tabIndex="8" />
															</div>
														</div>
														<div class="form-group">
															<label>E-Mail：</label>
															<div class="input-group">
																<div class="input-group-addon">
																	<i class="fa fa-envelope"></i>
																</div>
																<input type="email" class="form-control" name="email" placeholder="输入E-Mail地址" tabIndex="9">
															</div>
														</div>
														<div class="form-group">
															<label>QQ：</label>
															<div class="input-group">
																<div class="input-group-addon">
																	<i class="fa fa-qq"></i>
																</div>
																<input type="tel" class="form-control" name="qqNumber" placeholder="输入QQ号" tabIndex="10">
															</div>
														</div>
														<div class="form-group">
															<label>微信：
																<input type="text" id="searchWXFilter"  oninput="searchMyFilter()"  placeholder="输入微信号过滤列表" style="border:1px solid white;width:218px" />
															</label>
															<div class="input-group">
																<div class="input-group-addon">
																	<i class="fa fa-weixin"></i>
																</div>
																<!-- <input type="text" class="form-control" name="wechat" placeholder="输入微信号" tabIndex="11"> -->
																<select class="form-control" name="wechat"  id="wechat" style="z-index:9999">
								
																</select>
															</div>
														</div>
													</div>
													<!-- /.col-lg-6 -->
													<div class="col-md-12">
														<div class="form-group">
															<label>备注：</label>
															<div class="input-group">
																<div class="input-group-addon">
																	<i class="fa fa-comment"></i>
																</div>
																<input type="text" class="form-control" name="comment" placeholder="输入备注信息" tabIndex="12">
															</div>
														</div>
													</div>
												</div>
												<!-- /.row -->
											</form>
										</div>
										<div class="modal-footer">
											<button type="button" id='usersave' class="btn btn-primary" onclick="submitCheck()" tabIndex="13">保存</button>
											<button type="button" class="btn btn-primary" data-dismiss="modal" tabIndex="14">关闭</button>
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
				</div>
			</section>
			<!-- /.content -->
		</div>
		
	<%@include file="/WEB-INF/page/footer.jsp"%>
</div>


<script type="text/javascript">
function addUser() {
	resetForm();
	$("#usermodal").modal('show');
	$("#usermodal-title").text("新增用户");
	$("input[name=password]").attr("placeholder", "输入密码");
	$("input[name=password2]").attr("placeholder", "再次输入密码确认");
	$("#usersave").attr('onclick', 'addUserCheck()');
}

function resetForm() {
	$("input[name=id]").val("");
	$("input[name=username]").val("");
	$("input[name=username]").attr("disabled", null);
	$("input[name=password]").val("");
	$("input[name=password2]").val("");
	$("select[name=groupName]").val("未分组");
	$("#statusRadio1").prop("checked", true);
	$("input[name=cellPhone]").val("");
	$("input[name=telephone]").val("");
	$("input[name=email]").val("");
	$("input[name=qqNumber]").val("");
	$("input[name=wechat]").val("");
	$("input[name=comment]").val("");
	$("#searchWXFilter").val("");
	
	/* if ("flowerList" in userData) {
		var selectStr = '<option value="" >暂不绑定微信号</option>';
		flowerList = userData.flowerList;
		if (flowerList!=null && flowerList.length>0) {
			for (var i=0; i<flowerList.length; i++) {
				var myphone = "暂无手机号";
				if (!isNull(flowerList[i].phone)) {
					myphone = flowerList[i].phone;
				}
				selectStr += "<option value='"+flowerList[i].openId+"' title='国家："+flowerList[i].country+"&#10;省份："+flowerList[i].province+"&#10;城市："+flowerList[i].city+"&#10;手机号："+myphone+"'>";
				selectStr += flowerList[i].nickName+"</option>";
			}
		}
		$("#wechat").html(selectStr);
	} */
}
</script>
</body>
</html>