<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
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
<div class="container">
    <div>
        <table class="table table-striped">
            <h1>User's information</h1>
            <br>
            <tbody>
            <tr>
                <td>Phone</td>
                <td>${phone}</td>
<%--                <td><a href="controller?command=CHANGEUSERFIELD&fieldToChange=phone">change</a><td>--%>
            <tr>
                <td>FirstName</td>
                <td>${firstName}</td>
<%--                <td><a href="controller?command=CHANGEUSERFIELD&fieldToChange=firstName">change</a><td>--%>
            <tr>
                <td>LastName</td>
                <td>${lastName}</td>
<%--                <td><a href="controller?command=CHANGEUSERFIELD&fieldToChange=lastName">change</a><td>--%>
            <tr>
                <td>Country</td>
                <td>${country}</td>
<%--                <td><a href="controller?command=CHANGEUSERFIELD&fieldToChange=country">change</a><td>--%>
            <tr>
                <td>City</td>
                <td>${city}</td>
<%--                <td><a href="controller?command=CHANGEUSERFIELD&fieldToChange=city">change</a><td>--%>
            <tr>
                <td>Age</td>
                <td>${age}</td>
<%--                <td><a href="controller?command=CHANGEUSERFIELD&param=age">change</a><td>--%>
            <tr>
<%--                <td>Password</td>--%>
                <%--<td><a href="controller?command=CHANGEUSERFIELD&fieldToChange=password">change</a><td>--%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
