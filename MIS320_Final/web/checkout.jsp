<%-- 
    Document   : checkout
    Created on : Apr 29, 2017, 5:00:31 PM
    Author     : Brandon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Blockbuster Checkout</title>
    <head>
        <link rel="stylesheet" href="resources/css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <form method="post" action="CheckoutServlet"
              onsubmit="return checkform(this);">

            <div class="container">


                <label><b>PayPal Username</b></label>
                <input type="text" placeholder="Enter PayPal Username" name="pUser" required>

                <label><b>PayPal Password</b></label>
                <input type="text" placeholder="Enter PayPal Password" name="pPass" required>

                <p>By checking out you agree to our <a href="#">Terms & Privacy</a>.</p>

                <!-- START CAPTCHA -->
                <br>
                <div class="capbox">

                    <div id="CaptchaDiv"></div>

                    <div class="capbox-inner">
                        Type the above number:<br>

                        <input type="hidden" id="txtCaptcha">
                        <input type="text" name="CaptchaInput" id="CaptchaInput" size="15"><br>

                    </div>
                </div>
                <br><br>
                <!-- END CAPTCHA -->

                <button type="button"  class="cancelbtn">Cancel</button>
                <button type="submit" class="checkoutbtn">Checkout</button>
            </div>
        </form>
    </body>
</html>
