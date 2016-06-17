<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
 <title>Header</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <script src="./resources/js/jquery-1.12.4.min.js"></script>
  <script src="./resources/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">MusicHub</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li ><a href="#">Home</a></li>
        <li><a href="#">About Us</a></li>
        <li class="active"><a href="#">Contact Us</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>



<%@ include file="footer.jsp" %>

</body>
</html>