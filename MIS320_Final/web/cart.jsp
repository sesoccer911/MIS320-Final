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
        <script type="text/javascript" src="resources/scripts/jquery-1.8.2.min.js"></script>
        <title>Home Page</title>
    </head>
    <body> 
        <br>
        <br>
        <script>
            (function (global) {
                document.getElementById("output").value = global.localStorage.getItem("mySharedData");
            }(window));
        </script>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/sakila"
                           user="root"  password="nbuser"/>
        <sql:query dataSource="${snapshot}" var="result">
            Select F.title, (F.rental_rate * F.rental_duration) as 'Price'
            from cart as C
            join cartofitems as CI
            on CI.cart_id = C.cart_id
            join film as F
            on CI.film_id = F.film_id
        </sql:query>
        <div align="center">
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
            <form action="checkout.jsp" method="post" border="">
                <table width="850" border="1" class="cart">
                    <thead>
                        <tr>
                            <th>Action</th>
                            <th>Movie Title</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${result.rows}" var="cart">
                            <tr>
                                <td><a href="CartServlet?action=delete&orderNum=<c:out value="${product.orderNum}"/>">Delete</a></td>
                                <td><c:out value="${cart.title}" /></td>
                                <td class="price"><c:out value="${cart.Price}" /></td>
                            </tr>
                        </c:forEach>
                        <tr class="totalColumn">
                            <td bgcolor="ffffff" colspan="2" align="right" ><b>Subtotal: </b></td>
                            <td bgcolor="ffffff" align="right" ><b><span id="subtotal"></span></b></td>
                    <script language="javascript" type="text/javascript">
                        var tds = document.getElementById('cart').getElementsByTagName('td');
                        var sum = 0;
                        for (var i = 0; i < tds.length; i++) {
                            if (tds[i].className == 'price') {
                                sum += isNaN(tds[i].innerHTML) ? 0 : parseInt(tds[i].innerHTML);
                            }
                        }
                        document.getElementById('price').innerHTML += '<tr><td>' + sum + '</td><td>total</td></tr>';
                    </script>

                    </tr>
                    </tbody>
                </table>
                <table width="850" border="1">
                    <tr>
                    <div style="width:650px;">

                        <button type="submit" name="your_name" value="totalCost" class="loginbtn">Checkout Cart</button>
                        </form>
                        <p><form action="faces/index.xhtml" method="post">
                            <button type="submit" name="your_name" value="your_value" class="adminloginbtn">Back To Search</button>
                        </form>

                    </div>
                    </tr>
                    </tbody>
                </table>

                </body>

                </html>
