
<title>Sign Up</title>
<%@ include file="header.jsp" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Register Customer</h1>

            <p class="lead">Please fill in your information below</p>
        </div>

        <form:form action="${pageContext.request.contextPath}/register"
                   method="post" commandName="usercommand">

        <h3>Basic Information</h3>

        <div class="form-group">
            <label for="name">Name</label>
            <form:errors path="username" cssStyle="color: #ff0000" />
            <form:input path="username" id="username" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <span style="color: #ff0000">${emailMsg}</span>
            <form:errors path="useremail" cssStyle="color: #ff0000" />
            <form:input path="useremail" id="useremail" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <form:input path="usernumber" id="usernumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="username">Username</label>
            <span style="color: #ff0000">${usernameMsg}</span>
            <form:errors path="userloginname" cssStyle="color: #ff0000" />
            <form:input path="userloginname" id="userloginname" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <form:errors path="userloginpassword" cssStyle="color: #ff0000" />
            <form:password path="userloginpassword" id="userloginpassword" class="form-Control" />
        </div>


        <br/>

        <h3>Billing Address</h3>

        <div class="form-group">
            <label for="billingStreet">Street Name</label>
            <form:input path="billingAddress.streetName" id="billingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="houseNumber">House Number</label>
            <form:input path="billingAddress.houseNumber" id="houseNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="city">City</label>
            <form:input path="billingAddress.city" id="city" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="billingAddress.state" id="state" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="billingAddress.country" id="billingCountry" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingZip">Zipcode</label>
            <form:input path="billingAddress.zipCode" id="billingZip" class="form-Control" />
        </div>

        <br/>

        <h3>Shipping Address for Products</h3>

        <div class="form-group">
            <label for="shippingStreet">Street Name</label>
            <form:input path="shippingAddress.streetName" id="shippingStreet" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippinghouseNumber">House Number</label>
            <form:input path="shippingAddress.houseNumber" id="houseNumber" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCity">City</label>
            <form:input path="shippingAddress.city" id="shippingCity" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="shippingAddress.state" id="state" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:input path="shippingAddress.country" id="country" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingZip">Zipcode</label>
            <form:input path="shippingAddress.zipCode" id="zip" class="form-Control" />
        </div>

        <br/><br/>

        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/" />" class="btn btn-default">Cancel</a>

        </form:form>



<%@ include file="footer.jsp" %>