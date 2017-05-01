
import java.io.IOException;
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
            int orderNum = Integer.parseInt(request.getParameter("cartItem_id"));
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
    
    
}
