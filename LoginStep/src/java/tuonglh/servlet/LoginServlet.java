/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package tuonglh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import tuonglh.registration.RegistrationDAO;

/**
 *
 * @author USER
 */
public class LoginServlet extends HttpServlet {

    private static String INVALID_PAGE = "invalid.html";
    private static String SEARCH_PAGE = "search.html";

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
        String button = request.getParameter("btAction");
        try {
            if (button.equals("Login")) {
                String phoneStr = request.getParameter("txtPhoneNumber");
                int phone = Integer.parseInt(phoneStr);
                String password = request.getParameter("txtPassword");
                //2. Controller call method of Model
                //2.1 New DAO Object
                RegistrationDAO dao = new RegistrationDAO();

                //2.2 Call method of DAO Object
                boolean result = dao.checkLogin(phone, password);

                //3. Process tra ket qua cho controller
                if (result) {
                    url = SEARCH_PAGE;
                    System.out.println(">> Đăng nhập thành công!");
                } else {
                    System.out.println(">> Đăng nhập thất bại!");
                }

                System.out.println("Phone nhập: " + phone);
                System.out.println("Pass nhập: " + password);

            }//user clicked Login button
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {

            response.sendRedirect(url);
            out.close();
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
