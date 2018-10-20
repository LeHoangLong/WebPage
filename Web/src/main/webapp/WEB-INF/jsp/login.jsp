<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script src="resources/static/scripts/form.js" async></script>
</head>
<body>
	Log in
	<form action="/loginSubmitted" onsubmit="return formSubmitted(this)">
		Username:<br>
		<input type="text" name="username" class="Username"/><br>
		Password:<br>
		<input type="password" name="password" class="Password"/><br>
		<div class="Error"><br></div>
		<input type="submit" value="Submit">
	</form>
</body>
</html>