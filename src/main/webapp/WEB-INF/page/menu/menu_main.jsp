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
			<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',title:'',border:false,collapsible:false">
		<div class="easyui-panel powerdiv"  data-options="border:false,fit:true">
		    <a href="javascript:void(0)" class="easyui-menubutton powerbtn" data-options="menu:'#m1',iconCls:'icon-add'" 
		    url="menu/save">新增</a>
		    <a href="javascript:void(0)" class="easyui-linkbutton powerbtn" data-options="plain:true,iconCls:'icon-edit'" 
		    url="menu/update" onclick="update()">修改</a>
		    <a href="javascript:void(0)" class="easyui-linkbutton powerbtn" data-options="plain:true,iconCls:'icon-remove'" 
		    url="menu/del" onclick="del()">删除</a>
		    <a href="javascript:void(0)" class="easyui-linkbutton powerbtn" data-options="plain:true,iconCls:'icon-move'" 
		    url="menu/move" onclick="move()">移动到</a>
		    <a href="javascript:void(0)" class="easyui-linkbutton powerbtn" data-options="plain:true,iconCls:'icon-move'" 
		    url="menu/copyAndMove" onclick="copyAndmove()">复制到</a>
		    <a href="javascript:void(0)" onclick="linkhelp()" class="easyui-linkbutton powerbtn" data-options="iconCls:'icon-link-edit',plain:true" 
			url="menu/linkhelp">关联帮助</a>
		    <a href="javascript:void(0)" onclick="sort()" class="easyui-linkbutton powerbtn" data-options="iconCls:'icon-queue',plain:true" 
			url="menu/sort">排序</a>
		</div>
		<div id="m1" style="width:70px;">
		    <div onclick="add()">菜单</div>
		    <div onclick="add(1)">组合菜单</div>
	    </div>
	</div>
	<div data-options="region:'center',title:'',border:false,collapsible:false" >
		<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'west',iconCls:'icon-reload',title:'',border:false" style="width:230px;">
		    	<div class="easyui-panel" data-options="fit:true,border:false,title:''">
		   			<ul id="clsTree" class="" data-options="lines:true,onSelect:treeClick,onBeforeSelect:befor, onBeforeSelect:beforeSelectclsTree"  ></ul>
		    	</div>
			</div>
		    <div data-options="region:'center',title:'',border:false,collapsible:false" style="border-left-width: 1px;">
			<table id="menuTreeGd" class="easyui-treegrid customtreegd" 
            data-options="fit:true,border:false,
                method: 'post',
                rownumbers: true,
                idField: 'id',
                treeField: 'text',
                lines:true,
                onBeforeSelect:beforeSelectGrid">
				<thead>
				    <tr>
				        <th data-options="field:'text',formatter:menuFmt" width="160">菜单名</th>
				        <th data-options="field:'relUrl'" width="420">链接</th>
				        <th data-options="field:'urlParam'" width="220">HTTP参数</th>
				        <th data-options="field:'shortName'" width="100">简称</th>
				     <%--    <th data-options="field:'isMenu',formatter:yesNoFmt" width="60" align="center">是否菜单</th>
				        <th data-options="field:'isTabMenu',formatter:yesNoFmt" width="60" align="center">合并菜单</th>
				        <th data-options="field:'indexHide',formatter:yesNoFmt" width="60" align="center">首页隐藏</th>
				        <c:if test="${sessionScope['_user_'].userId == '1' }">
				        <th data-options="field:'isManage',formatter:yesNoFmt" width="60" align="center">授权用户</th>
				        </c:if> --%>
				       <!--  <th data-options="field:'helpId',formatter:view" width="100" align="center">帮助</th> -->
				        <th data-options="field:'sortNo'" width="60">排序号</th>
				    </tr>
				</thead>
			</table>
		    </div>   
		</div>
	</div>
</div>

	</div>
		
	<%@include file="/WEB-INF/page/footer.jsp"%>
</div>


