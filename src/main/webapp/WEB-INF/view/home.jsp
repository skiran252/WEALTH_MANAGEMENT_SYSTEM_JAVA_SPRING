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
<title>HOME</title>
</head>
<body>
	<h1>WElCOME TO HOME</h1>
	<p>
		USERNAME:
		<security:authentication property="principal.username" />
	</p>

	<p>
		ROLE:
		<security:authentication property="principal.authorities" />
	</p>


	<security:authorize access="hasRole('MANAGER')">
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/leaders"> LeaderShip
				Meeting </a>
		</p>
		<hr>
	(Only for Managers)
	
	
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/systems"> IT Systems
				Meeting </a>
		</p>
	(Only for Admin peeps )
	<hr>
	</security:authorize>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<button type="submit" value="Logout">LOG OUT</button>
	</form:form>
</body>
</html>