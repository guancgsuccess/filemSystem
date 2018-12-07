<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>影片列表页</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path }/css/album.css" />
		<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="${path }/dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
		<!-- diyUpload批量上传图片 -->
		<link rel="stylesheet" type="text/css" href="${path }/js/diyUpload/css/webuploader.css">
    	<link rel="stylesheet" type="text/css" href="${path }/js/diyUpload/css/diyUpload.css">
    	<script type="text/javascript" src="${path }/js/diyUpload/js/webuploader.html5only.min.js"></script>
    	<script type="text/javascript" src="${path }/js/diyUpload/js/diyUpload.js"></script>
	</head>
	<body>
		<!-- 加载页面顶部 -->
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
		
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="#">影片集上传</a></li>
				<li><a href="#">${film.filmName }</a></li>
				<li class="active">${film.releaseTime }</li>
			</ol>
		</div>
		
		<!--上传影片集开始-->
		<div class="container">
			<div id="demo">
		        <div id="as">
		        </div>
		    </div>
		</div>
		<!--上传影片集结束-->
		
		
		<!-- 加载页面底部 -->
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</body>
	<script type="text/javascript">
		$('#as').diyUpload({
			url:'${pageContext.request.contextPath }/back/album/multiPicUpload/${film.id}',
			success:function( data ) {
				console.info( data );
			},
			error:function( err ) {
				console.info( err );	
			},
			buttonText : '选择文件',
			chunked:true,
			// 分片大小
			chunkSize:512 * 1024,
			//最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
			fileNumLimit:50,
			fileSizeLimit:500000 * 1024,
			fileSingleSizeLimit:50000 * 1024,
			accept: {}
		});
	</script>
</html>
