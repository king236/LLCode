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
<%--左侧导航栏--%>
    <aside class="main-sidebar">
        <section class="sidebar">
            <div class="user-panel">
                <div class="pull-left image">
                    <img class="img-circle" src="${pageContext.request.contextPath}/adminLTE/img/user2-160x160.jpg"
                         alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>HELLO<%-- <%=administratorName%> --%>
                    </p>
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>
            <%--搜索表单--%>
            <form class="sidebar-form" action="#" method="get">
                <div class="input-group">
                    <input class="form-control" name="txtSearch" type="text" title="请输入搜索内容">
                    <span class="input-group-btn">
                        <button class="btn btn-flat" id="btnSearch" name="btnSearch" type="submit"><i
                                class="fa fa-search"></i></button>
                    </span>
                </div>
            </form>
            <ul class="sidebar-menu">
                <%--主页--%>
                <li class="active">
                    <a href="<%=request.getContextPath()%>/main">
                        <i class="fa fa-home" style="font-size: larger"></i>
                        <span>主页</span>
                    </a>
                </li>
            </ul>
        </section>
    </aside>
</body>
</html>