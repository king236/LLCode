$(function(){  
    $('#mySwitch input').bootstrapSwitch();  
})  

$('#tb_departments').bootstrapTable({
   /* data : [{Id: 1, Name: "系统设置", Url: null, ParentId: null,  CreateTime: null, Status: 1, SortOrder: 1},
            {Id: 2, Name: "菜单管理", Url: "/Systems/Menu/Index", ParentId: 1,  CreateTime: null, Status: 1},
            {Id: 3, Name: "订单管理", Url: null, ParentId: null,  CreateTime: "2017-05-31 17:05:27"},
            {Id: 4, Name: "基础数据", Url: null, ParentId: null,  CreateTime: "2017-05-31 17:05:55"},
            {Id: 5, Name: "新增订单", Url: "/order/add", ParentId: 3,  CreateTime: "2017-05-31 17:07:03"}],*/
	url: '/menu/getMenu',
    toolbar: '#toolbar',
    sidePagination: 'client',
    pagination: false,
    treeView: true,
    treeId: "id",
    treeField: "menuName",
   // treeRootLevel: 1,
    striped: true,
    clickToSelect: true,
    singleSelect: true,
    //collapseIcon: "glyphicon glyphicon-triangle-right",//折叠样式
    //expandIcon: "glyphicon glyphicon-triangle-bottom"//展开样式
    columns: [{
    			checkbox: true
    		}, /*{
            	field: 'Id',
                title: '#',
                width: '5%'
            }, */{
                field: 'menuName',
                title: '菜单名称',
                width: '25%'
            }, {
                field: 'menuUrl',
                title: '菜单URL',
                width: '35%'
            }/*, {
                field: 'Level',
                title: '部门级别',
              //  width: '80px'
            }*/, {
            	field: 'status',
                title: '状态',
                formatter: function(v,r,i){
                	var str = '';
                	if(v == '1'){
                		str = '<div class="switch"  id="mySwitch" >  ' + 
								'<input type="checkbox" checked  data-on-color="success" data-off-color="warning" data-on-text="启用" data-off-text="禁用"/>  '+
								'</div>  ';
                	}else if(v == '0'){
                		str = '<div class="switch"  id="mySwitch" >  ' + 
								'<input type="checkbox" data-on-color="success" data-off-color="warning" data-on-text="启用" data-off-text="禁用"/>  '+
								'</div>  ';
                	}               
                	return str;
                }
            }, {
            	field:"shortcutOperation",
            	title:"快捷操作",
            	align: "center",
            	formatter: function(v,r,i){
            	var str = "<div class='btn-group'>"+
            	    "<button id="+r.modelId+" class='btn btn-success btn-xs' onclick='applyReason(\""+r.modelId+"\")'>申请权限</button>"+
            	    "</div>"
            	if(r.status=='00'){
            	  var str = "<div class='btn-group'>"+
            	     "<button class='btn btn-success btn-xs' style='background:#ccc;border-color:#ccc;' >已申请</button>"+
            	     "</div>"
            	 }
            	return str;
            	}
           } ],
    onLoadSuccess:function(){
    	 $('#mySwitch input').bootstrapSwitch();  
    }       
});

function addMenu() {
	resetForm();
	var row = $('#tb_departments').bootstrapTable('getSelections');
	if(row.length > 0){
		$("input[name=parentMenuName]").val(row[0].Name);	
		$("input[name=parentMenuId]").val(row[0].Id);
	}
	$("#menumodal").modal('show');
	$("#menumodal-title").text("新增用户");
	$("input[name=menuName]").attr("placeholder", "输入菜单名称");
	$("input[name=menuUrl]").attr("placeholder", "输入菜单URL");
	$("input[name=parentMenuName]").attr("placeholder", "父节点URL");
	$("#menusave").attr('onclick', 'addMenuCheck()'); 
}

function resetForm() {
 	$("input[name=id]").val("");
	$("input[name=menuName]").val("");
	$("input[name=menuName]").attr("disabled", null);
	$("input[name=menuUrl]").val("");
	$("input[name=parentMenuId]").val("");
	$("input[name=parentMenuName]").val("");	
	$("#statusRadio1").prop("checked", true);
	$("input[name=note]").val("");
	//$("#searchWXFilter").val(""); 
}

function menuFormCheck() {
	if (isNull($("input[name=menuName]").val())) {
		inputCheckedError($('input[name=menuName]'), "菜单名不能为空！", "top");
		return false;
	} else if (hasBlank($("input[name=menuName]").val())) {
		inputCheckedError($('input[name=menuName]'), "菜单名中不能含有空格！", "top");
		return false;
	} else if (isNull($("input[name=menuUrl]").val())) {
		inputCheckedError($('input[name=menuUrl]'), "菜单URL不能为空！", "top");
		return false;
	} else if (hasBlank($("input[name=menuUrl]").val())) {
		inputCheckedError($('input[name=menuUrl]'), "菜单URL中不能含有空格！", "top");
		return false;
	} else {
		return true;
	}
}

function inputCheckedError(obj, str, side) {
	$(obj).popover({
		container : '#menuform',
		trigger : 'focus',
		placement : side,
		content : str
	});
	$(obj).parent().addClass("has-error");
	$(obj).focus();
}

function addMenuCheck() {
	if (menuFormCheck()) {
		doAddMenu();
	}
}

function doAddMenu() {
	$.ajax({
		type : 'post',
		url : '/menu/add',
		data : $("#menuform").serialize(),// 传给后台的数据
		dataType : 'json',// 服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success : function(data) {
			if (data.result == 'success') {
				$("#menuform").modal('hide');
				refreshTable(currentPage);
			} else {
				toastr.warning(data.message);
			}
		},
		error : function() {
			toastr.warning("提交失败，请稍后重试。");
		}
	});
}