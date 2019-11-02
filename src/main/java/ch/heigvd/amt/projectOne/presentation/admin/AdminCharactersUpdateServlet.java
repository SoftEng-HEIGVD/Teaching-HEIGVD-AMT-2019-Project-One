package ch.heigvd.amt.projectOne.presentation.admin;

import ch.heigvd.amt.projectOne.model.Character;
import ch.heigvd.amt.projectOne.services.dao.CharacterManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/admin/characters/update")
public class AdminCharactersUpdateServlet extends HttpServlet {

    @EJB
    private CharacterManagerLocal characterManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Character character = characterManager.getCharacterById(Integer.parseInt(id));
        req.setAttribute("character", character);
        req.getRequestDispatcher("/WEB-INF/pages/admin/admin_characters_update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        Character character = characterManager.getCharacterById(Integer.parseInt(id));
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String passwordVerify = req.getParameter("passwordVerify");
        String isadmin = req.getParameter("isAdminCheckbox");
        boolean isAdminBool = false;
        boolean updatePassword = false;

        List<String> errors = new ArrayList<>();

        if (name == null || name.trim().equals("")) {
            errors.add("Username cannot be empty");
        }

        if (!character.getName().equals(name) && !characterManager.isUsernameFree(name)) {
            errors.add("This name is already taken");
        }

        if (isadmin != null && isadmin.equals("on")) {
            isAdminBool = true;
        }

        if ((password == null || password.trim().equals("")) && (passwordVerify == null || passwordVerify.trim().equals(""))) {
            updatePassword = false;
        } else {
            if (!password.equals(passwordVerify)) {
                errors.add("Password are not the same");
            } else {
                updatePassword = true;
            }
        }

        req.setAttribute("character", character);

        if (errors.size() == 0) {

            if (!characterManager.updateCharacter(Integer.parseInt(id), name, password, isAdminBool, updatePassword)) {
                errors.add("Unable to update the character");
                req.setAttribute("errors", errors);
                req.getRequestDispatcher("/WEB-INF/pages/admin/admin_characters_update.jsp").forward(req, resp);
            } else {
                resp.sendRedirect(req.getContextPath() + "/admin/characters");
            }
        } else {
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/WEB-INF/pages/admin/admin_characters_update.jsp").forward(req, resp);
        }
    }
}