<script type="text/javascript">

 function treeClick(node){
	 if($("#clsTree").tree('isLeaf',node.target)){
	  }else{
	   if(node.state=='closed'){//展开 收缩
		   $("#clsTree").tree('expand',node.target);
	  }else{
		  $("#clsTree").tree('collapse',node.target);
	  }
	  return;//如果是父节点，不往下执行点击事件
	 }
	 $("#menuTreeGd").treegrid("unselectAll");//重新加载treegrid后，原先的selected状态还是没改变。
	 var params = {'PMENU_ID':node.id}
	$("#menuTreeGd").treegrid({
		url:'${path}/menu/data',
		queryParams : params,
		
	}); 
} 
 
function befor(node){
	return true;
}

$(document).ready(function(){
	 smt(); 
});

function smt(){
	if('${sessionScope["_user_"].userId}' != '1'){//非管理员
		var params = {'filter[IS_MANAGE][eq]':'1'};
	}
	/* $("#clsTree").tree({
		url:'${path}/menu/rootTree',
		queryParams : params
	}); */
}

function view(v,r,i) {
	if(v!=null){
		return "<a href='javascript:void(0)' onclick='openView(\"" + v + "\")'>查看</a>&nbsp;<a href='javascript:void(0)' onclick='delView(\"" + r.id + "\")'>删除</a>" 
	}else{
		return ;
	}
}

function menuFmt(v,r,i){
	if(r.isTabMenu == '1'){
		return "<a href='javascript:void(0)' onclick='linkTabMenu(\""+r['id']+"\")' style=\"cursor:pointer;text-decoration: underline;\">"+v+"</a>";
	}else{
		return v;
	}
}

function beforeSelectGrid(r){
	var s = $("#menuTreeGd").treegrid("getSelected");
	if(s != null && r.id == s.id){
		$("#menuTreeGd").treegrid("unselect", r.id);
		return false;
	}
	return true;
}

function beforeSelectclsTree(r){
	var s = $("#clsTree").tree("getSelected");
	if(s != null && r.id == s.id){
		$('#clsTree').find('.tree-node-selected').removeClass('tree-node-selected');
		return false;
	}
	return true;
}

function add(isTabMenu){
	var node = $("#menuTreeGd").treegrid("getSelected");
	var nod = $("#clsTree").tree("getSelected");
	var parentId,parentName;
	if(node != null){
		parentId = node.id;
		parentName = node.text;
	}else if(node == null && nod !=null){
		parentId = nod.id;
		parentName = nod.text;
	}else{
		parentId = "";
		parentName="";
	}
	if(node != null && node.isTabMenu == '1'){
		top.layer.alert('选项卡菜单不允许添加子项');
		return;
	}
	parentName = encodeURIComponent(parentName);
	$("<div id='infoDiv' data-options='width:600,modal:true,top:100,left:200' style='height:auto;'/>").dialog({
		title : '新增',
		href : '${path}/page/platform/menu/menu_info.jsp?op=add&parentName=' + parentName + '&isTab='+isTabMenu,
		buttons:[{text:'确定',handler:function(){
			$("#form").form("submit",{
				url:"${path}/menu/save",
				onSubmit:function(params){
					params['menu.PMENU_ID'] = parentId;
					return $(this).form('enableValidation').form('validate');
				},
			    success:function(data){
			    	data = $.evalJSON(data);
			    	if(!data.result){
			    		top.layer.alert('添加失败,' + data.msg);
			    		return;
			    	}
			    	top.layer.alert('添加成功');
			    	$("#infoDiv").dialog("close");
			    	$("#menuTreeGd").treegrid("reload");
			    	if(node == null){
			    		$("#clsTree").tree("reload");
			    	}
			    }
			});
		}},{text:'取消',handler:function(){
			$("#infoDiv").dialog("close");
		}}],
		onClose:function(){
			$(this).dialog("destroy");
		}
	});
	
}


