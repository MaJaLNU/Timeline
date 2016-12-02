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

    <link href="${pageContext.request.contextPath}/resources/css/style-dashboard.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/fileinput.min.css" media="all" rel="stylesheet"
          type="text/css"/>

    <!-- Image upload -->
    <script src="${pageContext.request.contextPath}/resources/js/fileinput.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dashboard.js"></script>

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
                <c:when test="${not empty movie}">
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
                    <a href="${pageContext.request.contextPath}/dashboard/${movie.id}"
                       class="list-group-item">${movie.title}</a>
                </c:forEach>
            </c:if>
        </div>
    </div>

    <div class="center-table">
        <form:form class="form-horizontal" method="POST" modelAttribute="movieForm"
                   action="${pageContext.request.contextPath}/saveMovie">
            <div class="form-group">
                <label for="title" class="col-sm-2 control-label">Title</label>
                <div class="col-sm-10">
                    <form:input type="text" class="form-control" path="title" id="title" placeholder="title"
                                value="${movie.title}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="rating" class="col-sm-2 control-label">Rating</label>
                <div class="col-sm-10">
                    <form:input type="number" step="0.1" path="rating" class="form-control" id="rating"
                                placeholder="rating"
                                min="0" max="10" value="${movie.rating}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="releaseYear" class="col-sm-2 control-label">Release Year</label>
                <div class="col-sm-10">
                    <form:input type="date" class="form-control" path="releasedate" id="releaseYear"
                                placeholder="release year" value="${movie.releasedate}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="length" class="col-sm-2 control-label">Length</label>
                <div class="col-sm-10">
                    <form:input type="text" path="length" class="form-control" id="length" placeholder="length"
                                value="${movie.length}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="director" class="col-sm-2 control-label">Director</label>
                <div class="col-sm-10">
                    <form:input type="text" path="director" class="form-control" id="director" placeholder="director"
                                value="${movie.director}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="youtube" class="col-sm-2 control-label">Youtube-Code</label>
                <div class="col-sm-10">
                    <form:input type="text" path="youtube" class="form-control" id="youtube" placeholder="frdj1zb9sMY"
                                value="${movie.youtube}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="image" class="col-sm-2 control-label">Image</label>
                <div class="col-sm-10">
                    <input id="image" type="file" class="file" data-show-upload="false">
                    <form:input id="hiddenImage" path="image" hidden="true"/>
                </div>
            </div>
            <div class="form-group">
                <label for="description"
                       class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <form:textarea maxlength="200" class="form-control" path="description" rows="3" id="description"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">Save</button>
                </div>
            </div>
        </form:form>

        <form:form class="form-horizontal" method="POST" action="${pageContext.request.contextPath}/deleteMovie">
            <button type="button" class="btn btn-danger delete-movie-btn">Delete movie</button>
        </form:form>
    </div>
</div>

<footer class="navbar-fixed-bottom">
    <%@include file="../snippet/footer.jspf" %>
</footer>

<script src="${pageContext.request.contextPath}/resources/js/image-upload.js"></script>
<script src="//wzrd.in/standalone/blob-util@latest"></script>
</body>

</html>
