<%@include file="includes/header.jsp" %>


<div class="container-fluid">
    <c:forEach items="${classes}" var="class" varStatus="loop">
        <c:if test="${loop.index % 2 == 0}">
            <div class="row">
        </c:if>
        <a href="${pageContext.request.contextPath}/classInfo?id=${class.id}" class="col-6">
            <button class="btn btn-outline-dark">
                <img src="./images/favicon.ico">
                    <h2>${class.name}</h2>
            </button>
        </a>


        <c:if test="${loop.index % 2 == 1}">
            </div>
        </c:if>


    </c:forEach>

</div>
<%--<script>--%>
<%--    function redirect(id) {--%>
<%--        console.log(id)--%>
<%--        window.location.href = "${pageContext.request.contextPath}/classInfo?id="+id--%>
<%--    }--%>
<%--</script>--%>
<%@include file="includes/footer.jsp" %>