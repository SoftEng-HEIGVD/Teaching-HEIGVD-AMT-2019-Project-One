S<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: radame
  Date: 04/11/19
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/favicon.png">
    <link rel="icon" type="image/png" href="./assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>
        Chillout - Orders
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
<body class="sidebar-collapse">

<jsp:include page="include/nav.jsp"/>


<div class="container">
    <div class="row">
        <h1>Orders</h1>
        <c:forEach items="${orders}" var="order">
            <c:if test="${(order.idClient == sessionScope.user.id)}">
                <div class="card" style="width: 20rem;">
                    <div class="card-body">
                        <h1 class="card-text">${order.id}</h1>
                        <p class="card-text">Order was made by : ${sessionScope.user.name}</p>
                        <button class="btn btn-round" data-toggle="modal" data-target="#orderModal">
                            <i class="material-icons">shopping_cart</i>
                            Show more
                        </button>

                        <div class="modal fade" id="orderModal" tabindex="-1" role="dialog">
                            <div class="modal-dialog modal-signup" role="document">
                                <div class="modal-content">
                                    <div class="card card-plain">
                                        <div class="modal-header">
                                            <h5 class="modal-title card-title">More info</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <i class="material-icons">clear</i>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row">
                                                <div>
                                                    <p>
                                                        ${order.idClient}
                                                    </p>
                                                    <p>
                                                        <c:forEach items="${sessionScope.products}" var="product">
                                                            <c:if test="${(order.command.idProduit == sessionScope.products.id)}">
                                                                product.name
                                                            </c:if>
                                                        </c:forEach>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>

<!--   Core JS Files   -->
<script src="assets/js/core/jquery.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
<script src="assets/js/plugins/moment.min.js"></script>
<!--	Plugin for the Datepicker, full documentation here: https://github.com/Eonasdan/bootstrap-datetimepicker -->
<script src="assets/js/plugins/bootstrap-datetimepicker.js" type="text/javascript"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<!--  Google Maps Plugin  -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="https://buttons.github.io/buttons.js"></script>
<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
<script src="assets/js/material-kit.js?v=2.0.6" type="text/javascript"></script>
</body>


</html>
