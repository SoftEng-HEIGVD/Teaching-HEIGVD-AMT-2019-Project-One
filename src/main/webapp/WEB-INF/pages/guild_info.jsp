<%@include file="includes/header.jsp" %>


<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>
                <a href="${pageContext.request.contextPath}/guilds">
                    <i class="btn btn-primary fas fa-arrow-left">Back</i>
                </a>
            </th>
        </tr>
        <tr>
            <th>
                <h2>${guild.name}:</h2>
            </th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                ${guild.description}
            </td>
            <td>
                <img src="./images/${fn:replace(fn:toLowerCase(guild.name), ' ','')}.jpg"
                     style="background-color: white; border-radius: 10px">
            </td>
        </tr>
        <tr>
            <td>
                <c:if test="${currentCharMembership != true}">
                    <a class="btn btn-primary"
                       href="${pageContext.request.contextPath}/guilds/join?id=${guild.id}">Join</a>
                </c:if>
            </td>
        </tr>
        </tbody>
    </table>

</div>

<%@include file="includes/footer.jsp" %>