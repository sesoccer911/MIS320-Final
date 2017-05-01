<%-- 
    Document   : WishList
    Created on : Apr 30, 2017, 9:43:09 PM
    Author     : Evan
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
        <title>Wish List</title>
    </head>
    <body>
         <table width="850" border="1" class="cart">
                    <thead>
                        <tr>
                            <th>Movie Title</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${result.rows}" var="wishlist">
                            <tr>
                                <td><a href="WishListServlet.java?action=delete&cartItem_id=<c:out value="${wishlist.wishList_id}"/>">Delete</a></td>                
                                <td><c:out value="${wishlist.title}" /></td>
                                <td class="price"><c:out value="${wishlist.Price}" /></td>
                            </tr>
                        </c:forEach>
                        <tr class="totalColumn">
                            <td  colspan="2" align="right" ><b>Subtotal: </b></td>
                    <form action="account.jsp" method="post" border="">
                        <c:forEach items="${subtotal.rows}" var="subtotal">
                            <td class="price"><c:out value="${subtotal.Subtotal}" /></td>
                        </c:forEach>

                        </tr>
                        </tbody>
                </table>
        
        <p><form action="account.jsp" method="post">
                            <button type="submit" name="your_name" value="your_value" class="accloginbtn">Back To Account</button>
                        </form>
    </body>
</html>
