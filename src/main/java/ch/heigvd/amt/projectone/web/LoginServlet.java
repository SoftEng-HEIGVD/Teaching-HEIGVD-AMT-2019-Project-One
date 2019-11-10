package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.model.Client;
import ch.heigvd.amt.projectone.services.dao.ClientsManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name="LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @EJB
    ClientsManagerLocal clientsManagerLocal;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error;

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html;charset=UTF-8");

        if (username.isEmpty()|| password.isEmpty()){
                error = "Mot de passe ou username vide !";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            } else {
                int id = clientsManagerLocal.getIdByUsername(username);
                if (id != -1) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", clientsManagerLocal.getClientById(id));
                    resp.sendRedirect(req.getContextPath()+"/logged/home?id="+id);
                } else {
                    error = "Le mot de passe ou le username n'est pas valable";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
                }
            }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }



}
