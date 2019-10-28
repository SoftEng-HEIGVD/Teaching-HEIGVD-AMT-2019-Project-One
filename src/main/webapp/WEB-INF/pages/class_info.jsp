<%@include file="includes/header.jsp" %>


<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th><a href="${pageContext.request.contextPath}/classes"><i class="btn btn-primary fas fa-arrow-left">Back</i></a></th>
        </tr>
        <tr>
            <th><h2>${class.name}:</h2></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                ${class.description}
            </td>
            <td>
                <img src="./images/${image}Image.jpg">
            </td>

        </tr>
        </tbody>
    </table>

</div>

<%@include file="includes/footer.jsp" %>