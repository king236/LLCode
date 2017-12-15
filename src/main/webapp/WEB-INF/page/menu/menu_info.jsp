<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<%-- <%@include file="/page/platform/base.jsp" %> --%>
<%-- <%String parentName = request.getParameter("parentName");
if(StringUtils.isNotBlank(parentName)){
	parentName = new String(parentName.getBytes("iso-8859-1"),"utf8");
	request.setAttribute("parentName", parentName);
}
%> --%>
</head>
<body>

<form id="form" method="post" class="easyui-form" data-options="novalidate:true,url:'${path}/menu/update'">
	<div id="p" class="easyui-panel" data-options="fit:true,border:false,footer:'#btn'" style="padding: 1px;">
		<table class="formtable" style="width:100%;">
			<c:if test="${parentName != null && parentName != ''}">
			<tr>
				<th width="25%">父菜单：</th>
			    <td>${parentName}</td>
			</tr>
			</c:if>
			<tr>
				<th width="25%">菜单名称：</th>
			    <td>
		    		<input id="menuName" name="menu.MENU_NAME" type="text" class="easyui-textbox" 
		    			value="${menu.menuName }"/>
			    	<input type="hidden" name="menu.MENU_ID" id="menuId" value="${menu.menuId }"/>
			    </td>
			</tr>
			<tr>
				<th width="25%">菜单简称：</th>
			    <td>
		    		<input id="menuName" name="menu.MENU_SHORT_NAME" type="text" class="easyui-textbox" 
		    			value="${menu.menuShortName }"/>
			    </td>
			</tr>
			<c:if test="${param.isTab != '1' }">
				<tr>
				    <th>关联URL：</th>
				    <td>
				    	<input id="rel_url" name="menu.REL_URL" type="text" class="easyui-textbox"  style="width: 400px;"
				    	value="${menu.relUrl }"/>
				    </td>
				</tr>
				
				<tr>
				    <th>URL参数：</th>
				    <td>
				    	<input name="menu.URL_PARAM" type="text" class="easyui-textbox"  style="width: 400px;"
				    	value="${menu.urlParam }"/>
				    </td>
				</tr>
			</c:if>
			<c:if test="${param.isTab == '1' }">
				<input name="menu.REL_URL" value="common/tabIndex" type="hidden"/>
				<input name="menu.IS_TAB" value="1" type="hidden"/>
				<input name="menu.IS_MENU" value="1" type="hidden"/>
			</c:if>
			<tr>
			    <th>快捷图标：</th>
			    <td>
			    	<input name="menu.SHORTCUT_IMG" type="text" class="easyui-textbox" 
			    	value="${menu.shortcutImg }"/>
			    </td>
			</tr>
			<c:if test="${param.isTab != '1' }">
			<tr>
			    <th>菜单：</th>
			    <td><label>
			    	<c:if test="${param.op=='add' }">
			    		<input id="isMenu" name="menu.IS_MENU" type="checkbox" value="1" checked="checked"/>
			    	</c:if>
			    	<c:if test="${param.op!='add' }">
			    		<input id="isMenu" name="menu.IS_MENU" type="checkbox" value="1"
			    	 		<c:if test="${menu.isMenu=='1' }">checked="checked"</c:if>/>
		    	 	</c:if>
			    	 菜单项</label>
			    </td>
			</tr>
			</c:if>
			<tr>
			    <th>打开链接方式：</th>
			    <td>
			    	<label>
		    			<input name="menu.SKIP_MODE" type="radio" value="1" 
		    				<c:if test="${menu.skipMode == null || menu.skipMode=='1' || param.op=='add'}">checked="checked"</c:if>/>easyui引入
		    	 	</label>
		    	 	<label>
		    			<input name="menu.SKIP_MODE" type="radio" value="2" <c:if test="${menu.skipMode=='2'}">checked="checked"</c:if>/>iframe
		    	 	</label>
			    </td>
			</tr>
			<c:if test="${param.op != 'add' }">
				<tr>
					<th>排序号：</th>
					<td><input name="menu.SORT_NO" type="text" class="easyui-numberbox" value="${menu.sortNo }"/></td>
				</tr>
			</c:if>
			<tr>
				<th>首页是否隐藏：</th>
				<td>
					<label><input id="menu.INDEX_HIDE" type="checkbox" <c:if test="${menu.indexHide=='1' }">checked="checked"</c:if> />勾选开启</label>
					<input name="menu.INDEX_HIDE" type="hidden" value="${menu.indexHide }"/>
				</td>
			</tr>
			<c:if test="${sessionScope['_user_'].userId == '1'}">
				<tr>
					<th>普通管理员是否可见：</th>
					<td>
						<label><input id="menu.IS_MANAGE" type="checkbox" <c:if test="${menu.isManage=='1' }">checked="checked"</c:if> />勾选开启</label>
						<input name="menu.IS_MANAGE" type="hidden" value="${menu.isManage }"/>
					</td>
				</tr>
				<tr>
			</c:if>
				<th>是否最大化：</th>
				<td>
					<label><input id="menu.IS_OPEN_MAX" type="checkbox" <c:if test="${menu.isOpenMax=='1' }">checked="checked"</c:if> />勾选开启</label>
					<input name="menu.IS_OPEN_MAX" type="hidden" value="${menu.isOpenMax }"/>
				</td>
			</tr>
		</table>
	</div>
</form>
<script type="text/javascript">
$(document).ready(function(){
	$("input[type='checkbox']").click(function() {
		if ($(this).is(":checked")) {
			$('input[name="' + $(this).attr('id') + '"]').val("1");
		}else{
			$('input[name="' + $(this).attr('id') + '"]').val("0");
		}
    });
});

function ok(succ){
	$("#form").form("submit",{
		url:"${path}/menu/save",
		onSubmit:function(params){
			params['menu.PMENU_ID'] = '${param.parentId}';
			return $(this).form('enableValidation').form('validate');
		},
	    success:function(data){
	    	data = $.evalJSON(data);
	    	if(!data.result){
	    		top.layer.alert('添加失败,' + data.msg);
	    		return;
	    	}
	    	top.layer.alert('添加成功');
	    	succ(data);
	    }
	});
}
</script>
</body>
</html>