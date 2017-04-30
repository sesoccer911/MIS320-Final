/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
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


    public static java.sql.Timestamp convertToSqlDateTime(Date utilDate) {
        return new java.sql.Timestamp(utilDate.getTime());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String storeID = request.getParameter("storeID");
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String address_id = "00";
        String userID = request.getParameter("userID");
        String password = request.getParameter("password");

        java.sql.Timestamp create_date;
        create_date = new Timestamp(Calendar.getInstance().getTimeInMillis());
        java.sql.Timestamp last_update = create_date;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "nbuser");

            Statement st = con.createStatement();
            String query = "INSERT INTO sakila.customer(store_id, first_name, last_name, email, address_id, active, create_date, last_update, username, password)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            INSERT INTO sakila.customer(store_id, first_name, last_name, email, address_id, active, create_date, last_update, username, password) 
//            VALUES(1, 'test', 'test', 'test', 101, true, '2017-04-09 21:11:43.321', '2017-04-09 21:12:02.124', 'test', 'test'
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, storeID);
            preparedStmt.setString(2, fName);
            preparedStmt.setString(3, lName);
            preparedStmt.setString(4, email);
            preparedStmt.setBoolean(5, true);
            preparedStmt.setString(6, address_id);
            preparedStmt.setTimestamp(7, create_date);
            preparedStmt.setTimestamp(8, last_update);
            preparedStmt.setString(9, userID);
            preparedStmt.setString(10, password);
            // execute the preparedstatement
            preparedStmt.execute();
            con.close();



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Database Connection Not Established");
        }
                    if (userID != null) {
                //session.setAttribute("userid", user);
                //response.sendRedirect("login.jsp");
                out.print("Registration Successfull!"+"<a href='login.jsp'>Go to Login</a>");
            } else {
                response.sendRedirect("login.jsp");
            }
    }
}
