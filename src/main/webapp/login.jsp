<%--
  Created by IntelliJ IDEA.
  User: kanlo
  Date: 9/4/2023
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<h1>Event Point Limited</h1><br>
<div class="container" id="container">
    <div class="form-container sign-up-container">
        <form action="createAC" method="post">
            <h1>Create Account</h1>
            <span>or use your email for registration</span>
            <input type="text" placeholder="Name" name="username"/>
            <input type="hidden" name="action" value="memberAC">
            <input type="number" placeholder="Phone Number" name="phoneNumber">
            <input type="email" placeholder="Email" name="email"/>
            <input type="password" placeholder="Password" name="password"/>
            <button>Sign Up</button>
        </form>
    </div>
    <div class="form-container sign-in-container">
        <form action="login" method="post">
            <h1>Sign in</h1>
            <span>or use your account</span>
            <input type="text" placeholder="User Name" name="username"/>
            <input type="password" placeholder="Password" name="password"/>
            <input type="hidden" name="action" value="authenticate">
            <a href="#">Forgot your password?</a>
            <button type="submit" value="login">Sign In</button>
        </form>
    </div>
    <div class="overlay-container">
        <div class="overlay">
            <div class="overlay-panel overlay-left">
                <h1>Welcome Back!</h1>
                <p>To keep connected with us please login with your personal info</p>
                <button class="ghost" id="signIn">Sign In</button>
            </div>
            <div class="overlay-panel overlay-right">
                <h1>Hello, Friend!</h1>
                <p>Enter your personal details and start journey with us</p>
                <button class="ghost" id="signUp">Sign Up</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<script src="js/login.js"></script>