<%--
  Created by IntelliJ IDEA.
  User: damma
  Date: 19.11.2016
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div class="container">
    ${loginError}
    <div>
        <form action="../view/dashboard.jsp" method="post">
            <div>
                <label>Admin email:</label>
                <input type="text" id="adminMail" name="adminMail" placeholder="Admin Mail" class="form-control"/>
            </div>
            <div>
                <label>Passwordl:</label>
                <input type="text" id="adminPassword" name="adminPassword" placeholder="Password" class="form-control"/>
            </div>
            <button id="loginutton" class="form-control">
                Login
            </button>
        </form>
    </div>
</div>

</body>
</html>
