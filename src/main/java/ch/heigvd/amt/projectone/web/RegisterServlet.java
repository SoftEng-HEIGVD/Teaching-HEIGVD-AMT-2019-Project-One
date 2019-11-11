package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.exceptions.DuplicateKeyException;
import ch.heigvd.amt.projectone.model.Client;
import ch.heigvd.amt.projectone.services.dao.ClientsManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @EJB
    ClientsManagerLocal clientsManagerLocal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String error;

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_confirm = request.getParameter("password_repeat");

        response.setContentType("text/html;charset=UTF-8");

        if (name.isEmpty() || username.isEmpty()|| password.isEmpty() || password_confirm.isEmpty()){
            error = "Mot de passe, username ou name vide !";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);

        } else if (password.equals(password_confirm)){
            try {
                clientsManagerLocal.create(new Client(name,username,password));
                response.sendRedirect(request.getContextPath() + "/login");

            } catch (DuplicateKeyException e) {
                e.printStackTrace();
            }
        } else{
            error = "Les deux passwords ne correspondent pas";
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);

        }

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        //TODO : TO change to an register Page similar to login page)
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }
}
