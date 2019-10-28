package ch.heig.amt.project.one.presentation;

import ch.heig.amt.project.one.business.interfaces.SeriesManagerLocal;
import ch.heig.amt.project.one.business.interfaces.ViewersManagerLocal;
import ch.heig.amt.project.one.business.interfaces.WatchingInfosManagerLocal;
import ch.heig.amt.project.one.model.Serie;
import ch.heig.amt.project.one.model.User;
import ch.heig.amt.project.one.model.Viewer;
import ch.heig.amt.project.one.model.WatchingInfo;
import ch.heig.amt.project.one.utils.Pair;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DetailSerieServlet extends HttpServlet {
    @EJB
    SeriesManagerLocal seriesManagerLocal;

    @EJB
    WatchingInfosManagerLocal watchingInfosManagerLocal;

    @EJB
    ViewersManagerLocal viewersManagerLocal;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int NB_RECORD_PRINT = 50;

        User user = (User)request.getSession().getAttribute("user");
        String sIdSerie = request.getParameter("idserie");
        int pagetable = 0;
        if(request.getParameter("pagetable") != null) {
            pagetable = Integer.valueOf(request.getParameter("pagetable"));
        }
        if(sIdSerie != null) {
            long idserie = Long.valueOf(sIdSerie);
            Serie serie = seriesManagerLocal.findById(idserie);
            List<WatchingInfo> watchingInfoList = watchingInfosManagerLocal.findBySerie(user, serie, (pagetable * NB_RECORD_PRINT), ((pagetable + 1) * NB_RECORD_PRINT));
            List<Pair<String, WatchingInfo>> viewersInfo = new ArrayList<>();
            for(WatchingInfo w : watchingInfoList) {
                Viewer v = viewersManagerLocal.findById(w.getIdViewer());
                Pair<String, WatchingInfo> pair = new Pair<>(v.getUsername(), w);
                viewersInfo.add(pair);
            }
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("username", user.getUsername());
            request.setAttribute("serie", serie);
            request.setAttribute("viewersInfos", viewersInfo);
            request.getRequestDispatcher("/WEB-INF/pages/detailserie.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/restreint/series");
        }
    }
}
