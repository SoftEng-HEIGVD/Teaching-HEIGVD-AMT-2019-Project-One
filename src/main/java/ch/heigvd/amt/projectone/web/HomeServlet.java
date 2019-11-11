package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.services.dao.ClientsManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    @EJB
    ClientsManagerLocal clientsManagerLocal;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("user", clientsManagerLocal.getClientById(Integer.parseInt(req.getParameter("id"))));
        req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
    }
}
