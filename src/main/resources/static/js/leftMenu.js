$(function(){  
	$.ajax({
		url:"/menu/leftMenuData",
		type:"post",
		dataType:"json",
		success:function(data){
			createMenu(data);
		}
	});
})  

function createMenu(menuList) {
	if (menuList == null) {
		return;
	}
	var arr = [];
	$.each(menuList, function(i, menu) {
		arr.push('<li class="treeview">');
		arr.push('<a href="#">');
		arr.push('<i class="fa fa-cog"></i>');
		arr.push('<span>' + menu.menuName + '</span>');
		arr.push('<span class="pull-right-container">' +
				'<i class="fa fa-angle-left pull-right"></i>' +
				'</span> ');
		arr.push('</a>');	
		arr.push('<ul class="treeview-menu">');
		
		$.each(menu.children, function(j, submenu) {
			arr.push('<li><a href="' + submenu.menuUrl + '">');
			arr.push('<i class="fa fa-circle-o"></i>');
			arr.push(submenu.menuName);
			arr.push('</a>');
			arr.push('</li>');
		});
		arr.push('</ul>');
		arr.push('</li>');
	});
	$('#menu_default').after(arr.join(""));
}