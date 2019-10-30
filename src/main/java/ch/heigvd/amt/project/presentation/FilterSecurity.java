package ch.heigvd.amt.project.presentation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterSecurity", urlPatterns = "/*")
public class FilterSecurity implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        boolean isTargetUrlProtected = true;

        if ("/login".equals(path)) {
            isTargetUrlProtected = false;
        } else {
            req.setAttribute("targetUrl", path);
        }

        /*
         * If the user has been authenticated before, then the AuthenticationServlet has placed
         * an object (in this case a String) in the HTTP session. We can retrieve it.
         */
        String principal = (String) httpRequest.getSession().getAttribute("principal");
        if (principal == null && isTargetUrlProtected) {
            /*
             * The user has not been authenticated and tries to access a protected resource,
             * we display the login page (and interrupt the request processing pipeline).
             */
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
            //((HttpServletResponse)resp).sendRedirect(((HttpServletRequest) req).getContextPath() + "/login");
        } else {
            /*
             * We authorize the access, so we can tell the request processing pipeline to
             * continue its work.
             */
            chain.doFilter(req, resp);
            /*
             * Here, we could inspect and manipulate the response and its way back to the
             * client. In this case, we don't have anything to do.
             */
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
