<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTER HERE</title>
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
			<!-- The image half -->
			<div class="col-md-6 d-none d-md-flex bg-image"></div>


			<!-- The content half -->
			<div class="col-md-6 bg-light">
				<div class="login d-flex align-items-center py-5">

					<!-- Demo content-->
					<div class="container">

						<div class="row">
							<div class="col-lg-10 col-xl-7 mx-auto">
								<c:if test="${param.error!=null}">
									<div class="alert alert-danger">Sorry! You Entered
										invalid username/password</div>
								</c:if>
								<h6>Wealth Management System</h6>
								<p class="text-muted mb-4">PLEASE REGISTER BELOW</p>


								<form:form
									action="${pageContext.request.contextPath}/register/save"
									modelAttribute="user" method="POST">

									<div class="form-group mb-3">
										<form:input path="username" placeholder="username"
											name="username"
											class="form-control rounded-pill border-0 shadow-sm px-4" />
									</div>

									<div class="form-group mb-3">
										<form:input path="password" placeholder="password"
											name="password" type="password"
											class="form-control rounded-pill border-0 shadow-sm px-4" />
									</div>

									<div class="form-group mb-3">
										<form:input path="firstName" placeholder="first name"
											name="firstName"
											class="form-control rounded-pill border-0 shadow-sm px-4" />
									</div>

									<div class="form-group mb-3">
										<form:input path="lastName" placeholder="last name"
											name="lastName"
											class="form-control rounded-pill border-0 shadow-sm px-4" />
									</div>

									<div class="form-group mb-3">
										<form:input path="email" placeholder="email address"
											name="email" type="email"
											class="form-control rounded-pill border-0 shadow-sm px-4" />
									</div>


									<div class="form-group mb-3">
										<form:input path="address" placeholder="your address"
											name="address"
											class="form-control rounded-pill border-0 shadow-sm px-4" />
									</div>

									<div class="form-group mb-3">
										<form:input path="phone" placeholder="phone number"
											name="phone"
											class="form-control rounded-pill border-0 shadow-sm px-4" />
									</div>

									<div class="form-group mb-3">
										<form:input path="balance" placeholder="initial balance"
											name="balance"
											class="form-control rounded-pill border-0 shadow-sm px-4" />
									</div>
									<div class="custom-control custom-checkbox mb-3">
										<input id="customCheck1" type="checkbox" checked
											class="custom-control-input"> <label
											for="customCheck1" class="custom-control-label">Remember
											password</label>
									</div>

									<button type="submit"
										class="btn btn-primary btn-block text-uppercase mb-2 rounded-pill shadow-sm">REGISTER</button>
									<div class="text-center d-flex justify-content-between mt-4">
									</div>
								</form:form>
								<p>Already registered? Click <a href="${pageContext.request.contextPath}/signin"> here </a> to login</p>
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