package ch.heigvd.amt.projectOne.presentation;

import ch.heigvd.amt.projectOne.model.Class;
import ch.heigvd.amt.projectOne.services.dao.ClassManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/classInfo")
public class ClassInfoServlet extends HttpServlet {

    @EJB
    ClassManagerLocal classManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Class thisClass = classManager.getClassById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("class", thisClass);
        req.setAttribute("image", thisClass.getName().toLowerCase());
        req.getRequestDispatcher("/WEB-INF/pages/class_info.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
