package controller;

import dao.DigitalDAO;
import entity.Digital;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DigitalDAO dao = new DigitalDAO();
        Digital top1 = dao.getTop1();
        List<Digital> top5 = dao.getTop5Exclude(top1 != null ? top1.getID() : -1);

        request.setAttribute("top1", top1);
        request.setAttribute("top5", top5);
        request.setAttribute("imagePath", "images/");
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
    }
}