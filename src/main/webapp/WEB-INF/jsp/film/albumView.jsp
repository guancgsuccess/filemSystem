<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>影片集详情页</title>
		<link rel="stylesheet" href="${path}/dist/css/bootstrap.min.css" />

		<link rel="stylesheet" href="${path}/css/albumView.css" />

	</head>
	<body>
		<!-- 加载页面顶部 -->
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
		
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="#">影片图集</a></li>
				<li><a href="#">${film.filmName }</a></li>
				<li class="active">${film.releaseTime }</li>
			</ol>
		</div>
		
		<!--影片集列表开始-->
		<div class="container">
			<div class="box">
			    <div id="imgs" class="imgs">
				   	<c:forEach items="${albums }" var="album">
				        <img src="${path}/img/${album.imgUrl }" layer-pname="${album.film.filmName }">
				    </c:forEach>
			    </div>
				<div style="text-align:center;clear:both;"></div>
			</div>
		</div>
		<!--影片集列表结束-->
		
		<!-- 加载页面底部 -->
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
		<script type="text/javascript" src="${path}/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="${path}/dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${path}/js/qqAlbum/layer/jquery.js?v=1.83.min" ></script>
		<script type="text/javascript" src="${path}/js/qqAlbum/layer/layer.min.js"></script>
		<script type="text/javascript">
            ;!function(){
                layer.use('extend/layer.ext.js', function(){
                    alert("==")
                    //初始加载即调用，所以需放在ext回调里
                    layer.ext = function(){
                        layer.photosPage({
                            html:'<div style="padding:20px;">内容</div>',
                            title: '快捷模式-获取页面元素包含的所有图片',
                            //id: 100, //相册id，可选
                            parent:'#imgs'
                        });
                    };
                });
            }();
		</script>
	</body>
</html>
