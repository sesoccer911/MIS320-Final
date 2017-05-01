<%-- 
    Document   : RentalHistory
    Created on : Apr 30, 2017, 9:42:31 PM
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
        <title>Rental History</title>
    </head>
    <body>
        
        
        
        <table width="850" border="1" class="cart">
                    <thead>
                        <tr>
                            <th>Movie Title</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${result.rows}" var="wishlist">
                            <tr>>
                            </tr>
                        </c:forEach>

                        </tr>
                        </tbody>
                </table>
        
        <p><form action="account.jsp" method="post">
                            <button type="submit" name="your_name" value="your_value" class="accloginbtn">Back To Account</button>
                        </form>
    </body>
</html>
