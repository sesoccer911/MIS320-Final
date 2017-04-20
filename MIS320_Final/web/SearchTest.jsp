<%-- 
    Document   : SearchTest
    Created on : Apr 17, 2017, 1:59:19 AM
    Author     : Ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="javascript.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="init()">
        <form name="autofillform" action="autocomplete">
                <table border="0" cellpadding="5">
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><strong>Film Name:</strong></td>
                            <td><input type="text"
                                       size="40"
                                       id="complete-field"
                                       onkeyup="doCompletion();"/></td>
                        </tr>
                        <tr>
                            <td id="auto-row" colspan="2">
                                <table id="complete-table" class="popupBox"></table>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
    </body>
</html>
