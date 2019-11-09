package ch.heigvd.amt.projectone.presentation;

import ch.heigvd.amt.projectone.DAO.ICoachDAO;
import ch.heigvd.amt.projectone.DAO.IPlayerDAO;
import ch.heigvd.amt.projectone.DAO.ITeamDAO;
import ch.heigvd.amt.projectone.model.Coach;
import ch.heigvd.amt.projectone.model.Player;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TablePlayerServlet", urlPatterns = {"/tablePlayerPage/allPlayers","/tablePlayerPage/myPlayers","/tableTeamPage/myTeams","/tableTeamPage/allTeams","/tableCoachPage"})
public class TablePlayerServlet extends HttpServlet {

    @EJB
    private IPlayerDAO pd;
    @EJB
    private ITeamDAO td;
    @EJB
    private ICoachDAO cd;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/tablePlayer.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Coach coach = (Coach) request.getSession().getAttribute("coach");

        System.out.println(request.getServletPath());
        String path = request.getServletPath();
        request.setAttribute("coach", coach);


        if(path.contains("/tablePlayerPage/")) {
            if (path.equals("/tablePlayerPage/myPlayers")) {
                request.setAttribute("players", pd.findMyTeamPlayers(coach));
            }

            if (path.equals("/tablePlayerPage/allPlayers")) {
                request.setAttribute("players", pd.findAllPlayers());
            }

            request.getRequestDispatcher("/WEB-INF/pages/tablePlayer.jsp").forward(request, response);
        }

        if(path.contains("/tableTeamPage/")) {
            if (path.equals("/tableTeamPage/myTeams")) {
                request.setAttribute("teams", td.findMyTeam(coach.getUsername()));
            }

            if (path.equals("/tableTeamPage/allTeams")) {
                request.setAttribute("teams", td.findAllTeam());
            }

            request.getRequestDispatcher("/WEB-INF/pages/tableTeam.jsp").forward(request, response);
        }

        if(path.equals("/tableCoachPage")) {
                request.setAttribute("coaches", cd.findAllCoach());

                request.getRequestDispatcher("/WEB-INF/pages/tableCoach.jsp").forward(request, response);
        }

    }
}
