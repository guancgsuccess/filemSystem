<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>影片编辑页面</title>
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
				<form id="filmForm" action="#" method="post"  class="form-horizontal" role="form" enctype="multipart/form-data">
					<fieldset>
						<legend>新增影片信息</legend>
						<input type="hidden" value="${film.id }" name="id">
						<input type="hidden" id="filmPic" name="filmPic">
						<div class="form-group">
							<label for="filmCode" class="col-md-3 control-label">影片编号</label>
							<div class="col-md-6">
								<input type="text" name="filmCode" value="${film.filmCode }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="filmName" class="col-md-3 control-label">片名</label>
							<div class="col-md-6">
								<input type="text" name="filmName" value="${film.filmName }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="filmPic" class="col-md-3 control-label">谍照</label>
							<div class="col-md-6">
								<div id="queue">
									 <img alt="谍照" width="240px" id="queue_img" height="240px" src="/pic/${film.filmPic }">
								</div>
								<span class="btn btn-success fileinput-button">
				                    <i class="glyphicon glyphicon-plus"></i>
				                    <span>选择谍照</span>
				                    <input type="file" name="file_upload" id="file_upload" >
				                </span>
								<!-- <input type="file" id="file_upload" name="file_upload" value=""> -->
							</div>
						</div>
						<div class="form-group">
							<label for="years" class="col-md-3 control-label">年代</label>
							<div class="col-md-6">
								<input type="text" name="years" value="${film.years }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="types" class="col-md-3 control-label">类别</label>
							<div class="col-md-6">
								<input type="text" name="types" value="${film.types }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="language" class="col-md-3 control-label">语言</label>
							<div class="col-md-6">
								<input type="text" name="language" value="${film.language }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="caption" class="col-md-3 control-label">字幕</label>
							<div class="col-md-6">
								<input type="text" name="caption" value="${film.caption }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="director" class="col-md-3 control-label">导演</label>
							<div class="col-md-6">
								<input type="text" name="director" value="${film.director }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="actors" class="col-md-3 control-label">演员</label>
							<div class="col-md-6">
								<input type="text" name="actors" value="${film.actors }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="releaseTime" class="col-md-3 control-label">上映时间</label>
							<div class="col-md-6">
								<input type="text" name="releaseTime" value="${film.releaseTime }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<label for="playRoom" class="col-md-3 control-label">播放影厅</label>
							<div class="col-md-6">
								<input type="text" name="playRoom" value="${film.playRoom }" class="form-control" required="required">
							</div>
						</div>
						<div class="form-group">
							<div>
								<div class="form-group has-feedback">
									<label for="playTime" class="col-md-3 control-label">播放时间</label>
									<div class="col-md-6">
										<input name="playTime" value="${film.playTime }" type="text" class="form-control" id="datetimepicker" required="required"> 
										<span class="glyphicon glyphicon-time form-control-feedback"></span>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div>
								<div class="form-group has-feedback">
									<label for="remarks" class="col-md-3 control-label">简介</label>
									<div class="col-md-8">
										<textarea id="remarks" name="remarks"  rows="10" cols="80">${film.remarks }</textarea>
									</div>
								</div>
							</div>
						</div>
						<!--<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">性别</label>
							<div class="col-md-1">
									<input type="radio" value="M" checked class="form-control" name="gender">
							</div>
							<label class="pull-left control-label">男</label>
							
							<div class="col-md-1">
								<input type="radio" value="F" class="form-control" name="gender">
							</div>
							<label class="pull-left control-label">女</label>
						</div>-->
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="button" class="btn btn-warning" onclick="saveFilm()">保存</button>
								<button type="button" class="btn btn-warning" onclick="back()">返回</button>
							</div>
						</div>
					</fieldset>
				</form>
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
	<script type="text/javascript" src="${path }/js/ckeditor/ckeditor.js"></script>
	<script type="text/javascript" src="${path }/js/ckfinder/ckfinder.js"></script>
	<script type="text/javascript" src="${path }/js/jquery-upload/vendor/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="${path }/js/jquery-upload/jquery.iframe-transport.js"></script>
	<script type="text/javascript" src="${path }/js/jquery-upload/jquery.fileupload.js"></script>
	<script type="text/javascript">
		$(function() {
		    $('#file_upload').fileupload({
		    	url: "${pageContext.request.contextPath }/back/filmPicUpload",
		    	type:"POST",
		    	//dataType: 'json',
		        done: function (e, data) {
		        	/* console.log(data);
		        	console.log(data.result); */
		        	$("#queue_img").attr("src","/pic/"+data.result);
		        	$("#filmPic").val(data.result);
		        }
		    });
		});
	</script>
	<script type="text/javascript">
		function saveFilm() {
			if($("#filmForm").valid()){
				//取值
				var htmlData=CKEDITOR.instances.remarks.getData();
				$("#remarks").val(htmlData);
				var data = $("#filmForm").serialize();
				$.ajax({
					url:"${pageContext.request.contextPath }/back/filmSave",
					data:data,
					type:"post",
					success:function(msg){
						//判断是否登陆成功
						if(msg == "success"){
							layer.msg("保存成功");
							window.location.href = "${pageContext.request.contextPath }/back/filmList";
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
			window.location.href = "${pageContext.request.contextPath }/back/filmList";
		}
		
		/* ckeditor使用 */
		// CKEDITOR.replace( 'remarks' );
		 var editor = CKEDITOR.replace( 'remarks' );
	     CKFinder.setupCKEditor(editor, '${pageContext.request.contextPath }/js/ckfinder/');
	</script>
	
</html>
