<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<aside class="main-sidebar">
	<section class="sidebar">
		<!-- Sidebar Menu -->
		<ul class="sidebar-menu" data-widget="tree">
			<li id="main-index">
				<a href="${requestContext.contextPath}/admin/index">
					<i class='fa fa-home'></i> <span>首页</span>
				</a>
			</li>
			<li class="treeview"><a href="#"><i class="fa fa-cog"></i>
					<span>系统设置</span> <span class="pull-right-container">
						<i class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="${requestContext.contextPath}/menu/"><i class="fa fa-circle-o"></i>菜单</a></li>
					<li><a href="#"><i class="fa fa-circle-o"></i>Link in level 2</a></li>
				</ul>
			</li>
		</ul>
	</section>
</aside>
