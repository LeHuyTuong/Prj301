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
@WebServlet(name = "UpdateAccountServlet", urlPatterns = {"/UpdateAccountServlet"})
public class UpdateAccountServlet extends HttpServlet {

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
        //B1 get data tu request 
        String phone = request.getParameter("txtphoneNumber");
        String password = request.getParameter("txtPassword");
        String role = request.getParameter("chkRole");
        String searchValue = request.getParameter("lastSearchValue");
        SigninCreateError errors = new SigninCreateError(); // khai bao noi chua loi 

        boolean foundErr = false;
        boolean sendRedirt = false;
        String url = ERROR_PAGES;
        try {
            boolean isRole = Boolean.parseBoolean(role);
            if (role != null) {
                isRole = true;
            } else {
                isRole = false;
            }

            // System.out.println("Bug sau result");
            //3 Process 
            if (password.trim().length() < 8
                    || password.trim().length() > 20) {
                foundErr = true;
                errors.setPasswordNotLengthErr("Password is requirement typing from 8 to 20 characters");
            }
            if (foundErr) {
                sendRedirt = false;
                request.setAttribute("CREATE_ERROR", errors);
                url = "DispatchServlet"
                        + "?btAction=Search"
                        + "&txtSearchValue=" + searchValue;
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);   // sau khi ma da forward roi thi gui requestScope ra jsp de in error 
            } else {
                //b2 call method
                //2.1 New DAO 
                SigninBLI blo = new SigninBLO();

                //2.2 Call method from DAO Object 
                boolean result = blo.updateAccount(phone, password, isRole);
                if (result == true) {
                    url = "searchLastname?"
                            + "&txtSearchValue=" + searchValue; // co bao nhieu input thi them bay nhieu param vao trong url 
                }

                //System.out.println("Bug nè nhan duoc url roi");
            }// co gia tri trong DTO 
            //  System.out.println("ket qua result" + result);
//        }catch(SQLException ex){
//            log("SQL:" + ex.getMessage());
//        }catch(NamingException ex){
//            log("NamingException : "+ ex.getMessage());
        } finally {
            // System.out.println("Bug nè di thoi ");
            if(sendRedirt){
            response.sendRedirect(url);
            }
            //System.out.println("Bug nè di thoi ");
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
