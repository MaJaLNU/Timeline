<%--
  Created by IntelliJ IDEA.
  User: damma
  Date: 24.11.2016
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!doctype html>
<html lang="en">
<head>

    <%@include file="../snippet/head.jspf" %>

    <title>Dashboard</title>

    <link href="${pageContext.request.contextPath}/resources/css/style-dashboard.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/dashboard.js"></script>
</head>
<body>

<header>
    <%@include file="../snippet/navigation.jspf" %>
</header>

<div class="dashboard">
    <div class="list-of-movies">
        <div class="list-group">
            <a href="#" class="list-group-item active">New movie</a>

            <c:if test="${not empty listMovies}">
                <c:forEach var="movie" items="${listMovies}" varStatus="status">
                    <a href="/${movie.id}" class="list-group-item">${movie.title}</a>
                </c:forEach>
            </c:if>
        </div>
    </div>

    <div class="center-table">
        <form class="form-horizontal">
            <div class="form-group">
                <label for="title" class="col-sm-2 control-label">Title</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" placeholder="title">
                </div>
            </div>
            <div class="form-group">
                <label for="rating" class="col-sm-2 control-label">Rating</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="rating" placeholder="rating">
                </div>
            </div>
            <div class="form-group">
                <label for="releaseYear" class="col-sm-2 control-label">Release Year</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="releaseYear" placeholder="release year">
                </div>
            </div>
            <div class="form-group">
                <label for="length" class="col-sm-2 control-label">Length</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="length" placeholder="length">
                </div>
            </div>
            <div class="form-group">
                <label for="director" class="col-sm-2 control-label">Director</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="director" placeholder="director">
                </div>
            </div>
            <div class="form-group">
                <label for="youtube" class="col-sm-2 control-label">Youtube-Code</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="youtube" placeholder="frdj1zb9sMY">
                </div>
            </div>
            <div class="form-group">
                <label for="image" class="col-sm-2 control-label">Image</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="image" placeholder="image">
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <textarea class="form-control" rows="3" id="description"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Save</button>
                </div>
            </div>
        </form>
        <button type="button" class="btn btn-danger delete-movie-btn">Delete movie</button>
    </div>
</div>

</body>
</html>
