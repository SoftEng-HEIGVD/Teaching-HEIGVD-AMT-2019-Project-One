<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>

    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>Dungeons & Unicorns</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport'/>
    <meta name="viewport" content="width=device-width"/>

    <base href="${pageContext.request.contextPath}/"/>

    <link rel="icon" type="image/png" href="./images/favicon.ico">

    <link href="./bootstrap4/css/bootstrap.css" rel="stylesheet"/>
    <link href="./bootstrap4/css/bootstrap-grid.css" rel="stylesheet"/>
    <link href="./bootstrap4/css/bootstrap-reboot.css" rel="stylesheet"/>
    <link href="./bootstrap4/css/bootstrap-theme.css" rel="stylesheet"/>
    <link href="./bootstrap4/css/font-awesome.css" rel="stylesheet"/>

    <style>
        @import url('https://fonts.googleapis.com/css?family=Risque&display=swap');
    </style>



</head>
<body style="background-color: black">



<div class="wrapper">
    <div class="container-fluid">
        <img class="mySlides" src="./images/banner.jpg" style="width:100%">
    </div>
    <div class="container">
        <form id="loginForm" method="post" action="${pageContext.request.contextPath}/login">
            <div class="form-group">
                <label for="usernameField">Username</label>
                <input type="text" class="form-control" id="usernameField" name="username">
            </div>
            <div class="form-group">
                <label for="passwordField">Password</label>
                <input type="password" class="form-control" id="passwordField" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Sign in</button>
        </form>
        <c:if test="${errors != null}">
            Errors:
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </c:if>
    </div>



    <div class="container">
        New to Dungeons and Unicorns ?
        <a href="${pageContext.request.contextPath}/register" style="color: #2C93FF">Sign up !</a>
    </div>
</div>

</body>

<script src="./bootstrap4/js/bootstrap.js" type="text/javascript"></script>
<script src="./bootstrap4/js/bootstrap.bundle.js" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>


</html>

