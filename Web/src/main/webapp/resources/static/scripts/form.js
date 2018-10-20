/**
 * 
 */

function formSubmitted(elm){
	var username = $(elm).find(".Username").val();
	var password = $(elm).find(".Password").val();
	console.log(username)
	console.log(password)
	if (username == ""){
		$(elm).find(".Error").text("Please enter your username");
		return false;
	}else{
		if (password == ""){
			$(elm).find(".Error").text("Please enter your password");
			return false;
		}else{
			return true;
		}
	}
}