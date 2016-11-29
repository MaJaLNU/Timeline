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
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="An overview about the StarWars movies.">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="images/android-desktop.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Material Design Lite">
    <link rel="apple-touch-icon-precomposed" href="images/ios-desktop.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <meta name="msapplication-TileColor" content="#3372DF">

    <link rel="shortcut icon" href="">
    <title>StarWars Timeline</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <!-- Custom styles for this template -->
    <!--<link href="resources/starter-template.css" rel="stylesheet">-->
    <link href="resources/css/style.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="resources/js/home.js"></script>

</head>
<body>
<div class="header-bar">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                </button>
                <a class="navbar-brand" href="/WEB-INF/view/test.html">StarWars Timeline</a>

                <%--      <c:choose>
                          <c:when test="${pageContext.request.lists != null}">
                              <h2>Admin : ${pageContext.request.lists} </h2>
                        <a type="button" class="btn btn-link navbar-btn pull-right" href="javascript:formSubmit()">
                            Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a type="button" class="btn btn-link navbar-btn pull-right" href="../view/dashboard.jsp">
                            Login</a>
                    </c:otherwise>
                </c:choose>--%>
            </div>
        </div>
    </nav>
</div>

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


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
