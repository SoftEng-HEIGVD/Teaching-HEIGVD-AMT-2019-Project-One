<%--
  Created by IntelliJ IDEA.
  User: jordan
  Date: 10/23/19
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Series</title>
</head>
<body>
<h2>Series</h2>
<ul>
    <c:forEach items="${series}" var="serie">
        <li>Titre: "${serie.title}"</li>
        <li>Genre: "${serie.genre}"</li>
        <li>Producer: "${serie.producer}"</li>
        <li>Age restriction: "${serie.ageRestriction}"</li>
        <li>Synopsis: "${serie.synopsis}"</li>

    </c:forEach>
</ul>
</body>
</html>