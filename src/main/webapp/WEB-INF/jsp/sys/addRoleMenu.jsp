<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>菜单列表页</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="${path }/dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
		<!-- zTree -->
		<link rel="stylesheet" href="${path }/js/zTree_v3/css/zTreeCustom.css" type="text/css">
		<link rel="stylesheet" href="${path }/js/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
		<script type="text/javascript" src="${path }/js/zTree_v3/js/jquery.ztree.core.js"></script>
		<script type="text/javascript" src="${path }/js/zTree_v3/js/jquery.ztree.excheck.js"></script>
		<script type="text/javascript" src="${path }/js/zTree_v3/js/jquery.ztree.exedit.js"></script>
		<style type="text/css"> 
			.ztree li span.button.add {
			margin-left:2px; 
			margin-right: -1px; 
			background-position:-144px 0; 
			vertical-align:top; 
			*vertical-align:middle
			} 
			#update{
				float:left;
				margin-top: 10px;
				width: 800px;
			}
		</style>
	</head>
	<body>
		<!-- 加载页面顶部 -->
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
		
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="#">菜单列表</a></li>
				<!-- <li><a href="#">2017</a></li>
				<li class="active">十月</li> -->
			</ol>
		</div>
		
		<!--查询开始-->
		<div class="container">
			<div class="content_wrap">
				<div class="zTreeDemoBackground left">
					<ul id="menuTree" class="ztree"></ul>
				</div>
			</div>
			
			<!-- 角色信息 -->
			<div id="update">
				<form id="roleForm" action="#" method="post"  class="form-horizontal" role="form">
					<legend>角色信息</legend>
					<input type="hidden" value="${role.id }" id="roleId">
					<div class="form-group">
						<label for="filmCode" class="col-md-3 control-label">角色名称</label>
						<div class="col-md-6">
							<input type="text" value="${role.description }" readonly="readonly" class="form-control">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-warning" onclick="saveRoleMenu()">保存</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--查询结束-->
		
		<!-- 加载页面底部 -->
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</body>
	<script type="text/javascript">
		var setting = {
				check : {  
			        chkboxType:{"Y":"ps","N":"ps"},//勾选checkbox对于父子节点的关联关系  
			        chkStyle:"checkbox",  
			        enable : true   //是否复选框  
			    },  
			    //数据  
			    data : {  
			        simpleData : {  
			            enable : true  
			        }  
			    }
		};
		
		$(document).ready(function(){
			var roleId = ${role.id};
			$.post('${path}/sys/role/getRoleMenuList', {'id':roleId }, function(zNodes) {  
		        for (var i = 0; i < zNodes.length; i++) {  
		            if (zNodes[i].isParent) {  
		  
		            } else {  
		                //zNodes[i].icon = "${ctxStatic}/images/532.ico";//设置图标  
		            }  
		        }  
		        tree = $.fn.zTree.init($("#menuTree"), setting, zNodes);  
		        tree.expandAll(true);//全部展开  
		        //var nodes = treeObj.getNodes();  
		    }, 'json'); 
		});
		
		//获取选中节点  
		function saveRoleMenu(){  
		     var roleId = $("#roleId").val();  
		     var treeObj=$.fn.zTree.getZTreeObj("menuTree");  
		     var nodes=treeObj.getCheckedNodes(true);  
		     var ids=null;  
		     for(var i=0;i<nodes.length;i++){  
		        //获取选中节点的值  
		        // ids.push(nodes[i].id);  
		        ids = ids + nodes[i].id + ",";
		     }
		   
		   ajaxSubmit(roleId,ids);       
		}
		
		//提交角色菜单
		function ajaxSubmit(roleId,ids){
			$.ajax({
				url: "${path}/sys/role/saveRoleMenu",
				data:{"role.id":roleId,"menuIds":ids},
				type:"post",
				success: function(){
					layer.msg("保存成功");
				}
			});
		}

	</script>
</html>
