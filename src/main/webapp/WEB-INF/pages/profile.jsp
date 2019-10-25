<%@include file="includes/header.jsp" %>

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

<%@include file="includes/footer.jsp" %>