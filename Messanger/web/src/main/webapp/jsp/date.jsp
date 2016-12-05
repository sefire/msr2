<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head><title>timezone</title></head>
<body>
<jsp:useBean id="now" class="java.util.Date"/>
<br/>
<fmt:setLocale value="ru-RU"/>
<fmt:timeZone value="GMT+4:00">
    Locale: RU :
    <fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="long"/><br/>
</fmt:timeZone>
<fmt:setLocale value="pl-PL"/>
<fmt:timeZone value="GMT+1:00">
    Locale: PL :
    <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="medium"/><br/>
</fmt:timeZone>
</body>
</html>