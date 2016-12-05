<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Registration</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <style type="text/css">
        <%@include file="/bootstrap/css/bootstrap.css" %>
        <%@include file="/bootstrap/css/bootstrap-theme.css" %>
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="bootstrap/js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="navbar navbar-inverse navbar-static-top"><!--убрать топ чтобы было не  -->
    <div class="container body-content">
        <div class="navbar-header">
            <h1 class="navbar-brand">Messenger</h1>
        </div>
    </div>
</div>
<h1>Fill it to register!</h1>
<br/>
<div class="container">
    <form name="signupForm" method="POST" action="controller">
        <input type="hidden" name="command" value="passregistration"/>
        Phone: <br/>
        <input type="text" name="phoneNumber" value=""/>
        <br/>
        FirstName: <br/>
        <input type="text" name="firstname" value=""/>
        <br/>
        LastName: <br/>
        <input type="text" name="lastname" value=""/>
        <br/>
        Country:<br/>
        <input type="text" name="country" value=""/>
        <br/>
        City:<br/>
        <input type="text" name="city" value=""/>
        <br/>
        Age:<br/>
        <input type="text" name="age" value=""/>
        <br/>
        Password:<br/>
        <input type="password" name="password" value=""/>
        <br/>
        <br/>
        <input type="submit" value="Let's start!"/>
    </form>
    <hr/>
</div>
</div>
</body>
</html>
