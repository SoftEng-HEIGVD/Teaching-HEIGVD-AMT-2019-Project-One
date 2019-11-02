<%@include file="includes/header.jsp" %>

<div>
    <h3>Welcome, ${sessionScope.character.name} !</br></h3>
    <h3>Are you an admin ? ${sessionScope.character.isadmin} </br></h3>
</div>

<%@include file="includes/footer.jsp" %>