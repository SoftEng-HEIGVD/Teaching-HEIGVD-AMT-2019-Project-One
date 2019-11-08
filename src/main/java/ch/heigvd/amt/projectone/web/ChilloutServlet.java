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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/login")
public class ChilloutServlet extends HttpServlet {

    @EJB
    ClientsManagerLocal clientsManagerLocal;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error;

        Client client = null;

        String username = req.getParameter("username");
//        String username = "jzerbib";
        Logger.getLogger(ChilloutServlet.class.getName()).log(Level.INFO, "Username is : " + username);
//        String password = req.getParameter("password");
        String password = "jzerbib";
        resp.setContentType("text/html;charset=UTF-8");

        if (username.isEmpty()|| password.isEmpty()){
                error = "Mot de passe ou username vide !";
                req.setAttribute("error", error);
                req.setAttribute("user", username);
                req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            } else {
                if (clientsManagerLocal.validConnection(username, password)) {
                    client = clientsManagerLocal.findClientByUsername(username);
                    req.getSession().setAttribute("client", client);
                    req.setAttribute("user", username);
                    String path = req.getContextPath() + "/login/products";
                    resp.sendRedirect(path);
                } else {
                    error = "Le mot de passe ou le username n'est pas valable";
                    req.setAttribute("error", error);
                    req.setAttribute("user", username);
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
