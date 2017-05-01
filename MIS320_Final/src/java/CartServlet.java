import dvdrental.FilmController;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sesoc
 */
public class CartServlet {

    private static String LIST_PRODUCT = "/cart.jsp";
    private CartDao dao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";

        String action = request.getParameter("action");
        System.out.println(action);
        if (action.equalsIgnoreCase("delete")) {
            int cartItem_id = Integer.parseInt(request.getParameter("cartItem_id"));
            dao.deleteProduct(cartItem_id);
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
            PreparedStatement pr = connection.prepareStatement("Select C.customer_id\n"
                    + "from cart as C\n"
                    + "join cartofitems as CI\n"
                    + "on CI.cart_id = C.cart_id\n"
                    + "join customer as CS\n"
                    + "on CS.customer_id = C.customer_id\n"
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
                    + "from cart as C\n"
                    + "join cartofitems as CI\n"
                    + "on CI.cart_id = C.cart_id\n"
                    + "join film as F\n"
                    + "on CI.film_id = F.film_id\n"
                    + "join customer as CS\n"
                    + "on CS.customer_id = C.customer_id\n"
                    + "Where username =  " + custId);
            ResultSet r = pre.executeQuery();
            int cartId = 0;
            while (r.next()) {
                cartId = r.getInt("cart_id");
            }
            System.out.println(cartId);
            System.out.println(title);
            PreparedStatement prep = connection.prepareStatement("Select F.title, (F.rental_rate * F.rental_duration) as Price, cartItem_id\n"
                    + "from cart as C\n"
                    + "join cartofitems as CI\n"
                    + "on CI.cart_id = C.cart_id\n"
                    + "join film as F\n"
                    + "on CI.film_id = F.film_id\n"
                    + "join customer as CS\n"
                    + "on CS.customer_id = C.customer_id\n"
                    + "Where username = " + custId);
            ResultSet result = prep.executeQuery();
            int filmId = 0;
            while (result.next()) {
                filmId = result.getInt("film_id");
            }
            PreparedStatement p = connection.prepareStatement("insert into cartofitems(cart_id, film_id) VALUES(\"" + cartId + "\" , \"" + filmId + "\")");
            p.executeUpdate();
            response.sendRedirect("cart.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
