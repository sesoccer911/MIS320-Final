<%-- 
    Document   : SearchResult
    Created on : Apr 27, 2017, 12:22:20 AM
    Author     : Ben
--%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resources/css/main.css">
        <link rel="stylesheet" href="resources/css/cssLayout.css">
        <link rel="stylesheet" href="resources/css/styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Result</title>
    </head>
    <body>
        <table columns ="2">
            Title: <c:out value="${title}"/>
        </table>
    </body>
</html>
