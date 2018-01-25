<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>权限列表</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${ctx!}/assets/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">

    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap-switch/css/bootstrap-switch.css" />
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>权限管理</h5>
                    </div>
                    <div class="ibox-content">
                        <p>
                        	
                        		<button class="btn btn-success " type="button" onclick="add();"><i class="fa fa-plus"></i>&nbsp;添加</button>
                        
                        </p>
                        <hr>
                        <div class="row row-lg">
		                    <div class="col-sm-12">
		                        <!-- Example Card View -->
		                        <div class="example-wrap">
		                            <div class="example">
		                            	<table id="table_list"></table>
		                            </div>
		                        </div>
		                        <!-- End Example Card View -->
		                    </div>
	                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
    <script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>


	<!-- Bootstrap table -->
    <script src="${ctx!}/assets/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

	<script src="${pageContext.request.contextPath}/bootstrap-table/dist/bootstrap-table-extends-tree.js" ></script>
	<script src="${pageContext.request.contextPath}/bootstrap-switch/js/bootstrap-switch.js" ></script>

    <!-- Peity -->
    <script src="${ctx!}/assets/js/plugins/peity/jquery.peity.min.js"></script>

    <script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>

    <!-- Page-Level Scripts -->
    <script>
        $(document).ready(function () {
			//初始化表格,动态从服务器加载数据  
			$("#table_list").bootstrapTable({
			    url: '${ctx!}/admin/permission/getPermission',
    			toolbar: '#toolbar',
    			sidePagination: 'client',
    			pagination: false,
    			treeView: true,
    			treeId: "id",
    			treeField: "menuName",
   				//treeRootLevel: 1,
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
                	field: 'name',
                	title: '权限名称',
                	width: '25%'
            	}, {
                	field: 'url',
                	title: '权限URL',
                	width: '35%'
            	},{
			     	title: "资源KEY",
			     	field: "key"
				}, {
			        title: "资源类型",
			        field: "type",
			        formatter: function(value,row,index){
			        	if(value == '0')
                    		return '<span class="label label-info">目录</span>';
                    	else if(value == '1')
                    		return '<span class="label label-primary">菜单</span>';
                    	else if(value == '2')
                    		return '<span class="label label-warning">按钮</span>';
			        }
			 	}, {
            		field:"shortcutOperation",
            		title:"快捷操作",
            		align: "center",
            		formatter: function (value, row, index) {
            			var operateHtml = '<button class="btn btn-primary btn-xs" type="button" onclick="edit(\''+row.id+'\')"><i class="fa fa-edit"></i>&nbsp;修改</button> &nbsp;';
                    	operateHtml = operateHtml + '<button class="btn btn-danger btn-xs" type="button" onclick="del(\''+row.id+'\')"><i class="fa fa-remove"></i>&nbsp;删除</button>';
                        return operateHtml;
            		}
           		} ],
    			onLoadSuccess:function(){
    	 			$('#mySwitch input').bootstrapSwitch();  
    			}  
			});
        });
        
        function edit(id){
        	layer.open({
        	      type: 2,
        	      title: '权限修改',
        	      shadeClose: true,
        	      shade: false,
        	      area: ['893px', '600px'],
        	      content: '${ctx!}/admin/resource/edit/' + id,
        	      end: function(index){
        	    	  $('#table_list').bootstrapTable("refresh");
       	    	  }
        	    });
        }
        function add(){
        	layer.open({
        	      type: 2,
        	      title: '权限添加',
        	      shadeClose: true,
        	      shade: false,
        	      area: ['893px', '600px'],
        	      content: '${ctx!}/admin/resource/add',
        	      end: function(index){
        	    	  $('#table_list').bootstrapTable("refresh");
       	    	  }
        	    });
        }
        function del(id){
        	layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
        		$.ajax({
    	    		   type: "POST",
    	    		   dataType: "json",
    	    		   url: "${ctx!}/admin/resource/delete/" + id,
    	    		   success: function(msg){
	 	   	    			layer.msg(msg.message, {time: 2000},function(){
	 	   	    				$('#table_list').bootstrapTable("refresh");
	 	   	    				layer.close(index);
	 	   					});
    	    		   }
    	    	});
       		});
        }
        
        function detailFormatter(index, row) {
	        var html = [];
	        html.push('<p><b>描述:</b> ' + row.description + '</p>');
	        return html.join('');
	    }
    </script>

    
    

</body>

</html>
