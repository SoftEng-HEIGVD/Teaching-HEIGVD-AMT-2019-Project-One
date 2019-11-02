<%@include file="../includes/header.jsp" %>
<%
    java.util.Enumeration params = request.getParameterNames();
    StringBuilder parameters = new StringBuilder();
    while (params.hasMoreElements()) {
        String paramName = (String) params.nextElement();
        String paramValue = request.getParameter(paramName);
        if (!paramName.equals("page")) {
            parameters.append(paramName).append("=").append(paramValue).append("&");
        }
    }
%>
<div class="container-fluid">
    <div class="container">
        <a href="${pageContext.request.contextPath}/admin/characters/add" class="btn btn-primary">Add new character</a>
    </div>
    <div class="container">

        <form class="form-inline" method="get">
            <input class="form-control" type="text" placeholder="Search" aria-label="Search" name="searchBar">
        </form>

        <a href="${pageContext.request.contextPath}/admin/characters">All</a> /
        <c:set var="alphabet" value="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z"/>
        <c:forTokens var="letter" items="${alphabet}" delims=",">
            <a href="${pageContext.request.contextPath}/admin/characters?letter=${letter}">${letter}</a> /
        </c:forTokens>


    </div>
    <table class="table">
        <thead>
        <tr>
            <th>Character name</th>
            <th>Is admin</th>
            <th>Actions</th>
        </tr>
        </thead>
        <c:forEach items="${characters}" var="character" varStatus="loop">
            <tr>
                <td><h2 style="color: white">${character.name}</h2></td>
                <td><i class="fas fa-${(character.isadmin ?  "check" : "times")}"></i></td>
                <td>
                    <c:if test="${character.id != sessionScope.character.id}">
                        <a href="${pageContext.request.contextPath}/admin/characters/delete?id=${character.id}"><i
                                class="fas fa-trash-alt"></i></a>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/admin/characters/update?id=${character.id}"><i
                            class="fas fa-pen"></i></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="container">
        <div class="text-center">
            <c:forEach begin="1" end="${numberOfPage}" varStatus="loop">
                <a href="${pageContext.request.contextPath}/admin/characters?<%=parameters%>page=${loop.index}">${loop.index}</a>
            </c:forEach>
        </div>
    </div>

    <c:if test="${sessionScope.deleteStatus != null}">
        ${sessionScope.deleteStatus}
    </c:if>
    <c:remove var="deleteStatus"/>

</div>

<%@include file="../includes/footer.jsp" %>
