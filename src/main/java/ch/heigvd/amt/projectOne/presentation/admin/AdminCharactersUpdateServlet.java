package ch.heigvd.amt.projectOne.presentation.admin;

import ch.heigvd.amt.projectOne.model.Character;
import ch.heigvd.amt.projectOne.model.Guild;
import ch.heigvd.amt.projectOne.model.Membership;
import ch.heigvd.amt.projectOne.services.dao.CharacterManagerLocal;
import ch.heigvd.amt.projectOne.services.dao.GuildManagerLocal;
import ch.heigvd.amt.projectOne.services.dao.MembershipManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/admin/characters/update")
public class AdminCharactersUpdateServlet extends HttpServlet {

    @EJB
    private CharacterManagerLocal characterManager;

    @EJB
    private MembershipManagerLocal membershipManager;

    @EJB
    private GuildManagerLocal guildManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Character character = characterManager.getCharacterById(Integer.parseInt(id));
        List<Membership> memberships = membershipManager.getMembershipsByUserId(Integer.parseInt(id));
        List<Guild> guilds = guildManager.getAllGuilds();
        req.setAttribute("character", character);
        req.setAttribute("memberships", memberships);
        req.setAttribute("guilds", guilds);
        req.getRequestDispatcher("/WEB-INF/pages/admin/admin_characters_update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameterMap().containsKey("updateMemberships")) {
            updateMembership(req, resp);
        } else if (req.getParameterMap().containsKey("updateCharacter")) {
            updateCharater(req, resp);
        }

    }

    private void updateCharater(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    private void updateMembership(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        /* Fetch the old membership of the character */
        List<Membership> memberships = membershipManager.getMembershipsByUserId(Integer.parseInt(id));

        /* If the select2 get value we will check if we need to update membership*/
        if (req.getParameterMap().containsKey("membershipsSelect")) {
            /* Get values of select2 */
            String[] guildsSelected = req.getParameterValues("membershipsSelect");

            /* We make a list with new selection of guild from the html page */
            List<String> newGuildId = new LinkedList<>(Arrays.asList(guildsSelected));

            /* For each "old membership" we look if it's still in te new selection. If not we remove
            *  it from previous membership. And if it was already in the membership we remove the id
            *  from the list newGuildId. At the end of the loop we will have all the new membership
            *  in the table newGuildID */
            for (Membership membership : memberships) {
                if (newGuildId.contains(Integer.toString(membership.getGuild().getId()))) {
                    newGuildId.remove(Integer.toString(membership.getGuild().getId()));
                } else {
                    membershipManager.removeMembership(membership.getId());
                }
            }

            if (newGuildId.size() > 0) {
                Membership newMembership;
                for (String guildId: newGuildId) {
                    newMembership = Membership.builder().character(Character.builder().id(Integer.parseInt(id)).build()).guild(Guild.builder().id(Integer.parseInt(guildId)).build()).build();
                    membershipManager.addMembership(newMembership);
                }

            }
        } else { // We remove all membership because the selection is empty
            for (Membership membership : memberships) {
                membershipManager.removeMembership(membership.getId());
            }
        }
        resp.sendRedirect(req.getContextPath() + "/admin/characters");
    }
}

