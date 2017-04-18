/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class SearchServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws
            ServletException, IOException {
        String search = request.getParameter("search");
        response.setContentType("text/html");
        if (!((search.trim()).equals(""))) {
            String searchString = getSearchResult(search);
            response.getWriter().write(searchString);
        } else {
            response.getWriter().write("");
        }
    }

    public String getSearchResult(String search) {
        Connection conn = null;
        Statement st = null;
        ResultSet res = null;
        String finalSearch = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "nbuser");
            st = conn.createStatement();
            String s = "SELECT title FROM film WHERE title like'" + search + "%'ORDER BY title";
            res = st.executeQuery(s);
            while (res.next()) {
                String un = res.getString(1);
                finalSearch += un + "\n";
            }
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finalSearch;
    }
}
