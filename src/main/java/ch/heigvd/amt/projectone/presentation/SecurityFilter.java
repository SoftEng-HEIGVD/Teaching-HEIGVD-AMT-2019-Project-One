package ch.heigvd.amt.projectone.presentation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"", "/coachProfile", "/tablePlayerPage"})
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // Check if the user id is stored in session
        if (request.getSession().getAttribute("coach") != null) {
            chain.doFilter(req, resp);
        } else {
            // The user is not connected, redirect to the login page
            response.sendRedirect(request.getContextPath() + "/loginPage");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}


