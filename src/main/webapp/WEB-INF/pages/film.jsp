<%--
  Created by IntelliJ IDEA.
  User: Stephane
  Date: 27.10.19
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/docs/4.0/assets/img/favicons/favicon.ico">

    <title>Film rating app</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">

    <!-- Bootstrap core CSS -->
    <link href="./assets/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./assets/album.css" rel="stylesheet">
  </head>

  <body>

    <header>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <strong>Film rating app</strong>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="true" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </div>
    </header>

    <main role="main">
      <div class="album py-5 bg-light">
        <div class="container">

          <div class="row">
            <div class="col-md-6">
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" alt="Thumbnail [100%x225]" style="height: 100%; width: 100%; display: block;" src="./assets/img/${film.moviePosterPath}">
              </div>
            </div>

            <div class="col-md-6">
              <div class="card mb-4 box-shadow">
                <div class="card-body" style="height: 100%">

                  <div style="display: inline-block; width:80%">
                    <p class="card-text" style="font-size: 2em;">${film.title}</p>
                  </div>
                  <div style="margin-bottom: 20px;">
                    <small class="text-muted">${film.runningTime} mins</small>
                  </div>
                  <p class="card-text" style="font-size: 1.5em;">Director : ${film.director}</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <footer class="text-muted">
      <div class="container">
        <p class="float-right">
          <a href="#">Back to top</a>
        </p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="./assets/jquery-3.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="./assets/popper.js"></script>
    <script src="./assets/bootstrap.js"></script>
    <script src="./assets/holder.js"></script>
  

<svg xmlns="http://www.w3.org/2000/svg" width="348" height="225" viewBox="0 0 348 225" preserveAspectRatio="none" style="display: none; visibility: hidden; position: absolute; top: -100%; left: -100%;"><defs><style type="text/css"></style></defs><text x="0" y="17" style="font-weight:bold;font-size:17pt;font-family:Arial, Helvetica, Open Sans, sans-serif">Thumbnail</text></svg></body></html>