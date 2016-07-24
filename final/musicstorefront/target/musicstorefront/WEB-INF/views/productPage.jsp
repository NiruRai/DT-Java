<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
        <br><br>
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product:</p>
        </div>

        <div class="container" ng-app = "cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images${product.pid}.png" />" alt="image" style="width:100%"/>
                </div>
                <div class="col-md-5">
                    <h3>${product.name}</h3>
                    <p>${product.brand}</p>
                    <p><strong>Category</strong>: ${product.category.cname}</p>
                    <p><strong>Supplier</strong>: ${product.supplier.supname}</p>
                    <p>Rs ${product.price}</p>

                    <br/>

                    <c:set var = "role" scope="page" value="${param.role}" />
                    <c:set var = "url" scope="page" value="/product/productList" />
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value = "/userCategory" />" class="btn btn-default">Back</a>
                        <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.pid}')"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</a>
                        <a href="<spring:url value="/customer/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                    </p>

                </div>
            </div>
        </div>

<script src="/musicstorefront/resources/js/controller.js?v3"></script>
<br><br><br><br><br><br><br>
<%@ include file="footer.jsp" %>
