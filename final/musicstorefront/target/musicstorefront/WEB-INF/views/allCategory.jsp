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
	<br><br>
	<body background="resources/images/bg2.png">
	<div class="container" id="categoryTable">
		<br><a href="<c:url value="/admin" />">Home</a><br>
		<h1>Add a Product</h1>

		<c:url var="addAction" value="/product/add"></c:url>

		<form:form action="${pageContext.request.contextPath}/admin/product/add" commandName="productcommand"
			enctype="multipart/form-data">
			<table id="editproduct">

				<tr>
					<td><label for="pid">ID</label></td>
					<c:choose>
						<c:when test="${!empty productcommand.pid}">
							<td><form:input path="pid" id="pid" readonly="true" /></td>
						</c:when>
						<c:otherwise>
							<td><form:input path="pid" id="pid" required="true"
									title="id should contains 6 to 7 characters" /></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td>Name</td>
					<td><form:input path="name" id="name" required="true"  /></td>
					<td><form:errors path="name" cssClass="error">Name</form:errors></td>
				</tr>
				<tr>
				<td>Supplier</td>
				 <td><form:select path="supplier.supname" items="${supplierList}" itemValue="supname" itemLabel="supname" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><form:select path="category.cname" items="${categoryList}" itemValue="cname" itemLabel="cname" /></td>
			</tr>
				<tr>
					<td>Price</td>
					<td><form:input path="price" required="true" /></td>
					<td><form:errors path="price">price</form:errors></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><form:input path="brand" required="true" /></td>
					<td><form:errors path="brand" cssClass="error">
						</form:errors>
				</tr>
				<tr>

					<td><form:label path="image">Image</form:label></td>
					<td><form:input type="file" path="image" /></td>

				</tr>
				<tr>
					<td><c:if test="${!empty productcommand.pid}">
							<input type="submit" value="Edit" />
						</c:if> <c:if test="${empty productcommand.pid}">
							<input type="submit" value="Submit" />
						</c:if></td>
						<td> <c:if test="${empty productcommand.pid}">
							<input type="reset" value="Reset" />
						</c:if></td>
				</tr>
			</table>
		</form:form>
		<!-- <input type="text" ng-model="searchtype" placeholder="I want........"
			class="inputText pull-right"><br> -->

		<c:if test="${!empty productList}">
			<h3>Product List</h3>
			<table class="table table-bordered table-striped" id="table">
				<tr>
					<th width="80">ID</th>
					<th width="120">Name</th>
					<th width="80">Brand</th>
					<th width="80">Price</th>
					<th width="80">Product Category</th>
					<th width="80">Product Supplier</th>
					<th width="20" height="50">Image</th>
					<th width="80">Edit</th>
					<th width="80">Delete</th>
				</tr>
				<tbody>
					<c:forEach var="pro" items="${productList}">
						<tr>
							<td>${pro.pid}</td>
							<td>${pro.name}</td>
							<td>${pro.brand}</td>
							<td>${pro.price}</td>
							<td>${pro.category.cname}</td>
							<td>${pro.supplier.supname}</td>
							<td><img src="<c:url value="/resources/images${pro.pid}.png"/>"/></td>
							<td><a href="<c:url value="/admin/product/edit/${pro.pid}" />"><span class="glyphicon glyphicon-pencil">Edit</span></a></td>
							<td><a href="<c:url value="/admin/product/remove/${pro.pid}" />"><span class="glyphicon glyphicon-trash">Delete</span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>


	
	<br>
	<br>
	<br>
	<%@ include file="footer.jsp"%>

</body>
</html>