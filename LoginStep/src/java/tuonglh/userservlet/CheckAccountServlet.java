/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package tuonglh.userservlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
@WebServlet(name="CheckAccountServlet", urlPatterns={"/CheckAccountServlet"})
public class CheckAccountServlet extends HttpServlet {
    private final String LOGIN_PAGES = "login.html";
    private final String SEARCH_PAGES = "search.jsp";
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
        String url = LOGIN_PAGES;
        try  {
            //B1 neu co cookie thi se get cookie 
            Cookie[] cookies = request.getCookies(); // cookie la 1 file nen la mang string 
            //B2 get data tu cookie neu co 
            if(cookies != null){
                Cookie recentCookie = cookies[cookies.length - 1];
                String phoneNumber = recentCookie.getName();   // name = value cua param 
                String password = recentCookie.getValue();
                
                //B3 call method tu DAO 
                SigninBLI blo = new SigninBLO();
                //2.2 Call method of DAO Object
                Signin result = blo.checkLogin(phoneNumber, password);
                //B4 process
                if(result != null){
                    //get session neu co 
                    HttpSession session = request.getSession();
                    session.setAttribute("USER_INFO", result);
                }// set session 
            }
//        }catch(SQLException ex){
//            log("SQL: " + ex.getMessage());
//        }catch(NamingException ex){
//            log("NamingException :"+ ex.getMessage());
        }
        finally {
            response.sendRedirect(url); // khi server stateless voi browser thi file cookie van con nen dung dispatcher cung duoc 
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
