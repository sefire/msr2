<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <form name="gotoMain" method="POST" action="controller">
                <input type="hidden" name="command" value="main"/>
                <input type="submit" value="My page"/>
                </br>
            </form>

            <form name="InfoForm" method="POST" action="controller">
                <input type="hidden" name="command" value="getuserinfo"/>
                <input type="submit" value="Get My Information"/>
                </br>
            </form>

            <form name="SeeAllUsersForm" method="POST" action="controller">
                <input type="hidden" name="command" value="getallusers"/>
                <input type="submit" value="Get all users"/>
                </br>
            </form>

            <form name="SeeAllUsersForm" method="POST" action="controller">
                <input type="hidden" name="command" value="GETALLUSERSPAGINATION"/>
                <input type="submit" value="Get all users(pagination)"/>
                </br>
            </form>

            <form name="ExitForm" method="POST" action="controller">
                <input type="hidden" name="command" value="logout"/>
                <input type="submit" value="EXIT"/>
            </form>
        </div>
        <%--for main part of page--%>
        <div class="container">
            <div>
                <table class="table table-striped">
                    <h1>${anyUser.getFirstName()} ${anyUser.getLastName()}</h1>
                    <br>
                    <tbody>
                    <tr>
                        <td>Phone</td>
                        <td>${anyUser.getPhone()}</td>
                    <tr>
                        <td>FirstName</td>
                        <td>${anyUser.getFirstName()}</td>
                    <tr>
                        <td>LastName</td>
                        <td>${anyUser.getLastName()}</td>
                    <tr>
                        <td>Country</td>
                        <td>${anyUser.getCountry()}</td>
                    <tr>
                        <td>City</td>
                        <td>${anyUser.getCity()}</td>
                    <tr>
                        <td>Age</td>
                        <td>${anyUser.getAge()}</td>
                    <tr>
                    </tbody>
                </table>

                <c:if test="${isItFriend ne true}">
                    <form name="addToFriends" method="POST" action="controller">
                        <input type="hidden" name="command" value="ADDTOFRIENDS"/>
                        <input type="hidden" name="userFriendId" value="${anyUser.getId()}" }/>
                        <input type="hidden" name="fromPage" value="/jsp/somebodysPage.jsp" }/>
                        <input type="submit" value="Add to friends"/>
                        </br>
                    </form>
                </c:if>

                <c:if test="${isItFriend eq true}">
                    <form name="deleteFromFriends" method="POST" action="controller">
                        <input type="hidden" name="command" value="DELETEFROMFRIENDS"/>
                        <input type="hidden" name="userFriendId" value="${anyUser.getId()}" }/>
                        <input type="hidden" name="fromPage" value="/jsp/somebodysPage.jsp" }/>
                        <input type="submit" value="Delete from friends"/>
                        </br>
                    </form>
                </c:if>

            </div>
        </div>
    </div>
</div>

</body>
</html>

