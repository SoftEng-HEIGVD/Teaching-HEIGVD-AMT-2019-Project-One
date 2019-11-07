package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.model.Client;
import ch.heigvd.amt.projectone.services.dao.ClientsManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class ChilloutServlet extends HttpServlet {

    @EJB
    ClientsManagerLocal clientsManagerLocal;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error;

        String action = req.getParameter("action");

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        if (action.equals("login")){
            if (username.isEmpty()|| password.isEmpty()){
                error = "Mot de passe ou username vide !";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            } else {
                if (clientsManagerLocal.validConnection(username, password)) {
                    Client client = clientsManagerLocal.findClientByUsername(username);
                    req.getSession().setAttribute("client", client);
                    String path = req.getContextPath() + "/products";
                    resp.sendRedirect(path);
                } else {
                    error = "Le mot de passe ou le username n'est pas valable";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
                }
            }
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }



}
