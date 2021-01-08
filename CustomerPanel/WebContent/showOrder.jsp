<html lang="en">
<head>
<title>show order</title>
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
.login-form input[type="number"], .login-form textarea {
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
</style>


</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<!-- banner -->
	<div id="home" class="w3ls-banner ">
		<%@ include file="header.jsp"%>
		<!-- banner-text -->
		<br>
		<br>
		<br>
		
		<div class="banner-text">
			<div class="container">
				<div class="flexslider">
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
						<%@ page import="com.bean.Placeorderbean,com.deo.Placeorderdeo,java.io.*" %>
						<%
						//int custid = ((Integer)request.getAttribute("custid")).intValue();
						int orderid = ((Integer)request.getAttribute("orderid")).intValue();
					    session.setAttribute("orderid",orderid);
						Placeorderbean pc = Placeorderdeo.getRecordById(orderid);
						%>
							<div id="register" class="login-form ">
								<div class="agile-row">
									<h5>Your order</h5>
									<label><%= orderid %></label>
									<div class="login-agileits-top">
										<form>
											<div class="row">
												<div class="col-md-5">
													<label>Vehicle number</label>
												</div>
												<div class="col-md-7">
													<label><%= pc.getVehino()%></label>
												</div>
											</div>
											<br>
											<div class="row">
												<div class="col-md-5">
													<label>Brand</label>
												</div>
												<div class="col-md-7">
													<label><%= pc.getBrand()%></label>
												</div>
											</div>
											<br>
											<div class="row">
												<div class="col-md-5">
													<label>Model</label>
												</div>
												<div class="col-md-7">
													<label><%= pc.getModel()%></label>
												</div>
											</div>
											<br>
											<div class="row">
												<div class="col-md-5">
													<label>Services</label>
												</div>
												<div class="col-md-7">
													<label><%= pc.getServices()%></label>
												</div>
											</div>
											<br>
											<div class="row">
												<div class="col-md-5">
													<label>Expected time</label>
												</div>
												<div class="col-md-7">
													<label><%= pc.getExptime()%></label>
												</div>
											</div>
											<br>
											
											<input type="submit" value="Edit" onclick="document.forms[0].action = 'orderEdit.jsp'; return true;">
											<input type="submit" value="Submit" onclick="document.forms[0].action = 'ordersuccess.jsp'; return true;">				
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3"></div>
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