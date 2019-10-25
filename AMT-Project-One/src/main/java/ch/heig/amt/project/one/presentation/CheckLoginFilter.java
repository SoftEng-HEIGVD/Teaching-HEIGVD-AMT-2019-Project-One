package ch.heig.amt.project.one.presentation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckLoginFilter implements Filter {
    private String logFile;

    @Override
    public void destroy() {
        System.out.println("CheckLoginFilter destroyed");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;

        if(request.getSession().getAttribute("user") == null) {
            HttpServletResponse response = (HttpServletResponse)resp;
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.logFile = config.getInitParameter("logFile");

        System.out.println("Log file " + logFile);
    }

}
