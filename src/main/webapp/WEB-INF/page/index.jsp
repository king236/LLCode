<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/page/common.jsp"%>
<title></title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	<%@include file="/WEB-INF/page/header.jsp"%>
	<%@include file="/WEB-INF/page/left-menue.jsp"%>
	<div class="content-wrapper">
		<section class="content-header">
			<h1>
				主 页 <small>后台管理</small>
			</h1>
			<ol class="breadcrumb">
				<li class="active"><a href="<%=request.getContextPath()%>/main"><i
						class="fa fa-home"></i> 主页</a></li>
			</ol>
		</section>
		<section class="content">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Bordered Table</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td>作者</td>
								<td>教程名称</td>
								<td>地址</td>
							</tr>
							<c:forEach var="learn" items="${learnList}">
								<tr class="text-info">
									<td>${learn.author}</td>
									<td>${learn.title}</td>
									<td><a href="${learn.url}" class="btn btn-info"
										target="_blank"><span>点我</span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!-- /.box-body -->
				<div class="box-footer clearfix">
					<ul class="pagination pagination-sm no-margin pull-right">
						<li><a href="#">«</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>
			</div>
		</section>
	</div>
</div>
</body>
</html>