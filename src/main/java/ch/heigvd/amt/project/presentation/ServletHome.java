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


//TODO: Page navigation
@WebServlet(name = "ServletHome", urlPatterns = "/home")
public class ServletHome extends HttpServlet {

    @EJB
    FilmsManagerLocal filmsManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        List<Film> films = filmsManager.getAllFilms();
        */
        int page = 1;
        int nbFilmsPerPage = 8;
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        FilmsDAO dao = new FilmsDAO();
        List<Film> films = null;
        int nbFilms = 0;
        try {
            films = dao.findBetween(Integer.toString((page - 1) * nbFilmsPerPage), Integer.toString(page * nbFilmsPerPage));
            nbFilms = dao.findAll().size();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        }
        int nbPages = (int) Math.ceil(nbFilms * 1.0 / nbFilmsPerPage);

        request.setAttribute("films", films);
        request.setAttribute("nbPages", nbPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }
}
