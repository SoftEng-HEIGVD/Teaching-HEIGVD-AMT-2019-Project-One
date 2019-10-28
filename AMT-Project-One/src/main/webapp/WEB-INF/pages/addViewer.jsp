<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>AMT Project One</title>

    <!-- Custom fonts for this template-->
    <link href="../assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../assets/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Ajouter un viewer</h1>
                        </div>
                        <form class="user" method="POST" action="./addviewer">
                            <div class="form-group">
                                <input type="text" name="firstname" class="form-control form-control-user" placeholder="Prénom">
                            </div>
                            <div class="form-group">
                                <input type="text" name="lastname" class="form-control form-control-user" placeholder="Nom">
                            </div>
                            <div class="form-group">
                                <input type="text" name="username" class="form-control form-control-user" placeholder="Nom d'utilisateur">
                            </div>
                            <select name="genre">
                                <option value="Genre" selected>--- Genre ---</option>
                                <option value="Homme">Homme</option>
                                <option value="Femme">Femme</option>
                                <option value="Non binaire">Non binaire</option>
                                <option value="Androgyne">Androgyne</option>
                            </select>
                            <div class="form-group">
                                <input type="text" name="birthdate" class="form-control form-control-user" placeholder="Date de naissance: yyyy-mm-dd">
                            </div>
                            <input type="submit" class="btn btn-primary btn-user btn-block" value="Ajouter"/>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="#">Retour</a>
                        </div>
                        <c:if test="${errors != null}">
                            <hr>
                            Erreurs:
                            <ul>
                                <c:forEach items="${errors}" var="error">
                                    <li>${error}</li>
                                </c:forEach>
                            </ul>
                        </c:if>
                        <c:if test="${stateOfCreation != null}">
                            <p>${stateOfCreation}</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="../assets/vendor/jquery/jquery.min.js"></script>
<script src="../assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="../assets/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="../assets/js/sb-admin-2.min.js"></script>

</body>

</html>