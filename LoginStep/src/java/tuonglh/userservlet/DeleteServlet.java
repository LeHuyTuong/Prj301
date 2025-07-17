/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tuonglh.userservlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.naming.NamingException;
import tuonglh.registration.SigninBLI;
import tuonglh.registration.SigninBLO;
import tuonglh.registration.SigninCreateError;
import tuonglh.registration.SigninDAO;

/**
 *
 * @author USER
 */
@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {

    private final String ERROR_PAGES = "error.html";

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

        //B1 : get param 
        String phoneNumber = request.getParameter("pk");
        String isRole = request.getParameter("isAdmin");
        String searchValue = request.getParameter("lastSearchValue");
        boolean sendRedirect = false;
        SigninCreateError errors = new SigninCreateError(); // khai bao noi chua loi 

        String url = ERROR_PAGES;
        try {
            // 2.New and Call method
            //2.1 New DAO 
            SigninBLI blo = new SigninBLO();
            //2.2 Call method from DAO Object
            boolean result = false;
            if (isRole.equals("false")) {
                result = blo.deleteValue(phoneNumber);
            }
            if (result == true) {
                url = "searchLastname?"
                        + "&txtSearchValue=" + searchValue;
                sendRedirect = true;
            }else{
                sendRedirect = false;
                errors.setAdminCannotBeDelete("Admin can't delete admin");
                request.setAttribute("CREATE_ERROR", errors);
                url = "DispatchServlet"
                            + "?btAction=Search"
                            + "&txtSearchValue=" + searchValue;
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                
            }
//        }catch(SQLException ex){
//            log("SQL Exception" + ex.getMessage());
//        }catch(NamingException ex){
//            log("NamingException " + ex.getMessage());
        } finally {
            if (sendRedirect) {
                response.sendRedirect(url);
            }
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
