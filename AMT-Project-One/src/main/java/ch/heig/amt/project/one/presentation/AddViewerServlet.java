package ch.heig.amt.project.one.presentation;

import ch.heig.amt.project.one.business.interfaces.ViewersManagerLocal;
import ch.heig.amt.project.one.model.User;
import ch.heig.amt.project.one.model.Viewer;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddViewerServlet extends HttpServlet {
    @EJB
    ViewersManagerLocal viewersManagerLocal;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = ((User)request.getSession().getAttribute("user"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String genre = request.getParameter("genre");
        String birthdate = request.getParameter("birthdate");

        List<String> errors = new ArrayList<>();
        if(firstname == null || firstname.trim().equals("")) {
            errors.add("Le prénom ne peut pas être vide");
        }
        if(lastname == null || lastname.trim().equals("")) {
            errors.add("Le nom ne peut pas être vide");
        }
        if(username == null || username.trim().equals("")) {
            errors.add("Le nom d'utilisateur ne peut pas être vide");
        }
        if(genre == null || genre.trim().equals("")) {
            errors.add("Le genre ne peut pas être vide");
        }
        if(genre.equals("Genre")) {
            errors.add("Le genre doit être défini");
        }
        if(birthdate == null || birthdate.trim().equals("")) {
            errors.add("La date de naissance ne peut pas être vide");
        }

        if(errors.size() == 0) {
            java.util.Date dbirthdate = new Date();
            try {
                dbirthdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
            }
            catch (Exception e) {
                Logger.getLogger(ch.heig.amt.project.one.presentation.AddViewerServlet.class.getName()).log(Level.SEVERE, null, e);
            }

            Viewer viewer = Viewer.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .username(username)
                    .genre(genre)
                    .birthDate(dbirthdate)
                    .build();
            viewer.setOwner(user.getId());

            boolean created = viewersManagerLocal.create(viewer);
            if(created) {
                request.setAttribute("stateOfCreation", "Le viewer a bien été crée");
            } else {
                request.setAttribute("stateOfCreation", "Une erreur est survenue");
            }
        } else {
            request.setAttribute("errors", errors);
        }
        request.getRequestDispatcher("/WEB-INF/pages/addViewer.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/pages/addViewer.jsp").forward(request, response);
    }
}
