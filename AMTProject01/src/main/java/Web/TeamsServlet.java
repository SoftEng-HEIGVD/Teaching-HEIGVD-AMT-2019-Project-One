/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Model.Player;
import Model.Team;
import Services.Team.TeamManagerSQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author goturak
 */
public class TeamsServlet extends HttpServlet {
    TeamManagerSQL teamManager= new TeamManagerSQL();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        
         
     
            request.getRequestDispatcher("WEB-INF/pages/Teams.jsp").forward(request,response);
    }

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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //To change body of generated methods, choose Tools | Templates.
       JSONObject json = new JSONObject();
       int draw= Integer.parseInt(req.getParameter("draw"));
       int start=Integer.parseInt(req.getParameter("start"));
       int length=Integer.parseInt(req.getParameter("length"));
       json.put("draw", draw);
        JSONArray data = new JSONArray();
     
        
        List<Team> teams=teamManager.getAllTeams((int) req.getSession().getAttribute("id"));     
        json.put("recordsTotal",teams.size());
        json.put("recordsFiltered",teams.size());

        for(int i=start;i< start+length;i++){
            if(i<teams.size()){
                Team t= teams.get(i);
                JSONArray pl= new JSONArray();
                pl.add("<a href=\"team?t="+t.getName()+"\">"+t.getName()+"</a>");
              
                data.add(pl);
             
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
    }// </editor-fold>

}
