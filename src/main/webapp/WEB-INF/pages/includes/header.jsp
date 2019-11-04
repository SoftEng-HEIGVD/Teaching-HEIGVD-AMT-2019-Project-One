<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
    <link href="./bootstrap4/css/custom.css" rel="stylesheet"/>

    <link href="./select2/css/select2.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Risque&display=swap');
    </style>

</head>

<body>
<div class="wrapper">

    <div class="container-fluid">
        <a href="${pageContext.request.contextPath}/logout" style="color: orange">Logout</a>
        <c:if test="${sessionScope.character.isadmin}">
            <a href="${pageContext.request.contextPath}/admin" style="color: orange">admin</a>
        </c:if>
        <img class="mySlides" src="./images/banner.jpg" style="width:100%">

        <ul class="nav nav-pills nav-fill" style="background-color: orange">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/home" class="nav-link"><h3>Home</h3>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/characters" class="nav-link"><h3>
                    Characters</h3></a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/classes" class="nav-link"><h3>
                    Classes</h3></a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/guilds" class="nav-link"><h3>Guilds</h3>
                </a>
            </li>
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/profile" class="nav-link"><h3>
                    MyProfile</h3></a>
            </li>
        </ul>

