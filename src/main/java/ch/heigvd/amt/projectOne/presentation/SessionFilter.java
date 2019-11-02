package ch.heigvd.amt.projectOne.presentation;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SessionFilter")
public class SessionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest filteredReq = (HttpServletRequest) req;
        HttpServletResponse filteredResp = (HttpServletResponse) resp;

        if (filteredReq.getSession().getAttribute("character") != null) {
            chain.doFilter(req, resp);
        } else {
            filteredResp.sendRedirect(filteredReq.getContextPath() + "/login");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
