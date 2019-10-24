package ch.heig.amt.project.one.presentation;

import ch.heig.amt.project.one.business.interfaces.SeriesManagerLocal;
import ch.heig.amt.project.one.model.Serie;
import ch.heig.amt.project.one.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddSerieServlet extends HttpServlet {
    @EJB
    private SeriesManagerLocal seriesManagerLocal;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = ((User)request.getSession().getAttribute("user"));
        String titre = request.getParameter("title");
        String genre = request.getParameter("genre");
        String producer = request.getParameter("producer");
        String ageRestriction = request.getParameter("ageRestriction");
        String synopsis = request.getParameter("synopsis");

        List<String> errors = new ArrayList<>();
        if(titre == null || titre.trim().equals("")) {
            errors.add("Le titre ne peut pas être vide");
        }
        if(genre == null || genre.trim().equals("")) {
            errors.add("Le genre ne peut pas être vide");
        }
        if(producer == null || producer.trim().equals("")) {
            errors.add("Le titre ne peut pas être vide");
        }
        if(ageRestriction == null || ageRestriction.trim().equals("")) {
            errors.add("La restriction d'âge ne peut pas être vide");
        }
        if(synopsis == null || synopsis.trim().equals("")) {
            errors.add("Le synopsis ne peut pas être vide");
        }

        if(errors.size() == 0) {
            int iAgeRestriction = Integer.valueOf(ageRestriction);
            Serie serie = Serie.builder()
                    .title(titre)
                    .genre(genre)
                    .producer(producer)
                    .ageRestriction(iAgeRestriction)
                    .synopsis(synopsis)
                    .build();
            serie.setOwner(user.getId());

            boolean created = seriesManagerLocal.create(serie);
            if(created) {
                request.setAttribute("stateOfCreation", "La série a bien été crée");
            } else {
                request.setAttribute("stateOfCreation", "Une erreur est survenue");
            }
        } else {
            request.setAttribute("errors", errors);
        }
        request.getRequestDispatcher("/WEB-INF/pages/addSerie.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/pages/addSerie.jsp").forward(request, response);
    }
}
