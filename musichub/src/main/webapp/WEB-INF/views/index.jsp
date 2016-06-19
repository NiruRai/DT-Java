<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<html>
<title>Home</title>
<%-- <meta name="description" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<link rel="stylesheet"
	href="<c:url value="./resources/css/bootstrap.min.css" />" />
<script src="<c:url value="./resources/js/jquery-1.12.4.min.js" />"></script>
<script src="<c:url value="./resources/js/bootstrap.min.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="./resources/css/styles.css" />" /> --%>
	<%@ include file="header.jsp"%>
<body>

	

	<div class="carousel slide" id="myCarousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li class="active" data-slide-to="0" data-target="#myCarousel"></li>
			<li data-slide-to="1" data-target="#myCarousel"></li>
			<li data-slide-to="2" data-target="#myCarousel"></li>
		</ol>
		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active" id="slide1">
				<div class="carousel-caption">
					<h4>Music is here</h4>
					<p>Feel the music and buy your choice you have all the options
						here!!</p>
				</div>
				<!-- end carousel-caption -->
			</div>
			<!-- end item -->

			<div class="item" id="slide2">
				<div class="carousel-caption">
					<h4>Songs are here</h4>
					<p>Listen the song and buy your choice you have all the options
						here!!</p>
				</div>
				<!-- end carousel-caption -->
			</div>
			<!-- end item -->

			<div class="item" id="slide3">
				<div class="carousel-caption">
					<h4>Life is happy with songs</h4>
					<p>Feel the music,Listen the song and buy your choice you have
						all the options here!!!</p>
				</div>
				<!-- end carousel-caption -->
			</div>
			<!-- end item -->
		</div>
		<!-- end carousel-inner -->

		<!-- Controls -->
		<a class="left carousel-control" data-slide="prev" href="#myCarousel"><span
			class="icon-prev"></span></a> <a class="right carousel-control"
			data-slide="next" href="#myCarousel"><span class="icon-next"></span></a>
	</div>
	<!-- end myCarousel -->


	<div class="row" id="features">

		<div class="col-sm-4 feature">
			<img src="<c:url value="resources/images/tabla.png" />" alt="
				MusicHub" class="img-circle">
			<h3>Tabla</h3>
		</div>
		<!-- end col-sm-4 -->

		<div class="col-sm-4 feature" id="middle-slide">
			<img src="<c:url value="resources/images/sitar.png" />" alt="
				MusicHub" class="img-circle">
			<h3>Sitar</h3>
		</div>
		<!-- end col-sm-4 -->

		<div class="col-sm-4 feature" id="last-slide">
			<img src="<c:url value="resources/images/flute1.png" />" alt="MusicHub"
				class="img-circle">
			<h3>Flute</h3>
		</div>
		<!-- end col-sm-4 -->
	</div>
	<!-- end row -->

	<script>
		$('.carousel').carousel({
			interval : 6000
		})
	</script>

	<%-- <%@ include file="footer.jsp"%> --%>

</body>
</html>
