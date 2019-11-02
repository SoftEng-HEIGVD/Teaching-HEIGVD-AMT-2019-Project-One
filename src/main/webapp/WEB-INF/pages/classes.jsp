<%@include file="includes/header.jsp" %>


<div class="container-fluid">
    <table class="table">
        <c:forEach items="${classes}" var="class" varStatus="loop">
            <c:if test="${loop.index % 2 == 0}">
                <tr>
            </c:if>
            <td>
            <a href="${pageContext.request.contextPath}/classInfo?id=${class.id}">
                <button class="btn btn-outline-dark" style="width: 50%">
                    <h2 style="color: white"><img src="./images/icons/${fn:toLowerCase(class.name)}.jpeg" style="background-color: white; border-radius: 10px"> ${class.name}</h2>
                </button>
            </a>

            </td>
            <c:if test="${loop.index % 2 == 1}">
                </tr>
            </c:if>


        </c:forEach>
    </table>

</div>
<%--<script>--%>
<%--    function redirect(id) {--%>
<%--        console.log(id)--%>
<%--        window.location.href = "${pageContext.request.contextPath}/classInfo?id="+id--%>
<%--    }--%>
<%--</script>--%>
<%@include file="includes/footer.jsp" %>