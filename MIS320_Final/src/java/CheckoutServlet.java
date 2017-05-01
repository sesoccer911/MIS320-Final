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
 * @author Brandon
 */
@WebServlet(urlPatterns = {"/CheckoutServlet"})
public class CheckoutServlet extends HttpServlet {


    public static java.sql.Timestamp convertToSqlDateTime(Date utilDate) {
        return new java.sql.Timestamp(utilDate.getTime());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        String paypalID = request.getParameter("paypalID");
//        String customerID = request.getParameter("customerID");
//        String filmID = request.getParameter("filmID");
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "nbuser");
//            Statement st = con.createStatement();
//            String query = "INSERT INTO transaction(paypal_id, customer_id, film_id)"
//                    + " values (?, ?, ?)";
//            PreparedStatement preparedStmt = con.prepareStatement(query);
//            preparedStmt.setString(1, paypalID);
//            preparedStmt.setString(2, customerID);
//            preparedStmt.setString(3, filmID);
//            // execute the preparedstatement
//            preparedStmt.executeUpdate();
//            con.close();
//
//
//
//        } 
//        catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            out.println("Database Connection Not Established");
//        }
//           // if (transactionID != null) {
//                //session.setAttribute("userid", user);
//                //response.sendRedirect("login.jsp");
//                out.print("Checkout Successfull!"+"<a href='index.xhtml'>Go to Search Page</a>");
//            } 
//            else {
//                response.sendRedirect("cart.jsp");
//            }
 }
}
