<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Home </title>
<meta name="description" content=" " >
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<script src="<c:url value="https://code.angularjs.org/1.3.0-beta.5/angular.js"/>"></script>   
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js" />"></script> 
<script src="<c:url value="/resources/js/jquery-1.12.4.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/script.js"/>"></script>

</head>
<div class="container" id="main">
<body>

<%@ include file="/WEB-INF/views/PagePlugIns/Navbar.jsp" %>
<div class="container" id="main">

	<%@ include file="/WEB-INF/views/PagePlugIns/Carousel.jsp" %>
	
	<br><br><br>
	
	<div class="row">
  <div class="col-md-4">
    <div class="thumbnail">
    <center>
      <img class= "img-responsive" src="<c:url value="/resources/images/flute.png"/>" height= 200px width=100px alt="MY LOGO" id="imageSupplier">
      <div class="caption">
        <h3> Flute </h3> 
        <p>Click here so that you can Search for all the Flute <br> Go ahead and take a look </p>
        <p><a href="<c:url value="/product/ListProduct?searchCondition=Flute"/>" class="btn btn-primary" role="button" aria-haspopup="true" aria-expanded="false"> Look Up!</a> </p> </center>
      </div>
    </div>
  <div class="col-md-4">
    <div class="thumbnail">
    <center>
      <img class= "img-responsive" src="<c:url value="/resources/images/tabla.png"/>" height= 100px width=100px alt="MY LOGO" id="imageCategory">
      <div class="caption">
        <h3> Tabla </h3> 
        <p>Click here so that you can search for all type of tabla</p>
        <p><a href="<c:url value="/product/ListProduct?searchCondition=Tabla"/>" class="btn btn-primary" role="button" aria-haspopup="true" aria-expanded="false"> Look Up!</a> </p> </center>
      </div>
    </div>
 
  <div class="col-md-4">
    <div class="thumbnail">
    <center>
      <img class= "img-responsive" src="<c:url value="/resources/images/sitar.png"/>" height= 100px width=100px alt="MY LOGO" id="imageSupplier">
      <div class="caption">
        <h3>Sitar</h3> 
        <p>Click here so that you can search for all Sitar</p>
        <p><a href="<c:url value="/product/ListProduct?searchCondition=Sitar"/>" class="btn btn-primary" role="button" aria-haspopup="true" aria-expanded="false"> Look Up!</a> </p> </center>
      </div>
    </div>
</div>
  </div>
   </div>
	
</div>
</div>
<%@ include file="/WEB-INF/views/PagePlugIns/Footer.jsp" %>
</body>

</html>
