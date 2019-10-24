package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Character;
import ch.heigvd.amt.projectOne.model.Mount;

import javax.annotation.Resource;
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

    private int getRandomNumber(int from, int to) {
        Random r = new Random();
        return r.nextInt(to - from) + from;
    }

    /************************************************************
     * Characters related functions
     ***********************************************************/

    @Override
    public List<Character> findAllCharacters() {
        List<Character> characters = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            System.out.println("Schema: " + connection.getSchema());
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM character");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int level = rs.getInt("level");
                int health = rs.getInt("health");
                int stamina = rs.getInt("stamina");
                int mana = rs.getInt("mana");
                characters.add(new Character(id, name, level, health, stamina, mana));
            }
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return characters;
    }

    @Override
    public boolean addCharacter(String username, String password) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "INSERT INTO character (name, password, mount_id) VALUES (?, ?, ?)");
            pstmt.setObject(1, username);
            pstmt.setObject(2, password);
            pstmt.setObject(3, getRandomNumber(1, 11));

            int row = pstmt.executeUpdate();

            connection.close();

            return row > 0;


        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

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

            connection.close();
            return new Character(id, name, level, health, stamina, mana);

        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public Character getCharacterByUsername(String username) {
        try {
            Character character = null;
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM character WHERE name=?");
            pstmt.setObject(1, username);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int level = rs.getInt("level");
                int health = rs.getInt("health");
                int stamina = rs.getInt("stamina");
                int mana = rs.getInt("mana");
                character = new Character(id, username, level, health, stamina, mana);
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

            return !rs.next();


        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
}
