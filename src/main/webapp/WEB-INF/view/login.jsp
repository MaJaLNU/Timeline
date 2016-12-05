<%--
  Created by IntelliJ IDEA.
  User: damma
  Date: 19.11.2016
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html lang="en">
<head>

    <%@include file="../snippet/head.jspf" %>

    <link href="${pageContext.request.contextPath}/resources/css/style-login.css" rel="stylesheet">

    <title>Login - Timeline</title>

</head>
<body>

<header>
    <%@include file="../snippet/navigation.jspf" %>
</header>

<div class="vertical-center">
    <div class="container">
        <div class="row">
            <div class="col-sm-6 col-md-4 col-md-offset-4">
                <h1 class="text-center login-title">Sign in to admin dashboard</h1>
                <div class="account-wall">
                    <img class="profile-img"
                         src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                         alt="">
                    <form:form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
                        <!-- to display error message from action method if any -->
                        <form:errors/>
                        <form:input path="email" type="email" class="form-control" placeholder="Email" required="true"
                                    autofocus="true"/>
                        <form:password path="password" class="form-control" placeholder="Password" required="true"/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                            Sign in
                        </button>
                    </form:form>
                    <c:if test="${not empty loginError}">
                        <p class="bg-danger text-center">
                                ${loginError}
                        </p>
                    </c:if>
                </div>
                <a href="${pageContext.request.contextPath}" class="text-center new-account">Back</a>
            </div>
        </div>
    </div>
</div>

<footer class="navbar-fixed-bottom">
    <%@include file="../snippet/footer.jspf" %>
</footer>

</body>
</html>