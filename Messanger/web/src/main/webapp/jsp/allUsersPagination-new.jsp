<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Users</title>
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

        <div class="container">
            <div class="col-md-9">
                <div class="container">
                    <h2>Total count of users: ${totaluserscount}</h2>
                    </br>
                    <h2>Current page: ${page}</h2>
                    </br>
                    </br>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <h1>All Users</h1>
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
                            <c:forEach var="userEntity" items="${alluserslist}">
                                <tr>
                                        <%--                <td><c:out value="${ userEntity.getId() }"/></td>--%>
                                    <td><c:out value="${ userEntity.phone }"/></td>
                                    <td><c:out value="${ userEntity.firstName }"/></td>
                                    <td><c:out value="${ userEntity.lastName }"/></td>
                                    <td><c:out value="${ userEntity.country }"/></td>
                                    <td><c:out value="${ userEntity.city }"/></td>
                                    <td><c:out value="${ userEntity.age }"/></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <br>
                    <div>
                        <ul class="pagination">
                            <c:if test="${page ne 1}">
                                <li>
                                    <a href="controller?command=GETALLUSERSPAGINATION&page=${page - 1}">
                                        &#60;&#60;Previous </a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${countofpages}" var="i">
                                <c:choose>
                                    <c:when test="${page eq i}">
                                        <li class="active"><span>${i}</span></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="controller?command=GETALLUSERSPAGINATION&page=${i}">${i}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <c:if test="${page lt countofpages}">
                                <li>
                                    <a href="controller?command=GETALLUSERSPAGINATION&page=${page + 1}">Next&#62;&#62;</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>

                    <!-- выпадающие меню-->
                    <div class="btn-group pull-right dropup"> <!--div class="btn-group dropup"-->

                        <button class="btn btn-success dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                            Change count of rows
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="controller?command=GETALLUSERSPAGINATION&countPerPage=5">5</a></li>
                            <li><a href="controller?command=GETALLUSERSPAGINATION&countPerPage=10">10</a>
                            </li>
                            <li><a href="controller?command=GETALLUSERSPAGINATION&countPerPage=20">20</a>
                            </li>
                        </ul>
                    </div>
                    <br>
                    <br>
                    <br>
                    <br>

                </div>
            </div>


        </div>
    </div>
</div>
</body>
</html>