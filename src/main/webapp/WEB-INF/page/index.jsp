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
<body class="hold-transition skin-blue-light sidebar-mini">
<div class="wrapper">
	<%@include file="/WEB-INF/page/header.jsp"%>
	<%@include file="/WEB-INF/page/left-menue.jsp"%>
	<div class="content-wrapper">
		<section class="content-header">
			<h1>后台首页 <small>系统后台管理首页</small>
			</h1>
			<ol class="breadcrumb">
				<li class="active"><a href="<%=request.getContextPath()%>/admin/index"><i
						class="fa fa-home"></i> 主页</a></li>
			</ol>
		</section>
		<section class="content">
			
		</section>
	</div>
	<%@include file="/WEB-INF/page/footer.jsp"%>
</div>
</body>
</html>