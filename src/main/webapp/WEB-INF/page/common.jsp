<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- main JS libs -->
<!--  modernizr.min.js -->
<!-- Modernizr帮助我们检测浏览器是否实现了某个feature，如果实现了那么开发人员就可以充分利用这个feature做一些工作，
反之没有实现开发人员也好提供一个fallback。
所以，我们要明白的是Modernizr只是帮我们检测feature是否被支持，它并不能够给浏览器添加那些本来不支持的feature。 -->
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.2.1.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script> --%>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/adminLTE/js/adminlte.min.js"></script>

<!-- Style CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" />
<!-- Theme style -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminLTE/css/AdminLTE.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminLTE/css/AdminLTE.min.css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminLTE/css/skins/_all-skins.min.css" />
<!-- AdminLTE little style like left menue '>' -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminLTE/css/font-awesome/css/font-awesome.css"" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminLTE/css/font-awesome/css/font-awesome.min.css"" />
<!-- Ionicons -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/adminLTE/css/Ionicons/css/ionicons.min.css">

<!-- easy-ui -->
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js?t=2017.5.17"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js?t=20161011.01"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.json.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/layer/layer.js?r=2017.06.20"></script>

<link href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css?t=20161011.01" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/easyui/themes/icon.css?t=20161201.01" rel="stylesheet" type="text/css" />
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
