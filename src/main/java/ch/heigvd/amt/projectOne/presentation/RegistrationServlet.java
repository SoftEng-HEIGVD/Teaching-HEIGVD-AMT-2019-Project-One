package ch.heigvd.amt.projectOne.presentation;

import ch.heigvd.amt.projectOne.services.dao.CharacterManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    @EJB
    CharacterManagerLocal characterManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordVerify = req.getParameter("passwordVerify");

        List<String> errors = new ArrayList<>();

        if (username == null || username.trim().equals("")) {
            errors.add("Username cannot be empty");
        }
        if (password == null || password.trim().equals("") || passwordVerify == null || passwordVerify.trim().equals("")) {
            errors.add("Password cannot be empty");
        } else {
            if (!password.equals(passwordVerify)) {
                errors.add("Password are not the same");
            }
        }
        try{
            characterManager.findAllCharacters();
            //characterManager.addCharacter(username, password);

        }catch (Exception ex){

            errors.add(ex.getMessage());
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
        }


        req.setAttribute("username", username);

        if (errors.size() == 0) {
            req.setAttribute("username", username);
            req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
        } else {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
        }

    }


}
