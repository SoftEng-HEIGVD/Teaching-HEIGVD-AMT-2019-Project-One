/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Model.Team;
import Services.PlayerManager;
import Services.TeamManager;
import java.io.IOException;
import java.io.PrintWriter;
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

    PlayerManager playerManager = new PlayerManager();
    TeamManager teamManager= new TeamManager();
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
        
        ArrayList<Team> ts= new ArrayList(teamManager.getAllTeams());
        
            request.setAttribute("teams", ts);
            request.setAttribute("players",playerManager.getAllPLayers());
        request.getRequestDispatcher("WEB-INF/pages/matchAdd.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
           // read form fields
        String username = req.getParameter("userName");     
        String name = req.getParameter("name");
        String team= req.getParameter("team");
        
        
        
            
        ArrayList<Team> ts= new ArrayList(teamManager.getAllTeams());
        
        req.setAttribute("teams", ts);
        req.getRequestDispatcher("WEB-INF/pages/matchAdd.jsp").forward(req,resp);
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
