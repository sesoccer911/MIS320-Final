<%-- 
    Document   : account
    Created on : Apr 16, 2017, 8:17:07 PM
    Author     : ewaremickens
--%>

<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <title> Customer Account</title>
    </head>
    <body>     
        Please input any information you want to change to your information. 
             <form method="POST" action='CustomerUpdateServlet'  onsubmit="return checkform(this);">
            First Name : <input
                type="text" name="firstName"
                value="<c:out value="${customer.first_name}" />" /> <br /> 
            Last Name : <input
                type="text" name="lastName"
                value="<c:out value="${customer.last_name}" />" /> <br /> 
            Password : <input
                type="text" name="password"
                value="<c:out value="${customer.password}" />" /> <br /> 
            Email : <input type="text" name="email"
                           value="<c:out value="${customer.email}" />" /> <br /> 

           <button type="submit" class="loginbtn">Submit Changes</button>
        </form> 

                           <a href="RentalHistory.jsp" style="margin-left:30px;">View Rental History</a>
                           <a href="CurrentRentals.jsp" style="margin-left:30px;">View Current Rentals</a>
                           <a href="WishList.jsp" style="margin-left:30px;">View Wish List</a>
        
    </body>
</html> 
