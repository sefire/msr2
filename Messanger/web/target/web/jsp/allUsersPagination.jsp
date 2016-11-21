<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>All Users</title>
</head>
<body>

<td>Total count of users: ${totaluserscount}</td>
</br>
<td>Current page: ${page}</td>
</br>
</br>
<table border="3" style="font: 14pt arial;     width: 90%;   border: 1px solid green; margin: auto;">
    <tr>
        <th>UserId</th>
        <th>Phone</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Age</th>
        <th>Country</th>
        <th>City</th>
    </tr>

    <c:forEach var="userEntity" items="${alluserslist}">
        <tr>
            <td>${ userEntity.getId() }</td>
            <td>${ userEntity.phone }</td>
            <td>${ userEntity.firstName }</td>
            <td>${ userEntity.lastName }</td>
            <td>${ userEntity.age }</td>
            <td>${ userEntity.country }</td>
            <td>${ userEntity.city }</td>
        </tr>
    </c:forEach>
</table>
</br>
</br>

<table style="font: 14pt arial;     width: 50%;  margin: auto;">
    <tr>
        <th>
            <c:if test="${page ne 1}">
                <%--                <form name="seeprevpageform" method="POST" action="controller">
                                    <br>
                                    <input type="hidden" name="command" value="GETALLUSERSPAGINATIONPREV"/>
                                    <input type="submit" value="<<Previous Page"/>
                                    </br>
                                </form>--%>
                <a href="controller?command=GETALLUSERSPAGINATION&page=${page - 1}">&#60;&#60;Previous</a>
            </c:if>
        </th>
        <%--For displaying Page numbers.
The when condition does not display a link for the current page--%>

        <c:forEach begin="1" end="${countofpages}" var="i">
            <c:choose>
                <c:when test="${page eq i}">
                    <th>${i}</th>
                </c:when>
                <c:otherwise>
                    <th>
                        <a href="controller?command=GETALLUSERSPAGINATION&page=${i}">${i}</a>
                    </th>
                </c:otherwise>
            </c:choose>
        </c:forEach>


        <th>
            <%--For displaying Next link --%>
            <c:if test="${page lt countofpages}">
                <%--      <br>--%>
                <%--                <form name="seenextpageform" method="POST" action="controller">
                                    <input type="hidden" name="command" value="GETALLUSERSPAGINATIONNEXT"/>
                                    <input type="submit" value="Next Page>>"/>
                                    </br>
                                </form>--%>
                <a href="controller?command=GETALLUSERSPAGINATION&page=${page + 1}">Next&#62;&#62;</a>
                </br>
                </form>
            </c:if>
        </th>
    </tr>
</table>
<%--For displaying Previous link except for the 1st page --%>


</body>
</html>