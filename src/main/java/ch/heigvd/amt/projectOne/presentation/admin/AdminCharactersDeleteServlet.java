package ch.heigvd.amt.projectOne.presentation.admin;

import ch.heigvd.amt.projectOne.model.Character;
import ch.heigvd.amt.projectOne.services.dao.CharacterManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/admin/characters/delete")
public class AdminCharactersDeleteServlet extends HttpServlet {

    @EJB
    private CharacterManagerLocal characterManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameterMap().containsKey("id")) {
            HttpSession session = req.getSession();
            if (!characterManager.deleteCharacter(Integer.parseInt(req.getParameter("id")))){
                session.setAttribute("deleteStatus", "Unable to delete the user");
            }else{
                session.setAttribute("deleteStatus", "User deleted");
            }
            resp.sendRedirect(req.getContextPath() + "/admin/characters");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
