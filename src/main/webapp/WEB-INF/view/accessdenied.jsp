<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: black;
	color: white;
}

h1 {
	color: red;
}

h6 {
	color: red;
	text-decoration: underline;
}
</style>
<title>Access Denied</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="w3-display-middle">
		<h1 class="w3-jumbo w3-animate-top w3-center">
			<code>Access Denied</code>
		</h1>
		<hr class="w3-border-white w3-animate-left"
			style="margin: auto; width: 50%">
		<h3 class="w3-center w3-animate-right">You dont have permission
			to view this site.</h3>
		<h6 class="w3-center w3-animate-zoom">error code:403 forbidden</h6>

		<a class="w3-center w3-animate-right"
			href="${pageContext.request.contextPath}/">Click Here to head
			back to home</a>
	</div>
</body>
</html>