package ch.heigvd.amt.projectone.presentation;

import ch.heigvd.amt.projectone.DAO.*;
import ch.heigvd.amt.projectone.model.Coach;
import ch.heigvd.amt.projectone.model.Team;

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

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {

    @EJB
    ICoachDAO cd;

    @EJB
    ITeamDAO td;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName =request.getParameter("first_name");
        String lastName  =request.getParameter("last_name");
        String userName  =request.getParameter("username");
        String password  =request.getParameter("password");
        String team  =request.getParameter("team");
        boolean isAdmin  = false;

        System.out.println(team);
        Team t = td.findById(team);
        Coach c = Coach.builder().firstName(firstName)
                .lastName(lastName)
                .username(userName)
                .password(password)
                .isAdmin(isAdmin)
                .build();

        try {
            cd.create(c);
            response.getWriter().println("coach created");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(request, response);
    }

}