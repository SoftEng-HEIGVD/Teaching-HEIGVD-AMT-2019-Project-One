/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;


import Model.Match;
import Services.Match.MatchesManagerSQL;
import Services.Player.PlayerManagerSQL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author goturak
 */
public class MatchServlet extends HttpServlet {
    MatchesManagerSQL mm= new MatchesManagerSQL();
    PlayerManagerSQL pm= new PlayerManagerSQL();
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
         Match m;
        try{
            long requestedMatch= Long.parseLong(request.getParameter("id"));
            m=mm.getMatch(requestedMatch);
        }catch(Exception e){
            m=null;
        }
  
        if(m!=null){
            request.setAttribute("match", m);
            request.setAttribute("team1Players", pm.getPlayersFromMatchTeam1(m.getId()));
            request.setAttribute("team2Players", pm.getPlayersFromMatchTeam2(m.getId()));
            request.getRequestDispatcher("WEB-INF/pages/Match.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("WEB-INF/pages/PlayerNotFound.jsp").forward(request,response);
        }
    
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
