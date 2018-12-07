<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>角色列表页</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css" />
	</head>
	<body>
		<!--列表主体开始-->
		<div class="container">
			<div class="table-responsive">
				<table class="table table-hover">
					<caption>全部角色信息</caption>
					<thead>
						<tr class="active">
							<th><input type="checkbox" onclick="checkAllOrNot()" /></th>
							<th>角色</th>
							<th>角色名称</th>
							<th>状态</th>
							<th>创建时间</th>
							<th>修改时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.datas }" var="role">
							<tr>
								<td><input type="checkbox" value="${role.id }" class="cks" name="cks" /></td>
								<td>${role.role }</td>
								<td>${role.description }</td>
								<td>${role.status }</td>
								<td><fmt:formatDate value="${role.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td><fmt:formatDate value="${role.updateTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>
									<a href="${pageContext.request.contextPath }/sys/role/form?id=${role.id}" class="btn btn-warning">修改</a>
									<a href="${pageContext.request.contextPath }/sys/role/getRoleMenu?id=${role.id}" class="btn btn-warning">菜单权限</a>
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
