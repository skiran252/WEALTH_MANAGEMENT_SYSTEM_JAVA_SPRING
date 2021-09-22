<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN HERE</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

<style>
.login, .image {
	min-height: 100vh;
}

.bg-image {
	background-image:
		url('https://assets.entrepreneur.com/content/3x2/2000/1597230521-coins-1015125.jpg');
	background-size: cover;
	background-position: center center;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row no-gutter">
			<div class="col-md-6 d-none d-md-flex bg-image"></div>
			<div class="col-md-6 bg-light">
				<div class="login d-flex align-items-center py-5">
					<div class="container">
						<div class="row">
							<div class="col-lg-10 col-xl-7 mx-auto">





								<h3 class="display-4">Wealth Management System</h3>

								<p class="text-muted mb-4">Please Sign In below</p>

								<c:if test="${param.logout!=null}">
									<div class="alert alert-success text-center">You've been
										successfully logged out!</div>
								</c:if>
								<c:if test="${param.error!=null}">
									<div class="alert alert-danger">Sorry! You Entered
										invalid username/password</div>
								</c:if>

								<form:form
									action="${pageContext.request.contextPath}/authenticateuser"
									method="POST">

									<div class="form-group mb-3">
										<input id="inputEmail" type="text" name="username"
											placeholder="username" required="" autofocus=""
											class="form-control rounded-pill border-0 shadow-sm px-4">
									</div>

									<div class="form-group mb-3">
										<input id="inputPassword" type="password" name="password"
											placeholder="Password" required=""
											class="form-control rounded-pill border-0 shadow-sm px-4 text-primary">
									</div>

									<div class="custom-control custom-checkbox mb-3">
										<input id="customCheck1" type="checkbox" checked
											class="custom-control-input"> <label
											for="customCheck1" class="custom-control-label">Remember
											password</label>
									</div>

									<button type="submit"
										class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">Sign
										in</button>

								</form:form>
							</div>
						</div>
					</div>
					<!-- End -->

				</div>
			</div>
			<!-- End -->

		</div>
	</div>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
	integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
	crossorigin="anonymous"></script>
</html>