<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="java.util.*"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="demo.model.Stats"%>


<c:set var="income" value="${stats.getIncome()}" />
<c:set var="expense" value="${stats.getExpense()}" />

<%
Gson gsonObj = new Gson();
Map<Object, Object> map = null;
List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
double income = (Double) pageContext.getAttribute("income");
double expense = (Double) pageContext.getAttribute("expense");
double total = income + expense;
map = new HashMap<Object, Object>();
map.put("label", "Expense");
map.put("y", (expense / income) * 100);
map.put("exploded", true);
list.add(map);
map = new HashMap<Object, Object>();
map.put("label", "Savings");
map.put("y", ((income - expense) / income) * 100);
list.add(map);
String dataPoints = gsonObj.toJson(list);
%>

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

	<div class="container" style="margin-top: 15vh">
		<div class="row">
			<div class="col-md-4">
				<div class="card bg-light bg-gradient" style="width: 18rem">
					<div class="card-body">
						<h3 class="card-title">Expenses</h3>
						<h6 class="card-subtitle mb-2 text-muted">Total Amount Spent</h6>
						<h1 class="card-text text-danger">-${stats.getExpense()}</h1>
					</div>
				</div>

				<div class="card bg-light bg-gradient mt-5" style="width: 18rem">
					<div class="card-body">
						<h3 class="card-title">Income</h3>
						<h6 class="card-subtitle mb-2 text-muted">Total Amount
							Deposited/Credited</h6>
						<h1 class="card-text text-success">${stats.getIncome()}</h1>
					</div>
				</div>

			</div>
			<div class="col-md-8">
				<div class="col-md-3 float-right">
					<c:if test="${message!=null}">
						<div class="alert alert-success float-right">${message}</div>
					</c:if>
					<c:if test="${error!=null}">
						<div class="alert alert-success">${error}</div>
					</c:if>
				</div>
				<div class="card bg-light bg-gradient mt-">
					<div class="text-center">
						<div class="card-header">ANALYSUS</div>
					</div>
					<div class="mt-5" id="chartContainer"
						style="height: 370px; width: 100%;"></div>
					<div class="btn-group align-self-left" role="group"
						aria-label="Basic example">
						<a class="btn btn-success"
							href="${pageContext.request.contextPath}/addtransaction"> Add
							Transaction </a> <a class="btn btn-primary align-middle"
							href="${pageContext.request.contextPath}/transactions"> View
							Transactions </a>
					</div>


				</div>
			</div>

			<!-- end of col-md-4 -->
		</div>
		<!-- /row -->
	</div>
	<!-- /container -->
</body>

<script type="text/javascript">
	window.onload = function() {
		var chart = new CanvasJS.Chart("chartContainer", {
			theme : "light2",
			animationEnabled : true,
			exportFileName : "Spend Analysis",
			exportEnabled : true,
			title : {
				text : "Spend Analysis"
			},
			data : [ {
				type : "pie",
				showInLegend : true,
				legendText : "{label}",
				toolTipContent : "{label}: <strong>{y}%</strong>",
				indexLabel : "{label} {y}%",
				dataPoints :
<%out.print(dataPoints);%>
	} ]
		});
		chart.render();
	}
</script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

<jsp:include page="partials/jsscripts.jsp" />
</html>