<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>HOME</title>
<jsp:include page="partials/bootstrap.jsp" />
<jsp:include page="partials/style.jsp" />
</head>
<body>
	<jsp:include page="partials/navbar.jsp" />


	<div class="container" style="margin-top:15vh;">
		<div class="text-center">
			<div class="col-md-3 text-center">
				<c:if test="${message!=null}">
					<div class="alert alert-success">${message}</div>
				</c:if>
				<c:if test="${error!=null}">
					<div class="alert alert-success">${error}</div>
				</c:if>
			</div>
			<h3>PLEASE CHOOSE BELOW OPERATIONS TO PERFORM</h3>
			<a class="btn btn-success"
				href="${pageContext.request.contextPath}/addtransaction"> Add
				Transaction </a> <a class="btn btn-primary"> View Transactions </a>
		</div>
	</div>
</body>
<jsp:include page="partials/jsscripts.jsp" />
</html>
