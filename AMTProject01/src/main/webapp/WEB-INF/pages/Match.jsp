<%-- 
    Document   : Match
    Created on : 31 oct. 2019, 15:02:15
    Author     : goturak
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<!doctype html>

<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, maximum-scale=1">

	<title>Homepage</title>
	<link rel="icon" href="favicon.png" type="image/png">
	<link rel="shortcut icon" href="favicon.ico" type="img/x-icon">

	<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,800italic,700italic,600italic,400italic,300italic,800,700,600' rel='stylesheet' type='text/css'>

	<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
	<link href="css/style.css" rel="stylesheet" type="text/css">
	<link href="css/font-awesome.css" rel="stylesheet" type="text/css">
	<link href="css/responsive.css" rel="stylesheet" type="text/css">
	<link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
	<link href="css/animate.css" rel="stylesheet" type="text/css">

	<script type="text/javascript" src="js/jquery.1.8.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	<script type="text/javascript" src="js/jquery-scrolltofixed.js"></script>
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	<script type="text/javascript" src="js/jquery.isotope.js"></script>
	<script type="text/javascript" src="js/wow.js"></script>
	<script type="text/javascript" src="js/classie.js"></script>
	<script type="text/javascript" src="js/magnific-popup.js"></script>
	<script src="contactform/contactform.js"></script>

	<!-- =======================================================
    Theme Name: Knight
    Theme URL: https://bootstrapmade.com/knight-free-bootstrap-theme/
    Author: BootstrapMade
    Author URL: https://bootstrapmade.com
	======================================================= -->

</head>

<body>


	<nav class="main-nav-outer" id="test">
		<!--main-nav-start-->
		<div class="container">
			<ul class="main-nav">
				<li><a href="matches.html">Matches</a></li>
                                <li><a href="teams.html">Teams</a></li>
				<li><a href="playersHtml.html">Players</a></li>

			</ul>
			<a class="res-nav_click" href="#"><i class="fa fa-bars"></i></a>
		</div>
	</nav>
	<!--main-nav-end-->


        <section class="main-section" id="TeamName">
    		<h2>${team.name}</h2>
			
	</section>
	<section class="main-section" id="players">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5 text-right wow fadeInRight delay-02s">

                       <c:if test="${empty match.team1}">
                                    <h2>No Team</h2>
                        </c:if>
                        <c:if test="${not empty match.team1}">
                            <h2>${mtch.team1.name}</h2>
                            <br>
                        </c:if>
                        <div class="">

                                <c:forEach items="${match.team1Players}" var="item">
                                    <a href="player?u=${item.userName}">
                                        <div class="service-list">
                                           
                                            <div class="service-list-col2">
                                               <h4>${item.userName}</h4>

                                                  
                                            </div>
                                      

                                        </div>
                                    </a>
                               </c:forEach>

                        </div>
                    </div>
                    
                    <div class="col-lg-2 text-Center wow fadeInUp delay-02s">
                        <h2>${match.team1EndScore}-${match.team2EndScore}</h2>
                       
                    </div>
                    
                    <div class="col-lg-5 text-left wow fadeInRight delay-02s">

                       <c:if test="${empty match.team1}">
                                    <h2>No Team</h2>
                        </c:if>
                        <c:if test="${not empty match.team1}">
                            <h2>${mtch.team2.name}</h2>
                        </c:if>
                        <div class="">

                                <c:forEach items="${match.team2Players}" var="item">
                                    <a href="player?u=${item.userName}">
                                        <div class="service-list">
                                           
                                            <div class="service-list-col2">
                                               <h4>${item.userName}</h4>

                                                  
                                            </div>
                                      

                                        </div>
                                    </a>
                               </c:forEach>

                        </div>
                    </div>
                </div>
                <!--main-section-start-->
		
            </div>
		
	</section>
                
       
	<!--main-section-end-->




	<footer class="footer">
		<div class="container">
			<div class="footer-logo"><a href="#"><img src="img/footer-logo.png" alt=""></a></div>
			<span class="copyright">&copy; Knight Theme. All Rights Reserved</span>
			<div class="credits">
				<!--
          All the links in the footer should remain intact.
          You can delete the links only if you purchased the pro version.
          Licensing information: https://bootstrapmade.com/license/
          Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Knight
        -->
				Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
			</div>
		</div>
	</footer>


	<script type="text/javascript">
		$(document).ready(function(e) {

			$('#test').scrollToFixed();
			$('.res-nav_click').click(function() {
				$('.main-nav').slideToggle();
				return false

			});

      $('.Portfolio-box').magnificPopup({
        delegate: 'a',
        type: 'image'
      });

		});
	</script>

	<script>
		wow = new WOW({
			animateClass: 'animated',
			offset: 100
		});
		wow.init();
	</script>


	<script type="text/javascript">
		$(window).load(function() {

			$('.main-nav li a, .servicelink').bind('click', function(event) {
				var $anchor = $(this);

				$('html, body').stop().animate({
					scrollTop: $($anchor.attr('href')).offset().top - 102
				}, 1500, 'easeInOutExpo');
				/*
				if you don't want to use the easing effects:
				$('html, body').stop().animate({
					scrollTop: $($anchor.attr('href')).offset().top
				}, 1000);
				*/
				if ($(window).width() < 768) {
					$('.main-nav').hide();
				}
				event.preventDefault();
			});
		})
	</script>

	<script type="text/javascript">

		$(window).load(function() {


			var $container = $('.portfolioContainer'),
				$body = $('body'),
				colW = 375,
				columns = null;


			$container.isotope({
				// disable window resizing
				resizable: true,
				masonry: {
					columnWidth: colW
				}
			});

			$(window).smartresize(function() {
				// check if columns has changed
				var currentColumns = Math.floor(($body.width() - 30) / colW);
				if (currentColumns !== columns) {
					// set new column count
					columns = currentColumns;
					// apply width to container manually, then trigger relayout
					$container.width(columns * colW)
						.isotope('reLayout');
				}

			}).smartresize(); // trigger resize to set container width
			$('.portfolioFilter a').click(function() {
				$('.portfolioFilter .current').removeClass('current');
				$(this).addClass('current');

				var selector = $(this).attr('data-filter');
				$container.isotope({

					filter: selector,
				});
				return false;
			});

		});
	</script>

</body>

</html>
