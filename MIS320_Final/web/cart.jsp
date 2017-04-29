<title>Blockbuster Store</title>

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
                <td><c:out value="${product.title}" /></td>
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
    <p><a href="checkout.jsp">Checkout Cart</a></p>
</div>
<p><br><br>
</html>
