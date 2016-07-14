<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<head>
<title>Header</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />" />
	<script src="<c:url value="/resources/js/jquery-1.12.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/script.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/styles.css" />" />
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">MusicHub</a>
			</div>

			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<c:url value="/" />">Home</a></li>
					<li><a href="aboutUs">About Us</a></li>
					<li><a href="contactUs">Contact Us</a></li>
					<li><a href="userCategory">All Category</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<c:if test="${pageContext.request.userPrincipal.name != null}">

						<li><a><span class="glyphicon glyphicon-user"></span>Welcome
								${pageContext.request.userPrincipal.name}</a></li>

							<li><a href="#">Setting</a></li>
							<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
						
						<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">

							<li><a href="<c:url value="/customer/cart" />">User Cart</a></li>

						</c:if>
						<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">

							<li><a href="<c:url value="/admin" />">Administrator</a></li>

						</c:if>

					</c:if>


					<c:if test="${pageContext.request.userPrincipal.name == null}">

						<li><a href="login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>

						<li><a href="#"><span class="glyphicon glyphicon-user"></span>
								Sign Up</a></li>

					</c:if>



				</ul>
			</div>
		</div>
	</nav>

</body>
</html>
