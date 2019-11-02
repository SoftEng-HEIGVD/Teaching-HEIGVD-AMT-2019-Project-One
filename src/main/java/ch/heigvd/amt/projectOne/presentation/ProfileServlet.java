package ch.heigvd.amt.projectOne.presentation;

import ch.heigvd.amt.projectOne.model.Character;
import ch.heigvd.amt.projectOne.model.Membership;
import ch.heigvd.amt.projectOne.services.dao.CharacterManagerLocal;
import ch.heigvd.amt.projectOne.services.dao.MembershipManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/profile")

public class ProfileServlet extends HttpServlet {

  @EJB
  private MembershipManagerLocal membershipManager;
  @EJB
  private CharacterManagerLocal characterManager;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Character character;
    HttpSession session = req.getSession();

    if (req.getParameterMap().containsKey("id")) {
      character = characterManager.getCharacterById(Integer.parseInt(req.getParameter("id")));
    } else {
      character = (Character) session.getAttribute("character");
    }

    List<Membership> memberships = membershipManager.getMembershipsByUserId(character.getId());

    req.setAttribute("memberships", memberships);
    req.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
