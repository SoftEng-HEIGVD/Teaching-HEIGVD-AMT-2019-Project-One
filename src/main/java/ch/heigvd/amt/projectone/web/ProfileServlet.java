package ch.heigvd.amt.projectone.web;

import ch.heigvd.amt.projectone.exceptions.KeyNotFoundException;
import ch.heigvd.amt.projectone.model.Client;
import ch.heigvd.amt.projectone.services.dao.ClientsManager;
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

        Logger LOG = Logger.getLogger(ClientsManager.class.getName());

        String username_old = request.getParameter("old_user");
        String username = request.getParameter("new_user");
        String name = request.getParameter("name");

        response.setContentType("text/html;charset=UTF-8");

        int id = clientsManagerLocal.getIdByUsername(username_old);


        LOG.log(Level.WARNING, username);
        LOG.log(Level.WARNING, Integer.toString(id));

        if (id != -1) {
            Client client = clientsManagerLocal.getClientById(id);
            client = new Client(client.getId(), name, username, client.getPassword(), client.isAdmin());
            try {
                clientsManagerLocal.update(client);
                HttpSession session = request.getSession();
                session.removeAttribute("user");
                session.setAttribute("user", client);
                request.getRequestDispatcher("WEB-INF/pages/profile.jsp").forward(request, response);
            } catch (KeyNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
    }
}
