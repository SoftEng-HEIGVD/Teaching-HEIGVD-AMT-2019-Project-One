package ch.heigvd.amt.project.presentation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAuthentification", urlPatterns = "/login")
public class ServletAuthentification extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    /*
     Get the parameter values, which have been transmitted either in the query string
     (for GET requests) or in the body (for POST requests).
     */
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

    /*
     When the user is not logged in yet and tries to access /pages/xxx, then he
     is redirected to the login page by the security filter. The security filter
     stores the targer url (/pages/xxx) in the request context, so that we can
     send redirect the user to the desired location after successful authentication.

     If the user accessed /auth directly and there is no targetUrl, then we send him
     to the home page.
     */
        String targetUrl = (String) request.getAttribute("targetUrl");
        if (targetUrl == null) {
            targetUrl = "/home";
        }
        targetUrl = request.getContextPath() + targetUrl;

        if ("login".equals(action)) {
            request.getSession().setAttribute("principal", email);
            response.sendRedirect(targetUrl);
        } else if ("logout".equals(action)) {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath());
        } else {
            response.sendRedirect(targetUrl);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
