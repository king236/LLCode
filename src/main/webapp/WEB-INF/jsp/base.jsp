<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- main JS libs -->
<!--  modernizr.min.js -->
<!-- Modernizr帮助我们检测浏览器是否实现了某个feature，如果实现了那么开发人员就可以充分利用这个feature做一些工作，
反之没有实现开发人员也好提供一个fallback。
所以，我们要明白的是Modernizr只是帮我们检测feature是否被支持，它并不能够给浏览器添加那些本来不支持的feature。 -->
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<!-- Style CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />