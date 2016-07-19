<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Category</title>
</head>
<body>
<%@ include file="header.jsp" %>/>
<br>
	<br>
	<br>
	<br>
	<br>
	<br><br>
	<br>
	<br>
<c:if test="${!empty productList}">	
	<h3>Product List</h3>
		<table class="table table-bordered table-striped" id="categorytable">
			<tr>
				<!-- <th width="80">ID</th> -->
				<th width="50" height="100">Image</th>
				<th width="120">Name</th>
				<th width="80">Brand</th>
				<th width="80">Price</th>
				<th width="80">Category</th>
				<th width="80">Supplier</th>
				<th width="80">View</th>
				</tr>
			<tbody>
				<c:forEach var="pro" items="${productList}">
					<tr>
						<td><img src="<c:url value="/resources/images${pro.pid}.png"/>"/></td>
						<td>${pro.name}</td>
						<td>${pro.brand}</td>
						<td>${pro.price}</td>
						<td>${pro.category.cname}</td>
						<td>${pro.supplier.supname}</td>
						<td><a href="<c:url value="/product/viewProduct/${pro.pid}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                   			 <a href="<c:url value="/product/favorite/${pro.pid }" />"><img src="<c:url value="resources/images/heart.png" />" /></a></td>
					 </tr>
				</c:forEach>
			</tbody>
		</table>
</c:if>
	


	
	<br>
	<br>
	<br>
	<%@ include file="footer.jsp"%>



</body>
</html>