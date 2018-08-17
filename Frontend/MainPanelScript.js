
var img = document.getElementById("image12");
img.style.width = '600px';
img.style.height = '400px';
setInterval(myFunc, 1000);
counter = 0;
fastCounter = 0;
var ctx = canvas.getContext("2d");
function myFunc(){
	counter++;
	var image1 = document.getElementById("image12");
	if (counter % 2 == 0){
		image1.src = "store.jpg";
	}else{
		image1.src = "index.jpeg";
	}
}
