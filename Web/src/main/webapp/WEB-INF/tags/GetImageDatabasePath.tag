<%@ tag language="java" pageEncoding="UTF-8"%>

<script>
	function getImageDatabasePath(elementId, imageType, productName, imageName){
		var path;
		if (imageType.toUpperCase() == "PRODUCT"){
			path = "/resources/database/Products/";
			document.getElementById(elementId).src = path + productName + "/" + imageName;
		}
		if (imageType.toUpperCase() == "ICON"){
			path = "/resources/static/image/icon/";
			document.getElementById(elementId).src = path + productName + "." + imageName;
		}
	}
</script>