<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
    <body bgcolor="FFFFFF" background="backgrounds/stripevertbg6.gif" topmargin="0" marginheight="0" leftmargin="0" marginwidth="0"> 
    <head>
        <link rel="stylesheet" href="resources/css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home Page</title>
    </head>
    <div align="center">
        <br>
        <br>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/sakila"
                           user="root"  password="nbuser"/>

        <sql:query dataSource="${snapshot}" var="result">
            SELECT * from cart
        </sql:query>
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

        <table width="850" style="BACKGROUND-COLOR: #FFFFFF;" border="1">
            <thead>
                <tr>
                    <th></th>
                    <th>Movie Title</th>
                    <th>Movie Description</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td bgcolor="ffffff" align="center" valign="middle" class="cart-td-trash">&nbsp;<a href="cart.cfm?op=del&id=213051&cid=41"><img src="images/trash.gif" alt="Remove&nbsp;" title="Remove&nbsp;" border="0"></a>&nbsp;</td>
                        <td><c:out value="${product.custID}" /></td>
                        <td><c:out value="${product.Price}" /></td>
                        <td><c:out value="${product.quantity}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <table width="850" bgcolor="ffffff" border="1">
            <tr>
                <td align="center">
                    <br>
                    <img src="https://secure.ironhorsemedia.com/client_headers/furnituredemo/graphics/brownbar.jpg">
                    <br>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <br>
                    <div style="width:650px;" align="justify">
                        This is a custom HTML footer.  This footer may contain any HTML code, text,
                        graphics, active content such as dropdown menus, java, javascript, or other
                        content that you would like to display at the bottom of your cart pages.  You create
                        custom HTML footer yourself and specify its location in the CustomCart Administrator.
                        This footer is not required, but does add a nice custom touch to your cart.
                    </div>
                    <br>
                    <br>
                </td>
            </tr>
        </table> 
        <p><a href="index.xhtml">Back to Search</a></p>
        <p><a href="checkout.xhtml">Checkout Cart</a></p>
    </div>
    <p><br><br>
</html>
