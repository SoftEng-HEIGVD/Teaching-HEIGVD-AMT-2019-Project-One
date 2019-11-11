<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        Chillout - Products
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
<body>
<jsp:include page="include/nav.jsp"/>


<div class="container">
    <div class="row">
        <div class="brand">
            <h1>Products</h1>
        </div>

<%--        <c:forEach items="${products}" var="product">--%>
<%--            <div class="card" style="width: 20rem;">--%>
<%--                <img class="card-img-top"--%>
<%--                     src="./assets/img/photo_not_found.gif"--%>
<%--                     alt="${product.name}">--%>
<%--                <div class="card-body">--%>
<%--                    <h1 class="card-text">${product.name}</h1>--%>
<%--                    <p class="card-text">${product.description}</p>--%>
<%--                    <h3 class="card-text">Unit price : ${product.unitPrice}</h3>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
    </div>


    <%--        <c:if test="${sessionScope.user.isAdmin == true}">--%>
    <div class="text-center">
        <a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modalProduct">Add product</a>
    </div>

    <div class="modal fade" id="modalProduct" tabindex="-1" data-backdrop="false">
        <div class="modal-dialog modal-login" role="document">
            <div class="modal-content">
                <div class="card card-signup card-plain">
                    <div class="modal-body">
                        <form class="form" method="post" action="./products">
                            <p class="description text-center">Add product</p>
                            <div class="card-body">
                                <div class="form-group bmd-form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="material-icons">face</i></div>
                                        </div>
                                        <label>
                                            Name
                                            <input name="name" type="text" class="form-control" placeholder="Name">
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group bmd-form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="material-icons">face</i></div>
                                        </div>
                                        <label>
                                            Unit Price
                                            <input name="price" type="text" class="form-control" placeholder="Unit Price">
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group bmd-form-group">
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <div class="input-group-text"><i class="material-icons">face</i></div>
                                        </div>
                                        <label>
                                            Description
                                            <input name="desc" type="text" placeholder="Description" class="form-control">
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer justify-content-center">
                                <button type="submit" class="btn btn-primary btn-link btn-wd btn-lg">Update</button>
                                <button type="button" class="btn btn-outline-info waves-effect ml-auto"
                                        data-dismiss="modal">Close
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--        </c:if>--%>
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
