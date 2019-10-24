package ch.heig.amt.project.one.presentation;

import ch.heig.amt.project.one.business.interfaces.UsersManagerLocal;
import ch.heig.amt.project.one.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RegistrationServlet")
public class RegisterServlet extends HttpServlet {
    @EJB
    UsersManagerLocal usersManagerLocal;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        List<String> errors = new ArrayList<>();
        if(username == null || username.trim().equals("")) {
            errors.add("Le nom d'utilisateur ne peut pas être vide");
        }
        User user = usersManagerLocal.findUserByUsername(username);
        if(user.getUsername() != null && user.getUsername().equals(username)) {
            errors.add("Le compte existe déjà, veuillez-vous connecter");
        }
        if(password1 == null || password1.trim().equals("")) {
            errors.add("Le mot de passe ne peut pas être vide");
        }
        if(password2 == null || password2.trim().equals("")) {
            errors.add("La répétition du mot de passe ne peut pas être vide");
        }
        if(!password1.equals(password2)) {
            errors.add("Les mots de passe doivent correspondrent");
        }

        if(errors.size() == 0) {
            boolean createdUser = usersManagerLocal.create(username, password1);
            if(createdUser) {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        } else {
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }
}
