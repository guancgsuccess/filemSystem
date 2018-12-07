<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>影片集表页</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path }/css/album.css" />
		<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="${path }/dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
	</head>
	<body>
		<!-- 加载页面顶部 -->
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
		
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="#">影片集列表</a></li>
				<%-- <li><a href="#">${film.filmName }</a></li>
				<li class="active">${film.releaseTime }</li> --%>
			</ol>
		</div>
		
		<!--影片集列表开始-->
		<div class="container">
			<c:forEach items="${films }" var="film">
				<div class="col-sm-6 col-md-3">
			        <a href="${path }/back/album/showAllPic/${film.id}" class="" style="width: 255px; height:200px">
			            <img width="255px" height="200px" src="${path}/img/${film.filmPic }" alt="通用的占位符缩略图">
			        	<span class="filmNameTip">${film.filmName }</span>
			        </a>
			    </div>
			</c:forEach>
		</div>
		<!--影片集列表结束-->
		
		<!-- 加载页面底部 -->
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</body>
	<script type="text/javascript">
		
	</script>
</html>