function linkTabMenu(menuId){
	setGlobParams({'shrink':'2','level':'3','filter[IS_TAB][eq]':'0',
		'selectedParam':{'filter[t1.MENU_ID][eq]':menuId,'sort':'MENU_INDEX'},'selectedUrl':'${path}/menu/findMenuGroup'});
	top.layer.open({
		type: 2,
		title: '设置组合菜单',
		shadeClose: false,
		shade: 0.3,
		maxmin: true,
		area: ['490px', '550px'],
		btn: ['确认', '关闭'],
	    btn1:function(index, layero){
	    	var ids = top.window.frames["layui-layer-iframe" + index].sel_Data();
	    	if(ids){
	    		$.ajax({
	    			url:"${path}/menu/tabLinkMenu",
	    			type:"post",
	    			data:{"menuId":menuId, "linkMenuId":ids},
	    			dataType:"json",
	    			success:function(data){
	    				if(data.result){
	    					top.layer.alert('关联成功');
	    				}else{
    			    		top.layer.alert('关联成功,' + data.msg);
	    				}
	    			}
	    		});
				top.layer.close(index);
	    	}
	    },
		content: "${path}/page/platform/menu/tab_menu_selected.jsp"
	});
	
}

function update(){
	var node = $("#menuTreeGd").treegrid("getSelected");
	 var nod = $("#clsTree").tree("getSelected");
	 if(node==null && nod==null){
		 top.layer.alert('请选择菜单');
		 return;
	 }
	 if(node!=null){
		 id=node.id
	 }else{
		 id=nod.id
	 }
	 var updateUrl = '${path}/menu/info?id=' +id;
	 if(node){
		 updateUrl += '&isTab='+node.isTabMenu;
	 }
	 $("<div id='infoDiv' data-options='width:600,modal:true,top:100,left:200' style='height:auto;'/>").dialog({
			title : '修改',
			href : updateUrl,
			buttons:[{text:'确定',handler:function(){
				$("#form").form("submit",{
					url:"${path}/menu/update",
				    success:function(data){
				    	data = $.evalJSON(data);
				    	if(!data.result){
				    		top.layer.alert('修改失败,' + data.msg);
				    		return;
				    	}
				    	$("#infoDiv").dialog("close");
				    	top.layer.alert('修改成功');
				    	$("#menuTreeGd").treegrid("reload");
				    	if(node == null){
				    		$("#clsTree").tree("reload");
				    	}
				    }
				});
			}},{text:'取消',handler:function(){
				$("#infoDiv").dialog("close");
			}}],
			onClose:function(){
				$(this).dialog("destroy");
			}
		});
}

function del(){
	var node = $("#menuTreeGd").treegrid("getSelected");
	var nod = $("#clsTree").tree("getSelected");
	if(node==null && nod==null){
		top.layer.alert('请选择菜单');
		return;
	}
	if(node!=null){
		id=node['id'];
	}else{
		id=nod['id'];
	}
	top.layer.confirm('确认删除',function(){
		$.ajax({
	   		url:"${path}/menu/del?id=" + id,
	   		type:"post",
	   		dataType:"json",
	   		success:function(data){
	   			top.layer.alert('删除成功');
		    	$("#menuTreeGd").treegrid("reload");
		    	if(node == null){
		    		$("#clsTree").tree("reload");
		    	}
		    	$("#menuTreeGd").treegrid("unselectAll");
	   		}
	   	});
	});
}

function move(){
	var node = $("#menuTreeGd").treegrid("getSelected");
	var nod = $("#clsTree").tree("getSelected");
	 if(node==null && nod==null){
		 top.layer.alert('请选择菜单');
		 return;
	 }
	 if(node!=null){
		 id=node['id']
	 }else{
		 id=nod['id']
	 }
	top.layer.open({
		type: 2,
		title: '移动菜单',
		shadeClose: false,
		shade: 0.3,
		maxmin: true,
		area: ['300px', '550px'],
		btn: ['确认', '关闭'],
	    btn1:function(index, layero){
	    	var lines = top.window.frames["layui-layer-iframe" + index].sel_Data();
	    	if(lines){
	    		$.ajax({
	        		url:"${path}/menu/move",
	        		type:"post",
	        		data:{"menuId":lines['id'], "moveId":id},
	        		dataType:"json",
	        		success:function(data){
	        			top.layer.alert('移动菜单成功');
	        			$("#menuTreeGd").treegrid("reload");
	        			smt();
	        		}
	        	});
				top.layer.close(index);
	    	}
	    },
		content: '${path}/page/platform/menu/menu_selected2.jsp'
	});
}

