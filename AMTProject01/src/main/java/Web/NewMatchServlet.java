/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Model.Match;
import Model.Player;
import Model.Team;
import Services.Match.MatchesManagerSQL;

import Services.Player.PlayerManagerSQL;
import Services.Player.PlayerManager;
import Services.Team.TeamManagerSQL;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author goturak
 */
public class NewMatchServlet extends HttpServlet {

    PlayerManager playerManager = new PlayerManagerSQL();


    TeamManagerSQL teamManager= new TeamManagerSQL();

    MatchesManagerSQL mm= new MatchesManagerSQL();
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        
        ArrayList<Team> ts= new ArrayList(teamManager.getAllTeams((int) request.getSession().getAttribute("id")));
        
            request.setAttribute("teams", ts);
            request.setAttribute("players",playerManager.getAllPlayers((int) request.getSession().getAttribute("id")));
        request.getRequestDispatcher("WEB-INF/pages/matchAdd.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
           // read form fields
        Match nm= new Match(0,
                teamManager.getTeam(req.getParameter("team1"), (int)req.getSession().getAttribute("id")),
                teamManager.getTeam(req.getParameter("team2"), (int)req.getSession().getAttribute("id")),
                Integer.parseInt( req.getParameter("scoreTeam1")),
                 Integer.parseInt(  req.getParameter("scoreTeam2")));
        nm.setCreator((int)req.getSession().getAttribute("id"));
        Player t1p1= playerManager.getPlayer(req.getParameter("t1player1"), (int) req.getSession().getAttribute("id"));
        Player t1p2= playerManager.getPlayer(req.getParameter("t1player2"), (int) req.getSession().getAttribute("id"));
        Player t1p3= playerManager.getPlayer(req.getParameter("t1player3"), (int) req.getSession().getAttribute("id"));
        Player t1p4= playerManager.getPlayer(req.getParameter("t1player4"), (int) req.getSession().getAttribute("id"));
        Player t1p5= playerManager.getPlayer(req.getParameter("t1player5"), (int) req.getSession().getAttribute("id"));
        Player t2p1= playerManager.getPlayer(req.getParameter("t2player1"), (int) req.getSession().getAttribute("id"));
        Player t2p2= playerManager.getPlayer(req.getParameter("t2player2"), (int) req.getSession().getAttribute("id"));
        Player t2p3= playerManager.getPlayer(req.getParameter("t2player3"), (int) req.getSession().getAttribute("id"));
        Player t2p4= playerManager.getPlayer(req.getParameter("t2player4"), (int) req.getSession().getAttribute("id"));
        Player t2p5= playerManager.getPlayer(req.getParameter("t2player5"), (int) req.getSession().getAttribute("id"));

        int [] team1={t1p1.getId(),t1p2.getId(),t1p3.getId(),t1p4.getId(),t1p5.getId()};
                int [] team2={t2p1.getId(),t2p2.getId(),t2p3.getId(),t2p4.getId(),t2p5.getId()};

        mm.addMatch(nm, team1, team2);
            
      resp.sendRedirect("matches");
    }

    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
