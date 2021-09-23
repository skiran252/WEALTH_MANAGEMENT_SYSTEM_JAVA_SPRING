<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">WEALTH
			MANAGEMENT SYSTEM</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">



				<li class="nav-item disabled"><a class="nav-link"
					href="${pageContext.request.contextPath}/">Home , <security:authentication
							property="principal.username" />
				</a></li>


				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/addtransaction">Add
						Transaction</a></li>

				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/addcategory">Add
						Category</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/transactions">View
						Transactions</a></li>



				<li class="nav-item"><form:form
						action="${pageContext.request.contextPath}/logout" method="POST">
						<a onclick="this.closest('form').submit();return false;"
							class="nav-link">LOG OUT</a>
					</form:form></li>
			</ul>

		</div>

	</nav>
</header>
