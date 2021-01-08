<html lang="en">
<head>
<title>Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta name="keywords"
	content="Car Trade Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
	SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
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
<script type="text/javascript">
	function wm(id, t) {
		if (document.getElementById(id).value.length == 0) {
			alert(t + "will be filled out");
		}

	}
</script>


</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
	<!-- banner -->
	

	
	
	<div id="home" class="w3ls-banner ">
		<%@ include file="header.jsp"%>
		
		<br>
		<br>
		<br>
		<div class="banner-text">
			<div class="container">
				<div class="flexslider">
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div id="register" class="login-form">
								<div class="agile-row">
									<h5>Register Form</h5>
									<div class="login-agileits-top">
										<form action="CustomerRegServlet" method="post">
											<p>Name</p>
											<input type="text" class="name" name="name" required/>
											<p>Email</p>
											<input type="email" class="email" name="email" required />
											<p>Password</p>
											<input type="password" class="password" name="password" required /><br>
								
											<p>Address</p>
											<textarea class="address" rows="4" name="address" required></textarea>
											<p>State</p>
											<input type="text" class="state" name="state" required />
											<p>Mobile no.</p>
											<input type="text" class="number" name="mobile" required />
											
  <!-- Trigger the modal with a button -->
  <center>
  <button type="submit" class="btn btn-info btn-lg" value="submit" data-toggle="modal" data-target="#myModal">Register</button>
</center>
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <!-- <button type="button" class="submit" data-target="modal">&times;</button> -->
          <h4 class="modal-title">Success</h4>
        </div>
        <div class="modal-body">
          <p>Please Register If you are a New User</p>
        </div>
        <div class="modal-footer">
        <center>
        <button type="button" class="btn btn-default" data-dismiss="modal">Register Now</button>
          <button type="submit"  class="btn btn-default" onclick="window.location.href='login.jsp'" data-dismiss="modal">Sign In</button>
        </center>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
												
								<!-- <button class="btn btn-primary" type="submit"
												value="submit" href="login.jsp">Register</button>
									 -->	
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