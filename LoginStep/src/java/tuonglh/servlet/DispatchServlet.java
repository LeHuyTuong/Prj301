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

/**
 *
 * @author USER
 */
@WebServlet(name="DispatchServlet", urlPatterns={"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {
    private final  String LOGIN_PAGE = "login.html";
    private final  String LOGIN_CONTROLLER = "LoginServlet";
    private final  String SEARCH_CONTROLLER = "SearchLastnameServlet";
    private final  String CACULATOR_CONTROLLER = "CaculatorServlet";
    private final  String DELETER_CONTROLLER = "DeleteServlet";
    private final  String CHECK_ACCOUNT_CONTROLLER ="CheckAccountServlet";
    private final  String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountServlet";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String button = request.getParameter("btAction");
        String url = LOGIN_PAGE;
        response.setContentType("text/html;charset=UTF-8");
        //1. Which button user click
        
        try {
            
            //1.Check Button 
            if(button == null){
                url = CHECK_ACCOUNT_CONTROLLER;
            }else{
                switch (button) {
                    case "Login":
                        url = LOGIN_CONTROLLER;
                        break;
                    case "Search":
                        url = SEARCH_CONTROLLER;
                        break;
                    case "Caculator":
                        url= CACULATOR_CONTROLLER;
                        break;
                    case "Delete":
                        url = DELETER_CONTROLLER;
                        break;
                    case "Update":
                        url = UPDATE_ACCOUNT_CONTROLLER;
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            
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
