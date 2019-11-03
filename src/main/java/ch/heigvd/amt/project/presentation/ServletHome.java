package ch.heigvd.amt.project.presentation;

import ch.heigvd.amt.project.business.FilmsManagerLocal;
import ch.heigvd.amt.project.model.Film;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletHome", urlPatterns = "/home")
public class ServletHome extends HttpServlet {

    @EJB
    FilmsManagerLocal filmsManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Film> films = filmsManager.getAllFilms();
        request.setAttribute("films", films);
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }
}
