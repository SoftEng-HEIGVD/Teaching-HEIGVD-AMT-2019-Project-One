<%@include file="../includes/header.jsp" %>

<div class="container">
    <div class="container">
        <c:if test="${sessionScope.deleteStatus != null}">
            ${sessionScope.deleteStatus}
        </c:if>
        <c:remove var="deleteStatus"/>
        <table class="table" id="guildsTable" style="background-color: black; color: white">
            <thead>
            <tr>
                <th>Guild's name</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${guilds}" var="guild" varStatus="loop">
                <tr style="background-color: black">
                    <td><h2>${guild.name}</h2></td>
                    <td>
                        <a data-toggle="modal" data-target="#modal${guild.id}"><i
                                class="fas fa-trash-alt"></i></a>

                        <a href="${pageContext.request.contextPath}/admin/guilds/update?id=${guild.id}"><i
                                class="fas fa-pen"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <c:forEach items="${guilds}" var="guild" varStatus="loop">
        <div class="modal fade" id="modal${guild.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2 style="color: black" class="modal-title">${guild.name}</h2>
                    </div>
                    <div class="modal-body">
                       <h5 style="color: black">Are you sure that you want to delete this guild ?</h5>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <a  href="${pageContext.request.contextPath}/admin/guilds/delete?id=${guild.id}" type="button" class="btn btn-danger">Delete</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>

</div>
<script>
    $(document).ready(function () {
        $('#guildsTable').DataTable();
    });
</script>


<%@include file="../includes/footer.jsp" %>
