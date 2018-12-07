<%@page import="com.tz.film.sys.entity.User"%>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<%
	User user = (User)request.getSession().getAttribute("user");
%>
<div class="container">
	<%=new Date()%>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid"> 
		    <div class="navbar-header">
		        <a class="navbar-brand" href="#">天悦</a>
		    </div>
		    <div>
		        <!--向左对齐-->
		        <ul class="nav navbar-nav navbar-left">
		            <c:forEach items="${menuList }" var="menu">
		            	<c:if test="${menu.pId ne '0'  }">
		            		<c:choose>
		            			<c:when test="${menu.isParent eq '1'}">
		            				<li class="dropdown">
						                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
						                	${menu.name }
						                   	<b class="caret"></b>
						                </a>
						                 <ul class="dropdown-menu">
						                 	<c:forEach items="${menuList }" var="subMenu">
						                 		<c:if test="${subMenu.pId ne '0' and subMenu.pId eq menu.id }">
						                 			<li><a href="${path }${subMenu.mUrl}">${subMenu.name }</a></li>
						                 		</c:if>
						                 	</c:forEach>
						                </ul>
						            </li>
		            			</c:when>
		            			<c:when test="${menu.isParent ne '1' and menu.pId eq '1' }">
		            				<li class="dropdown">
						                <a href="${path }${menu.mUrl}">
						                    ${menu.name }
						                </a>
						            </li>
		            			</c:when>
		            			<c:otherwise></c:otherwise>
		            		</c:choose>
		            	</c:if>
		            </c:forEach>
		        </ul>
		        
		        <!--向右对齐-->
		        <ul class="nav navbar-nav navbar-right">
		            <li class="dropdown">
		                <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
		                    <span class="text-success"><%=user.getUsername() %></span> 
		                    <b class="caret"></b>
		                </a>
		                <ul class="dropdown-menu">
		                    <li><a href="#">修改密码</a></li>
		                </ul>
		            </li>
		            <li>
		                <a href="${path }/sys/user/safeExit">安全退出</a>
		            </li>
		        </ul>
		    </div>
		</div>
	</nav>
</div>