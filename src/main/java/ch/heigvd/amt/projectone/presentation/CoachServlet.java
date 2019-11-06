package ch.heigvd.amt.projectone.presentation;

import ch.heigvd.amt.projectone.DAO.ICoachDAO;
import ch.heigvd.amt.projectone.DAO.LoginDAO;
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

@WebServlet(name = "CoachServlet", urlPatterns = {"/coachProfile"})
public class CoachServlet extends HttpServlet {

    @EJB
    private ICoachDAO cd;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/coach.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/coach.jsp").forward(request, response);





    }
}
