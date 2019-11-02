<%@include file="includes/header.jsp" %>

<div class="container">
    <table class="table text-center">
        <thead>
        <tr>
            <th><h1><u>Character</u></h1></th>
            <th><h1><u>Mount</u></h1></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <table class="table text-center myProfile" >
                    <tr>
                        <td colspan="2"><img class="mySlides" src="./images/mage.jpg" style="width:50%"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><h1>${sessionScope.character.name}</h1></td>
                    </tr>
                    <tr>
                        <td>
                            Class :</td>
                        <td>${sessionScope.character.myClass.name}</td>
                    </tr>
                    <tr>
                        <td>Level :</td>
                        <td>${sessionScope.character.level}</td>
                    </tr>
                    <tr>
                        <td>Health :</td>
                        <td>${sessionScope.character.health}</td>
                    </tr>
                    <tr>
                        <td>Stamina :</td>
                        <td>${sessionScope.character.stamina}</td>
                    </tr>
                    <tr>
                        <td>Mana :</td>
                        <td>${sessionScope.character.mana}</td>
                    </tr>
                </table>

            </td>
            <td>
                <table class="table text-center myProfile">
                    <tr>
                        <td colspan="2"><img class="mySlides" src="./images/mage.jpg" style="width:50%"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><h1>${sessionScope.character.mount.name}</h1></td>
                    </tr>
                    <tr>
                        <td>Speed :</td>
                        <td>${sessionScope.character.mount.speed}</td>
                    </tr>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
</div>

<div class="text-center">
    <h1>Guild memberships :</h1>
</div>
<div class="container-fluid" style="background-color: dimgrey">
    <div class="form-group">
        <table class="table">
            <c:forEach items="${memberships}" var="membership" varStatus="loop">
                <c:if test="${loop.index % 3 == 0}">
                    <tr>
                </c:if>
                <td>
                    <table>
                        <tr>
                            <td>
                                <img src="./images/${fn:replace(fn:toLowerCase(membership.guild.name), ' ', '')}.jpg" />
                            </td>
                            <td>
                                <h4>${membership.guild.name}</h4></br>
                                <h4>Rank : ${membership.rank}</h4></br>
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/guilds/info?id=${membership.guild.id}">Learn more</a></br>
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/guilds/leave?id=${membership.guild.id}">Leave</a>
                            </td>
                        </tr>
                    </table>
                </td>
                <c:if test="${loop.index % 3 == 2}">
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="includes/footer.jsp" %>