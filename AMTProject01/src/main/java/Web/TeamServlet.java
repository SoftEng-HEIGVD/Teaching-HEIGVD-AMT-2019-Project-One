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
import Services.Player.PlayerManager;
import Services.Player.PlayerManagerSQL;
import Services.Team.TeamManagerSQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *Servlet Handling the team detail page
 * @author goturak
 */
public class TeamServlet extends HttpServlet {
    TeamManagerSQL teamManager= new TeamManagerSQL();
    PlayerManager playerManager = new PlayerManagerSQL();
    MatchesManagerSQL matchManager= new MatchesManagerSQL();
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
        String requestedUser= request.getParameter("t");
        Team t;
        t= teamManager.getTeam(requestedUser, (int) request.getSession().getAttribute("id"));
        if(t!=null){
            request.setAttribute("team", t);
            request.setAttribute("players",playerManager.getPlayersFrom(t,(int) request.getSession().getAttribute("id")));
            request.getRequestDispatcher("WEB-INF/pages/Team.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("WEB-INF/pages/PlayerNotFound.jsp").forward(request,response);
        }
    
    }
    
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //To change body of generated methods, choose Tools | Templates.
       JSONObject json = new JSONObject();
       int draw= Integer.parseInt(req.getParameter("draw"));
       int start=Integer.parseInt(req.getParameter("start"));
       int length=Integer.parseInt(req.getParameter("length"));
       json.put("draw", draw);
        JSONArray data = new JSONArray();
     
        
        List<Match> matches=matchManager.getAll((int) req.getSession().getAttribute("id"));     
        json.put("recordsTotal",matches.size());
        json.put("recordsFiltered",matches.size());

        for(int i=start;i< start+length;i++){
            if(i<matches.size()){
                Match m= matches.get(i);
                JSONArray mArray= new JSONArray();
                 if(m.getTeam1()!=null){
                    mArray.add("<a href=\"team?t="+m.getTeam1().getName()+"\">"+m.getTeam1().getName()+"</a>");
                }else{
                    mArray.add("no team");
                }
                mArray.add("<a href=\"match?id="+m.getId()+"\">"+m.getTeam1EndScore()+"-"+m.getTeam2EndScore()+"</a>");
              
                if(m.getTeam2()!=null){
                    mArray.add("<a href=\"team?t="+m.getTeam2().getName()+"\">"+m.getTeam2().getName()+"</a>");
                }else{
                    mArray.add("no team");
                }

                data.add(mArray);
             
            }
            
        }
        json.put("data", data);
        resp.getWriter().write(json.toString());
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
