package ch.heigvd.amt.projectOne.presentation;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordVerify = req.getParameter("passwordVerify");

        List<String> errors = new ArrayList<>();
        if (firstName == null || firstName.trim().equals("")) {
            errors.add("First name cannot be empty");
        }
        if (lastName == null || lastName.trim().equals("")) {
            errors.add("Last name cannot be empty");
        }
        if (username == null || username.trim().equals("")) {
            errors.add("Username cannot be empty");
        }
        if (email == null || email.trim().equals("")) {
            errors.add("Email cannot be empty");
        } else {
            if (email.indexOf('@') == -1) {
                errors.add("Invalid format for email.");
            }
        }
        if (password == null || password.trim().equals("") || passwordVerify == null || passwordVerify.trim().equals("")) {
          errors.add("Password cannot be empty");
        }else {
          if(!password.equals(passwordVerify)){
            errors.add("Password are not the same");
          }
        }


        req.setAttribute("firstname", firstName);
        req.setAttribute("lastname", lastName);
        req.setAttribute("email", email);
        req.setAttribute("username", username);

        if (errors.size() == 0) {
            req.setAttribute("fullName", firstName + " " + lastName);
            req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
        } else {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(req, resp);
        }

    }


}
