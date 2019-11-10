package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.services.dao.ClientsManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = "/logged/home")
public class HomeServlet extends HttpServlet {

    @EJB
    ClientsManagerLocal clientsManagerLocal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("user", clientsManagerLocal.getClientById(Integer.parseInt(req.getParameter("id"))));
        //TODO : TO change to an Home Page with tab Products , Orders, Account (with infos and logout)
        req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
    }
}
