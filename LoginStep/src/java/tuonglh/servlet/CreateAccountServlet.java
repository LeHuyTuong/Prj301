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
import tuonglh.registration.SigninCreateError;
import tuonglh.registration.SigninDAO;
import tuonglh.registration.SigninDTO;

/**
 *
 * @author USER
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    private final String CREATE_PAGE = "createAccount.jsp";
    private final String LOGIN_PAGE = "login.html";

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
        //b1 get all User info 
        String phoneNumber = request.getParameter("txtPhoneNumber");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullName = request.getParameter("txtFullName");
        String url = CREATE_PAGE;

        SigninCreateError errors = new SigninCreateError(); // khai bao cho de loi 
        boolean foundErr = false;

        try {
            if (phoneNumber.trim().length() != 10) {
                foundErr = true;
                errors.setPhoneNumberNotFormat(
                        "Phone Number is requestment type 10 number");
            }
            if (password.trim().length() < 8 || password.trim().length() > 40) {
                foundErr = true;
                errors.setPasswordNotLengthErr(
                        "Password is requestment type more than 8 end less than 40");
            } else if (!confirm.trim().equals(password.trim())) {
                foundErr = true;
                errors.setConfirmNotMatch("Confirm not match Password");
            }
            if (fullName.trim().length() < 8 || fullName.trim().length() > 40) {
                foundErr = true;
                errors.setFullNameNotLengthErr(
                         "FullName is requestment type more than 8 end less than 40");
            }
            if (foundErr == true) {
                request.setAttribute("CREATE_ERRORS", errors);
            } else {
                //2 call method from dao object 
                //2.1 call dao
                SigninDAO dao = new SigninDAO();
                //2.2 call method
                SigninDTO accounts = new SigninDTO(phoneNumber, password, false, fullName);
                boolean result = dao.createAccount(accounts);
                //3 process
                if (result) {
                    url = LOGIN_PAGE;
                }// user is exist
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("SQL " + msg);
            if(msg.contains("duplicate")){
                errors.setPhoneNumberIsExist(phoneNumber + "duplicate");
                request.setAttribute("CREATE_ERRORS", errors);
            }
        } catch (ClassNotFoundException ex) {
            log("Class not found " + ex.getMessage());
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
