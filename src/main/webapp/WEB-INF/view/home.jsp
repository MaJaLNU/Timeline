<%--
  Created by IntelliJ IDEA.
  User: damma
  Date: 09.11.2016
  Time: 10:25
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

    <title>StarWars Timeline</title>

    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/home.js"></script>
</head>
<body>

<header>
    <%@include file="../snippet/navigation.jspf" %>
</header>

<c:if test="${not empty listMovies}">
    <div class="timeline">

        <c:forEach var="movie" items="${listMovies}" varStatus="status">
            <div class="row test-wide">
                <div class="col-sm-6 col-md-4 movie-wrapper">
                    <div class="thumbnail">
                        <div class="image-holder">
                            <!-- <img src="${movie.image}" alt="..."> -->
                            <img src="resources/movie1.jpg" alt="...">
                            <button type="button" class="btn btn-primary trailer-button" data-toggle="modal"
                                    data-target="#myModal-${status.index}">
                                Trailer
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="myModal-${status.index}" tabindex="-1" role="dialog"
                                 aria-labelledby="myModalLabel-${status.index}">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"
                                                    aria-label="Close"><span
                                                    aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel-${status.index}">Youtube
                                                Trailer: ${movie.title}</h4>
                                        </div>
                                        <div class="modal-body">
                                            <iframe id="trailer-${status.index}" width="560" height="315"
                                                    src="https://www.youtube.com/embed/${movie.youtube}" frameborder="0"
                                                    allowfullscreen></iframe>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="caption">
                            <h3>${movie.title}</h3>
                            <div class="table-responsive">
                                <table class="table">
                                    <tr>
                                        <td>Rating</td>
                                        <td>${movie.rating}</td>
                                    </tr>
                                    <tr>
                                        <td>Release</td>
                                        <td>${movie.releasedate}</td>
                                    </tr>
                                    <tr>
                                        <td>Length</td>
                                        <td>${movie.length}</td>
                                    </tr>
                                    <tr>
                                        <td>Director</td>
                                        <td>${movie.director}</td>
                                    </tr>
                                </table>
                                <p>${movie.description}</p>
                            </div>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</c:if>

</body>
</html>
