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
        
        <script type="text/javascript">

// Captcha Script

            function checkform(theform) {
                var why = "";

                if (theform.CaptchaInput.value == "") {
                    why += "- Please Enter CAPTCHA Code.\n";
                }
                if (theform.CaptchaInput.value != "") {
                    if (ValidCaptcha(theform.CaptchaInput.value) == false) {
                        why += "- The CAPTCHA Code Does Not Match.\n";
                    }
                }
                if (why != "") {
                    alert(why);
                    return false;
                }
            }

            var a = Math.ceil(Math.random() * 9) + '';
            var b = Math.ceil(Math.random() * 9) + '';
            var c = Math.ceil(Math.random() * 9) + '';
            var d = Math.ceil(Math.random() * 9) + '';
            var e = Math.ceil(Math.random() * 9) + '';

            var code = a + b + c + d + e;
            document.getElementById("txtCaptcha").value = code;
            document.getElementById("CaptchaDiv").innerHTML = code;

// Validate input against the generated number
            function ValidCaptcha() {
                var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
                var str2 = removeSpaces(document.getElementById('CaptchaInput').value);
                if (str1 == str2) {
                    return true;
                } else {
                    return false;
                }
            }

// Remove the spaces from the entered and generated code
            function removeSpaces(string) {
                return string.split(' ').join('');
            }
        </script>
    </body>
</html>
