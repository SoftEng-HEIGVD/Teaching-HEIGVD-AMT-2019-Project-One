package ch.heig.amt.project.one.presentation;

import ch.heig.amt.project.one.business.interfaces.ViewersManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteViewerServlet extends HttpServlet {
    @EJB
    ViewersManagerLocal viewersManagerLocal;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sIdViewer = request.getParameter("idviewer");

        if(sIdViewer != null) {
            long idviewer = Long.valueOf(sIdViewer);
            viewersManagerLocal.delete(idviewer);
        }

        response.sendRedirect(request.getContextPath() + "/viewers");
    }
}
