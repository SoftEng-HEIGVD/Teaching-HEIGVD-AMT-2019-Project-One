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
      <section class="jumbotron text-center" style="height: 300px;">
        <div class="container">
          <h1 class="jumbotron-heading" style="color: black;">Film rating app</h1>
        </div>
      </section>

      <div class="album py-5 bg-light">
        <div class="container">

          <div class="row">

            <c:forEach items="${films}" var="film">
              <div class="col-md-3">
                <div class="card mb-4 box-shadow">
                  <img class="card-img-top" alt="Thumbnail [100%x225]" style="height: 400px; width: 100%; display: block;" src="./assets/img/${film.moviePosterPath}" >
                  <div class="card-body" style="height: 130px">
                    <p class="card-text">${film.title}</p>
                    <div class="d-flex justify-content-between align-items-center">
                      <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Like</button>
                      </div>
                      <div>
                        <small class="text-muted">${film.runningTime} mins</small>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </div>
      </div>
    </main>

    <footer class="text-muted">
      <div class="container" style="margin-left: 40%;"> <!-- TODO : center nav in container -->
        <nav>
          <ul class="pagination">
            <!-- First page -->
            <li class="page-item">
              <a href="home">«</a>
            </li>
            <!-- Previous page -->
            <c:if test="${currentPage > 1}">
              <li class="page-item">
                <a href="home?page=${currentPage - 1}">‹</a>
              </li>
            </c:if>
            <!-- 2 prev pages, curr page, 2 next pages -->
            <c:forEach begin="${currentPage - 2}" end="${currentPage + 2}" var="i">
              <c:if test="${i >= 1 && i <= nbPages}">
                <c:choose>
                  <c:when test="${currentPage eq i}">
                    <li class="page-item">${i}</li>
                  </c:when>
                  <c:otherwise>
                    <li class="page-item">
                      <a href="home?page=${i}">${i}</a>
                    </li>
                  </c:otherwise>
                </c:choose>
              </c:if>
            </c:forEach>
            <!-- Next page -->
            <c:if test="${currentPage < nbPages}">
              <li class="page-item">
                <a href="home?page=${currentPage + 1}">></a>
              </li>
            </c:if>
            <!-- Last page -->
            <li class="page-item">
              <a href="home?page=${nbPages}">»</a>
            </li>
          </ul>
        </nav>
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