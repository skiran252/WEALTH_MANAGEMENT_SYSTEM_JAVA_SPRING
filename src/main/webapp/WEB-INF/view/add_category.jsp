<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD A NEW TRANSACTION</title>
<jsp:include page="partials/bootstrap.jsp" />
<jsp:include page="partials/style.jsp" />
</head>
<body >
	<jsp:include page="partials/navbar.jsp" />
	<div class="container" style="margin-top:15vh;">
		<div>
			<h3>PLEASE ADD A NEW CATEGORY HERE</h3>
		</div>

		<div class="row ">

			<div class="col-md-4 bg-iight">
				<form:form
					action="${pageContext.request.contextPath}/addcategory"
					modelAttribute="category" method="POST">
					<div class="form-group">
						<label for="title">Title:</label>
						<form:input path="title" type="text" class="form-control"
							id="title" name="title"
							placeholder="Category title" />
					</div>

					<div class="form-group">
						<label for="description">description:</label>
						<form:input path="description" type="text" class="form-control"
							id="description" name="description"
							placeholder="Category description" />
					</div>

					
					<button type="submit" class="btn btn-success" >Add Category </button>

				</form:form>
			</div>

		</div>
	</div>
</body>
<jsp:include page="partials/jsscripts.jsp" />
</html>