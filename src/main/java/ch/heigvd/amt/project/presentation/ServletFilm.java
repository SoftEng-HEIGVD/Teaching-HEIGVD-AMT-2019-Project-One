package ch.heigvd.amt.project.presentation;

import ch.heigvd.amt.project.business.FilmsManagerLocal;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.integration.FilmsDAO;
import ch.heigvd.amt.project.model.Film;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletFilm", urlPatterns = "/film")
public class ServletFilm extends HttpServlet {

    @EJB
    FilmsManagerLocal filmsManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = "0";
        if(request.getParameter("id") != null) {
            id = request.getParameter("id");
        }

        /*FilmsDAO dao = new FilmsDAO();
        Film film = null;
        try {
            film = dao.findById(Long.parseLong(id));
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }*/
        Film film = filmsManager.getFilm(Integer.parseInt(id));
        request.setAttribute("film", film);
        request.getRequestDispatcher("/WEB-INF/pages/film.jsp").forward(request, response);
    }
}
