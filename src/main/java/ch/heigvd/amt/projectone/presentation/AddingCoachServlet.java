package ch.heigvd.amt.projectone.presentation;

import ch.heigvd.amt.projectone.DAO.ITeamDAO;
import ch.heigvd.amt.projectone.model.Coach;

import javax.ejb.DuplicateKeyException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddingCoachServlet", urlPatterns = {"/addingCoach"})
public class AddingCoachServlet extends HttpServlet {
    @EJB
    ITeamDAO td;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Coach coach = (Coach) request.getSession().getAttribute("coach");

        String name = request.getParameter("tname");

        System.out.println(name);

        td.addCoach(coach.getUsername(), name);


        response.getWriter().println("coach train team");
        RequestDispatcher rd = request.getRequestDispatcher("./tableTeamPage/myTeams");
        rd.forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
