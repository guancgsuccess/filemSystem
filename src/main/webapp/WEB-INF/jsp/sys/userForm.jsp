<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户编辑页面</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path }/css/update.css" />
		<link rel="stylesheet" href="${path }/js/jquery-upload/css/jquery.fileupload-ui.css" />
		<link rel="stylesheet" href="${path }/js/jquery-upload/css/jquery.fileupload.css" />
		<style type="text/css">
			.error{
				color:red;
			}
		</style>
	</head>
	<body>
		<!-- 加载页面顶部 -->
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
		
		<div class="container">
			<div id="update">
				<form:form id="userForm" name="userForm" action="#" method="post" modelAttribute="user" class="form-horizontal">
					<form:hidden path="id"/>
					<form:hidden path="password"/>
					<fieldset>
						<legend>新增用户</legend>
						<div class="form-group">
							<label for="filmCode" class="col-md-3 control-label">用户名</label>
							<div class="col-md-6">
								<form:input path="username" class="form-control" required="required"/>
							</div>
						</div>
						<div class="form-group">
							<label for="filmCode" class="col-md-3 control-label">角色</label>
							<div class="col-md-6">
								<form:checkboxes items="${roleList }" itemLabel="description" itemValue="id" path="roles" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" class="btn btn-warning" onclick="saveUser()">保存</button>
								<button type="button" class="btn btn-warning" onclick="back()">返回</button>
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
		
		<!-- 加载页面底部 -->
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</body>
	<!--引入js-->
	<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="${path }/dist/js/bootstrap.min.js" ></script>
	<script type="text/javascript" src="${path }/js/moment.js" ></script>
	<script type="text/javascript" src="${path }/js/bootstrap-datetimepicker.min.js" ></script>
	<script type="text/javascript" src="${path }/js/jquery-validator/jquery.validate.min.js"></script>
	<script type="text/javascript" src="${path }/js/jquery-validator/messages_cn.js"></script>
	<script type="text/javascript" src="${path }/js/update.js" ></script>
	<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
	<script type="text/javascript">
		function saveUser() {
			if($("#userForm").valid()){
				//取值
				var data = $("#userForm").serialize();
				$.ajax({
					url:"${path }/sys/user/save",
					data:data,
					type:"post",
					success:function(msg){
						//判断是否登陆成功
						if(msg == "success"){
							layer.msg("保存成功");
							window.location.href = "${path }/sys/user/userList";
							return;
						}else{
							return false;
						}
					}
				});
			}
		}
		
		//返回
		function back(){
			window.location.href = "${path}/sys/user/userList";
		}
		
	</script>
	
</html>
