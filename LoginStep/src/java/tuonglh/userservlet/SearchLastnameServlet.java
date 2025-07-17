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
import java.util.List;
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
@WebServlet(name="SearchLastnameServlet", urlPatterns={"/SearchLastnameServlet"})
public class SearchLastnameServlet extends HttpServlet {
    private final String SEARCH_PAGE ="search.jsp";
    private final String SEARCH_RESULT ="search.jsp";
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
        //1,Get all user's information
        
        String searchValue = request.getParameter("txtSearchValue");
        String url = SEARCH_PAGE;
        try {
            if(!searchValue.trim().isEmpty()){
                // ko empty trim 
                //2 Controller call method of Model 
                //2.1 New DAO Object 
                    SigninBLI blo = new SigninBLO();
                    
                //2.2 Call Method of DAO Object
                List<Signin> result =  blo.searchLastName(searchValue);
                //3.Get du lieu tu method 
//                List<SigninDTO> result = blo.getAccounts();
                url = SEARCH_RESULT;
                
                // gio thi da co thong tin roi muon set attribute de hien thi view thi  se setAttri vao jsp
                request.setAttribute("SEARCH_RESULT", result);
            }
//        }catch(SQLException ex){
//            log("SQL :" + ex.getMessage());
//        }catch(NamingException ex){
//            log("NamingException : " + ex.getMessage());
        }
        finally{
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
