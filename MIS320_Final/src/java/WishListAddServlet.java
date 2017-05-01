import dvdrental.FilmController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Evan
 */
public class WishListAddServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WishListAddServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WishListAddServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FilmController f = new FilmController();
        String s = request.getParameter("output");
        String title = request.getParameter("title");
        try {
            System.out.println(s);
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "nbuser");
            PreparedStatement pr = connection.prepareStatement("select customer_id from customer where username = \"" + s + "\"");
            ResultSet rs = pr.executeQuery();
            int custId = 0;
            while (rs.next()) {
                custId = rs.getInt("customer_id");             
            }
            System.out.println(custId);
            custId++;
            PreparedStatement pre = connection.prepareStatement("select wishList_id from wishlist where customer_id = " + custId);
            ResultSet r = pre.executeQuery();
            int wishListId = 0;
            while(r.next()){
                wishListId = r.getInt("wishList_id");
            }
            System.out.println(wishListId);
            System.out.println(title);
            //Film add = f.prepareFilm();
            //PreparedStatement p = connection.prepareStatement("insert into cartofitems(film_id) VALUES(" +  add.getFilmId() + ")");
            //System.out.println(add.getTitle());
            PreparedStatement prep = connection.prepareStatement("select film_id from film where title = \"" + title + "\"");
            ResultSet result = prep.executeQuery();
            int filmId = 0;
            while(result.next()){
                filmId = result.getInt("film_id");
            }
            PreparedStatement p = connection.prepareStatement("insert into wishlistitems(wishList_wishList_id, film_id) VALUES(\"" + wishListId + "\" , \"" + filmId + "\")");
            p.executeUpdate();
            response.sendRedirect("WishList.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
