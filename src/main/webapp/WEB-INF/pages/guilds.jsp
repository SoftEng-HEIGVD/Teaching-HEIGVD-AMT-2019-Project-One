<%@include file="includes/header.jsp" %>


<div class="container-fluid">
    <div class="container">
        <table class="table">
            <c:forEach items="${guilds}" var="guild" varStatus="loop">
                <c:if test="${loop.index % 2 == 0}">
                    <tr>
                </c:if>
                <td>
                    <table class="table">
                        <tr>
                            <td><img src="./images/${fn:replace(fn:toLowerCase(guild.name), ' ','')}.jpg"
                                     style="background-color: white; border-radius: 10px"></td>
                            <td>
                                <h3>${guild.name}</h3><br/>
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/guilds/info?id=${guild.id}">Learn more</a></br>
                            </td>
                        </tr>
                    </table>
                </td>
                <c:if test="${loop.index % 2 == 1}">
                    </tr>
                </c:if>


            </c:forEach>
        </table>
    </div>
</div>
<%@include file="includes/footer.jsp" %>