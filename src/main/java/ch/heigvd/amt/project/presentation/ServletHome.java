package ch.heigvd.amt.project.presentation;

import ch.heigvd.amt.project.business.FilmsManagerLocal;
import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.datastore.exceptions.KeyNotFoundException;
import ch.heigvd.amt.project.integration.FilmsDAO;
import ch.heigvd.amt.project.integration.IFilmsDao;
import ch.heigvd.amt.project.model.Film;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//TODO: Page navigation
@WebServlet(name = "ServletHome", urlPatterns = "/home")
public class ServletHome extends HttpServlet {

    @EJB
    FilmsManagerLocal filmsManager;

    @EJB
    IFilmsDao filmsDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int nbFilmsPerPage = 8;
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        List<Film> films = filmsManager.getFilmsBetween((page - 1) * nbFilmsPerPage, page * nbFilmsPerPage);
        int nbFilms = filmsManager.getAllFilms().size();
        int nbPages = (int) Math.ceil(nbFilms * 1.0 / nbFilmsPerPage);

        request.setAttribute("films", films);
        request.setAttribute("nbPages", nbPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }
}
