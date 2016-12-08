<%--
  Created by IntelliJ IDEA.
  User: damma
  Date: 09.11.2016
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>

<!doctype html>
<html lang="en">
<head>

    <%@include file="../snippet/head.jspf" %>

    <link href="${context}/resources/css/style-timeline.css" rel="stylesheet">

    <script>
        $(document).ready(function () {
            <!-- Switch left right for timeline -->
            $("#line ul li:nth-of-type(even)").addClass("timeline-inverted");
            $("#line ul li:nth-of-type(odd)").removeClass("timeline-inverted");
            //$("#line ul li a i:nth-of-type(even)").addClass("invert");
            //$("#line ul li a i:nth-of-type(odd)").removeClass("invert");
        })
    </script>

    <title>StarWars Timeline</title>

</head>
<body>

<!-- Header -->
<header>
    <%@include file="../snippet/navigation.jspf" %>
</header>

<c:choose>
    <c:when test="${empty listMovies}">
        <div class="center-myshit">
            <div class="page-header">
                <h1 id="timeline_empty">No Movies saved...</h1>
            </div>
        </div>
    </c:when>

    <c:otherwise>
        <div id="line" class="container">
            <div class="page-header text-center">
                <h1 id="timeline">StarWars Movie Timeline</h1>
            </div>
            <ul class="timeline">
                <c:forEach var="movie" items="${listMovies}" varStatus="status">
                    <li>
                        <div id="tool" class="timeline-badge primary"><a><i class="glyphicon glyphicon-record"
                                                                            rel="tooltip"
                                                                            title="${movie.releasedate}"></i></a>
                        </div>
                        <div class="timeline-panel">
                            <div class="timeline-heading">
                                <c:choose>
                                    <c:when test="${not empty movie.image}">
                                        <img class="img-responsive" src="data:image/png;base64, ${movie.image}"/>
                                    </c:when>
                                    <c:otherwise>
                                        <img class="img-responsive" src="https://placehold.it/666x666"/>
                                    </c:otherwise>
                                </c:choose>
                            </div>

                            <div class="timeline-body">
                                <h3>${movie.title} (${movie.releasedate})</h3>
                                <p>${movie.description}</p>
                            </div>

                            <div class="timeline-footer">
                                <div class="row">
                                    <p class="pull-left"><i class="glyphicon glyphicon-time"></i>
                                        Length: ${movie.length}</p>
                                    <c:if test="${not empty movie.youtube}">
                                        <p class="pull-right">
                                            <i class="glyphicon glyphicon-play-circle"></i>
                                            <a data-toggle="modal" data-target="#myModal-${status.index}"> Trailer</a>
                                        </p>
                                        <!-- Modal -->
                                        <div class="modal fade" id="myModal-${status.index}" tabindex="-1" role="dialog"
                                             aria-labelledby="myModalLabel-${status.index}">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close"><span
                                                                aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title" id="myModalLabel-${status.index}">
                                                            Youtube
                                                            Trailer: ${movie.title}</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <iframe id="trailer-${status.index}" width="560" height="315"
                                                                src="https://www.youtube.com/embed/${movie.youtube}"
                                                                frameborder="0"
                                                                allowfullscreen></iframe>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </c:if>
                                </div>
                                <div class="row">
                                    <p class="pull-left">
                                        <i class="glyphicon glyphicon-thumbs-up"></i> Ratring: ${movie.rating}
                                    </p>
                                    <p class="pull-right">
                                        <i class="glyphicon glyphicon-user"></i> Director:
                                        <a target="_blank"
                                           href="https://www.google.com/search?q=${movie.director}">${movie.director}</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </li>

                </c:forEach>
                <li class="clearfix" style="float: none;"></li>
            </ul>
        </div>
    </c:otherwise>
</c:choose>

<div class="row"></div>

<!-- Footer -->
<footer class="footer">
    <%@include file="../snippet/footer.jspf" %>
</footer>

<script src="${context}/resources/js/timeline.js"></script>

</body>
</html>
