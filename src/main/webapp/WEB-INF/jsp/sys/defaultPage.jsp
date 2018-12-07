<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>默认页面</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<style type="text/css"> 
			.content_default{
				width: 100%;
				height: 400px;
				font-size: 30px;
				color: grey;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<!-- 加载页面顶部 -->
		<jsp:include page="/WEB-INF/jsp/include/header.jsp"></jsp:include>
		
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="#">默认页面</a></li>
				<!-- <li><a href="#">2017</a></li>
				<li class="active">十月</li> -->
			</ol>
		</div>
		
		<!--查询开始-->
		<div class="container">
			<div class="content_default">
				待开发页面
			</div>
			
		
		<!-- 加载页面底部 -->
		<jsp:include page="/WEB-INF/jsp/include/footer.jsp"></jsp:include>
	</body>
</html>
