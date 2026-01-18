/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tuonglh.userservlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import javax.naming.NamingException;
import tuonglh.registration.Signin;
import tuonglh.registration.SigninBLI;
import tuonglh.registration.SigninBLO;
import tuonglh.registration.SigninDAO;
import tuonglh.registration.SigninDTO;

/**
 *
 * @author USER
 */
public class LoginServlet extends HttpServlet {

    private final String INVALID_PAGE = "invalid.html";
    private final String SEARCH_PAGE = "search.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String url = INVALID_PAGE;
        String phone = request.getParameter("txtPhoneNumber");
        String password = request.getParameter("txtPassword");
        try {
                //2. Controller call method of Model
                //2.1 New DAO Object
                SigninBLI blo = new SigninBLO();
                //2.2 Call method of DAO Object
                Signin result = blo.checkLogin(phone, password);
                //3. Process tra ket qua cho controller
                if (result != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("USER_INFO", result);
                    url = SEARCH_PAGE;
                    
                    Cookie cookie = new Cookie(phone, password);
                    cookie.setMaxAge(60 * 5);
                    response.addCookie(cookie);  // gio cookie da bao gom ben trong response khi server tra ve browser
                } 
//        } catch (SQLException ex) {
//            log("SQL :" + ex.getMessage());
//        } catch (NamingException ex) {
//            log("Naming : " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        processRequest(request, response);
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
