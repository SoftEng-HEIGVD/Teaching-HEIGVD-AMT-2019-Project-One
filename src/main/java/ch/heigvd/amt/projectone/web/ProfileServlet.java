package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Client;
import ch.heigvd.amt.projectone.services.dao.ClientsManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {


    @EJB
    ClientsManagerLocal clientsManagerLocal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger TAG = Logger.getLogger(ProfileServlet.class.getName());

        String error;

        String old_user = request.getParameter("old_user");
        String new_user = request.getParameter("new_user");
        String new_user_confirm = request.getParameter("new_user_confirm");
        String password = request.getParameter("password");
        String action = request.getParameter("action");

        response.setContentType("text/html;charset=UTF-8");

        TAG.log(Level.WARNING, "Je suis dans le post et la valeur de action vaut : " + action);

        if (action.equals("update_user")){
            if (old_user.isEmpty() || new_user.isEmpty() || new_user_confirm.isEmpty() || password.isEmpty()){
                error = "Aucun des champs ne peut être vide !";
                request.setAttribute("error", error);
                request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
            } else if (new_user.equals(new_user_confirm)){
                int id = clientsManagerLocal.getIdByUsername(old_user);
                TAG.log(Level.WARNING, "Je suis ici et l'id vaut : " + id);

                if (id != -1){
                    Client client = clientsManagerLocal.getClientById(id);
                    TAG.log(Level.WARNING, "Password vaut :" + client.getPassword());
                    if (password.equals(client.getPassword())){
                        client = new Client(client.getName(), new_user, password);
                        try {
                            clientsManagerLocal.update(client);
                            TAG.log(Level.WARNING, "Le client est mis à jour et il vaut : " + client.getUsername());
                            request.setAttribute("user", client);
                            request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
                        } catch (KeyNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                error = "Username is not the same";
                request.setAttribute("error", error);
                request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
    }
}
