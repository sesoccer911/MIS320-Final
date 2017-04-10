/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sesoc
 */
@WebServlet(urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");
        String storeID = request.getParameter("storeID");
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "nbuser");
            Statement st = con.createStatement();
            int i = st.executeUpdate("INSERT INTO sakila.customer(store_id, first_name, last_name, email, address_id, active, create_date, last_update, username, password)"
                    + "VALUES('" + storeID + "','" + fName + "','" + lName + "','" + email + "','" + 00 + "','" + "true" + "', CURDATE(), CURDATE()" + "','" + userID +"','" + password);
//            INSERT INTO sakila.customer(store_id, first_name, last_name, email, address_id, active, create_date, last_update, username, password) 
//            VALUES(1, 'test', 'test', 'test', 101, true, '2017-04-09 21:11:43.321', '2017-04-09 21:12:02.124', 'test', 'test'
            

            if (i > 0) {
                //session.setAttribute("userid", user);
                //response.sendRedirect("welcome.jsp");
                // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Database Connection Not Established");
        }
    }
}
