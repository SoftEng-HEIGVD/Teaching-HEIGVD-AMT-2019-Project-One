package ch.heigvd.amt.projectOne.presentation;

import ch.heigvd.amt.projectOne.model.Class;
import ch.heigvd.amt.projectOne.model.Guild;
import ch.heigvd.amt.projectOne.services.dao.ClassManagerLocal;
import ch.heigvd.amt.projectOne.services.dao.GuildManager;
import ch.heigvd.amt.projectOne.services.dao.GuildManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/guilds")
public class GuildsServlet extends HttpServlet {

  @EJB
  GuildManagerLocal guildManager;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Guild> guilds = guildManager.getAllGuilds();
    req.setAttribute("guilds", guilds);
    req.getRequestDispatcher("/WEB-INF/pages/guilds.jsp").forward(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
