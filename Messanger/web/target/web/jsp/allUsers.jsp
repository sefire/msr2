<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All users</title>
</head>
<body>

<br/>

<table border="3" style="font: 14pt arial;     width: 90%;   border: 1px solid green; margin: auto;">
    <caption>All Users</caption>

    <c:forEach var="userEntity" items="${alluserslist}">
        <tr>
            <td><c:out value="${ userEntity.getId() }"/></td>
            <td><c:out value="${ userEntity.phone }"/></td>
            <td><c:out value="${ userEntity.firstName }"/></td>
            <td><c:out value="${ userEntity.lastName }"/></td>
            <td><c:out value="${ userEntity.country }"/></td>
            <td><c:out value="${ userEntity.city }"/></td>
            <td><c:out value="${ userEntity.age }"/></td>
        </tr>
    </c:forEach>
</table>

<br/>

</body>
</html>
