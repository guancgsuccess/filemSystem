<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>影片编辑页面</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" />
		<%-- <link rel="stylesheet" href="${pageContext.request.contextPath }/css/update.css" /> --%>
		<style>
		</style>
	</head>
	<body>
		<div class="containers">
			<div id="update">
				<form id="filmForm" action="#" method="post"  class="form-horizontal" role="form">
						<div class="form-group">
							<label for="filmCode" class="col-md-3 control-label">影片编号</label>
							${film.filmCode }
						</div>
						<div class="form-group">
							<label for="filmName" class="col-md-3 control-label">片名</label>
							${film.filmName }
						</div>
						<!--<div class="form-group">
							<label for="filmPic" class="col-md-3 control-label">谍照</label>
							<div class="col-md-6">
								<input type="file" name="file" value="" class="form-control">
							</div>
						</div>-->
						<div class="form-group">
							<label for="years" class="col-md-3 control-label">年代</label>
							${film.years }
						</div>
						<div class="form-group">
							<label for="types" class="col-md-3 control-label">类别</label>
							${film.types }
						</div>
						<div class="form-group">
							<label for="language" class="col-md-3 control-label">语言</label>
							${film.language }
						</div>
						<div class="form-group">
							<label for="caption" class="col-md-3 control-label">字幕</label>
							${film.caption }
						</div>
						<div class="form-group">
							<label for="director" class="col-md-3 control-label">导演</label>
							${film.director }
						</div>
						<div class="form-group">
							<label for="actors" class="col-md-3 control-label">演员</label>
							${film.actors }
						</div>
						<div class="form-group">
							<label for="releaseTime" class="col-md-3 control-label">上映时间</label>
							${film.releaseTime }
						</div>
						<div class="form-group">
							<label for="playRoom" class="col-md-3 control-label">播放影厅</label>
							${film.playRoom }
						</div>
						<div class="form-group">
							<label for="playTime" class="col-md-3 control-label">播放时间</label>
							${film.playTime }
						</div>
						<div class="form-group">
							<label for="remarks" class="col-md-3 control-label">简介</label>
							${film.remarks }
						</div>
				</form>
			</div>
		</div>
	</body>
</html>
