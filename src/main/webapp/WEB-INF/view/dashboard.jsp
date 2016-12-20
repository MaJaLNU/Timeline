<%--
  Created by IntelliJ IDEA.
  User: damma
  Date: 24.11.2016
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>

<!doctype html>
<html lang="en">
<head>

    <%@include file="../snippet/head.jspf" %>

    <link href="${context}/resources/css/style-dashboard.css" rel="stylesheet">
    <link href="${context}/resources/css/fileinput.min.css" media="all" rel="stylesheet"
          type="text/css"/>

    <title>Dashboard</title>
</head>
<body>

<header>
    <%@include file="../snippet/navigation.jspf" %>
</header>

<div class="dashboard">
    <div class="page-header">
        <h1>Admin Dashboard
            <c:choose>
                <c:when test="${empty movie}">
                    <small> create new movie</small>
                </c:when>
                <c:otherwise>
                    <small> manage "${movie.title}"</small>
                </c:otherwise>
            </c:choose>
        </h1>
    </div>

    <div class="list-of-movies">
        <div class="list-group">
            <a href="${pageContext.request.contextPath}/dashboard" class="list-group-item active">New movie</a>

            <c:if test="${not empty listMovies}">
                <c:forEach var="movie" items="${listMovies}" varStatus="status">
                    <a href="${context}/dashboard/${movie.id}"
                       class="list-group-item" id="${movie.id}">(${movie.releasedate}) ${movie.title}</a>
                </c:forEach>
            </c:if>
        </div>
    </div>

    <div class="center-table">
        <form:form class="form-horizontal" method="POST" modelAttribute="movieForm">
            <div class="form-group">
                <c:if test="${not empty success}">
                    <div class="alert alert-success" role="alert">
                        <strong>Well done!</strong>${success}
                    </div>
                </c:if>
                <c:if test="${not empty delete}">
                    <div class="alert alert-success" role="alert">
                            ${delete}
                    </div>
                </c:if>
                <label for="title" class="col-sm-2 control-label">Title</label>
                <div class="col-sm-10">
                    <form:input type="text" class="form-control" path="title" id="title" placeholder="title"
                                value="${movie.title}" required="required"/>
                </div>
            </div>
            <div class="form-group">
                <label for="rating" class="col-sm-2 control-label">Rating</label>
                <div class="col-sm-10">
                    <form:input type="number" step="0.1" path="rating" class="form-control" id="rating"
                                placeholder="1.0 - 10.0" min="0" max="10" value="${movie.rating}" required="true"/>
                </div>
            </div>
            <div class="form-group">
                <label for="releaseYear" class="col-sm-2 control-label">Release Year</label>
                <div class="col-sm-10">
                    <form:input type="number" min="1800" max="9999" class="form-control" path="releasedate"
                                id="releaseYear"
                                placeholder="yyyy" value="${movie.releasedate}" required="true"/>
                </div>
            </div>
            <div class="form-group">
                <label for="length" class="col-sm-2 control-label">Length</label>
                <div class="col-sm-10">
                    <form:input type="text" path="length" class="form-control" id="length" placeholder="h min"
                                value="${movie.length}" required="required"/>
                </div>
            </div>
            <div class="form-group">
                <label for="director" class="col-sm-2 control-label">Director</label>
                <div class="col-sm-10">
                    <form:input type="text" path="director" class="form-control" id="director" placeholder="director"
                                value="${movie.director}" required="required"/>
                </div>
            </div>
            <div class="form-group">
                <label for="youtube" class="col-sm-2 control-label">Youtube-Code</label>
                <div class="col-sm-10">
                    <form:input type="text" path="youtube" class="form-control" id="youtube" placeholder="frdj1zb9sMY"
                                value="${movie.youtube}"/>
                </div>
            </div>

            <div class="form-group" hidden>
                <label for="movieId" class="col-sm-2 control-label">Movie Id</label>
                <div class="col-sm-10">
                    <form:input type="text" path="id" class="form-control" id="movieId" placeholder="movieId"
                                value="${movie.id}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="image" class="col-sm-2 control-label">Image</label>
                <div class="col-sm-10">
                    <input id="image" type="file" class="file" data-show-upload="false">
                    <form:input id="hiddenImage" path="image" hidden="true"/>
                    <c:if test="${not empty movie.image}">
                        <br>
                        <picture>
                            <img class="img-responsive" width="150" src="data:image/png;base64, ${movie.image}">
                        </picture>
                    </c:if>
                </div>
            </div>
            <div class="form-group">
                <label for="description"
                       class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <form:textarea maxlength="1000" class="form-control" placeholder="..." value="${movie.description}"
                                   path="description"
                                   id="description" rows="5" required="required"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button formaction="${context}/saveMovie" type="submit"
                            class="btn btn-success movie-btn">Save
                    </button>
                </div>
            </div>
            <c:if test="${not empty movie}">
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">

                        <button formaction="${context}/deleteMovie/${movie.id}" type="submit"
                                class="btn btn-danger movie-btn">Delete movie
                        </button>
                    </div>
                </div>
            </c:if>
        </form:form>
    </div>
</div>

<!-- Image upload -->
<script src="${context}/resources/js/image-upload.js"></script>
<script src="${context}/resources/js/blob.js"></script>
<script src="${context}/resources/js/fileinput.min.js"></script>
<script src="${context}/resources/js/dashboard.js"></script>

</body>
</html>
