<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LEADER'S HOME PAGE</title>
</head>
<body>
	<h2>Welcome to IT System's Meeting</h2>
	
	<p> Guys we have a major data breach. we need to figure it out how to avoid further damage</p>
	<p> Above is a secret </p>
	
	<a href="${pageContext.request.contextPath}/"> Head back to home page</a>
</body>
</html>