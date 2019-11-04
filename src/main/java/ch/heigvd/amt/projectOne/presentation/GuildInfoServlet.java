package ch.heigvd.amt.projectOne.presentation;

import ch.heigvd.amt.projectOne.model.Character;
import ch.heigvd.amt.projectOne.model.Guild;
import ch.heigvd.amt.projectOne.services.dao.GuildManagerLocal;
import ch.heigvd.amt.projectOne.services.dao.MembershipManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/guilds/info")
public class GuildInfoServlet extends HttpServlet {

    @EJB
    GuildManagerLocal guildManager;
    @EJB
    MembershipManagerLocal membershipManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Guild guild = guildManager.getGuildById(Integer.parseInt(req.getParameter("id")));
        boolean isCharacterMemberOfThisGuild = membershipManager.checkCharacterMembership(
                (Character) req.getSession().getAttribute("character"), guild);

        req.setAttribute("currentCharMembership", isCharacterMemberOfThisGuild);
        req.setAttribute("guild", guild);
        req.getRequestDispatcher("/WEB-INF/pages/guild_info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
