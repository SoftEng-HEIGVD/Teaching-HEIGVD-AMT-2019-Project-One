package ch.heigvd.amt.projectOne.presentation;

import ch.heigvd.amt.projectOne.services.dao.MembershipManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/guilds/leave")
public class GuildLeaveServlet extends HttpServlet {

    @EJB
    MembershipManager membershipManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int guildId = Integer.parseInt(req.getParameter("id"));



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
