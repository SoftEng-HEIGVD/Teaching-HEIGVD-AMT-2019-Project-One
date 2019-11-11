/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Model.Team;
import Model.User;
import Services.User.UserManagerSQL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author goturak
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    UserManagerSQL userManager= new UserManagerSQL();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        
        
           
        request.getRequestDispatcher("WEB-INF/pages/Login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
       
        // read form fields
        String username = req.getParameter("username");     
        String pwd = req.getParameter("pwd");
        if(!username.isEmpty()&& !pwd.isEmpty()){
            if(req.getParameter("loginButton")!=null){
                User u= userManager.get(username);
               
                if(u!=null&& u.getPwd().equals(pwd)){
                    req.getSession().setAttribute("id", u.getId());
                    resp.sendRedirect("players");
                }else{
                    req.getRequestDispatcher("WEB-INF/pages/Login.jsp").forward(req,resp);

                }
            }else if(req.getParameter("regButton")!=null){
                if(userManager.get(username)==null){
                        User u= new User (username,pwd);
                        userManager.add(u);
                        u= userManager.get(username);
                    if(u!=null){
                        req.getSession().setAttribute("id", u.getId());
                        resp.sendRedirect("players");
                    }else{
                        req.getRequestDispatcher("WEB-INF/pages/Login.jsp").forward(req,resp);

                    }
                }else{
                    req.getRequestDispatcher("WEB-INF/pages/Login.jsp").forward(req,resp);

                }
                
            }
        }else{
             req.getRequestDispatcher("WEB-INF/pages/Login.jsp").forward(req,resp);

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
