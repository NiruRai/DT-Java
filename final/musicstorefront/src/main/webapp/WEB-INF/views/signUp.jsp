<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Sign Up</title>
<%@ include file="header.jsp" %>
<body background=resources/images/bg1.png>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Please fill in your information below</p>
        </div>
<%-- <c:url var="addAction" value="/register"></c:url>
 --%>
		<form:form action="${pageContext.request.contextPath}/register" commandName="registerCommand" method="post">
			

        <h3>Basic Information</h3>

        <div class="form-group">
            <label for="name">Name</label>
            <form:errors path="username" cssStyle="color: #ff0000" />
            <form:input path="username" id="username"  class="form-Control" type="text" required="true"/>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <span style="color: #ff0000">${emailMsg}</span>
            <form:errors path="useremail" cssStyle="color: #ff0000" />
            <form:input path="useremail" id="useremail" type="email" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="usernumber" id="usernumber" type="tel" title="id should contains 10 digit" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="username">Username</label>
            <span style="color: #ff0000">${usernameMsg}</span>
            <form:errors path="userloginname" cssStyle="color: #ff0000" />
            <form:input path="userloginname" id="userloginname" type="text" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <form:errors path="userloginpassword" cssStyle="color: #ff0000" />
            <form:password path="userloginpassword" id="userloginpassword" required="true" class="form-Control" />
        </div>


        <br/>

        <h3>Billing Address</h3>

        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <form:input path="billingAddress.streetName" id="billingStreet" type="text" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="houseNumber">House Number</label>
            <form:input path="billingAddress.houseNumber" id="houseNumber" type="tel" title="id should contains 10 digit" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="billingAddress.city" type="text" required="true" id="city" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="billingAddress.state" id="state" type="text" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="billingAddress.country" id="billingCountry" type="text" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingZip">Zipcode</label>
            <form:input path="billingAddress.zipCode" id="billingZip" require="true" title="Zip should contains 7 digit" class="form-Control" />
        </div>

        <br/>

        <h3>Shipping Address for Products</h3>

        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" type="text" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippinghouseNumber">House Number</label>
            <form:input path="shippingAddress.houseNumber" id="houseNumber" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:input path="shippingAddress.city" id="shippingCity" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="shippingAddress.state" id="state" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:input path="shippingAddress.country" id="country" required="true" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingZip">Zipcode</label>
            <form:input path="shippingAddress.zipCode" id="zip" required="true" class="form-Control" />
        </div>

        <br/><br/>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>

        </form:form>
</div></div>


<%@ include file="footer.jsp" %>