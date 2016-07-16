<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Category</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
<script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/styles.css" />" />

<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resources/js/angular.js"/>"></script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container" id="categoryTable">
		<style>
table, th, td {
	border: 1px solid grey;
	border-collapse: collapse;
	padding: 15px;
}

table tr:nth-child(odd) {
	background-color: #f1f1f1;
}

table tr:nth-child(even) {
	background-color: #ffffff;
}
</style>
		<h1>Add a Category</h1>

		<c:url var="addAction" value="/product/add"></c:url>

		<form:form action="/product/add" commandName="productcommand">
			<table>

				<tr>
					<td><label for="pid">ID</label></td>
					<td><form:input path="pid" id="pid"/></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><form:input path="name" id="name" /></td>
					<td><form:errors path="name" cssClass="error">Name</form:errors></td>
				</tr>
				<tr>
					<td>Supplier</td>
					<td><form:input path="supplier" /></td>
					<td><form:errors path="product" cssClass="error"></form:errors></td>

				</tr>
				<tr>
					<td>Price</td>
					<td><form:input path="price" /></td>
					<td><form:errors path="price">price</form:errors></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><form:input path="brand" /></td>
					<td><form:errors path="brand" cssClass="error">
						</form:errors>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
		<input type="text" ng-model="searchtype" placeholder="I want........"
			class="inputText pull-right"><br>
		<table class="table table-bordered table-striped" id="categorytable">
			<tr>
				<th width="80">ID</th>
				<th width="120">Name</th>
				<th width="80">Brand</th>
				<th width="80">Price</th>
				<th width="80">Edit</th>
				<th width="80">Delete</th>
			</tr>
			<tbody>
				<c:forEach var="pro" items="${product }">
					<tr>
						<td>${pro.pid}</td>
						<td>${pro.name}</td>
						<td>${pro.brand}</td>
						<td>${pro.price}</td>
						<td><a href="<c:url value='product/edit/${product.pid}' />">Edit</a></td>
					<td><a href="<c:url value='product/remove/${product.pid}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>


	<!--  </div> -->
	<br>
	<br>
	<br>
	<%@ include file="footer.jsp"%>

</body>
</html>