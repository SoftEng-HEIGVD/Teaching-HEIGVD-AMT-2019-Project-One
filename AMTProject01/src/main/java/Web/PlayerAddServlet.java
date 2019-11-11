/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Model.Player;
import Model.Team;
import Services.Player.PlayerManager;
import Services.Player.PlayerManagerSQL;
import Services.Team.TeamManagerSQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *Servlet Handling the Player Creation Page
 * @author goturak
 */
public class PlayerAddServlet extends HttpServlet {
  
PlayerManager playerManager = new PlayerManagerSQL();
    TeamManagerSQL teamManager= new TeamManagerSQL();
    
    
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
        request.getRequestDispatcher("WEB-INF/pages/PlayerAdd.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
           // read form fields
        String username = req.getParameter("userName");     
        String name = req.getParameter("name");
        String team= req.getParameter("team");
        
        Player np = new Player(0,username,name,teamManager.getTeam(team,(int) req.getSession().getAttribute("id")), (int) req.getSession().getAttribute("id"));
        
        
        playerManager.Add(np);
        req.setAttribute("teams", teamManager.getAllTeams((int) req.getSession().getAttribute("id")));
        req.getRequestDispatcher("WEB-INF/pages/PlayerAdd.jsp").forward(req,resp);
    }

    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
