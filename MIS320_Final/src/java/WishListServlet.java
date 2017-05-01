import dvdrental.FilmController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Evan
 */
public class WishListServlet extends HttpServlet
{
    private static String LIST_PRODUCT = "/WishList.jsp";
    private WishListDao dao;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";

        String action = request.getParameter("action");
        System.out.println(action);
        if (action.equalsIgnoreCase("delete")) {
            int orderNum = Integer.parseInt(request.getParameter("wishItems_id"));
            dao.deleteProduct(orderNum);
            forward = LIST_PRODUCT;
            //request.setAttribute("products", dao.getAllProducts());
        } else {
            forward = LIST_PRODUCT;
        }

        //fowards it to the specific page
        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FilmController f = new FilmController();
        String s = request.getParameter("custId");
        String title = request.getParameter("title");
        try {
            System.out.println(s);
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "nbuser");
            PreparedStatement pr = connection.prepareStatement("Select W.customer_id\n"
                    + "from wishlist as W\n"
                    + "join wishlistitems as WI\n"
                    + "on WI.wishList_wishList_id = W.wishList_id\n"
                    + "join customer as CS\n"
                    + "on CS.customer_id = W.customer_id\n"
                    + "where username = " + s + "\n"
                    + "limit 1;");
            ResultSet rs = pr.executeQuery();
            int custId = 0;
            while (rs.next()) {
                custId = rs.getInt("customer_id");
            }
            System.out.println(custId);
            custId++;
            PreparedStatement pre = connection.prepareStatement("Select sum(F.rental_rate * F.rental_duration)as Subtotal\n"
                    + "from wishlist as W\n"
                    + "join wishlistitems as WI\n"
                    + "on WI.wishList_wishList_id = W.wishList_id\n"
                    + "join film as F\n"
                    + "on WI.film_id = F.film_id\n"
                    + "join customer as CS\n"
                    + "on CS.customer_id = W.customer_id\n"
                    + "Where username =  " + custId);
            ResultSet r = pre.executeQuery();
            int wishListId = 0;
            while (r.next()) {
                wishListId = r.getInt("wishList_id");
            }
            System.out.println(wishListId);
            System.out.println(title);
            PreparedStatement prep = connection.prepareStatement("Select F.title, (F.rental_rate * F.rental_duration) as Price, wishItems_id\n"
                    + "from wishlist as W\n"
                    + "join wishlistitems as WI\n"
                    + "on WI.wishList_wishList_id = W.wishList_id\n"
                    + "join film as F\n"
                    + "on WI.film_id = F.film_id\n"
                    + "join customer as CS\n"
                    + "on CS.customer_id = W.customer_id\n"
                    + "Where username = " + custId);
            ResultSet result = prep.executeQuery();
            int filmId = 0;
            while (result.next()) {
                filmId = result.getInt("film_id");
            }
            PreparedStatement p = connection.prepareStatement("insert into cartofitems(wishList_wishList_id, film_id) VALUES(\"" + wishListId + "\" , \"" + filmId + "\")");
            p.executeUpdate();
            response.sendRedirect("WishList.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
