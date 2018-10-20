
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="resources/static/css/BarStyle.css">
	<link rel="stylesheet" type="text/css" href="resources/static/css/ImageStyle.css">
	<link rel="stylesheet" type="text/css" href="resources/static/css/ButtonStyle.css">
	<link rel="stylesheet" type="text/css" href="resources/static/css/MarginStyle.css">
	<link rel="stylesheet" type="text/css" href="resources/static/css/BorderStyle.css">
	<title>Insert title here</title>
	<tags:GetImageDatabasePath></tags:GetImageDatabasePath>
	<tags:CounterButton/>
</head>
<body>
<tags:headerTag/>
	<div class="LeftBar">
		<c:forEach items="${product.images}" var="image" varStatus="i">
			<div>
				<img id="${product.productId}/${image}" src="" class="SmallImage SmallMargin" onClick='replaceImage(this.id, "mainImage");'/>
				<script>getImageDatabasePath("${product.productId}/${image}", "product", "${product.name}","${image}")</script>
			</div>
		</c:forEach>
	</div>
	<div class="LeftBar">
		<img id="mainImage" src="" class="LargeImage LeftBar"/>
		<script>getImageDatabasePath("mainImage", "product", "${product.name}","${product.indexImage}")</script>
		<div class="LeftBar">
			<div name="productInfo" class="LeftBar SmallSideMargin">
				<div class="LeftBar SmallButtonSize">
					Name:
				</div>
				<div class="LeftBar SmallLongButtonSize NormalSideMargin">
					${product.name}
				</div>
				<br>
				
				<div class="LeftBar SmallButtonSize">
					Price:
				</div>
				<div class="LeftBar SmallLongButtonSize NormalSideMargin">
					<span>${product.price}</span>
					<span> ${product.currency}</span>
				</div>
				
			</div>
			<br>
			<div id="addtoCartButton" class="CommonButtonColor CommonButtonSize">
				<div class="CenterButtonContent">Add To Cart</div>
			</div>
			<div id="numOfItemsButton" class="WhiteButton SmallLongButtonSize SolidBorder">
				<div id="numOfItemsButton/plus" class="WhiteButton SmallButtoNSize SolidBorder LeftBar">
					<img id="numberOfItemsButton/plus/img" src="" class="SmallImage" onClick="counter.increment()">
					<script>getImageDatabasePath("numberOfItemsButton/plus/img", "icon", "plus", "jpg")</script>
				</div>
				<div id="itemsCounter" class="CenterButtonContent">
					<script>var counter = new CounterButton("itemsCounter", 1)</script>
				</div>
				<div id="numOfItemsButton/minus" class="WhiteButton SmallButtoNSize SolidBorder RightBar">
					<img id="numberOfItemsButton/minus/img" src="" class="SmallImage" onClick="counter.decrement()">
					<script>getImageDatabasePath("numberOfItemsButton/minus/img", "icon", "minus", "jpg")</script>
				</div>
			</div>
		</div>
	</div>
	
<tags:ReplaceImage/>
</body>
</html>