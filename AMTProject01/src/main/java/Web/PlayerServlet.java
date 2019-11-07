/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Model.Player;
import Services.MatchesManager;
import Services.PlayerManager;
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
public class PlayerServlet extends HttpServlet {
   
PlayerManager playerManager = new PlayerManager();
MatchesManager mm= new MatchesManager();
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
         String requestedUser= request.getParameter("u");
        Player p = playerManager.getPlayer(requestedUser);
        
        if(p!=null){
            request.setAttribute("thePlayer", p);
            request.setAttribute("matches", mm.getMatchesPlayedBy(p));

            request.getRequestDispatcher("WEB-INF/pages/Player.jsp").forward(request,response);
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
    }// </editor-fold>

}
