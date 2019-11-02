package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.business.IAuthenticationService;
import ch.heigvd.amt.projectOne.model.Character;
import ch.heigvd.amt.projectOne.model.Class;
import ch.heigvd.amt.projectOne.model.Mount;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class CharacterManager implements CharacterManagerLocal {

    @Resource(lookup = "jdbc/amt")
    private DataSource dataSource;

    @EJB
    IAuthenticationService authenticationService;

    private int getRandomNumber(int from, int to) {
        Random r = new Random();
        return r.nextInt(to - from) + from;
    }

    @Override
    public int countRows(String table, String pattern) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) AS counter FROM " + table + " " + pattern);

            ResultSet rs = pstmt.executeQuery();

            rs.next();
            connection.close();

            return rs.getInt("counter");

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    /************************************************************
     * Characters related functions
     ***********************************************************/

    //TODO Do we really need to have the mount info ? We only need the name, the level and the class
    @Override
    public List<Character> getCharactersByPattern(String pattern, int pageNumber) {

        List<Character> characters = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT character.*, mount.name AS mount_name, mount.speed AS mount_speed, class.name AS class_name FROM character INNER JOIN mount ON character.mount_id = mount.id INNER JOIN class ON character.class_id = class.id WHERE character.name ILIKE ? ORDER BY name LIMIT 25 OFFSET ? ");
            pstmt.setObject(1,pattern+"%");
            pstmt.setObject(2,pageNumber * 25);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int level = rs.getInt("level");
                int health = rs.getInt("health");
                int stamina = rs.getInt("stamina");
                int mana = rs.getInt("mana");
                int mount_id = rs.getInt("mount_id");
                String mount_name = rs.getString("mount_name");
                int mount_speed = rs.getInt("mount_speed");
                int class_id = rs.getInt("class_id");
                String class_name = rs.getString("class_name");
                boolean isadmin = rs.getBoolean("isadmin");
                characters.add(Character.builder().id(id).name(name).level(level).health(health).stamina(stamina).mana(mana).mount(Mount.builder().id(mount_id).name(mount_name).speed(mount_speed).build()).myClass(Class.builder().id(class_id).name(class_name).build()).isadmin(isadmin).build());
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return characters;

    }

    //TODO Do we really need to have the mount info ? We only need the name, the level and the class
    @Override
    public List<Character> getCharactersByPage(int pageNumber) {
        List<Character> characters = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT character.*, mount.name AS mount_name, mount.speed AS mount_speed, class.name AS class_name FROM character INNER JOIN mount ON character.mount_id = mount.id INNER JOIN class ON character.class_id = class.id ORDER BY name LIMIT 25 OFFSET ? ");
            pstmt.setObject(1,pageNumber * 25);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int level = rs.getInt("level");
                int health = rs.getInt("health");
                int stamina = rs.getInt("stamina");
                int mana = rs.getInt("mana");
                int mount_id = rs.getInt("mount_id");
                String mount_name = rs.getString("mount_name");
                int mount_speed = rs.getInt("mount_speed");
                int class_id = rs.getInt("class_id");
                String class_name = rs.getString("class_name");
                boolean isadmin = rs.getBoolean("isadmin");
                characters.add(Character.builder().id(id).name(name).level(level).health(health).stamina(stamina).mana(mana).mount(Mount.builder().id(mount_id).name(mount_name).speed(mount_speed).build()).myClass(Class.builder().id(class_id).name(class_name).build()).isadmin(isadmin).build());
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return characters;

    }

    @Override
    public boolean addCharacter(String username, String password, boolean isAdmin) {

        try {
            String request;
            if(isAdmin){
                request = "INSERT INTO character (name, password, mount_id, class_id, isadmin) VALUES (?, ?, ?, ?, ?)";
            }else{
                request = "INSERT INTO character (name, password, mount_id, class_id) VALUES (?, ?, ?, ?)";
            }
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(request);
            pstmt.setObject(1, username);
            pstmt.setObject(2, authenticationService.hashPassword(password));
            pstmt.setObject(3, getRandomNumber(1, countRows("mount", "") + 1));
            pstmt.setObject(4, getRandomNumber(1, countRows("class", "") + 1));

            if (isAdmin) {
                pstmt.setBoolean(5, isAdmin);
            }

            int row = pstmt.executeUpdate();

            connection.close();

            return row > 0;


        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public boolean updateCharacter(int id, String username, String password, boolean isAdmin, boolean updatePassword) {

        try {
            String request;
            if(updatePassword){
                request = "UPDATE character SET name=?, isadmin=?, password=? WHERE id=?;";
            }else{
                request = "UPDATE character SET name=?, isadmin=? WHERE id=?;";
            }
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(request);
            pstmt.setObject(1, username);
            pstmt.setObject(2, isAdmin);
            int i = 3;
            if(updatePassword){
                pstmt.setObject(i++, authenticationService.hashPassword(password));
            }
            pstmt.setObject(i, id);

            int row = pstmt.executeUpdate();

            connection.close();

            return row > 0;


        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean checkPassword(String username, String password) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT password FROM character WHERE name=?");
            pstmt.setObject(1, username);

            ResultSet rs = pstmt.executeQuery();

            connection.close();

            rs.next();
            String hashedPassword = rs.getString("password");
            return authenticationService.checkPassword(password, hashedPassword);

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public Character getCharacterById(int id) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM character WHERE id=?");
            pstmt.setObject(1, id);

            ResultSet rs = pstmt.executeQuery();

            rs.next();
            String name = rs.getString("name");
            int level = rs.getInt("level");
            int health = rs.getInt("health");
            int stamina = rs.getInt("stamina");
            int mana = rs.getInt("mana");
            int mount_id = rs.getInt("mount_id");
            int class_id = rs.getInt("class_id");
            boolean isadmin = rs.getBoolean("isadmin");

            connection.close();

            return Character.builder().id(id).name(name).level(level).health(health).stamina(stamina).mana(mana).isadmin(isadmin).build();

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public Character getCharacterByUsername(String name) {
        try {
            Character character = null;
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT character.*, mount.name AS mount_name, mount.speed AS mount_speed, class.name AS class_name FROM character INNER JOIN mount ON character.mount_id = mount.id INNER JOIN class ON character.class_id = class.id WHERE character.name = ?");
            pstmt.setObject(1, name);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int level = rs.getInt("level");
                int health = rs.getInt("health");
                int stamina = rs.getInt("stamina");
                int mana = rs.getInt("mana");
                int mount_id = rs.getInt("mount_id");
                String mount_name = rs.getString("mount_name");
                int mount_speed = rs.getInt("mount_speed");
                int class_id = rs.getInt("class_id");
                String class_name = rs.getString("class_name");
                boolean isadmin = rs.getBoolean("isadmin");
                character = Character.builder().id(id).name(name).level(level).health(health).stamina(stamina).mana(mana).mount(Mount.builder().id(mount_id).name(mount_name).speed(mount_speed).build()).myClass(Class.builder().id(class_id).name(class_name).build()).isadmin(isadmin).build();

            }
            connection.close();
            return character;

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean isUsernameFree(String username) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT id FROM character WHERE name=?");
            pstmt.setObject(1, username);

            ResultSet rs = pstmt.executeQuery();

            connection.close();
            return !rs.next();


        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    @Override
    public boolean deleteCharacter(int id) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "DELETE FROM character WHERE id=?");
            pstmt.setObject(1, id);

            int row = pstmt.executeUpdate();

            connection.close();

            return row > 0;


        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
