

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ tag language="java" pageEncoding="UTF-8"%>


<div style="position:relative;">
	<div id="categoryList" style="position:relative;z-index:1; max-width:10%;float:left; margin-right:100px; margin-left:30px">
		<c:forEach items="${categories}" var="category">
			<a href="category?category=${category.categoryId}" style="margin-bottom:30px">${category.name}</a>
			<br/>
		</c:forEach>
	</div>
	<div style="position:relative;z-index:0">
		<img src="/resources/static/image/test.png">
		<br/>
	</div>
</div>