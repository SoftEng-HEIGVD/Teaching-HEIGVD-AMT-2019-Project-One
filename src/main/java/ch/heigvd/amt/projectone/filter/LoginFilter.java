package ch.heigvd.amt.projectone.filter;

import ch.heigvd.amt.projectone.model.Client;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/home",  "/products", "/orders", "/profile"} )
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        HttpSession session = httpServletRequest.getSession();

        if (session.getAttribute("user") == null){

            ((HttpServletResponse) resp).sendRedirect(httpServletRequest.getContextPath() + "/login");
        } else {
            chain.doFilter(httpServletRequest, httpServletResponse);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
