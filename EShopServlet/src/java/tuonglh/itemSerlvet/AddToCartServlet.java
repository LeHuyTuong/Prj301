/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package tuonglh.itemSerlvet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tuonglh.cart.CartObject;

/**
 *
 * @author USER
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = { "/AddToCartServlet", "/cart" })
public class AddToCartServlet extends HttpServlet {
    private final String SHOPPING_PAGE = "onlineShopping.html";

    /**
     * Processes requests for both HTTP GET and POST methods.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SHOPPING_PAGE;
        String btAction = request.getParameter("btAction");

        try {
            // 1. Customer goes to cart place
            HttpSession session = request.getSession();

            // 2. Customer takes a cart
            CartObject cart = (CartObject) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartObject();
            }

            // Handle different actions
            if ("View your cart".equals(btAction)) {
                url = "viewCart.jsp";
            } else if ("Add item to cart".equals(btAction)) {
                // 3. Get item from form
                String id = request.getParameter("itemID");
                String cboBook = request.getParameter("cboBook");

                // Use cboBook as name (no DB needed for simple dropdown)
                String name = (cboBook != null && !cboBook.isEmpty()) ? cboBook : id;
                if (id == null || id.isEmpty()) {
                    id = name;
                }

                // 4. Add item to cart
                if (name != null && !name.isEmpty()) {
                    cart.addItemToCart(id, name);
                    session.setAttribute("CART", cart);
                }
                url = "viewCart.jsp";
            }
        } catch (Exception ex) {
            log("Error: " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Add items to shopping cart";
    }
}
