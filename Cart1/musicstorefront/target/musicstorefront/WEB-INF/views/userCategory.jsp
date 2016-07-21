<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="header.jsp" %>

<br>
	<br>
	<br>
	<br>
	<br>
	<br><br>
	<br>
	<br>
<c:if test="${!empty productList}">
<script>

    $(document).ready(function(){
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu": [[1,2,3,5,10, -1], [1,2,3,5,10, "All"]],
            "oSearch" : {"sSearch": searchCondition}
        });
    });
</script>
<div class="container-wrapper">
    <div class="container">

	<h3>Product List</h3>
		<table class="table table-striped table-hover">
            <thead>
                <tr class="bg-success">
                    <th>Image</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Supplier</th>
                    <th>Brand</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images${product.pid}.png" />" alt="image" style="width:100%"/></td>
                    <td>${product.name}</td>
                    <td>${product.category.cname}</td>
                    <td>${product.supplier.supname}</td>
                    <td>${product.brand}</td>
                    <td>Rs ${product.price} </td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.pid}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                    <a href="<spring:url value="/product/favorite/${product.pid }" />"><img src="<c:url value="/resources/images/heart.png" />" /></a></td>
                </tr>
            </c:forEach>
        </table>
        </div>
	</div>
</c:if>
<c:choose>
<c:when test="${empty productList}">
<h1 style="color:blue;" align="center"><p>No Product Found</p></h1><br><br><br><br><br><br><br><br><br><br>
</c:when></c:choose>
	


	
	<br>
	<br>
	<br>
	<%@ include file="footer.jsp"%>



</body>
</html>