<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="security"
uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>ADD A NEW TRANSACTION</title>
    <jsp:include page="partials/bootstrap.jsp" />
    <jsp:include page="partials/style.jsp" />
  </head>
  <body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container" style="margin-top: 15vh">
      <div>
        <h3>PLEASE ADD A NEW TRANSACTION HERE</h3>
      </div>

      <div class="row">
        <div class="col-md-4 bg-iight align-items-center">
          <form:form
            action="${pageContext.request.contextPath}/addtransaction"
            modelAttribute="transaction"
            method="POST"
          >
            <div class="form-group">
              <label for="amount">Transaction Amount</label>
              <form:input
                path="amount"
                type="text"
                class="form-control"
                id="amount"
                name="amount"
                placeholder="Enter Your Transaction Amount"
              />
            </div>

            <div class="form-group mt-2">
              <label for="note">Description</label>
              <form:input
                path="note"
                type="text"
                class="form-control"
                id="note"
                name="note"
                placeholder="transaction for why?"
              />
            </div>
            <div class="form-group  mt-2">
              <label for="category">Category</label>
              <select
                name="category_name"
                class="form-control"
                id="category_name"
              >
                <c:forEach items="${categories}" var="category">
                  <option value="${category.id}">${category.title}</option>
                </c:forEach>
              </select>
            </div>
            <div class="form-group mt-2">
              <label for="transaction_type">Category</label>
              <select
                name="transaction_type"
                class="form-control custom-select"
                id="transaction_type"
              >
                <option value="expense">Exepense</option>
                <option value="income">Income</option>
              </select>
            </div>
            <button type="submit" class="btn btn-success mt-3">
              Add Transaction
            </button>
          </form:form>
        </div>
      </div>
    </div>
  </body>
  <jsp:include page="partials/jsscripts.jsp" />
</html>
