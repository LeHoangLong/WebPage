<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<tags:GetImageDatabasePath></tags:GetImageDatabasePath>
	<link rel="stylesheet" type="text/css" href="resources/static/css/ImageStyle.css">
	<link rel="stylesheet" type="text/css" href="resources/static/css/MarginStyle.css">
	<title>Insert title here</title>
</head>
<body>
	<tags:headerTag/>
	<div class="ImageGallery">
		<c:forEach items="${ products }" var="product" varStatus="i">
			<c:if test="${i.index % 3 == 0}">
				<div class="ImageRow">
			</c:if>
			<div id="${product.productId}" class="ImageWithCaption NormalMargin">
				<a href="product?productId=${product.productId}">
					<img id="${product.productId}/img" class="NormalImage">
				</a>
				<script>getImageDatabasePath("${product.productId}/img", "product", "${product.name}", "${product.indexImage}")</script>
				
				
				<div id="${product.productId}/name" class="ImageCaption">
					${product.name}
				</div>
			</div>
			<c:if test="${i.index % 3 == 2}">
				</div>
			</c:if>
		</c:forEach>
	</div>
</body>
</html>