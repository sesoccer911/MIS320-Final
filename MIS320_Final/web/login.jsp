<%-- 
    Document   : login
    Created on : Mar 30, 2017, 12:53:00 PM
    Author     : sgreen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en-US">
    <html>
        <head>
            <link rel="stylesheet" href="main.css">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Login Page</title>
        </head>
        <form action="/action_page.php">
            <div class="imgcontainer">
                <img src="img_avatar2.png" alt="Avatar" class="avatar">
            </div>

            <div class="container">
                <label><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="user" required>

                <label><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="pass" required>

                <button type="submit"class="loginbtn"> Login</button>
                
                <button type="button" class="cancelbtn"> Cancel</button>
                <button type="button" class="registerbtn"> Register</button>
                <input type="checkbox" checked="checked"> Remember me
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
    </html>
