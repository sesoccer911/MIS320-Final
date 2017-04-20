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

    @Override
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
            //INSERT INTO sakila.customer (store_id, first_name, last_name, email, address_id, active, create_date, last_update, username, password) 
	//VALUES (1, 'ROBIN', 'HAYES', 'ROBIN.HAYES@sakilacustomer.org', 104, true, '2006-02-14 22:04:36.0', '2006-02-15 04:57:20.0', '', NULL);

            int i = st.executeUpdate("INSERT INTO sakila.customer(store_id, first_name, last_name, email, address_id, active, create_date, last_update, username, password)"
                    + "VALUES(" + storeID + ",'" + fName + "','" + lName + "','" + email + "'," + 1 + "," + "true" + ", CURDATE(), CURDATE()" + ",'" + userID +"','" + password+"')");
           //int i = st.executeUpdate("INSERT INTO sakila.customer(store_id, first_name, last_name, email, address_id, active, create_date, last_update, username, password)" +
           //"VALUES(" + 1 + "," + "'test'" +"," + "'test', 'test', 101, true, '2017-04-09 21:11:43.321', '2017-04-09 21:12:02.124', 'test', 'test')");
            

            if (i > 0) {
                //session.setAttribute("userid", user);
                //response.sendRedirect("welcome.jsp");
                // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Database Connection Not Established");
        }
    }
}
