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

	<div class="text-center">
		<h1>
			WElCOME, <span> <security:authentication
					property="principal.username" />
			</span>
		</h1>
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<button type="submit" value="Logout">LOG OUT</button>
		</form:form>
	</div>

	<div class="col-md-3 text-center">
		<c:if test="${message!=null}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		<c:if test="${error!=null}">
			<div class="alert alert-success">${error}</div>
		</c:if>
	</div>
	<div class="container text-center" style="margin-top;2vh;">
		<h3>TRANSACTIONS</h3>


		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Date</th>
					<th scope="col">Description</th>
					<th scope="col">Amount</th>
					<th scope="col">Category</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="transaction" items="${transactions}"
					varStatus="loop">
					<th scope="row">${loop.index}</th>
					<td>${transaction.getTransactionDate().toLocaleString()}</td>
					<td>${transaction.getNote()}</td>
					<td>${transaction.getAmount()}</td>
					<td>${transaction.getCategory().getTitle()}</td>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<jsp:include page="partials/jsscripts.jsp" />
</html>
