<%-- 
    Document   : login
    Created on : Mar 28, 2017, 12:53:00 PM
    Author     : sgreen
--%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
    <head>
        <link rel="stylesheet" href="resources/css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home Page</title>
    </head>
    <body> 
        <br>
        <br>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/sakila"
                           user="root"  password="nbuser"/>
        <div align="center">
            <script>
                (function (global) {
                    document.getElementById("output").value = global.localStorage.getItem("mySharedData");
                }(window));
            </script>
            <table width="850" style="BACKGROUND-COLOR: #FFFFFF;" border="1">
                <tr>
                    <td align="center">
                        <img src="images/cart.png">
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="3">
                        <table width="650">
                            <tr>
                                <td>
                                    <div align="justify" style="color:#3e160e;">
                                        This is a custom HTML header.  This header may contain any HTML code, text,
                                        graphics, active content such as dropdown menus, java, javascript, or other
                                        content that you would like to display at the top of your cart pages.  You create
                                        custom HTML header yourself and specify its location in the CustomCart Administrator.
                                        Also note the custom wallpaper (brown striped background), this is uploaded via the
                                        administrator.  You may change the wallpaper any time you wish to change the look of
                                        your cart.
                                    </div>
                                </td>
                            </tr>
                        </table>
                    </td>
                <tr>
                <tr>
                </tr>
            </table>
        </div> 
        <div align="center">

            <table width="850" border="1">
                <thead>
                    <tr>
                        <th>Action</th>
                        <th>Movie Title</th>
                        <th>Movie Description</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${cart}" var="cart">
                        <tr>
                            <td><a href="CartServlet?action=delete&orderNum=<c:out value="${product.orderNum}"/>">Delete</a></td>
                            <td><c:out value="${cart.custID}" /></td>
                            <td><c:out value="${cart.Price}" /></td>
                            <td><c:out value="${cart.quantity}" /></td>
                        </tr>
                    </c:forEach>
                    <tr class="cart-tr-subtotal">
                        <td bgcolor="ffffff" colspan="3" align="right" ><b>Subtotal:</b></td>
                        <td bgcolor="ffffff" align="right" ><b>$595</b>&nbsp;</td>
                    </tr>
                </tbody>
            </table>
            <table width="850" border="1">
                <tr>
                <div style="width:650px;">
                    <p><a href="index.xhtml">Back to Search</a> <span> <a href="checkout.jsp">Checkout Cart</a></p></span>
                </div>
                </tr>
                </tbody>
            </table>

</html>
