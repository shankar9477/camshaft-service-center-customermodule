<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%--  <%@page import="java.text.SimpleDateFormat"%>  --%>
<html lang="en">
<head>
<title>Workorder</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Car Trade Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<!-- Custom Theme files -->
<link href="css/bootstrap.css" type="text/css" rel="stylesheet"
	media="all">
<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
<link href="css/font-awesome.css" rel="stylesheet">
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<!-- flexslider-CSS -->
<link rel="stylesheet" href="css/chocolat.css" type="text/css"
	media="screen">
<!-- //Custom Theme files -->
<!-- js -->
<script src="js/jquery-2.2.3.min.js"></script>
<!-- //js -->
<!-- web-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Aguafina+Script"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Petit+Formal+Script"
	rel="stylesheet">
<!-- //web-fonts -->

<style type="text/css">
.login-form input[type="number"], .login-form input[type="date"], .login-form textarea, .login-form select {
	outline: none;
	font-size: 1em;
	color: #999;
	padding: .7em 1em;
	margin: 0;
	width: 100%;
	border: 1px solid #ddd;
	-webkit-appearance: none;
	display: block;
	background: transparent;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	-o-border-radius: 2px;
	-ms-border-radius: 2px;
	border-radius: 2px;
}

button {
	font-size: 1.1em;
	color: #fff;
	background: #ffc107;
	border: 1px solid #ffc107;
	outline: none;
	cursor: pointer;
	padding: .7em 1em;
	-webkit-appearance: none;
	text-transform: uppercase;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	-ms-border-radius: 2px;
	-o-border-radius: 2px;
	border-radius: 2px;
	margin-top: 2em;
	transition: 0.5s all;
	-webkit-transition: 0.5s all;
	-moz-transition: 0.5s all;
	-o-transition: 0.5s all;
	-ms-transition: 0.5s all;
}

.rightside {
	text-align: right;
}
.name-and-date p{
	font-size: 0.9em;
    color: #000;
    margin: 1.5em 0 .5em;
    letter-spacing: 6px;
}
.name-and-date.dateclass{
	text-align: right;
}
hr { 
  display: block;
  margin-top: 0.5em;
  margin-bottom: 0.5em;
  margin-left: auto;
  margin-right: auto;
  border-style: inset;
  border-width: 1px;
} 
</style>


</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<!-- banner -->
	<div id="home" class="w3ls-banner ">
		<%@ include file="header.jsp"%>
		<!-- banner-text -->
		<%@ page import="com.bean.Customerbean,com.deo.CustomerRegistrationdeo,java.io.*" %>
		
		<%
					int custid = ((Integer)request.getAttribute("custid")).intValue();
						
					session.setAttribute("custid",custid); //send custid
					
					Customerbean cc = CustomerRegistrationdeo.getUsername(custid);
				%>
		<!-- Change -->
		<%-- <%@ page import="com.bean.customerworkorderbean,com.deo.customerworkorderdeo,java.util.*" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
		
		<br>
		<br>
		<br>
		<div class="banner-text">
			<div class="container">
				<div class="flexslider">
					<div class="row">
						<div id="register" class="login-form ">
							<div class="agile-row">
							<%-- <%
								List<Placeorderbean> list = Placeorderdeo.getAllRecords();
								request.setAttribute("list",list);
							%> --%>
								<div class="row">
									<div class="col-md-6">
										<button type="button" onclick="window.location.href='register.jsp'">Edit Profile</button>
									</div>
									<div class="col-md-6">
										<div class="rightside">
											<label><%= request.getAttribute("username")%></label>
											<button type="button" value="logout">Logout</button>
										</div>
								</div>
								</div>
								<br><br>
								<h5>Workorder Form</h5>
								<div class="name-and-date">
									<div class="row">
										<div class="col-md-6">
											<label><%= cc.getCustname() %></label>
										</div>
										<div class="col-md-6" align="right">
											<%-- <%
												/* java.util.Date d = new java.util.Date();
												SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy"); */
												SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
												  String date = sdf.format(new Date());
											%>
											<label><%= date %></label>
											<%
											session.setAttribute("date",date);
											%> --%>
										</div>
									</div>
								</div>
								<br>
								<hr>
								<br>
								<div class="login-agileits-top">
									<form action="PlaceorderServlet" method="post">
										<p>Vehicle number</p>
										<input type="text" class="name" name="vehino" required=""/>
										<p>Brand</p>
										<select id="brand" name="brand">
											<option value="">Select any</option>
  											<option value="volvo">Volvo</option>
  											<option value="bmw">BMW</option>
  											<option value="mercedes">Mercedes</option>
  											<option value="audi">Audi</option>
										</select>
										<p>Model</p>
										<input type="text" class="name" name="model" required=""/>
										<p>Services</p>
									 <select id="services" name="services">
											<option value="">Select </option>
  											<option value="fullcheckup">Full checkup</option>
  											<option value="oilandfilterchange">Oil and filter change</option>
  											<option value="wheelcheckupedes">Wheel checkup</option>
  											<option value="vehiclewash">Vehicle wash</option>
										</select> -->
										<p>Expected time</p>
										<input type="date" class="name" name="exptime" required=""/>
										
										<input type="submit" value="Place Order">
										
									</form>
								</div>
							</div>
						</div>

					</div>

				</div>

			</div>
		</div>
		<!-- //banner-text -->
	</div>

	<!-- //banner -->
	<br>
	<!-- footer -->
	<%@ include file="footer.jsp"%>
	<!-- /footer -->

	<!-- timer scripts -->
	<script type="text/javascript" src=" js/moment.js"></script>
	<script type="text/javascript" src=" js/moment-timezone-with-data.js"></script>
	<script type="text/javascript" src="js/timer.js"></script>
	<!-- //timer scripts -->
	<!-- start-smooth-scrolling -->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();

				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 1000);
			});
		});
	</script>
	<!-- //end-smooth-scrolling -->
	<!-- smooth-scrolling-of-move-up -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //smooth-scrolling-of-move-up -->
	<!-- Scrolling Nav JavaScript -->
	<script src="js/scrolling-nav.js"></script>
	<!-- //fixed-scroll-nav-js -->
	<!-- bth hover effect -->
	<script>
		$(function() {
			$('.btn-6').on(
					'mouseenter',
					function(e) {
						var parentOffset = $(this).offset(), relX = e.pageX
								- parentOffset.left, relY = e.pageY
								- parentOffset.top;
						$(this).find('span').css({
							top : relY,
							left : relX
						})
					}).on(
					'mouseout',
					function(e) {
						var parentOffset = $(this).offset(), relX = e.pageX
								- parentOffset.left, relY = e.pageY
								- parentOffset.top;
						$(this).find('.btn-6 span').css({
							top : relY,
							left : relX
						})
					});
		});
	</script>
	<!-- //bth hover effect -->
	<!-- jarallax -->
	<script src="js/jarallax.js"></script>
	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed : 0.5,
			imgWidth : 1366,
			imgHeight : 768
		})
	</script>
	<!-- //jarallax -->
	<!-- FlexSlider -->
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			$('.flexslider').flexslider({
				animation : "slide",
				start : function(slider) {
					$('body').removeClass('loading');
				}
			});
		});
	</script>
	<!-- //End-FlexSlider -->
	<!-- pop-up-script -->
	<script src="js/jquery.chocolat.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.view-seventh a').Chocolat();
		});
	</script>
	<!-- //pop-up-script -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/bootstrap.js"></script>
</body>
</html>