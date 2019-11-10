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
    <title>Chillout - Products</title>
</head>
<body>

<ch1>Products ${requestScope.session.user}</ch1>
<table>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.unitPrice}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
