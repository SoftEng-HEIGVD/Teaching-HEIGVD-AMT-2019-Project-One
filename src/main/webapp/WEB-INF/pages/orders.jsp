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
    <title>JSP Page</title>
</head>
<body>

<ch1>Orders</ch1>
<table>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.idClient}</td>
            <td>${order.command}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
