<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>${user}-page</title></head>

<body>
<%--<body BACKGROUND="<c:url value='/images/background.png'/>"/>--%>

<style>
    .text {
        text-align: center;
        font-family: Arial, Helvetica, Verdana, sans-serif;
        font-size: 16pt;
        font-weight: bold;
    }
</style>

<div class="text">
    <p>${user}</p>
</div>
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

</body>
</html>
