<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/carousel.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css"
	rel="stylesheet">
</head>

<body background=resources/images/bg2.png>
	<%@ include file="header.jsp"%>
	<br><br><br><br><br>
	<div class="container" id="adminhome" align="left">
	<ul id="adminlist">
	<li><a href="admin/allCategory"><h1>Product Management</h1></a></li>
	<h3><p>Manage the details of product</p></h3>
	<li><a href="admin/addCategory"><h1>Category Management</h1></a></li>
	<h3><p>Manage the details of category</p></h3>
	<li><a href="admin/addSupplier"><h1>Supplier Management</h1></a></li>
	<h3><p>Manage the details of supplier</p></h3>
	<li><a href="admin/addCustomer"><h1>Customer Management</h1></a></li>
	<h3><p>Manage the details of customer</p></h3>
	</ul>
	</div><br><br><br><br><br>
	<%@ include file="footer.jsp"%>