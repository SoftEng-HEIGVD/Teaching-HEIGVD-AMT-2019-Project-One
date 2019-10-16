package ch.heigvd.amt.projectOne.presentation;

import ch.heigvd.amt.projectOne.model.Character;
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

@WebServlet(urlPatterns = "/login")

public class LoginServlet extends HttpServlet {
  @EJB
  private CharacterManagerLocal characterManager;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getSession().getAttribute("username") != null) {
      req.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(req, resp);
    } else {
      req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    List<String> errors = new ArrayList<>();
    if (username == null || username.trim().equals("")) {
      errors.add("First name cannot be empty");
    }
    if (password == null || password.trim().equals("")) {
      errors.add("Password cannot be empty");
    }

    /* Check dans la DB */
    List<Character> chars = characterManager.findAllCharacters();

    req.setAttribute("firstName", username);
    //req.setAttribute("lastName", password);

    if (errors.size() == 0) {
      //req.setAttribute("fullName", firstName + " " + lastName);
      req.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(req, resp);
    } else {
      req.setAttribute("errors", errors);
      req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

  }
}
