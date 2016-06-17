<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>LoginSuccess</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <script src="./resources/js/jquery-1.12.4.min.js"></script>
  <script src="./resources/js/bootstrap.min.js"></script>
</head>
<body>
 <script src="./resources/js/jquery-1.12.4.min.js"></script>
  <script src="./resources/js/bootstrap.min.js"></script>
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
        <li class="active"><a href="#">Home</a></li>
       <li><a href="#">AboutUs</a></li>
        <li><a href="#">Contact Us</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
       <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> My Profile<strong class="caret"></strong></a>
          <ul class="dropdown-menu">
            <li><a href="#">Setting</a></li>
            <li><a href="#">WishList</a></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<%@ include file="footer.jsp" %>
</body>
</html>