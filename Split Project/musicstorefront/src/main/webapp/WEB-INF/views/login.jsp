<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<title>Login Page</title>
</head>
<body>
<%@ include file="header.jsp"%>
	<br><br><br><br><br><br><br>
	<div class="container" align="center" id="login" > 
	<p align="center">Enter Your Login Details</p>
	<form action="<c:url value="/j_spring_security_check" />" method="POST">
   Enter User Name:<input type="text" name="name">
		<br /><br>
   Enter Password :<input type="password" name="password" />
		<br /><br>
		<input type="submit" value="Login" align="middle">
		<input type="reset" value="Reset" align="middle">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

	</form>
${message}
</div>
<br><br><br><br><br><br><br>
<br><br><br><br><br><br><br>
<%@ include file="footer.jsp"%>
</body>
</html>