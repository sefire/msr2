<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
    <link rel="stylesheet" href="<c:url value="/static/css/common.css"/>">
</head>
<body>


<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>
</body>
</html>
