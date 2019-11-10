package ch.heigvd.amt.project.presentation;

import ch.heigvd.amt.project.datastore.exceptions.DuplicateKeyException;
import ch.heigvd.amt.project.integration.IUsersDAO;
import ch.heigvd.amt.project.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletTest", urlPatterns = "/test")
public class ServletTest extends HttpServlet {
    @EJB
    IUsersDAO usersDAO;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = User.builder()
                .username("Bram")
                .firstName("Franco")
                .lastName("Bobby")
                .email("Byebye@nsync.com")
                .password("Byebyebye")
                .build();

        try {
            usersDAO.create(user);
            response.getWriter().println("created user");
        } catch (DuplicateKeyException e) {
            response.getWriter().println("Could not create user: " + e.getMessage());
        }
    }
}
