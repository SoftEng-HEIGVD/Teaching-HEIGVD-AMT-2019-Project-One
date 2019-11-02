<%@include file="../includes/header.jsp" %>

<div class="container-fluid">

    <div class="container-fluid">
        <form method="post">
            <input type="hidden" name="id" value="${requestScope.character.id}">
            <div class="form-group">
                <label for="nameField">Name</label>
                <input type="text" class="form-control" id="nameField" name="name" value="${requestScope.character.name}">
            </div>
            <div class="form-group">
                <label for="passwordField">Password</label>
                <input type="password" class="form-control" id="passwordField" name="password">
            </div>
            <div class="form-group">
                <label for="passwordFieldVerify">Password</label>
                <input type="password" class="form-control" id="passwordFieldVerify" name="passwordVerify">
            </div>
            <div class="form-group">
                <label for="isAdminCheckbox">Is admin</label>
                <input type="checkbox" id="isAdminCheckbox" name="isAdminCheckbox" ${requestScope.character.isadmin ? 'checked' : ''}>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <c:if test="${errors != null}">
            Errors:
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </c:if>
    </div>


    <div class="container-fluid">
        <form method="post">
            <label for="id_select_guilds"> Select memberships of this user
                <select id="id_select_guilds" class="js-example-basic-multiple form-control" name="states[]" multiple="multiple" style="width: 100%">
                    <option value="AL">Alabama</option>
                    <option value="AQ">A</option>
                    <option value="AA">B</option>
                    <option value="AS">C</option>
                    <option value="AD">D</option>
                    <option value="AF">E</option>
                    <option value="WY">F</option>
                </select>
            </label>

            <input type="submit" class="btn btn-primary" name="updateMemberships" value="Update memberships">
        </form>

    </div>

</div>
<script>
    $(document).ready(function() {
        $('.js-example-basic-multiple').select2();
    });
</script>

<%@include file="../includes/footer.jsp" %>
