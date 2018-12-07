<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户列表页</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" />
	</head>
	<body>
		<!--列表主体开始-->
		<div class="container">
			<div class="table-responsive">
				<table class="table table-hover">
					<caption>全部用户信息</caption>
					<thead>
						<tr class="active">
							<th>用户名</th>
							<th>创建时间</th>
							<th>修改时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.datas }" var="user">
							<tr>
								<td>${user.username }</td>
								<td><fmt:formatDate value="${user.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${user.updateTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>
									<a href="${pageContext.request.contextPath }/sys/user/form?id=${user.id}" class="btn btn-warning">修改</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!--列表主体结束-->
		<div class="container">
			<div class="row text-center">
				<div class="col-md-12">
					<ul class="pagination">
						<li><a href="javascript:;" onclick="queryPage(1)">首页</a></li>
					    <li class="${page.current eq page.first ? 'disabled':'' }"><a href="#">&laquo;</a></li>
					    <c:forEach begin="1" end="${page.pageNum }" var="pages">
						    <li class="${page.current eq pages ? 'active':'' }"><a href="#" onclick="queryPage(${pages})" >${pages}</a></li>
					    </c:forEach>
					    <li class="${page.current eq page.last ? 'disabled':'' }"><a href="#">&raquo;</a></li>
					    <li><a href="#" style="border: 1px solid #ddd;" onclick="queryPage(${page.pageNum})">尾页</a></li>
					    <li><a style="border: 0px;margin-left: 0px;">当前页${page.current }/${page.pageNum }总页</a></li>
				    </ul>
				</div>
			</div>
		</div>
	</body>
</html>