function copyAndmove(){
	var node = $("#menuTreeGd").treegrid("getSelected");
	var nod = $("#clsTree").tree("getSelected");
	 if(node==null && nod==null){
		 top.layer.alert('请选择菜单');
		 return;
	 }
	 if(node!=null){
		 id=node['id']
	 }else{
		 id=nod['id']
	 }
	top.layer.open({
		type: 2,
		title: '移动并复制菜单',
		shadeClose: false,
		shade: 0.3,
		maxmin: true,
		area: ['300px', '550px'],
		btn: ['确认', '关闭'],
	    btn1:function(index, layero){
	    	var lines = top.window.frames["layui-layer-iframe" + index].sel_Data();
	    	if(lines){
	    		$.ajax({
	        		url:"${path}/menu/copyAndMove",
	        		type:"post",
	        		data:{"menuId":lines['id'], "moveId":id},
	        		dataType:"json",
	        		success:function(data){
	        			top.layer.alert('复制并移动菜单成功');
	        			$("#menuTreeGd").treegrid("reload");
	        			smt();
	        		}
	        	});
				top.layer.close(index);
	    	}
	    },
		content: '${path}/page/platform/menu/menu_selected2.jsp'
	});
}

function linkhelp(){
	var node = $("#menuTreeGd").treegrid("getSelected");
	if(node == null){
		top.layer.alert('请选择菜单');
		return;
	}
	top.layer.open({
		type: 2,
		title: '关联帮助 ',
		shadeClose: false,
		shade: 0.3,
		maxmin: true,
		area: ['870px', '600px'],
		btn: ['确认', '关闭'],
	    btn1:function(index, layero){
	    	var lines = top.window.frames["layui-layer-iframe" + index].sel_Data();
	    	if(lines){
	    		$.ajax({
	        		url:"${path}/menu/linkhelp",
	        		type:"post",
	        		data:{"menuId":node['id'], "contentId":lines['CONTENT_ID']},
	        		dataType:"json",
	        		success:function(data){
	        			top.layer.alert('关联帮助成功');
	    		    	$("#menuTreeGd").treegrid("reload");
	        		}
	        	});
				top.layer.close(index);
	    	}
	    },
		content: '${path}/page/platform/help/help_selected.jsp'
	});
}

function openView(id){
	top.layer.open({
		type: 2,
		title: '详情',
		maxmin: true,
		area: ['980px', '620px'],
		btn: ['关闭'],
		content:  '${path}/contentLink/info?op=view&id=' + id
	});
	
}

function delView(menuId){
	top.layer.confirm('确认删除',function(){
		$.ajax({
    		url:"${path}/menu/linkhelp",
    		type:"post",
    		data:{"menuId":menuId},
    		dataType:"json",
    		success:function(data){
    			top.layer.alert('删除成功');
    			$("#menuTreeGd").treegrid("reload");
    		}
    	});
	});
	
}
function sort() {
	var gridNode = $("#menuTreeGd").treegrid("getSelected");
	var treeNode = $("#clsTree").tree("getSelected");
	//排序逻辑为：未选情况下排顶级，选中情况排子节点
	var url = '';<%-- ${path}/common/toSort?className=<%=MenuModel.class.getName()%> --%>
	if (gridNode == null) {//树排序
		if (treeNode == null) {
			url += "&filter[PMENU_ID][null][s]=";
		} else {
			url += "&filter[PMENU_ID][eq][s]=" + treeNode.id;
		}
	} else {//树表排序
		url += "&filter[PMENU_ID][eq][s]=" + gridNode.id;
	}
	top.layer.open({
		type: 2,
		title: "排序 - 菜单",
		maxmin: true,
		area: ['350px', '500px'],
		btn: ['保存', '关闭'],
	    btn1:function(index, layero){
	    	top.window.frames["layui-layer-iframe" + index].ok(function(data){
	    		if(!data.result){
	    			top.layer.alert('修改失败,' + data.msg);
		    		return;
		    	}
	    		top.layer.close(index);
	    		top.layer.alert('修改成功',function(){
					$("#menuTreeGd").treegrid("reload");
			    	if(gridNode == null){
			    		$("#clsTree").tree("reload");
			    	}
		    	});
	    	});
	    	
	    },
		content: url + '&r=' + Math.random()
	});
}
</script>
</body>
</html>