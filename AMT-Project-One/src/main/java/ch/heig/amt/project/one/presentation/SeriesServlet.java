package ch.heig.amt.project.one.presentation;

import ch.heig.amt.project.one.business.interfaces.SeriesManagerLocal;
import ch.heig.amt.project.one.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SeriesServlet extends HttpServlet {
    @EJB
    private SeriesManagerLocal seriesManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setAttribute("series", seriesManager.findAll(((User)req.getSession().getAttribute("user")), 0, 25));
        req.getRequestDispatcher("/WEB-INF/pages/series.jsp").forward(req, resp);
    }
}
