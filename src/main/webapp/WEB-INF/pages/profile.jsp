<%@include file="includes/header.jsp" %>

<!-- Character -->
<div>
    <h3>Character : </h3>
</div>
<div>
    <img class="mySlides" src="./images/mage.jpg" style="width:10%">
</div>
<div>
    <h2>${sessionScope.character.name}</h2>
</div>
<table>
    <tr>
        <th>Class :</th>
        <th>${sessionScope.character.myClass.name}</th>
    </tr>
    <tr>
        <th>Level :</th>
        <th>${sessionScope.character.level}</th>
    </tr>
    <tr>
        <th>Health :</th>
        <th>${sessionScope.character.health}</th>
    </tr>
    <tr>
        <th>Stamina :</th>
        <th>${sessionScope.character.stamina}</th>
    </tr>
    <tr>
        <th>Mana :</th>
        <th>${sessionScope.character.mana}</th>
    </tr>
</table>

<!-- Mount -->
<div>
    <h3>Mount : </h3>
</div>
<div>
    <img class="mySlides" src="./images/mage.jpg" style="width:10%">
</div>
<div>
    <h2>${sessionScope.character.mount.name}</h2>
</div>
<table>
    <tr>
        <th>Speed :</th>
        <th>${sessionScope.character.mount.speed}</th>
    </tr>
</table>

<h3>Guild memberships :</h3>
<div class="container" style="background-color: dimgrey">
    <div class="form-group">
        To be continued...
        <!-- Iterate on guilds -->
    </div>
</div>

<%@include file="includes/footer.jsp" %>