/**
 * for lightweight, utility functions
 */

function setImageHeightToWidth(imageId){
	var width = document.getElementById(imageId).style.width;
	var height;
	if (width.includes("%")){
		height = window.innerWidth * Number(width.slice(0,2)) / 100;
	}else{
		height = Number(width.slice(0,2));
	}
	document.getElementById(imageId).style.height = height + "px";
}

/*
 * get product name from path and insert it into the parent DOM with id parentId
 */
function getProductNameFromPath(parentId, path){
	var list = path.split("/");
	document.getElementById(parentId).appendChild(document.createTextNode(list[list.length - 1]));
}