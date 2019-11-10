<%--
  Created by IntelliJ IDEA.
  User: jeremy
  Date: 10.11.19
  Time: 12:18
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
        Chillout - Profile
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
<div class="page-header header-filter"
     style="background-image: url('../../assets/img/bg8.jpg'); background-size: cover; background-position: top center;">
    <div class="container">

        <div class="row">
            <form>
                <label>
                    Name
                    <input class="form-control" type="text" placeholder="${sessionScope.user.name}" readonly>
                </label>
                <label>
                    Username
                    <input class="form-control" type="text" placeholder="${sessionScope.user.username}" readonly>
                </label>
            </form>
<%--            <label>--%>
<%--                Admin--%>
<%--                <input class="form-control" type="text" placeholder="${sessionScope.user.isAdmin}" readonly>--%>
<%--            </label>--%>
        </div>
        <div class="text-center">
            <a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modalLoginForm">Change
                Username</a>
        </div>

        <div class="modal fade" id="modalLoginForm" tabindex="-1" data-backdrop="false">
            <div class="modal-dialog modal-login" role="document">
                <div class="modal-content">
                    <div class="card card-signup card-plain">
                        <div class="modal-body">
                            <form class="form" method="post" action="./profile">
                                <p class="description text-center">Edit profile</p>
                                <div class="card-body">
                                    <div class="form-group bmd-form-group">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="material-icons">face</i></div>
                                            </div>
                                            <label>
                                                New Username
                                                <input name="new_user" type="text" class="form-control"
                                                       value="${sessionScope.user.username}">
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group bmd-form-group">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="material-icons">face</i></div>
                                            </div>
                                            <label>
                                                Old Username
                                                <input name="old_user" type="text" class="form-control"
                                                       value="${sessionScope.user.username}" readonly>
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group bmd-form-group">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="material-icons">face</i></div>
                                            </div>
                                            <label>
                                                Name
                                                <input name="name" type="text"
                                                       value="${sessionScope.user.name}" class="form-control">
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
    </div>
</div>
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
