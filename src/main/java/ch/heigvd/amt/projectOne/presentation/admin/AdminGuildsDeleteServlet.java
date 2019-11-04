package ch.heigvd.amt.projectOne.presentation.admin;

import ch.heigvd.amt.projectOne.model.Guild;
import ch.heigvd.amt.projectOne.services.dao.GuildManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/guilds/delete")
public class AdminGuildsDeleteServlet extends HttpServlet {

    @EJB
    private GuildManagerLocal guildManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameterMap().containsKey("id")) {
            HttpSession session = req.getSession();
            if (!guildManager.deleteGuild(Guild.builder().id(Integer.parseInt(req.getParameter("id"))).build())){
                session.setAttribute("deleteStatus", "Unable to delete the guild");
            }else{
                session.setAttribute("deleteStatus", "Guild deleted");
            }
            resp.sendRedirect(req.getContextPath() + "/admin/guilds");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
