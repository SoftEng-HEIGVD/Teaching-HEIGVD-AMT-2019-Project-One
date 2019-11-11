<%-- 
    Document   : login
    Created on : Sep 9, 2015, 11:37:49 AM
    Author     : Olivier Liechti (olivier.liechti@heig-vd.ch)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <base href="${pageContext.request.contextPath}/">

    <title>Login Page</title>

    <!-- Bootstrap core CSS -->
    <link href="./assets/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./assets/signin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <form method="POST" action="login" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="hidden" name="action" value="login">
        <input type="text" name="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name ="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
      <c:if test="${errs != null}">
        <ul>
          <c:forEach items="${errs}" var="err">
            <li>${err}</li>
          </c:forEach>
        </ul>
      </c:if>

    </div> <!-- /container -->

  </body>
</html>

