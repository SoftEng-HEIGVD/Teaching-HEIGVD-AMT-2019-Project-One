package ch.heigvd.amt.projectone.Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/login/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();

        if (session.getAttribute("client") != null){
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }
}
