<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 表单验证 jQuery Validation</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>权限编辑</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal m-t" id="frm" method="post" action="${ctx!}/admin/permission/edit">                     	
                            <input type="hidden" id="id" name="id" value="${permission.id}">
                            <#if permissionParent != null>
                            <div class="form-group">
                               	<label class="col-sm-3 control-label">父权限：</label>
                                <div class="col-sm-8">
                                	<input type="hidden" id="parentId" name="parentId" value="${permission.parentId}">
                                	<input class="form-control" type="text" readonly value="${permissionParent.permissionName}">
                                </div>
                            </div>
                            </#if>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">权限名称：</label>
                                <div class="col-sm-8">
                                    <input id="permissionName" name="permissionName" class="form-control" type="text" value="${permission.permissionName}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">唯一标识：</label>
                                <div class="col-sm-8">
                                    <input id="permissionKey" name="permissionKey" class="form-control" type="text" value="${permission.permissionKey}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">权限类型：</label>
                                <div class="col-sm-8">
                                	<select name="permissionType" class="form-control" value="${permission.permissionType}">
                                		<option value="0" <#if permission.permissionType == "0" >selected="selected"</#if>>目录</option>
                                		<option value="1" <#if permission.permissionType == "1" >selected="selected"</#if>>菜单</option>
                                		<option value="2" <#if permission.permissionType == "2" >selected="selected"</#if>>按钮</option>
                                	</select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">权限url：</label>
                                <div class="col-sm-8">
                                    <input id="permissionUrl" name="permissionUrl" class="form-control" value="${permission.permissionUrl}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">排序：</label>
                                <div class="col-sm-8">
                                    <input id="sort" name="sort" class="form-control" value="${permission.sort}">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" type="submit">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <!-- 全局js -->
    <script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
    <script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>

    <!-- jQuery Validation plugin javascript-->
    <script src="${ctx!}/assets/js/plugins/validate/jquery.validate.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/validate/messages_zh.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/layer/laydate/laydate.js"></script>
    <script type="text/javascript">
    $(document).ready(function () {
	  	
	    $("#frm").validate({
    	    rules: {
    	    	permissionName: {
    	        required: true,
    	        minlength: 4,
    	    	maxlength: 20
    	      },
    	      	permissionKey: {
    	        required: true,
    	        minlength: 4,
    	    	maxlength: 40
    	      },
    	      	permissionType: {
    	        required: true
    	      },
    	      	permissionUrl: {
    	        required: true
    	      },
    	      	sort: {
    	      	number:true,
    	        required: true
    	      }
    	    },
    	    messages: {},
    	    submitHandler:function(form){
    	    	$.ajax({
   	    		   type: "POST",
   	    		   dataType: "json",
   	    		   url: "${ctx!}/admin/permission/edit",
   	    		   data: $(form).serialize(),
   	    		   success: function(msg){
	   	    			layer.msg(msg.message, {time: 2000},function(){
	   						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
	   						parent.layer.close(index); 
	   					});
   	    		   }
   	    		});
            } 
    	});
    });
    </script>

</body>

</html>
