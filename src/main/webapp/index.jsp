<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>welcom</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <div class="title-text">
        <div class="title login">Login</div>
        <div class="title signup">Signup</div>
    </div>
    <div class="form-container">
        <div class="slide-controls">
            <input type="radio" name="slide" id="login" checked>
            <input type="radio" name="slide" id="signup" >
            <label for="login" class="slide login">Login</label>
            <label for="signup" class="slide signup">Signup</label>
            <div class="slider-tab"></div>
        </div>
<%--        @foreach($errors->all() as $error)--%>
<%--        <li style="color: red">{{ $error }}</li>--%>
<%--        @endforeach--%>
        <div class="form-inner">
            <form action="./login" method="POST" class="login">
                <div class="field">
                    <input type="text" placeholder="Username" name="username" required>
                </div>
                <div class="field">
                    <input type="password" placeholder="Password" name="password" required>
                </div>
                <div style="margin-top: 10px;padding-left: 0px;">
                    <input type="checkbox" name="remember">
                    <label>Remember me</label>
                </div>
                <div class="field btn">
                    <div class="btn-layer"></div>
                    <input type="submit" value="Login">
                </div>
                <div class="signup-link">Not a member? <a href="">Signup now</a></div>
            </form>
            <form action="./register" method="POST" class="signup">
                <div class="field">
                    <input type="text" placeholder="Username" name="username" required>
                </div>
                <div class="field">
                    <input type="Email" placeholder="Email" name="email" required>
                </div>
                <div class="field">
                    <input type="password" placeholder="Password" name="password" required>
                </div>
                <div class="field btn">
                    <div class="btn-layer"></div>
                    <input type="submit" value="Signup">
                </div>
                <div class="signup-link">By clicking on Signup you Agree to our<a href="#"> terms of use</a></div>
            </form>
        </div>
    </div>
</div>
<script src="js/script.js"></script>
</body>
</html>
