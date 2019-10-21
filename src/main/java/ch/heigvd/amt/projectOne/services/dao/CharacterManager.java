package ch.heigvd.amt.projectOne.services.dao;

import ch.heigvd.amt.projectOne.model.Character;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class CharacterManager implements CharacterManagerLocal {

    @Resource(lookup = "jdbc/amt")
    private DataSource dataSource;

    @Override
    public List<Character> findAllCharacters() throws SQLException {
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
            throw ex;
        }
        return characters;
    }

    @Override
    public boolean addCharacter(String username, String password) throws SQLException {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO public.character (name, password) VALUES (?, ?)");
            pstmt.setObject(1, username);
            pstmt.setObject(2, password);

            int row = pstmt.executeUpdate();

            connection.close();

            return row > 0;


        } catch (SQLException ex) {
            Logger.getLogger(CharacterManager.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }


    }
}
