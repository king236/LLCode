<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%--顶部导航条--%>
    <header class="main-header">
        <a class="logo" href="#">
            <span class="logo-mini"><b>系统</b></span>
            <span class="logo-lg"><b>后台管理系统</b></span>
        </a>

        <nav class="navbar navbar-static-top" role="navigation">
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <img class="user-image" src="${pageContext.request.contextPath}/adminLTE/img/user2-160x160.jpg"
                                 alt="User Image">
                            <span class="hidden-xs">${sessionScope['userInfo'].nickname}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-header" style="color: white">
                                <img class="img-circle" src="${pageContext.request.contextPath}/adminLTE/img/user2-160x160.jpg"
                                     alt="User Image">
                                <p style="color: white">
                                   ${sessionScope['userInfo'].nickname}
                                </p>
                                <small>权限等级</small>
                                123<%-- <%=privilegeLevel%> --%>
                            </li>
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <%--消息图标--%>
                                        <ul class="nav navbar-nav">
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-envelope-o"></i>
                                                    <span class="label label-success">4</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="col-xs-4">
                                        <%--通知图标--%>
                                        <ul class="nav navbar-nav">
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-bell-o"></i>
                                                    <span class="label label-warning">10</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="col-xs-4">
                                        <%--任务图标--%>
                                        <ul class="nav navbar-nav">
                                            <li>
                                                <a href="#">
                                                    <i class="fa fa-flag-o"></i>
                                                    <span class="label label-danger">9</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <%--设置界面--%>
                                    <a class="btn btn-default btn-flat" href="#">设 置</a>
                                </div>
                                <div class="pull-right">
                                    <%--退出登录按钮--%>
                                    <a class="btn btn-default btn-flat" href="<%=request.getContextPath()%>/signIn">退
                                        出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
