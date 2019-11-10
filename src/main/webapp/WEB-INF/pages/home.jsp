<!--
=========================================================
* Material Kit - v2.0.6
=========================================================

* Product Page: https://www.creative-tim.com/product/material-kit
* Copyright 2019 Creative Tim (http://www.creative-tim.com)
Licensed under MIT (https://github.com/creativetimofficial/material-kit/blob/master/LICENSE.md)


=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software. -->


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/favicon.png">
    <link rel="icon" type="image/png" href="./assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>
        Chillout
    </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link rel="stylesheet" type="text/css"
          href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="./assets/css/material-kit.css?v=2.0.6" rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="./assets/demo/demo.css" rel="stylesheet"/>
</head>

<body class="index-page sidebar-collapse">
<nav class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg" color-on-scroll="100"
     id="sectionsNav">
    <div class="container">
        <div class="navbar-translate">
            <a class="navbar-brand" href="./home?id=${sessionScope.user.id}" >
                Chillout </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="sr-only">Toggle navigation</span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
                <li class="dropdown nav-item">
                    <a class="nav-link" href="./products">
                        <i class="material-icons">storefront</i> Products
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./orders">
                        <i class="material-icons">shopping_cart</i> Orders
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./profile">
                        <i class="material-icons">profile</i> Profile
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="page-header header-filter clear-filter purple-filter" data-parallax="true"
     style="background-image: url('./assets/img/bg2.jpg');">
    <div class="container">
        <div class="row">
            <div class="col-md-8 ml-auto mr-auto">
                <div class="brand">
                    <h1>${requestScope.user.username}</h1>
                    <h3>Welcome to the chillout order service !</h3>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="footer" data-background-color="black">
    <div class="container">

    </div>
</footer>
<!--   Core JS Files   -->
<script src="./assets/js/core/jquery.min.js" type="text/javascript"></script>
<script src="./assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="./assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="./assets/js/plugins/moment.min.js"></script>
<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
<script src="./assets/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="./assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!--  Google Maps Plugin    -->
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
<script src="./assets/js/material-kit.js?v=2.0.6" type="text/javascript"></script>

</body>

</html>
