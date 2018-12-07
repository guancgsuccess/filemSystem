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
					<ul id="treeDemo" class="ztree"></ul>
				</div>
			</div>
			
			<!-- 编辑修改 -->
			<div id="update">
				<form id="menuForm" action="#" method="post"  class="form-horizontal" role="form">
					<legend>菜单修改</legend>
					<input type="hidden" value="" name="id" id="menuId">
					<input type="hidden" value="" name="pId" id="pId">
					<div class="form-group">
						<label for="filmCode" class="col-md-3 control-label">菜单名称</label>
						<div class="col-md-6">
							<input type="text" id="meneName" name="name" value="" readonly="readonly" class="form-control">
						</div>
					</div>
					<div class="form-group">
						<label for="filmCode" class="col-md-3 control-label">菜单路径</label>
						<div class="col-md-6">
							<input type="text" id="menuUrl" name="mUrl" value="" class="form-control" required="required">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="btn btn-warning" onclick="saveMenu()">保存</button>
							<button type="button" class="btn btn-warning" onclick="back()">返回</button>
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
			async: {
				enable: true,
				url:"${path }/sys/menu/getAllMenu",
				autoParam:["id", "name", "level"],
				otherParam:{"otherParam":"zTreeAsyncTest"},
			},
			view: {expandSpeed:"",
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true
			},
			data : {
				/* keep: {
					parent:true,
					leaf:true
				}, */
				key : {
					name : "name"
				},
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "pId",
					rootPId : 1
				}
			},
			callback: {//操作前的回调函数
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				beforeClick: beforeClick
			}
		};
		
		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			alert(treeNode.name)
			var flag = confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
			
			if(flag){//删除数据库中菜单
				deleteNode(treeNode.id,treeNode.getParentNode().id);
			}
			return flag;
		}		
		function beforeRename(treeId, treeNode, newName) {
			if (newName.length == 0) {
				setTimeout(function() {
					var zTree = $.fn.zTree.getZTreeObj("treeDemo");
					zTree.cancelEditName();
					alert("节点名称不能为空.");
				}, 0);
				return false;
			}
			//更新数据库
			updateNode(treeNode.id,treeNode.getParentNode().id,newName);
			return true;
		}
		
		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
				//新增节点入库
				saveNodes((100 + newCount),treeNode.id,"new node" + (newCount++));
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.tId).unbind().remove();
		};
		
		$(document).ready(function(){
			initTree();
		});
		
		function initTree(){
			$.fn.zTree.init($("#treeDemo"), setting);
			setTimeout(function(){  
                var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                treeObj.expandAll(true);
            },1000);//延迟加载  
            $("#menuForm")[0].reset();
		}
		
		//保存节点
		function saveNodes(id,pId,name){
			$.ajax({
				url:"${path}/sys/menu/saveNodes",
				data:{"id":id,"pId":pId,"name":name},
				type:"post",
				success:function(msg){
					//重新加载
					initTree();
				}
			})
		}
		
		//删除节点
		function deleteNode(id,pId){
			$.ajax({
				url:"${path}/sys/menu/deleteNode",
				data:{"id":id,"pId":pId},
				type:"post",
				success:function(msg){
					
				}
			})
		}
		//更新数据库
		function updateNode(id,pId,name){
			$.ajax({
				url:"${path}/sys/menu/updateNode",
				data:{"id":id,"pId":pId,"name":name},
				type:"post",
				success:function(msg){
					
				}
			})
		}
		
		//异步加载表单
		function beforeClick(treeId, node) {
			$.ajax({
				url:"${path}/sys/menu/queryNode",
				data:{"id":node.id},
				type:"post",
				success:function(data){
					console.log(data);
					//向表单中赋值
					$("#menuId").val(data.id);
					$("#pId").val(data.pId);
					$("#meneName").val(data.name);
					$("#menuUrl").val(data.mUrl);
				}
			})
        } 
		//保存表单数据
		function saveMenu(){
			var data = $("#menuForm").serialize();
			$.ajax({
				url:"${path}/sys/menu/updateNode",
				data:data,
				type:"post",
				success:function(msg){
					if(msg == "success"){
						layer.msg("保存成功");
					}
				}
			})
		}
	</script>
</html>
