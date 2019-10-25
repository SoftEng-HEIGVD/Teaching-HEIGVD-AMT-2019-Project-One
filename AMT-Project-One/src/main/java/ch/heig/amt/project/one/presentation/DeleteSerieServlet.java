package ch.heig.amt.project.one.presentation;

import ch.heig.amt.project.one.business.interfaces.SeriesManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteSerieServlet extends HttpServlet {
    @EJB
    SeriesManagerLocal seriesManagerLocal;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sIdSerie = request.getParameter("idserie");
        if(sIdSerie != null) {
            long idserie = Long.valueOf(sIdSerie);
            seriesManagerLocal.delete(idserie);
        }

        response.sendRedirect(request.getContextPath() + "/series");
    }
}
