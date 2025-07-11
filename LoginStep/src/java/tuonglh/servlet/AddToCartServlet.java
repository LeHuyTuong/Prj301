/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package tuonglh.servlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import javax.naming.NamingException;
import tuonglh.cart.CartObject;
import tuonglh.registration.ItemDAO;

/**
 *
 * @author USER
 */
@WebServlet(name="AddToCartServlet", urlPatterns={"/AddToCartServlet" ,"/cart"})
public class AddToCartServlet extends HttpServlet {
   private final String SHOPPING_PAGE ="onlineShopping.jsp";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SHOPPING_PAGE;
        String searchValue = request.getParameter("lastSearchValue");
        try  {
            //1 Customer goes to cart place
            HttpSession session = request.getSession();
            //2.customer takes a cart
            CartObject cart = (CartObject) session.getAttribute("CART");
            if(cart == null){
                cart = new CartObject();
            }
            //3 customer takes items 
            String id = request.getParameter("itemID");
            //4 Customer drops items to cart 
            ItemDAO dao = new ItemDAO();
            String name = dao.getNameByID(id);
            cart.addItemToCart(id,name);
            session.setAttribute("CART", cart);
            url = "cart"
                    + "?txtSearchItem=" + searchValue
                    + "&btAction=Search+Item";
            //5 redirect to online shopping page
        }
        catch(SQLException ex){
            log("SQL" + ex.getMessage());
        } 
        catch(NamingException ex){
            log("Naming " + ex.getMessage());
        }
        finally{ 
            response.sendRedirect(url);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
