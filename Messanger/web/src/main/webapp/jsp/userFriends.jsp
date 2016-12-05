<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users</title>
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
    <div class="table-responsive">
        <table class="table table-hover">
            <h1>${user} Friends</h1>
            <br>
            <thead>
            <tr>
                <th>Phone</th>
                <th>First Name</th>
                <th>last Name</th>
                <th>Country</th>
                <th>City</th>
                <th>Age</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="userEntity" items="${userFriendsList}">
                <tr>
                        <%--                <td><c:out value="${ userEntity.getId() }"/></td>--%>
                    <td><c:out value="${ userEntity.phone }"/></td>
                    <td><c:out value="${ userEntity.firstName }"/></td>
                    <td><c:out value="${ userEntity.lastName }"/></td>
                    <td><c:out value="${ userEntity.country }"/></td>
                    <td><c:out value="${ userEntity.city }"/></td>
                    <td><c:out value="${ userEntity.age }"/></td>
                    <td>
                        <form name="deleteFromFriends" method="POST" action="controller">
                            <input type="hidden" name="command" value="DELETEFROMFRIENDS"/>
                            <input type="hidden" name="userFriendId" value="${userEntity.getId()}" }/>
                            <input type="hidden" name="fromPage" value="/jsp/userFriends.jsp" }/>
                            <input type="submit" value="Delete from friends"/>
                            </br>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
