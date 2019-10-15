package ch.heigvd.amt.projectOne.presentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String firstName = req.getParameter("username");
    String lastName = req.getParameter("pasword");

    List<String> errors = new ArrayList<>();
    if (firstName == null || firstName.trim().equals("")) {
      errors.add("First name cannot be empty");
    }
    if (lastName == null || lastName.trim().equals("")) {
      errors.add("Last name cannot be empty");
    }


    req.setAttribute("firstName", firstName);
    req.setAttribute("lastName", lastName);
    if (errors.size() == 0) {
      req.setAttribute("fullName", firstName + " " + lastName);
      req.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(req, resp);
    } else {
      req.setAttribute("errors", errors);
      req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

  }
}
